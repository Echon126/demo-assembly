package com.example.api;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class EventTest {
    private final Logger logger = LoggerFactory.getLogger(EventTest.class);
    @Autowired
    ApplicationContext applicationContext;

    private MockMvc mvc;
    private MockHttpSession session;


    @Before
    public void setupMockMvc() {

    }

    //TODO 测试类需要完善


}
