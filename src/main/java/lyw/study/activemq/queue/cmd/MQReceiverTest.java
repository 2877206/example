package lyw.study.activemq.queue.cmd;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;import javax.jms.ConnectionFactory;import javax.jms.Destination;import javax.jms.JMSException;import javax.jms.MessageConsumer;import javax.jms.Session;import javax.jms.TextMessage;import java.lang.Boolean;import java.lang.String;import java.lang.System;

public class MQReceiverTest {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("longooc",
                "111111",
                "tcp://192.168.31.130:61616");

        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("helloworld1");
            MessageConsumer messageConsumer = session.createConsumer(destination);

            while (true) {
                TextMessage textMessage = (TextMessage) messageConsumer.receive();
                if (textMessage != null) {
                    System.out.println(textMessage.getText());
                } else {
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
