package com.example.springcriteria.controllers;

import com.example.springcriteria.repositories.ArticleRepository;
import com.example.springcriteria.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private ArticleRepository articleRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public TestController(ArticleRepository articleRepository, AuthorRepository authorRepository) {
        this.articleRepository = articleRepository;
        this.authorRepository = authorRepository;
    }

}
