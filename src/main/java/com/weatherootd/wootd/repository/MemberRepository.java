package com.weatherootd.wootd.repository;

import com.weatherootd.wootd.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Object> findById (String id);
    Optional<Object> findByNickname (String nickname);
}
