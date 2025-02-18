package com.only4.domain.aggregates.member.specs;

import com.only4.domain.aggregates.member.Member;
import org.netcorepal.cap4j.ddd.domain.aggregate.Specification;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * Member规格约束
 *
 *
 * @author cap4j-ddd-codegen
 * @date 2025/02/18
 */
@Aggregate(aggregate = "Member", name = "MemberSpecification", type = Aggregate.TYPE_SPECIFICATION, description = "")
@Service
public class MemberSpecification implements Specification<Member> {
    @Override
    public Result specify(Member entity) {
        if (!entity.validateRank()) {
            return Result.fail("等级分为负");
        }
        if (!entity.validateLikeCount()){
            return Result.fail("点赞数为负");
        }
        if (!entity.validateFanCount()) {
            return Result.fail("粉丝数为负");
        }
        if (!entity.validateReportCount()) {
            return Result.fail("举报数为负");
        }
        if (!entity.validateFollowingCount()) {
            return Result.fail("关注数为负");
        }
        if (!entity.validateWorkCount()) {
            return Result.fail("作品数为负");
        }
        if (!entity.validateFavoritesArticleCount()) {
            return Result.fail("收藏夹作品数为负");
        }

        return Result.pass();
    }
}
