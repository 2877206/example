package lyw.study.dubbo.spring.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by yw on 2016/2/27.
 */
public class DubboProviderMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext  applicationContext = new ClassPathXmlApplicationContext("dubbo-spring-context-provider.xml");
        applicationContext.start();


        System.out.println("监听");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
