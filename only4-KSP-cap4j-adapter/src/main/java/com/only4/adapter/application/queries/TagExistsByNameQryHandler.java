package com.only4.adapter.application.queries;

import com.only4.adapter.infra.mybatis.mapper.TagMapper;
import com.only4.application.queries.tag.TagExistsByNameQry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.application.query.Query;
import org.springframework.stereotype.Service;

/**
 * ExistedByNameQry查询请求适配实现 </br>
 * 根据 标签名 判断标签是否存在
 *
 * @author cap4j-ddd-codegen
 * @date 2025/01/19
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class TagExistsByNameQryHandler implements Query<TagExistsByNameQry.Request, TagExistsByNameQry.Response> {
    private final TagMapper tagMapper;
    @Override
    public TagExistsByNameQry.Response exec(TagExistsByNameQry.Request request) {
        // mybatis / jpa 哪个顺手就用哪个吧！
        Boolean isExists = tagMapper.existedTagByName(request.getName());
        return TagExistsByNameQry.Response.builder()
                .existed(isExists)
                .build();
    }
}
