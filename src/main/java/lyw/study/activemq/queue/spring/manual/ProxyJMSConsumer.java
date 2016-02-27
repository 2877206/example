package lyw.study.activemq.queue.spring.manual;

import org.springframework.jms.core.JmsTemplate;

import javax.jms.TextMessage;

/**
 * Created by yw on 2016/2/27.
 */
public class ProxyJMSConsumer {
    public ProxyJMSConsumer() {
    }

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

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
