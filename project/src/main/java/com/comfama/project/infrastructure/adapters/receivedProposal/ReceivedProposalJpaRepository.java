package com.comfama.project.infrastructure.adapters.receivedProposal;

import com.comfama.project.domain.models.ReceivedProposal;
import com.comfama.project.domain.ports.IReceivedProposalRepository;
import com.comfama.project.infrastructure.adapters.proposal.IProposalJpaRepository;
import com.comfama.project.infrastructure.adapters.representative.IRepresentativeJpaRepository;
import com.comfama.project.infrastructure.entities.ReceivedProposalEntity;
import com.comfama.project.infrastructure.exceptions.ProposalNotFoundException;
import com.comfama.project.infrastructure.exceptions.ReceivedProposalNotFoundException;
import com.comfama.project.infrastructure.mappers.ReceivedProposalMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


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
    public ReceivedProposal createReceivedProposal(ReceivedProposal receivedProposal) {
        ReceivedProposalEntity entity = new ReceivedProposalEntity();
        entity.setProposal(proposalRepository.findById(
                receivedProposal.getProposal().getId()).get());

        entity.setRepresentative(representativeRepository.findById(
                receivedProposal.getRepresentative().getId()).get());

        entity.setPresentationProposalDate(receivedProposal.getPresentationProposalDate());
        entity.setStatus(receivedProposal.getStatus());
        entity.setRequestedMoney(receivedProposal.getRequestedMoney());

        repository.save(entity);

        return receivedProposal;

    }

    @Override
    public Optional<ReceivedProposal> updateProposal(Long id, ReceivedProposal newReceivedProposal) {
        return Optional.ofNullable(repository.findById(id)
                .map(nrp -> {
                    nrp.setProposal(proposalRepository.findById(
                            newReceivedProposal.getProposal().getId()).get());
                    nrp.setRepresentative(representativeRepository.findById(
                            newReceivedProposal.getRepresentative().getId()).get());
                    nrp.setRequestedMoney(newReceivedProposal.getRequestedMoney());
                    nrp.setStatus(newReceivedProposal.getStatus());
                    nrp.setPresentationProposalDate(newReceivedProposal.getPresentationProposalDate());
                    return mapper.toReceivedProposal(repository.save(nrp));
                }).orElseThrow(()-> new ReceivedProposalNotFoundException(id)));
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
