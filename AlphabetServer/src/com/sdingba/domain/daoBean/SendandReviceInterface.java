package com.sdingba.domain.daoBean;

/**
 * Created by su on 16-6-3.
 */
public interface SendandReviceInterface {

    /**
     * 接受 的 人 的 id
     * -----
     * 我的
     * @return
     */
    public String SQLTableRecevierIdToData();


    /**
     * 发送人 的 人 的 id
     * -----
     * 对方的
     * @return
     */
    public String SQLTableSendIdToData();


}
