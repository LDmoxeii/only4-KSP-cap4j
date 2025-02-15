package com.only4.domain.aggregates.member.factory;

import com.only4.domain.aggregates.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregateFactory;
import org.netcorepal.cap4j.ddd.domain.aggregate.AggregatePayload;
import org.netcorepal.cap4j.ddd.domain.aggregate.annotation.Aggregate;
import org.springframework.stereotype.Service;

/**
 * Member聚合工厂
 *
 * @author cap4j-ddd-codegen
 * @date 2024/12/15
 */
@Aggregate(aggregate = "Member", name = "MemberFactory", type = Aggregate.TYPE_FACTORY, description = "")
@Service
public class MemberFactory implements AggregateFactory<MemberFactory.Payload, Member> {

    @Override
    public Member create(Payload payload) {

        return Member.builder()
                .name(payload.name)
                .password(payload.password)
                .phone(payload.phone)
                .build();
    }

    /**
     * Member工厂负载
     */
    @Aggregate(aggregate = "Member", name = "MemberPayload", type = Aggregate.TYPE_FACTORY_PAYLOAD, description = "")
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements AggregatePayload<Member> {

        String name;
        String password;
        String phone;

    }
}
