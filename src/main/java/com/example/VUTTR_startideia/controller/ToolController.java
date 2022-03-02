package com.example.VUTTR_startideia.controller;

import com.example.VUTTR_startideia.repository.ToolRepository;
import com.example.VUTTR_startideia.service.ToolService;
import com.example.VUTTR_startideia.model.dto.MessageResponseDTO;
import com.example.VUTTR_startideia.model.entity.Tool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@Api(value = "API REST VUTTR")
@CrossOrigin(origins="*")
public class ToolController {

    @Autowired
    private ToolRepository toolRepository;

    @Autowired
    private ToolService toolService;

    @GetMapping()
    @ApiOperation(value="Lista todas as tool do usuário ou por tag como ?tag=node")
    public ResponseEntity find(@RequestParam(name="tag", defaultValue = "0") String tag) {
        List<Tool> lista;

        if(!tag.equals("0")){
            lista = toolRepository.findByTag(tag);
        }else{
            lista = toolRepository.findAll();
        }

        return ResponseEntity.ok().body(lista);
    }


    @GetMapping("/{id}")
    @ApiOperation(value="Lista por tool/id")
    public ResponseEntity<Tool> findById(@PathVariable Long id){
        Optional<Tool> tool = toolRepository.findById(id);

        return tool.isPresent() ?
                ResponseEntity.ok().body(tool.get()) :
                ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value="Cria uma nova Tool")
    public MessageResponseDTO criarTool(@RequestBody Tool tool) {

        tool = toolRepository.save(tool);
        return MessageResponseDTO.builder()
                .message("Tool criado " + tool.getTitle())
                .build();
    }

    @DeleteMapping(value="/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @ApiOperation(value="Deleta uma tool por id")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        toolService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}