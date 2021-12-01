package com.example.demo.repository;

import com.example.demo.model.Mom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MomRepository extends JpaRepository<Mom, Long> {

    Mom findByMomName(String fullName);
}