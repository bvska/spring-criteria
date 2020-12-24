package com.example.springcriteria.repositories;

import com.example.springcriteria.entity.Article;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {
}
