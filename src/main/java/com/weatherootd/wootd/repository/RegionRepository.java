package com.weatherootd.wootd.repository;

import com.weatherootd.wootd.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {
    @Query("SELECT r.nx, r.ny FROM Region r WHERE r.township = :township")
    List<Object[]> findByTownship(@Param("township") String township);

    @Query("SELECT r.nx, r.ny FROM Region r WHERE r.province = ?1 AND r.district LIKE %?2% AND (r.township = ?3 OR r.township = '')")
    List<Region> findByNxNy(String addrSido, String addrSigungu, String addrEmdong);
}
