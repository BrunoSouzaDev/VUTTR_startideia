
package com.example.VUTTR_startideia.controller;

import com.example.VUTTR_startideia.repository.ToolRepository;
import com.example.VUTTR_startideia.service.ToolService;
import com.example.VUTTR_startideia.model.dto.MessageResponseDTO;
import com.example.VUTTR_startideia.model.entity.Tool;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tools")
public class ToolController {

    @Autowired
    private ToolRepository toolRepository;

    @Autowired
    private ToolService toolService;

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

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        Optional<Tool> tool = toolRepository.findById(id);
        return tool.isPresent() ?
                ResponseEntity.ok().body(tool.get()) :
                ResponseEntity.notFound().build();
    }

    @GetMapping()
    public List<Tool> findByTagCustom(@RequestParam(name="tag") String tag){
        List<Tool> tollsTaged = toolRepository.findByTag(tag);
        return tollsTaged;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO criarTool(@RequestBody Tool tool) {
        System.out.println("Tool="+tool.getTitle());
        System.out.println("Tool="+tool.getDsTool());
        System.out.println("Tool="+tool.getLink());
        System.out.println("Tool="+tool.getTags());
        Tool toolSalvo = toolRepository.save(tool);
        return MessageResponseDTO.builder()
                .message("Tool criado " + toolSalvo.getTitle())
                .build();
    }

    @DeleteMapping(value="/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Tool> delete(@PathVariable Long id) {
        toolService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}