package com.git.mq;

import com.alibaba.fastjson.JSON;
import com.git.inter.SendMsg;
import com.git.model.dto.MqMsgDto;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
@Service
public class SengMsgImpl implements SendMsg {

    @Autowired

    private JmsTemplate activeMqJmsTemplate;

    @Override
    public void sendQueue(String queenName, MqMsgDto message) {
        send( new ActiveMQQueue(queenName), message);
    }

    @Override
    public void sendTopic(String topicName, MqMsgDto message) {
        send( new ActiveMQTopic(topicName), message);
    }

    private void send(Destination destination, final MqMsgDto message) {
        activeMqJmsTemplate.send(destination, session -> {
            String msg = JSON.toJSONString(message);
            return session.createTextMessage(msg);
        });
    }

}
