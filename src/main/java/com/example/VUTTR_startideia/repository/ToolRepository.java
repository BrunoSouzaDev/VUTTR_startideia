package com.example.VUTTR_startideia.repository;

import com.example.VUTTR_startideia.model.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {

    @Query(
            value = "select "
                    +"Tools.id_tool, "
                    +"Tools.tool_title, "
                    +"Tools.tool_link, "
                    +"Tools.ds_tool, "
                    +"Tags.id_tag, "
                    +"Tags.nome_tag, "
                    +"from tools "
                    +"inner join tools_tags "
                    +"on tools_tags.tool_id = tools.id_tool "
                    +"where tags.nome_tag = ?1 ",
            nativeQuery = true
    )
    List<Tool> findByTag(String tag );
        }
