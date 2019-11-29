package com.git.inter;

import com.git.model.dto.MqMsgDto;


public interface TopicComsumerMsg {
    void omTopic(MqMsgDto mqMsgDto);
}
