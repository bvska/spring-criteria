package com.example.springcriteria.specifications;

import com.example.springcriteria.entity.Article;
import com.example.springcriteria.entity.Author;
import com.example.springcriteria.entity.Author_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

public class AuthorSpecifications {
    public static Specification<Author> withoutArticles(){
        return (root, query, criteriaBuilder) -> {
            Join<Author, Article> authorArticle =
                   root.join(Author_.articles , JoinType.LEFT);
            return criteriaBuilder.isNull(authorArticle.get(Author_.id));
        };
    }

    public static Specification<Author> articlesCount(String name){
        return (root, query, criteriaBuilder) -> {
            CriteriaQuery<Long> longQuery = criteriaBuilder.createQuery(Long.class);
            Join<Author, Article> authorArticle =
                    root.join(Author_.articles , JoinType.LEFT);

            Predicate condition = criteriaBuilder.equal(root.get(Author_.name), name);
            //SubQuery
            // .in(list);
//            query.groupBy(authorArticle.get(Author_.id))
//                    .orderBy(criteriaBuilder.asc(root.get(Author_.name)),
//                          criteriaBuilder.desc(root.get(Author_.age)));

            longQuery.select(criteriaBuilder.count(authorArticle))
                    .where(condition)
                    .groupBy(root.get(Author_.id));

            return longQuery.getRestriction();
        };
    }
}



