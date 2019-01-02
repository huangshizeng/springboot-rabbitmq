package com.huang.routing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoutingApplicationTests {

    @Autowired
    private Send send;

    @Test
    public void hello() {
        send.send();
    }
}

