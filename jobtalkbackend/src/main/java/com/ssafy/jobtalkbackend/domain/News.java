package com.ssafy.jobtalkbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class News {

    @Id
    @GeneratedValue
    @Column(name = "news_id")
    private Long id;

    private String title;

    private String url;

    private Integer hotRank;

    @OneToMany(mappedBy = "news", cascade = CascadeType.ALL)
    private List<NewsLike> newsLikeList = new ArrayList<>();

    @OneToMany(mappedBy = "news", cascade = CascadeType.ALL)
    private List<Keyword> keywordList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;
}
