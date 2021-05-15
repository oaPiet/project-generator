package com.nixvoid.project.generator.controller;

import com.nixvoid.project.generator.domain.User;
import com.nixvoid.project.generator.service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;

/**
 * Project: project-generator
 * Created by piet
 */
@Path("/user")
@RequestScoped
public class UserController {

    @Inject
    UserService userService;

    @POST
    @Path("/create")
    @Consumes("application/json")
    @Produces("application/json")
    public String createUSer (User user) {
        return userService.createUser(user);
    }
}