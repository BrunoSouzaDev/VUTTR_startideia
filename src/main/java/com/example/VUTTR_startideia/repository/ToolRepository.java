package com.example.VUTTR_startideia.repository;


import com.example.VUTTR_startideia.model.entity.Tool;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {


//    by id
    @Query("select u from Tool u where u.id = ?1")
    Tool findByIdTool(Long id);

//    by tag
    @Query(value = "SELECT * FROM tb_tool WHERE unaccent(tags) ilike unaccent('%' || ?1 || '%')",
            nativeQuery = true)
    Page<Tool> findByTag(String tag, Pageable pageable);

//    all tools
    @Query(value = "SELECT * FROM tb_tool",
            nativeQuery = true)
    Page<Tool> findAllTool(Pageable pageable);


}
