package com.comfama.project.infrastructure.adapters.proposer;

import com.comfama.project.domain.models.Proposer;
import com.comfama.project.domain.ports.IProposerRepository;
import com.comfama.project.infrastructure.entities.ProposerEntity;
import com.comfama.project.infrastructure.exceptions.ProposerNotFoundException;
import com.comfama.project.infrastructure.mappers.ProposerMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProposerJpaRepository implements IProposerRepository {

    private final IProposerJpaRepository repository;
    private final ProposerMapper mapper;

    public ProposerJpaRepository(IProposerJpaRepository repository, ProposerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Proposer> getProposers() {
        return mapper.toProposers(repository.findAll());
    }

    @Override
    public Optional<Proposer> getProposer(Long id) {

        ProposerEntity proposer = repository.findById(id)
                .orElseThrow(()-> new ProposerNotFoundException(id));
        return Optional.of(mapper.toProposer(proposer));
    }

    @Override
    public Proposer createProposer(Proposer proposer) {
        repository.save(mapper.toEntity(proposer));
        return proposer;
    }

    @Override
    public Optional<Proposer> update(Long id, Proposer newProposer) {
        return Optional.ofNullable(repository.findById(id)
                .map(proposer -> {
                    proposer.setName(newProposer.getName());
                    proposer.setTypeOfProposer(newProposer.getTypeOfProposer());
                    proposer.setAlliedCompanies(newProposer.getAlliedCompanies());
                    proposer.setUrlDocuments(newProposer.getUrlDocuments());
                    proposer.setTrajectoryDescription(newProposer.getTrajectoryDescription());
                    return mapper.toProposer(repository.save(proposer));
                }).orElseThrow(()-> new ProposerNotFoundException(id)));
    }

    @Override
    public Boolean deleteProposer(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
