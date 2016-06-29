package com.sdingba.service;

import com.sdingba.bean.Sendqq;

import java.util.List;

/**
 * Created by su on 16-6-7.
 */
public interface sendMessageService {

    /**
     *  获取 没有读完的消息。
     * @param sendid 发送方
     * @param revicesId 接收方 我的ID
     * @return
     */
    String MessageHistoryString(String sendid, String revicesId);

    /**
     * 当发送不在线的时候，添加发送数据到数据库。
     * @param sendId
     * @param RevicesId
     * @param message
     */
    void addMessageSendqq(String sendId, String RevicesId, String message);
}
