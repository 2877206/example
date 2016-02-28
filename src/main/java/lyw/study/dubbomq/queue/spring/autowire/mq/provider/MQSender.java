package lyw.study.dubbomq.queue.spring.autowire.mq.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by yw on 2016/2/28.
 */
@Component("sender")
public class MQSender {

    @Autowired
    private JmsTemplate jmsTemplate;
    int m=0;
    public void send(){
        System.out.println("provider send :"+(m++));

        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("provider - message..."+(m));
            }
        });

    }
}
