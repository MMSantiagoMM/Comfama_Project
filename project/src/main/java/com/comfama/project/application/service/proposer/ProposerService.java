package com.comfama.project.application.service.proposer;

import com.comfama.project.application.dto.ProposerDTO;
import com.comfama.project.application.mappers.ProposerMapperDto;
import com.comfama.project.domain.models.Proposer;
import com.comfama.project.infrastructure.adapters.proposer.ProposerJpaRepository;
import com.comfama.project.infrastructure.exceptions.ProposerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Proposer> updateProposer(Long id, ProposerDTO dto) {
        return Optional.ofNullable(repository.getProposer(id)
                .map(proposer -> {
                    proposer.setName(dto.getName());
                    proposer.setTypeOfProposer(dto.getTypeOfProposer());
                    proposer.setAlliedCompanies(dto.getAlliedCompanies());
                    proposer.setUrlDocuments(dto.getUrlDocuments());
                    proposer.setTrajectoryDescription(dto.getTrajectoryDescription());
                    repository.update(id,proposer);
                    return proposer;

                }).orElseThrow(()-> new ProposerNotFoundException(id)));
    }

    @Override
    public Boolean deleteProposer(Long id) {
        return repository.deleteProposer(id);
    }
}
