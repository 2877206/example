package lyw.study.dubbomq.queue.spring.autowire.impl;


import lyw.study.dubbomq.queue.spring.autowire.api.DubboMQService;
import lyw.study.dubbomq.queue.spring.autowire.mq.consumer.MQReceiver;
import lyw.study.dubbomq.queue.spring.autowire.mq.provider.MQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yw on 2016/2/28.
 */
@Service("targetDubboMQService")
public class DubboMQServiceImpl implements DubboMQService{

    @Autowired
    private MQSender sender;

    @Autowired
    private MQReceiver receiver;



    public void send(String str) {
        System.out.println("dubbo send..."+str);
        sender.send();
    }

    public String receive() {
        System.out.println("dubbo receive..." );
        String str = receiver.receive();

        return str;
    }
}
