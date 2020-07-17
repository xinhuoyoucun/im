package com.yuan.domain;

import javax.persistence.*;

@Table(name = "im..message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String type;

    private Integer time;

    @Column(name = "fromUserId")
    private Integer fromuserid;

    @Column(name = "toUserId")
    private Integer touserid;

    private String flow;

    @Column(name = "msgType")
    private String msgtype;

    private String content;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return time
     */
    public Integer getTime() {
        return time;
    }

    /**
     * @param time
     */
    public void setTime(Integer time) {
        this.time = time;
    }

    /**
     * @return fromUserId
     */
    public Integer getFromuserid() {
        return fromuserid;
    }

    /**
     * @param fromuserid
     */
    public void setFromuserid(Integer fromuserid) {
        this.fromuserid = fromuserid;
    }

    /**
     * @return toUserId
     */
    public Integer getTouserid() {
        return touserid;
    }

    /**
     * @param touserid
     */
    public void setTouserid(Integer touserid) {
        this.touserid = touserid;
    }

    /**
     * @return flow
     */
    public String getFlow() {
        return flow;
    }

    /**
     * @param flow
     */
    public void setFlow(String flow) {
        this.flow = flow;
    }

    /**
     * @return msgType
     */
    public String getMsgtype() {
        return msgtype;
    }

    /**
     * @param msgtype
     */
    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}