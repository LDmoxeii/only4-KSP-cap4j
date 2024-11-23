package com.only4.application.commands.star_comment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.netcorepal.cap4j.ddd.Mediator;
import org.netcorepal.cap4j.ddd.application.command.Command;
import org.springframework.stereotype.Service;

/**
 * DeleteStarCommentCmd命令请求实现
 * 删除评论
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/22
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteStarCommentCmdHandler implements Command<DeleteStarCommentCmdRequest, DeleteStarCommentCmdResponse> {

    @Override
    public DeleteStarCommentCmdResponse exec(DeleteStarCommentCmdRequest cmd) {
        Mediator.uow().save();
        
        return DeleteStarCommentCmdResponse.builder()
                .success(true)
                .build();
    }
}
