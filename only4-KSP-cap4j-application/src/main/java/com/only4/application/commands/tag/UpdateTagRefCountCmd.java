package com.only4.application.commands.tag;


import com.only4.common.exception.KnownException;
import com.only4.domain.aggregates.tag.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.RequestParam;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.netcorepal.cap4j.ddd.domain.repo.JpaPredicate;
import org.springframework.stereotype.Service;

/**
 * 更新标签引用次数
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/19
 */
public class UpdateTagRefCountCmd {

    /**
     * UpdateTagRefCountCmd命令请求实现
     */
    @Service
    @RequiredArgsConstructor
    @Slf4j
    public static class Handler implements Command<Request, Response> {
        @Override
        public Response exec(Request cmd) {
            Tag tag = Mediator.repositories()
                    .findOne(JpaPredicate.byId(Tag.class, cmd.getTagId()))
                    .orElseThrow(() -> new KnownException("标签不存在, tagId=" + cmd.getTagId()));

            tag.updateRefCount(cmd.getRefCount());
            Mediator.uow().persist(tag);
            Mediator.uow().save();

            return Response.builder()
                    .success(true)
                    .build();
        }
    }

    /**
     * UpdateTagRefCountCmd命令请求参数
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request implements RequestParam<Response> {

        Long tagId;

        @NotNull
        Integer refCount;
    }

    /**
     * UpdateTagRefCountCmd命令响应
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        boolean success;
    }
}
