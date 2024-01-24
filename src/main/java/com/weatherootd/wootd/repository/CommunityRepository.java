package com.weatherootd.wootd.repository;

import com.weatherootd.wootd.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CommunityRepository extends JpaRepository<Community, Long>, QuerydslPredicateExecutor<Community> {
}
