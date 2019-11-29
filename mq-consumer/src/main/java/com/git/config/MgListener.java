package com.git.config;

import com.git.anno.QueueName;
import com.git.anno.TopicName;
import com.git.inter.QueueComsumerMsg;
import com.git.inter.TopicComsumerMsg;
import com.git.util.AnnotationUtil;
import com.git.util.StringUtils;
import org.checkerframework.checker.units.qual.C;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.jms.connection.CachingConnectionFactory;

import javax.jms.*;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class MgListener implements ApplicationListener<ContextRefreshedEvent> {

    private static AtomicBoolean isRunned = new AtomicBoolean(false);

    public MgListener() {
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null && isRunned.compareAndSet(false, true)) {
            registerAll(event.getApplicationContext());
        }
    }





    private void registerAll(ApplicationContext applicationContext) {
        Map<String, QueueComsumerMsg> beansOfType = applicationContext.getBeansOfType(QueueComsumerMsg.class);
        CachingConnectionFactory cachingConnectionFactory = applicationContext.getBean(CachingConnectionFactory.class);
        beansOfType.entrySet().stream().forEach(m->{
            try {
                registerQueue(cachingConnectionFactory,m.getValue());
            } catch (JMSException e) {
                e.printStackTrace();

            }
        });

        Map<String, TopicComsumerMsg> topicComsumerMsgMap = applicationContext.getBeansOfType(TopicComsumerMsg.class);
        topicComsumerMsgMap.entrySet().stream().forEach(m->{
            try {
                registerTopic(cachingConnectionFactory,m.getValue());
            } catch (JMSException e) {
                e.printStackTrace();

            }
        });


    }

    private void registerQueue(CachingConnectionFactory cachingConnectionFactory, QueueComsumerMsg queueComsumerMsg) throws JMSException {
        String queueBeanName = "";
        QueueName anQueueName = (QueueName) AnnotationUtil.getAnnotation(queueComsumerMsg, QueueName.class);
        if(anQueueName==null)throw new RuntimeException("获取不到注解："+anQueueName.getClass().getName());
        queueBeanName = anQueueName.value();

        Connection conn = cachingConnectionFactory.createConnection();
        Session session = conn.createSession(false, 1);
        Queue queue = session.createQueue(queueBeanName);
        MessageConsumer consumer = session.createConsumer(queue);
        conn.start();
        consumer.setMessageListener(new MyQueueListener(queueComsumerMsg));

    }

    private void registerTopic(CachingConnectionFactory cachingConnectionFactory, TopicComsumerMsg topicComsumerMsg) throws JMSException {
        String queueBeanName = "";
        TopicName anQueueName = (TopicName) AnnotationUtil.getAnnotation(topicComsumerMsg, TopicName.class);
        if(anQueueName==null)throw new RuntimeException("获取不到注解："+anQueueName.getClass().getName());
        queueBeanName = anQueueName.value();

        Connection conn = cachingConnectionFactory.createConnection();
        Session session = conn.createSession(false, 1);
        Topic topic = session.createTopic(queueBeanName);
        MessageConsumer consumer = session.createConsumer(topic);
        conn.start();
        consumer.setMessageListener(new MyTopicListener(topicComsumerMsg));

    }

}
