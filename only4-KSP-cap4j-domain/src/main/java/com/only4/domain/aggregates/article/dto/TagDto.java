package com.only4.domain.aggregates.article.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author LD_moxeii
 */
@Data
@Builder
@AllArgsConstructor
public class TagDto {

    Long tagId;

    String tagName;

}
