package test6;

import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * 消息监听器
 * Created by Administrator on 2017/12/20.
 */
public class MessageListener implements javax.jms.MessageListener{
    @Override
    public void onMessage(Message message) {
        try{
            System.out.println("消费者-监听方式-收到消息: " + ((TextMessage)message).getText());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
