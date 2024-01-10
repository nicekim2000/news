package com.kw.news.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.time.OffsetDateTime;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "news_articles")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    @JsonProperty("published_time") // JSON 필드명에 매핑
    @Column(name = "published_time")
    private OffsetDateTime publishedTime;

    private String media;
    private String title;
    private String author;
    private String content;
    private String url;

    // 게터, 세터, 생성자 등
}
