package com.sdingba.bean;

/**
 * Created by su on 16-6-6.
 */
public class Message {
    private String id;
    private String reciver;
    private String message;
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReciver() {
        return reciver;
    }

    public void setReciver(String reciver) {
        this.reciver = reciver;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", reciver='" + reciver + '\'' +
                ", message='" + message + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}
