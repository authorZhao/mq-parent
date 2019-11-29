package com.git.service;


import com.git.anno.QueueName;
import com.git.anno.TopicName;
import com.git.inter.QueueComsumerMsg;
import com.git.inter.TopicComsumerMsg;
import com.git.model.dto.MqMsgDto;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;

@QueueName("queuq22")
@Service
public class QueueService implements QueueComsumerMsg {


    @Override
    public void onQueue(MqMsgDto mqMsgDto) {
        System.out.println("接收到了消息，我是queuq22");
    }
}
