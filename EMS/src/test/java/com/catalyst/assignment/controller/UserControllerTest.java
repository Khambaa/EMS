package com.catalyst.assignment.controller;

import com.catalyst.assignment.entities.User;
import com.catalyst.assignment.repositories.UserRepository;
import com.catalyst.assignment.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {


    private MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void insertUserTest() throws Exception{
           User user=createNewUser();
            when(userService.registerUser(any())).thenReturn(createNewUser());
           mockMvc.perform(
                            post("/user/registerUser")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(asJsonString(user))
           ).andDo(MockMvcResultHandlers.print()).andExpect(status().is2xxSuccessful());


    }

    public String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private User createNewUser() {

        User user=new User();
        user.setFullName("Chirag Bansal");
        user.setEmail("bansal@gmail.com");
        user.setPassword("asdfg");
        user.setEnabled(true);

        return user;
    }


}
