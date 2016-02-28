package lyw.study.dubbomq.queue.spring.autowire;

import lyw.study.dubbomq.queue.spring.autowire.api.DubboMQService;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by yw on 2016/2/28.
 */
public class DubboMQSpringServiceTest {
    public DubboMQSpringServiceTest() {
    }

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-mq-spring-context-autowire.xml");
       context.start();

//        DubboMQService mqService = (DubboMQService) context.getBean("targetDubboMQSender");

//        mqService.send();

        try {
            System.in.read(); // 按任意键退出
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
