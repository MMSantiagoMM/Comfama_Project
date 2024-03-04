package com.comfama.project.application.service.proposer;

import com.comfama.project.application.dto.ProposerDTO;
import com.comfama.project.application.mappers.ProposerMapperDto;
import com.comfama.project.domain.models.Proposer;
import com.comfama.project.infrastructure.adapters.proposer.ProposerJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProposerService implements IProposerService{

    private final ProposerMapperDto mapper;
    private final ProposerJpaRepository repository;

    public ProposerService(ProposerMapperDto mapper, ProposerJpaRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public List<Proposer> getProposers() {
        return repository.getProposers();
    }

    @Override
    public Proposer getProposer(Long id) {
        return repository.getProposer(id).get();
    }

    @Override
    public Proposer createProposer(ProposerDTO dto) {
        return repository.createProposer(mapper.toProposer(dto));
    }

    @Override
    public Boolean deleteProposer(Long id) {
        return repository.deleteProposer(id);
    }
}
