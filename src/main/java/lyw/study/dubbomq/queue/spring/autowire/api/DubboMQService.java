package lyw.study.dubbomq.queue.spring.autowire.api;

/**
 * Created by yw on 2016/2/28.
 */
public interface DubboMQService {
    void send(String str);
    String receive();
}
