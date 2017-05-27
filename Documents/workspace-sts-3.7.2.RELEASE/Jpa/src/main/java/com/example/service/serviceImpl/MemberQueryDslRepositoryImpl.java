package com.example.service.serviceImpl;

import com.example.service.MemberQueryDslRepository;
import com.example.service.vo.Member;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by yongyeonkim on 2016. 7. 18..
 */
public class MemberQueryDslRepositoryImpl extends QueryDslRepositorySupport implements MemberQueryDslRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public MemberQueryDslRepositoryImpl() {
        super(Member.class);
    }

    @Override
    public Member findById(String id) {

        JPAQuery query = new JPAQuery(entityManager);
        QMember member = QMember.member;
        return query.from(member)
                .where(member.id.eq(id))
                .uniqueResult(member); //하나 이상이면 처음거를 반환
    }
}
