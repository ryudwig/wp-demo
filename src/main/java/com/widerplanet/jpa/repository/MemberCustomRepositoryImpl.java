package com.widerplanet.jpa.repository;

import com.widerplanet.jpa.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class MemberCustomRepositoryImpl implements MemberCustomRepository
{
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Member> findByCustomOption(String name) {
        // Native Query String
        String queryString = "select * from member where name like ?";

        // NativeQuery인 경우, createNativQuery(...)
        // JPQL인 경우, createQuery(...) 메소드 사용
        Query query = entityManager.createNativeQuery(queryString, Member.class);
        query.setParameter(1, name + "%");

        List<Member> list = query.getResultList();
        return list;
    }
}
