package lyw.study.dubbo.spring.impl;

import lyw.study.dubbo.spring.api.TestRegistryService;
import org.springframework.stereotype.Service;



/**
 * Created by yw on 2016/2/27.
 */
@Service("testRegistryService")
public class TestRegistryServiceImpl implements TestRegistryService {
    int n=0;
    public String hello(String name) {
        return "hello,"+name+(++n);
    }
}
