package com.only4.adapter.infra.mybatis.mapper;

import com.only4.domain.aggregates.article.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
    Article getById(Long Id);

    Boolean existedByArticleId(Long Id);

    Boolean existedByCategoryId(Long Id);
}
