package com.git.inter;

import com.git.model.dto.MqMsgDto;

public interface ComsumerMsg {
    void onQueue(MqMsgDto mqMsgDto);

    void omTopic(MqMsgDto mqMsgDto);
}
