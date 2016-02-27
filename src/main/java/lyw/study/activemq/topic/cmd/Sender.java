package lyw.study.activemq.topic.cmd;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by yw on 2016/2/27.
 */
public class Sender {
    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("longooc", "111111", "tcp://192.168.31.130:61616");
        Connection connection = null;

        try {
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic("topic-hello");
            MessageProducer messageProducer = session.createProducer(topic);
            messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);

            int n = 0;
            while (true) {
                TextMessage textMessage = session.createTextMessage("hi," + (++n));
                messageProducer.send(textMessage);
                session.commit();
                Thread.sleep(200);
                if (n > 300) {
                    break;
                }
            }

            messageProducer.close();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
