package com.only4.adapter.application.queries;

import com.only4.application.queries.tag.TagExistsByIdQry;
import com.only4.domain.aggregates.tag.meta.TagSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * TagExistsByIdQry查询请求适配实现
 * 根据Id判断标签是否存在
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/22
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class TagExistsByIdQryHandler implements Query<TagExistsByIdQry.Request, TagExistsByIdQry.Response> {

    @Override
    public TagExistsByIdQry.Response exec(TagExistsByIdQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！

        return TagExistsByIdQry.Response.builder()
                .exists(byJpa(request.getTagId()))
                .build();
    }

    public boolean byJpa(Long tagId) {
        return Mediator.repositories()
                .exists(TagSchema.predicateById(tagId));
    }
}
