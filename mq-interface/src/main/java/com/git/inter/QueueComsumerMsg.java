package com.git.inter;

import com.git.model.dto.MqMsgDto;

public interface QueueComsumerMsg {
    void onQueue(MqMsgDto mqMsgDto);
}
