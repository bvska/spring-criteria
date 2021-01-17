package com.example.springcriteria.controllers;

import com.example.springcriteria.entity.Article;
import com.example.springcriteria.entity.Author;
import com.example.springcriteria.repositories.ArticleRepository;
import com.example.springcriteria.repositories.AuthorRepository;
import com.example.springcriteria.specifications.ArticleSpecifications;
import com.example.springcriteria.specifications.AuthorSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/bytitle/{title}")
    public Optional<Article> getByTitle(@PathVariable String title){
        Optional<Article> article = articleRepository.
                findOne(ArticleSpecifications.articleByTitle(title));
        System.out.println(article);
        return article;
    }


    // передача данных в строке запроса через ?first=value&second=value
    @GetMapping("/params")
    public void params(@RequestParam int first, @RequestParam int second){
        System.out.println("first " + first);
        System.out.println("second " + second);
    }

    // передача данных в строке запроса через /{param}
    @GetMapping("/{param}")
    public void param(@PathVariable String param){
        System.out.println("param " + param);
    }

    // передача данных в теле сообщения:
    // получение строки json из тела сообщения
    @PostMapping("/json")
    public void json(@RequestBody String jsonString){
        System.out.println("jsonString: " + jsonString);
    }

    // передача данных в теле сообщения:
    // получение строки json из тела сообщения и генерация в объект
    @PostMapping("/json/to/object")
    public void jsonToObject(@RequestBody Author author){
        System.out.println("author " + author);
    }
    // first: paramValue,
    // second: paramValue,
    // передача данных в теле сообщения: получение параметров
    @PostMapping("/many/params")
    public void manyParams(@RequestParam(value = "first") String first,
                           @RequestParam(value = "second") int second){
        System.out.println("first: " + first);
        System.out.println("second: " + second);
    }

    // Если необходимо вернуть из метода не json строку и
    // не html для (@Controller)
    // используйте аннотацию @ResponseBody типВозвращаемогоЗначения
    @GetMapping(value = "/img")
    public @ResponseBody byte[] getImg(){
        // преобразование изображения в массив байт
        return new byte[20];
    }
}







