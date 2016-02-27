package lyw.study.activemq.topic.cmd;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by yw on 2016/2/27.
 */
public class RecieverThread {

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("longooc",
                "111111", "tcp://192.168.31.130:61616");

        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("topic-hello");
        MessageConsumer consumer = session.createConsumer(topic);

        Receive rec = new Receive(consumer, session, connection);
        rec.start();
    }
}

class Receive extends Thread {
    private MessageConsumer consumer = null;
    private Session session = null;
    private Connection connection;

    public Receive(MessageConsumer consumer, Session session, Connection connection) {
        this.consumer = consumer;
        this.session = session;
        this.connection = connection;
    }

    @Override
    public void run() {
        System.out.println("start");
        try {
            // 避免出现上次收到的旧数据
//                session.commit();
//                session.close();
//                connection.close();
            this.consumer.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println(textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
