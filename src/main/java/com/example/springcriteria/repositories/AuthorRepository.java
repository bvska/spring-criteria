package com.example.springcriteria.repositories;


import com.example.springcriteria.entity.Author;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorRepository extends
        PagingAndSortingRepository<Author, Long>,
        JpaSpecificationExecutor<Author> { }