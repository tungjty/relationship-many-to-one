package com.example.demo.service;

import com.example.demo.model.Child;

import java.util.List;

public interface ChildService {

    List<Child> getChildren();

    void deleteChildById(Long id);
}
