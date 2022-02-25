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
@Entity(name="tb_tools")
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tool")
    private Long idTool;

    @Column(name="toolTitle")
    private String title;

    @Column(name="toolLink")
    private String link;

    @Column(name="dsTool")
    private String dsTool;

    @Column(name="toolTags")
    private String tags;

}
