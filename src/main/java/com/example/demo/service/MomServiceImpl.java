package com.example.demo.service;

import com.example.demo.model.Mom;
import com.example.demo.repository.ChildRepository;
import com.example.demo.repository.MomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class MomServiceImpl implements MomService {

    private final MomRepository momRepository;
    private final ChildRepository childRepository;

    @Override
    public List<Mom> getMommies() {
        return momRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteMomById(Long id) {
        childRepository.setChildIdToNullByMomId(id);
        momRepository.deleteById(id);
    }
}
