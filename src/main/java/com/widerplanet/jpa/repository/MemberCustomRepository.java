package com.widerplanet.jpa.repository;

import com.widerplanet.jpa.entity.Member;

import java.util.List;

public interface MemberCustomRepository  {
    // Custom Method
    public List<Member> findByCustomOption(String name);
}
