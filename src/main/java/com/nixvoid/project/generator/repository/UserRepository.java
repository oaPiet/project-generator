package com.nixvoid.project.generator.repository;

import com.nixvoid.project.generator.domain.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

/**
 * Project: project-generator
 * Created by piet
 */
@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
}
