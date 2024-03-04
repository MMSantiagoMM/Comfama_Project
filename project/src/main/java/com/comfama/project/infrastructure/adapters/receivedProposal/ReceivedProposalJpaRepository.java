package com.comfama.project.infrastructure.adapters.receivedProposal;

import com.comfama.project.domain.models.ReceivedProposal;
import com.comfama.project.domain.ports.IReceivedProposalRepository;
import com.comfama.project.infrastructure.adapters.proposal.IProposalJpaRepository;
import com.comfama.project.infrastructure.adapters.representative.IRepresentativeJpaRepository;
import com.comfama.project.infrastructure.exceptions.ReceivedProposalNotFoundException;
import com.comfama.project.infrastructure.mappers.ReceivedProposalMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class ReceivedProposalJpaRepository implements IReceivedProposalRepository {

    private final IReceivedProposalJpaRepository repository;
    private final IRepresentativeJpaRepository representativeRepository;
    private final IProposalJpaRepository proposalRepository;
    private final ReceivedProposalMapper mapper;

    public ReceivedProposalJpaRepository(IReceivedProposalJpaRepository repository, IRepresentativeJpaRepository representativeRepository, IProposalJpaRepository proposalRepository, ReceivedProposalMapper mapper) {
        this.repository = repository;
        this.representativeRepository = representativeRepository;
        this.proposalRepository = proposalRepository;
        this.mapper = mapper;
    }


    @Override
    public List<ReceivedProposal> getReceivedProposals() {
        return mapper.toReceivedProposals(repository.findAll());
    }

    @Override
    public Optional<ReceivedProposal> getReceivedProposal(Long id) {
        return Optional.of(mapper.toReceivedProposal(repository.findById(id)
                .orElseThrow(()-> new ReceivedProposalNotFoundException(id))));
    }

    @Override
    public ReceivedProposal createReceivedProposal(Long id) {
        return null;
    }

    @Override
    public Boolean deleteReceivedProposal(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
