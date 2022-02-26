package com.example.VUTTR_startideia.model.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ToolDTO {

    private long idTool;

    private String title;

    private String link;

    private String description;

    private String tags;

    public String tags() {
        return tags;
    }

    public String[] getTags() {
        return tags.split(" ");
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
