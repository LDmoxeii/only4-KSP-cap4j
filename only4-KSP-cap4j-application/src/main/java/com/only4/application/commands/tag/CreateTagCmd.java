package com.only4.application.commands.tag;


import com.only4.application.validater.TagUniqueName;
import com.only4.domain.aggregates.tag.Tag;
import com.only4.domain.aggregates.tag.factory.TagFactory;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

/**
 * 创建标签
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
public class CreateTagCmd {

    /**
     * CreateTagCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            Tag tag = Optional.ofNullable(Mediator.factories()
                            .create(TagFactory.Payload.builder()
                                    .name(cmd.getTagName())
                                    .description(cmd.getTagDesc())
                                    .icon(cmd.getTagIcon())
                                    .build()))
                    .orElseThrow(() -> new RuntimeException("创建标签失败"));

            tag.create();
            Mediator.uow().persist(tag);
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * CreateTagCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        @NotBlank
        @TagUniqueName
        String tagName;

        @NotBlank
        String tagDesc;

        @NotBlank
        String tagIcon;
    }

    /**
     * CreateTagCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
