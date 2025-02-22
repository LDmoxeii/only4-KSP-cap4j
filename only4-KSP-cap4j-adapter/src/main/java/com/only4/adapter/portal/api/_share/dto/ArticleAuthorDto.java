package com.only4.adapter.portal.api._share.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LD_moxeii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleAuthorDto {

    private Long id;

    private String name;
}
