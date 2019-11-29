/*
package com.git.controller;

import com.git.inter.SendMsg;
import com.git.model.dto.MqMsgDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq/activemq")
public class MqController {

    @Autowired
    private SendMsg mqService;

    @PostMapping("/queue")
    public void sendQueueMsg(@RequestBody MqMsgDto mqMsgDto){
        mqService.sendQueue("queue",mqMsgDto);
    }

    @PostMapping("/topic")
    public void sendTopicMsg(@RequestBody MqMsgDto mqMsgDto){
        mqService.sendTopic("topic",mqMsgDto);
    }
}
*/
