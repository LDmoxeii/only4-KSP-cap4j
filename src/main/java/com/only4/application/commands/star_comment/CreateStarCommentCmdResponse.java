package com.only4.application.commands.star_comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CreateStarCommentCmd命令响应
 * todo: 命令描述
 *
 * @author cap4j-ddd-codegen
 * @date 2024/11/22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateStarCommentCmdResponse {
    boolean success;
}
