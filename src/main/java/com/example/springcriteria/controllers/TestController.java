package com.example.springcriteria.controllers;

import com.example.springcriteria.entity.Author;
import com.example.springcriteria.repositories.ArticleRepository;
import com.example.springcriteria.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // GET запрос, передача данных через ?first=value&second=value
    @GetMapping("/params")
    public void params(@RequestParam int first, @RequestParam int second){
        System.out.println("first " + first);
        System.out.println("second " + second);
    }

    // GET запрос, передача данных через /{param}
    @GetMapping("/{param}")
    public void param(@PathVariable String paramValue){
        System.out.println("paramValue " + paramValue);
    }

    // POST запрос: получение строки json из тела сообщения
    @PostMapping("/json")
    public void json(@RequestBody String data){
        System.out.println("data " + data);
    }

    // POST запрос: получение строки json из тела сообщения и генерация в объект
    @PostMapping("/json/to/object")
    public void jsonToObject(@RequestBody Author author){
        System.out.println("author " + author);
    }

    // POST запрос: получение параметров
    @PostMapping("/many/params")
    public void manyParams(@RequestParam(value = "first") String first, @RequestParam(value = "second") int second){
        System.out.println("first: " + first);
        System.out.println("second: " + second);
    }

    // Если необходимо вернуть из метода не json строку используйте аннотацию @ResponseBody типВозвращаемогоЗначения
    @GetMapping(value = "/img")
    public @ResponseBody byte[] getImg(){
        // преобразование изображения в массив байт
        return new byte[20];
    }

}
