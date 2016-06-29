package com.sdingba.dao;

import com.sdingba.bean.Message;
import com.sdingba.bean.Sendqq;

import java.util.List;

/**
 * Created by su on 16-6-7.
 */
public interface sendMessageDao {

    /**
     * 返回  历史 数据 的集合。
     * @param sendid 发送方
     * @param revicesId 接收方
     * @param  readIs 0代表读完了，1代表没有读完
     * @return
     */
    List<Sendqq> MessageHistory(String sendid, String revicesId,int readIs);

    /**
     * 当发送不在线的时候，添加发送数据到数据库。
     * @param sendId
     * @param RevicesId
     * @param message
     */
    void addMessageSendqq(String sendId, String RevicesId, String message);

    /**
     * 修该查看完了的数据
     * @param sendid
     * @param revicesId
     */
    void updateMEssageRW(String sendid, String revicesId);
}
