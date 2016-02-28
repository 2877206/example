package lyw.study.dubbomq.queue.spring.autowire;

import lyw.study.dubbomq.queue.spring.autowire.api.DubboMQService;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

/**
 * Created by yw on 2016/2/28.
 */
public class DubboMQSpringMQClientTest {

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-mq-spring-context-receive-autowire.xml");
        context.start();

        DubboMQService service= (DubboMQService)context.getBean("dubboMQService");

        int n = 0;
        while(true) {
            System.out.println("client:send");
            service.send("client:" + (++n));
            System.out.println("client:receive" );
                    service.receive();
            try {
                Thread.sleep(5000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
