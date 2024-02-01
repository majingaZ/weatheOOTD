package com.weatherootd.wootd.repository;

import com.weatherootd.wootd.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findById (String id);
    Member findByNickname (String nickname);

}
