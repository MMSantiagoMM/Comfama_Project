package com.comfama.project.application.service.representative;


import com.comfama.project.application.dto.RepresentativeDTO;
import com.comfama.project.application.mappers.RepresentativeMapperDto;
import com.comfama.project.domain.models.Representative;
import com.comfama.project.infrastructure.adapters.representative.RepresentativeJpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RepresentativeService implements IRepresentativeService{

    private final RepresentativeJpaRepository repository;
    private final RepresentativeMapperDto mapper;

    public RepresentativeService(RepresentativeJpaRepository repository, RepresentativeMapperDto mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Iterable<Representative> getRepresentatives() {
        return repository.getAllRepresentatives();
    }

    @Override
    public Representative getRepresentativeById(Integer id) {
        return repository.getRepresentative(id).get();
    }

    @Override
    public Representative saveRepresentative(RepresentativeDTO dto) {
        return repository.saveRepresentative(
                mapper.toRepresentative(dto)
        );
    }

    @Override
    public Boolean deleteRepresentative(Integer id) {
        return repository.deleteRepresentative(id);
    }
}
