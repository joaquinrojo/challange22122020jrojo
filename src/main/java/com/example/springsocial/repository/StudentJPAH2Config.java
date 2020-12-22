package com.example.springsocial.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(repositoryBaseClass = ExtendedRepositoryImpl.class)
public class StudentJPAH2Config {
    // additional JPA Configuration
}