package com.git.service;

import com.alibaba.fastjson.JSON;
import com.git.model.dto.MqMsgDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;

import java.util.Map;

public class MqService {

    private static final Logger logger = LoggerFactory.getLogger(MqService.class);
    @JmsListener(destination = "queuq22",containerFactory = "jmsListenerContainer")
    public void receiveStringQueue1(String msg) {
        logger.info("====111===");
        System.out.println(msg.toString());
    }

    @JmsListener(destination = "topic22",containerFactory = "jmsListenerContainerFactory")
    public void receiveStringQueue2(String msg) {
        logger.info("====222===");
        System.out.println(msg.toString());
    }

    @JmsListener(destination = "topic22",containerFactory = "jmsListenerContainerFactory")
    public void receiveStringQueue3(String msg) {
        logger.info("====222第二个===");
        System.out.println(msg.toString());
    }

}
