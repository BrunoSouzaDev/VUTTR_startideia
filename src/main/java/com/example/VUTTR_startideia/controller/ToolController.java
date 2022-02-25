
package com.example.VUTTR_startideia.controller;

import com.example.VUTTR_startideia.model.dto.MessageResponseDTO;
import com.example.VUTTR_startideia.model.entity.Tool;
import com.example.VUTTR_startideia.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tools")
public class ToolController {

    @Autowired
    private ToolRepository toolRepository;

    @GetMapping()
    public List<Tool> listarTodasTools(){
        return toolRepository.findAll();
    }

    @GetMapping("tools")
    public ResponseEntity find(Tool filtro) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        List<Tool> lista = toolRepository.findAll(example);
        return ResponseEntity.ok(lista);
    }

    @PostMapping()
    public MessageResponseDTO criarProduto(@RequestBody Tool tool) {
        Tool toolSalvo = toolRepository.save(tool);
        return MessageResponseDTO.builder()
                .message("Produto criado " + toolSalvo.getDsTool())
                .build();
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Tool> delete(@PathVariable Long id) {
        toolService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}