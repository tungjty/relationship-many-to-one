package com.example.demo.repository;

import com.example.demo.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ChildRepository extends JpaRepository<Child, Long> {

    @Modifying
    // Native Query
    @Query(
            value = "update tbl_child set mom_id = null where mom_id = ?1",
            nativeQuery = true
    )
    void setChildIdToNullByMomId(Long id);
}