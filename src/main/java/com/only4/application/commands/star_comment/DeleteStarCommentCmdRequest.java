package com.only4.application.commands.star_comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.application.RequestParam;

/**
 * DeleteStarCommentCmd命令请求参数
 * 删除评论
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteStarCommentCmdRequest implements RequestParam<DeleteStarCommentCmdResponse> {
    Long id;
}