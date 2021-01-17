package com.example.springcriteria.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ArticleNomination {

    @EmbeddedId
    private ArticleNominationKey id;

    @Setter
    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("articleId")
    private Article article;

    @Setter
    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("nominationId")
    private Nomination nomination;

    @Setter
    @Getter
    @Column(nullable = false)
    private Rate rate;

    @Embeddable
    public static class ArticleNominationKey implements Serializable {

        @Getter
        @Column(name = "article_id")
        private Long articleId;

        @Getter
        @Column(name = "nomination_id")
        private Long nominationId;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass())
                return false;

            ArticleNominationKey ank = (ArticleNominationKey) o;
            return Objects.equals(articleId, ank.articleId) &&
                    Objects.equals(nominationId, ank.nominationId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(articleId, nominationId);
        }
    }

    public enum Rate {
        FIRST, SECOND, THIRD
    }
}
