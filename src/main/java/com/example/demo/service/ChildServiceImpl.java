package com.example.demo.service;

import com.example.demo.model.Child;
import com.example.demo.repository.ChildRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChildServiceImpl implements ChildService {

    private final ChildRepository childRepository;

    @Override
    public List<Child> getChildren() {
        return childRepository.findAll();
    }

    @Override
    public void deleteChildById(Long id) {
        childRepository.deleteById(id);
    }
}
