package com.git.inter;

import com.git.model.dto.MqMsgDto;

public interface SendMsg {

    /**
     *	发送队列消息
     * @param queuName 队列名称
     * @param mqMsgDto 消息内容
     */
    void sendQueue(String queuName, MqMsgDto mqMsgDto);

    /**
     * 发送主题消息
     * @param topicName 主题名称
     * @param mqMsgDto 消息内用
     */
    void sendTopic(String topicName, MqMsgDto mqMsgDto);
}
