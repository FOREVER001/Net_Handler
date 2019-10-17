package com.tianzhuan.net_handler.core;

public class Looper {
    public MessageQueue mQueue;
    static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<Looper>();

    private Looper() {
        mQueue = new MessageQueue();
    }

    public static void prepare() {
        //主线程只有唯一一个
        if(sThreadLocal.get()!=null){
            throw new RuntimeException("Only one Looper may be created per thread");
        }
        //应用启动时候，初始化赋值
        sThreadLocal.set(new Looper());
    }
    public static  Looper myLooper() {
        return sThreadLocal.get();
    }
    //轮询，需要获取looper里面的messageQueue
    public static void loop() {
        //从全局ThreadLocalMap中获取唯一:Looper对象
        Looper me=myLooper();
        //从Looper对象中获取全局唯一消息队列对象
       final MessageQueue queue=me.mQueue;

        Message resultMessage;
       while (true){
           Message msg=queue.next();
           if(msg!=null){
               if(msg.target!=null)
               msg.target.dispatchMessage(msg);
           }
       }
    }




}
