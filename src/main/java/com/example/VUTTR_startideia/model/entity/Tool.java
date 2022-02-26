package com.example.VUTTR_startideia.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.GenerationType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Tools")
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tool")
    private Long idTool;

    @Column(name="tool_title")
    private String title;

    @Column(name="tool_link")
    private String link;

    @Column(name="ds_tool")
    private String dsTool;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name="tools_tags",
                joinColumns = {
                    @JoinColumn(name="tool_id", referencedColumnName = "id_tool",
                        nullable = false, updatable = false)
                },
                inverseJoinColumns = {
                    @JoinColumn(name="tag_id", referencedColumnName = "id_tag",
                        nullable = false, updatable = false)
                }
    )
    private List<Tag> tags;


}
