package com.git.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.annotation.MatchesPattern;


@Configuration
@ComponentScan("com.git.mq")
public class MqConfig {

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
		JmsTemplate jmsTemplate = new JmsTemplate(cachingConnectionFactory);
		jmsTemplate.setReceiveTimeout(10000);
		return jmsTemplate;
	}

}
