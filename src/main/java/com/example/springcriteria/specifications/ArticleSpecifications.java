package com.example.springcriteria.specifications;

import com.example.springcriteria.entity.Article;
import com.example.springcriteria.entity.Article_;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class ArticleSpecifications {
    public static Specification<Article> articleByTitle(String title){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Article_.title), title);
    }

    public static Specification<Article> lastYear(){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                criteriaBuilder.function("year", Integer.class, root.get(Article_.created)),
                        LocalDateTime.now().minusYears(1));
    }
}
