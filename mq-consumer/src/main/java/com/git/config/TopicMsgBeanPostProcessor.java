/*
package com.git.config;

import com.alibaba.fastjson.JSON;
import com.git.inter.QueueComsumerMsg;
import com.git.inter.TopicComsumerMsg;
import com.git.model.dto.MqMsgDto;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.jms.JMSException;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TopicMsgBeanPostProcessor implements BeanPostProcessor , ApplicationContextAware {


    private TopicComsumerMsg topicComsumerMsg;

    public TopicMsgBeanPostProcessor(TopicComsumerMsg topicComsumerMsg) {
        this.topicComsumerMsg = topicComsumerMsg;
    }

    private ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        beanName = "queueMessageListener";

        return (MessageListener) message -> {
            if (message instanceof TextMessage) {
                TextMessage msg = (TextMessage)message;
                String strMsg = "";

                try {
                    strMsg = msg.getText();
                    MqMsgDto msgDto = (MqMsgDto) JSON.parseObject(strMsg, MqMsgDto.class);
                   */
/* if (msgDto == null) {
                        MessageConsumerRegister.LOGGER.error("消息队列数据转换异常，原内容：" + strMsg);
                    }*//*

                    this.topicComsumerMsg.omTopic(msgDto);
                } catch (JMSException var5) {
                    var5.printStackTrace();
                } catch (RuntimeException var6) {
                    throw var6;
                }
            }
        };
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
*/
