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
                    +"tools.id_tool, "
                    +"tools.ds_tool, "
                    +"tools.tool_link, "
                    +"tools.tool_title, "
                    +"tools_tags.tool_id, "
                    +"tools_tags.tag_id, "
                    +"tags.id_tag, "
                    +"tags.nome_tag "
                    +"from tools "
                    +"inner join tools_tags "
                    +"on tools_tags.tool_id = tools.id_tool "
                    +"inner join tags "
                    +"on tools_tags.tag_id = tags.id_tag "
                    +"where tags.nome_tag LIKE %:tag% ",
            nativeQuery = true
    )
    List<Tool> findByTag(@Param("tag")String tag);
}
