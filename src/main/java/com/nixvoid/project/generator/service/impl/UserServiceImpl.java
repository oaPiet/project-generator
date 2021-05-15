package com.nixvoid.project.generator.service.impl;

import com.nixvoid.project.generator.domain.User;
import com.nixvoid.project.generator.repository.UserRepository;
import com.nixvoid.project.generator.service.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * Project: project-generator
 * Created by piet
 */
@ApplicationScoped
public class UserServiceImpl implements UserService {

     @Inject
     UserRepository userRepository;

     @Override
     @Transactional
     public String createUser(User user) {

          String responseMessage = "error";

          if(user != null) {
               userRepository.persistAndFlush(user);
               responseMessage = "Successful";
          }
          return responseMessage;
     }
}