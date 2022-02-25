package com.example.VUTTR_startideia.repository;


import com.example.VUTTR_startideia.model.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public class ToolRepository extends JpaRepository<Tool, Long> {

    public List<Tool> findByDsTool(String dsTool);

    public List<Tool> findByDsTollIgnoreCaseContaining(String dsTool);

    @Query(value = "select * from tool where ds_tool like '%:dsTool%'", nativeQuery = true)
    public List<Tool> findContainingDsProduto(@Param("dsTool")String dsTool);

    @Query("select p.idTool from tool p")
    public List<Long> buscarIdsUtilizados();

}
