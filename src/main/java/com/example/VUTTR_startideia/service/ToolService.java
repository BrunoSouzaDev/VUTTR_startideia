package com.example.VUTTR_startideia.service;

import com.example.VUTTR_startideia.model.entity.Tool;
import com.example.VUTTR_startideia.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ToolService {

    @Autowired
    private ToolRepository toolRepository;

    public Tool findById(long id){
        Optional<Tool> tool = toolRepository.findById(id);
        if(tool.isPresent()){
            return tool.get();
        } else {
            throw new RuntimeException("A ferramenta selecionada não existe.");
        }
    }

    public void delete(Long id) {
        toolRepository.deleteById(id);
    }

}
