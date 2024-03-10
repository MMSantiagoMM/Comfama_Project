package com.comfama.project.application.service.representative;


import com.comfama.project.application.dto.RepresentativeDTO;
import com.comfama.project.application.mappers.RepresentativeMapperDto;
import com.comfama.project.domain.models.Representative;
import com.comfama.project.infrastructure.adapters.representative.RepresentativeJpaRepository;
import com.comfama.project.infrastructure.exceptions.RepresentativeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
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
    public Optional<Representative> updateRepresentative(Integer id, RepresentativeDTO dto) {
        return Optional.ofNullable(repository.getRepresentative(id)
                .map(representative -> {
                    representative.setName(dto.getName());
                    representative.setLastName(dto.getLastName());
                    representative.setEmail(dto.getEmail());
                    representative.setCelPhone(dto.getCelPhone());
                    representative.setTelephone(dto.getTelephone());
                    representative.setTypeDocument(dto.getTypeDocument());
                   repository.updateRepresentative(id,representative);
                   return representative;
                }).orElseThrow(()-> new RepresentativeNotFoundException(id)));
    }

    @Override
    public Boolean deleteRepresentative(Integer id) {
        return repository.deleteRepresentative(id);
    }
}
