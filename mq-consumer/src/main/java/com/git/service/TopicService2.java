package com.git.service;


import com.git.anno.TopicName;
import com.git.inter.TopicComsumerMsg;
import com.git.model.dto.MqMsgDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@TopicName(value="topic22")
public class TopicService2 implements TopicComsumerMsg {

    @Override
    public void omTopic(MqMsgDto mqMsgDto) {
        System.out.println("接收到了消息TopicService2，我是topic22");
    }
}

