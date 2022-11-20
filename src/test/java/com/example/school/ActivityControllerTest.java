package com.example.school;

import com.example.school.Controller.ActivityController;
import com.example.school.Service.Activity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ActivityController.class) // this makes enbabed tomcat shouldnot start and this tells the use activityController for testing
public class ActivityControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private Activity activity;

//    @Test
//    public void testgetStudentById() {
//        mockMvc.perform(get())
//    }




}
