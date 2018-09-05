package com.company.task1.app.controller;

import com.company.task1.app.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserControllerTest {

    @Test
    public void testUserController() {
        org.junit.Assert.assertNotNull(new UserController(new UserServiceImpl()));
    }

    @Test
    public void testUser() {
    }

    @Test
    public void testUsers() {
    }

    @Test
    public void testCreate() {
    }

    @Test
    public void testDelete() {
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testSetUserService() {
    }
}
