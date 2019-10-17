package com.tianzhuan.net_handler.core;

/**
 * 消息对象
 */
public class Message {
    //标识
    public int what;
    //消息内容
    public Object obj;
    //Handler对象
    public  Handler target;

    public Message() {
    }

    public Message(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return obj.toString();
    }
}
