package lyw.study.activemq.queue.spring.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yw on 2016/2/27.
 */
public class ProxyJMSConsumerTest{


        public static void main(String[] args) {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("mq-spring-context-autowire.xml");
            ProxyJMSConsumer proxyJMSConsumer = (ProxyJMSConsumer) applicationContext.getBean("messageReceiver");
            proxyJMSConsumer.recive();

            System.out.println("初始化消息消费者");
        }
}
