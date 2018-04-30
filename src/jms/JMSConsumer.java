package jms;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Before;
import org.junit.Test;

import javax.jms.*;

/**
 * 消息消费者
 * Created by Administrator on 2017/12/10.
 */
public class JMSConsumer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;

    private ConnectionFactory connectionFactory = null;
    private Connection connection = null;
    private Session session = null;
    private Destination destination = null;
    private MessageConsumer messageConsumer = null;

    @Before
    public void before(){
        connectionFactory = new ActiveMQConnectionFactory(JMSConsumer.USERNAME, JMSConsumer.PASSORD, JMSConsumer.BROKEURL);
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("HelloWorld");
            messageConsumer = session.createConsumer(destination);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     * 消费者接收消息的方式：循环receive方式
     */
    public void receiveType(){
        try{
            while(true){
                //每100000毫秒接收一次消息
                TextMessage textMessage = (TextMessage) messageConsumer.receive(100000);
                if(textMessage!=null){
                    System.out.println("收到的消息:" + textMessage.getText());
                }else{
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    /**
     * 消费者接收消息的方式：listening监听方式
     */
    public void listenerType(){
        try{
            // Listener方式:注册消息监听器
            messageConsumer.setMessageListener(new MessageListener());
            while(true){
                Thread.sleep(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}