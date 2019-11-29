package com.git.config;

import com.alibaba.fastjson.JSON;
import com.git.inter.QueueComsumerMsg;
import com.git.inter.TopicComsumerMsg;
import com.git.model.dto.MqMsgDto;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyTopicListener implements MessageListener {

    private TopicComsumerMsg topicComsumerMsg;

    public MyTopicListener(TopicComsumerMsg topicComsumerMsg) {
        this.topicComsumerMsg=topicComsumerMsg;
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage msg = (TextMessage)message;

            try {
                String strMsg = msg.getText();
                MqMsgDto msgDto = (MqMsgDto) JSON.parseObject(strMsg, MqMsgDto.class);
                if (msgDto == null) {
                    throw new RuntimeException("发的消息为空");
                }
                this.topicComsumerMsg.omTopic(msgDto);
            } catch (JMSException var5) {
                throw new RuntimeException("消费消息错误");
            }
        }
    }
}
