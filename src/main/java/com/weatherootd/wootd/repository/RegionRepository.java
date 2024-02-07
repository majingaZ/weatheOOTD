package com.weatherootd.wootd.repository;

import com.weatherootd.wootd.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {

    @Query("SELECT r.nx, r.ny FROM Region r WHERE r.township = :township")
    List<Object[]> findByTownship(@Param("township") String township);
}
