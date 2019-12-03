package com.git.config;

import com.git.service.MqService;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.context.annotation.*;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@Configuration
@ComponentScan(value = "com.git.service",useDefaultFilters = false,
		includeFilters = {@ComponentScan.Filter(type=FilterType.CUSTOM,
				value = MyFilter.class
		)})
//@Import(MqService.class)
@EnableJms
public class MqConfig2 {

	/**
	 * 连接工厂
	 * @return
	 */
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory(){
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
		return activeMQConnectionFactory;

	}

	/**
	 * 连接池工厂 使用ActiveMQ连接工厂
	 * @param connectionFactory
	 * @return
	 */
	@Bean
	public PooledConnectionFactory pooledConnectionFactory(ActiveMQConnectionFactory connectionFactory){
		PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
		pooledConnectionFactory.setConnectionFactory(connectionFactory);
		pooledConnectionFactory.setMaxConnections(500);
		return pooledConnectionFactory;

	}

	@Bean
	public CachingConnectionFactory cachingConnectionFactory(ActiveMQConnectionFactory connectionFactory){
		return new CachingConnectionFactory(connectionFactory);

	}

	@Bean
	public JmsTemplate jmsTemplate(CachingConnectionFactory cachingConnectionFactory){
		return new JmsTemplate(cachingConnectionFactory);
	}

	@Bean
	public JmsListenerContainerFactory<?> jmsListenerContainer(ConnectionFactory activeMQConnectionFactory) {
		DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
		//bean.setPubSubDomain(true);
		bean.setConnectionFactory(activeMQConnectionFactory);
		return bean;
	}

	@Bean("jmsListenerContainerFactory")
	public JmsListenerContainerFactory<?> jmsListenerContainerFactory(ConnectionFactory activeMQConnectionFactory) {
		DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
		bean.setPubSubDomain(true);
		bean.setConnectionFactory(activeMQConnectionFactory);
		return bean;
	}

}
