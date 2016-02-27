package lyw.study.dubbo.spring.consumer;

import lyw.study.dubbo.spring.api.TestRegistryService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yw on 2016/2/27.
 */
public class DubboConsumerMain {


    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"dubbo-spring-context-consumer.xml"});
        context.start();

        TestRegistryService testRegistryService = (TestRegistryService) context.getBean("testRegistryService"); //

        while(true){
            System.out.println(testRegistryService.hello("hi"));
            Thread.sleep(300);
        }
    }
}
