package com.only4.application.commands.star_comment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

/**
 * CreateStarCommentCmd命令请求实现
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/22
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CreateStarCommentCmdHandler implements Command<CreateStarCommentCmdRequest, CreateStarCommentCmdResponse> {

    @Override
    public CreateStarCommentCmdResponse exec(CreateStarCommentCmdRequest cmd) {
        Mediator.uow().save();
        
        return CreateStarCommentCmdResponse.builder()
                .success(true)
                .build();
    }
}
