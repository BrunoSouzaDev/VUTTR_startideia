package com.example.VUTTR_startideia.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    @Column(name="tool_tags")
    private String tags;
//
//    public String tags() {
//        return tags;
//    }
//
//    public String[] getTags() {
//        return tags.split(" ");
//    }
//
//    public void setTags(String tags) {
//        this.tags = tags;
//    }

}
