package com.weatherootd.wootd.repository;

import com.weatherootd.wootd.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AnswerRepository extends JpaRepository<Answer, Long>, QuerydslPredicateExecutor<Answer> {
}
