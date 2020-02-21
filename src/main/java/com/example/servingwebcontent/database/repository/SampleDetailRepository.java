package com.example.servingwebcontent.database.repository;

import com.example.servingwebcontent.database.entity.SampleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleDetailRepository extends JpaRepository<SampleDetail, String> {
}
