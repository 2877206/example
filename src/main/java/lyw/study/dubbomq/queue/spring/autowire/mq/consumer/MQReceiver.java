package lyw.study.dubbomq.queue.spring.autowire.mq.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by yw on 2016/2/28.
 */
@Component
public class MQReceiver {
    @Autowired
    JmsTemplate jmsTemplate ;

    public String receive(){
        TextMessage textMessage = (TextMessage)jmsTemplate.receive();

        try {
            System.out.println("consumer receive:"+textMessage.getText());

        } catch (JMSException e) {
            e.printStackTrace();
        }
        try {
            return textMessage.getText();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return "null";
    }
}
