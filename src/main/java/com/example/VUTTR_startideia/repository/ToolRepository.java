package com.example.VUTTR_startideia.repository;

import com.example.VUTTR_startideia.model.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {


}
