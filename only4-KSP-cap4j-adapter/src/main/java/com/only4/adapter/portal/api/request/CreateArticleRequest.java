package com.only4.adapter.portal.api.request;

import com.only4.domain.aggregates.article.dto.ArticleAuthorDto;
import lombok.Data;

import java.util.List;

/**
 * @author LD_moxeii
 */
@Data
public class CreateArticleRequest {

    String title;

    String description;

    String content;

    List<ArticleAuthorDto> authors;
}
