package com.comfama.project.infrastructure.adapters.representative;


import com.comfama.project.domain.models.Representative;
import com.comfama.project.domain.ports.IRepresentativeRepository;
import com.comfama.project.infrastructure.entities.RepresentativeEntity;
import com.comfama.project.infrastructure.exceptions.ProposerNotFoundException;
import com.comfama.project.infrastructure.exceptions.RepresentativeNotFoundException;
import com.comfama.project.infrastructure.mappers.RepresentativeMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RepresentativeJpaRepository implements IRepresentativeRepository {

    private final IRepresentativeJpaRepository repository;
    private final RepresentativeMapper mapper;


    public RepresentativeJpaRepository(IRepresentativeJpaRepository repository, RepresentativeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public Iterable<Representative> getAllRepresentatives() {
        return mapper.toRepresentatives(repository.findAll());
    }

    @Override
    public Optional<Representative> getRepresentative(Integer id) {
        RepresentativeEntity representative = repository.findById(id)
                .orElseThrow(()-> new RepresentativeNotFoundException(id));
        return Optional.of(mapper.toRepresentative(representative));
    }

    @Override
    public Representative saveRepresentative(Representative representative) {
        repository.save(mapper.toEntity(representative));
        return representative;

    }

    @Override
    public Optional <Representative> updateRepresentative(Integer id, Representative newRepresentative) {
        return Optional.ofNullable(repository.findById(id)
                .map(representative -> {
                    representative.setName(newRepresentative.getName());
                    representative.setLastName(newRepresentative.getLastName());
                    representative.setEmail(newRepresentative.getEmail());
                    representative.setCelPhone(newRepresentative.getCelPhone());
                    representative.setTelephone(newRepresentative.getTelephone());
                    representative.setTypeDocument(newRepresentative.getTypeDocument());
                    return mapper.toRepresentative(repository.save(representative));
                }).orElseThrow(()-> new RepresentativeNotFoundException(id)));
    }

    @Override
    public Boolean deleteRepresentative(Integer id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
