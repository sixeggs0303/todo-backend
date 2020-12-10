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

    public Label createLabel(Label label) {
        return labelRepository.save(label);
    }

    public void deleteLabel(String id) throws LabelNotFoundException {
        if (!labelRepository.existsById(id)) {
            throw new LabelNotFoundException();
        }
        labelRepository.deleteById(id);
    }
}
