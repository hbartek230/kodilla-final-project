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

    public UpdatingInfoService(UpdatingInfoRepository repository) {
        this.repository = repository;
    }

    public List<UpdatingInfo> getUpdatingInfos() {
        return repository.findAll();
    }

    public UpdatingInfo addUpdatingInfo(UpdatingInfo info) {
        return repository.save(info);
    }

}
