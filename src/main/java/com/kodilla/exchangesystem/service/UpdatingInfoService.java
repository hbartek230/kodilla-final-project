package com.kodilla.exchangesystem.service;

import com.kodilla.exchangesystem.domain.UpdatingInfo;
import com.kodilla.exchangesystem.domain.dto.UpdatingInfoDto;
import com.kodilla.exchangesystem.mapper.UpdatingInfoMapper;
import com.kodilla.exchangesystem.repository.UpdatingInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdatingInfoService {

    private final UpdatingInfoRepository repository;
    private final UpdatingInfoMapper mapper;

    public UpdatingInfoService(UpdatingInfoRepository repository, UpdatingInfoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<UpdatingInfo> getUpdatingInfos() {
        return repository.findAll();
    }

    public void addUpdatingInfo(UpdatingInfoDto info){
        repository.save(mapper.mapToUpdatingInfo(info));
    }

}
