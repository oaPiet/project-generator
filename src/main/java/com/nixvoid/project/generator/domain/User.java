package com.nixvoid.project.generator.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.smallrye.common.constraint.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Project: project-generator
 * Created by piet
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @NotNull
    private Long userId;

    @NotNull
    private String username;
}