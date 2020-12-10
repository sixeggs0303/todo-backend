package com.example.todo.service;

import com.example.todo.exception.LabelNotFoundException;
import com.example.todo.model.Label;
import com.example.todo.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelService {
    @Autowired
    private LabelRepository labelRepository;

    public List<Label> getLabels() {
        return labelRepository.findAll();
    }

    public Label getLabel(String id) throws LabelNotFoundException {
        return labelRepository.findById(id).orElseThrow(LabelNotFoundException::new);
    }
}
