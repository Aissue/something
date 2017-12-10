package test6;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 消息的生产者
 * Created by Administrator on 2017/12/10.
 */
public class JMSProducter {
    //默认连接用户名
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    //默认连接密码
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //默认连接地址
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
    //发送的消息数量
    private static final int SENDNUM = 10;

    /**
     * 发送消息
     * @param session
     * @param messageProducer 消息生产者
     */
    public static void sendMessage(Session session, MessageProducer messageProducer) throws Exception{
        for(int i=0;i<JMSProducter.SENDNUM;i++){
            TextMessage message = session.createTextMessage("ActiveMq 发送消息"+i);
            System.out.println("发送消息：Activemq 发送消息" + i);
            messageProducer.send(message);
        }
    }

    public static void main(String[] args) {
        //连接工厂
        ConnectionFactory connectionFactory = null;
        //连接
        Connection connection = null;
        //会话 接受或者发送消息的线程
        Session session = null;
        //消息的目的地
        Destination destination = null;
        //消息生产者
        MessageProducer messageProducer = null;
        //实例化连接工厂
        connectionFactory = new ActiveMQConnectionFactory(JMSProducter.USERNAME,JMSProducter.PASSWORD,JMSProducter.BROKEURL);

        try {
            //通过连接工厂获得连接
            connection = connectionFactory.createConnection();
            //启动连接
            connection.start();
            //创建session
            session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
            //创建一个名为helloworld的消息队列
            destination = session.createQueue("HelloWorld");
            //创建消息生产者
            messageProducer = session.createProducer(destination);
            sendMessage(session,messageProducer);

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connection!=null){
                try{
                    connection.close();
                }catch (JMSException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
