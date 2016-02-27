package lyw.study.activemq.queue.spring.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;

/**
 * Created by yw on 2016/2/27.
 */
@Component
public class ProxyJMSConsumer {
    public ProxyJMSConsumer() {
    }

    @Autowired
    private JmsTemplate jmsTemplate;

    public void recive() {
        try {
            TextMessage txtmsg = (TextMessage) jmsTemplate.receive();
            if (null != txtmsg) {
                System.out.println("[DB Proxy] " + txtmsg);
                System.out.println("[DB Proxy] 收到消息内容为: "
                        + txtmsg.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
