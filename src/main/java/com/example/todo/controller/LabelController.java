package com.example.todo.controller;

import com.example.todo.dto.LabelRequest;
import com.example.todo.dto.LabelResponse;
import com.example.todo.exception.LabelNotFoundException;
import com.example.todo.mapper.LabelMapper;
import com.example.todo.model.Label;
import com.example.todo.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/labels")
public class LabelController {
    @Autowired
    private LabelService labelService;
    @Autowired
    private LabelMapper labelMapper;

    @GetMapping
    public List<LabelResponse> getLabels() {
        return labelService.getLabels().stream().map(label -> labelMapper.toResponse(label)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public LabelResponse getLabel(@PathVariable String id) throws LabelNotFoundException {
        return labelMapper.toResponse(labelService.getLabel(id));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public LabelResponse createLabel(@RequestBody LabelRequest labelRequest) {
        Label label = labelMapper.toEntity(labelRequest);
        return labelMapper.toResponse(labelService.createLabel(label));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLabel(@PathVariable String id) throws LabelNotFoundException {
        labelService.deleteLabel(id);
    }
}
