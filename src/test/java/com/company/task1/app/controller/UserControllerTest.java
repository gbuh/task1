package com.company.task1.app.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.task1.app.entity.User;
import com.company.task1.app.service.api.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserService userService;

    private User user1;
    private User user2;

    @Before
    public void setUp() {
        user1 = buildUser("firstName1", "lastName1", "email1", "phoneNumber1");
        user2 = buildUser("firstName2", "lastName2", "email2", "phoneNumber2");
        userService.insert(user1);
        userService.insert(user2);
    }

    @After
    public void tearDown() {
        userService.getAll().forEach(user -> userService.delete(user.getId()));
    }

    @Test
    public void testAllUsersGetHttpRequest() {
        List<User> users = restTemplate.exchange("http://localhost:" + port + "/users", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<User>>() { }).getBody();
        assertEquals(2, users.size());
        assertTrue(users.contains(user1));
        assertTrue(users.contains(user2));
        userService.delete(user1.getId());
        users = restTemplate.exchange("http://localhost:" + port + "/users", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<User>>() { }).getBody();
        assertEquals(1, users.size());
        assertFalse(users.contains(user1));
        assertTrue(users.contains(user2));
    }

    @Test
    public void testSingleUserGetHttpRequest() {
        User user = restTemplate.exchange("http://localhost:" + port + "/users/{id}", HttpMethod.GET, null,
                new ParameterizedTypeReference<User>() { }, user1.getId()).getBody();
        assertEquals(user1, user);
        userService.delete(user1.getId());
        user = restTemplate.exchange("http://localhost:" + port + "/users/{id}", HttpMethod.GET, null,
                new ParameterizedTypeReference<User>() { }, user1.getId()).getBody();
        assertNull(user);
    }

    private User buildUser(final String firstName, final String lastName, final String email,
            final String phoneNumber) {
        return new User(firstName, lastName, email, phoneNumber);
    }
}
