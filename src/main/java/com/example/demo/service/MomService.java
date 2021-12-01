package com.example.demo.service;

import com.example.demo.model.Mom;

import java.util.List;

public interface MomService {

    List<Mom> getMommies();

    void deleteMomById(Long id);
}
