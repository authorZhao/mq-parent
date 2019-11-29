package com.git.model.dto;

import com.git.util.UuidUils;

import java.io.Serializable;
import java.util.Date;

/**
 * mq消息对象
 */
public class MqMsgDto implements Serializable {
	private static final long serialVersionUID = 3980851080260271132L;
	/**
	 * 消息id
	 */
	private String msgId;
	/**
	 * 发送时间
	 */
	private Date sendTime;
	/**
	 * 重试次数
	 */
	private int retriedCount = 0;

	/**
	 * 消息内容
	 */
	private String content = null;

	public static MqMsgDto newObj(String msg) {
		MqMsgDto msgDto = new MqMsgDto();
		msgDto.setMsgId(UuidUils.getUUID());
		msgDto.setSendTime(new Date());
		msgDto.setContent(msg);
		return msgDto;
	}

	public String getMsgId() {
		return this.msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public Date getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public int getRetriedCount() {
		return this.retriedCount;
	}

	public void setRetriedCount(int retriedCount) {
		this.retriedCount = retriedCount;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
