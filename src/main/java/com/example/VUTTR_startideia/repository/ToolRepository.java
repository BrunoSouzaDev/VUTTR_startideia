package com.example.VUTTR_startideia.repository;

import com.example.VUTTR_startideia.model.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {

    @Query(
            value = "select "
                    +"Tools.id_tool, "
                    +"Tools.ds_tool, "
                    +"Tools.tool_link, "
                    +"Tools.tool_title, "
                    +"Tags.id_tag, "
                    +"Tags.nome_tag, "
                    +"from tools "
                    +"inner join tools_tags "
                    +"on tools_tags.tool_id = tools.id_tool "
                    +"inner join tags "
                    +"on tools_tags.tag_id = tag.id_tag "
                    +"where tags.nome_tag LIKE %:tag% ",
            nativeQuery = true
    )
    List<Tool> findByTag(@Param("tag")String tag);
        }
