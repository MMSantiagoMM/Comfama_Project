package com.comfama.project.infrastructure.adapters.proposal;

import com.comfama.project.application.service.proposer.ProposerService;
import com.comfama.project.domain.models.Proposal;
import com.comfama.project.domain.ports.IProposalRepository;
import com.comfama.project.domain.ports.IProposerRepository;
import com.comfama.project.infrastructure.adapters.proposer.IProposerJpaRepository;
import com.comfama.project.infrastructure.adapters.proposer.ProposerJpaRepository;
import com.comfama.project.infrastructure.entities.ProposalEntity;
import com.comfama.project.infrastructure.exceptions.ProposalNotFoundException;
import com.comfama.project.infrastructure.exceptions.ProposerNotFoundException;
import com.comfama.project.infrastructure.exceptions.RepresentativeNotFoundException;
import com.comfama.project.infrastructure.mappers.ProposalMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProposalJpaRepository implements IProposalRepository {

    private final IProposalJpaRepository repository;
    private final ProposalMapper mapper;
    private final IProposerJpaRepository proposerRepository;

    public ProposalJpaRepository(IProposalJpaRepository repository, ProposalMapper mapper, IProposerJpaRepository proposerRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.proposerRepository = proposerRepository;
    }


    @Override
    public List<Proposal> getProposals() {
        return mapper.toProposals(repository.findAll());
    }

    @Override
    public Optional<Proposal> getProposal(Integer id) {
        return Optional.of(mapper.toProposal(repository.findById(id)
                .orElseThrow(()-> new ProposalNotFoundException(id))));
    }

    @Override
    public Proposal createProposal(Proposal proposal) {

        ProposalEntity proposalEntity = new ProposalEntity();


        proposalEntity.setName(proposal.getName());
        proposalEntity.setDescriptionActivities(proposal.getDescriptionActivities());
        proposalEntity.setDescriptionProposal(proposal.getDescriptionProposal());
        proposalEntity.setFocusedPeople(proposal.getFocusedPeople());
        proposalEntity.setBeginningDate(proposal.getBeginningDate());
        proposalEntity.setTotalMoney(proposal.getTotalMoney());
        proposalEntity.setProposer(proposerRepository.findById(
                proposal.getProposer().getId()
        ).get());

        repository.save(proposalEntity);
        return proposal;
    }

    @Override
    public Optional<Proposal> updateProposal(Integer id, Proposal newProposal) {
        return Optional.ofNullable(repository.findById(id)
                .map(proposal -> {
                    proposal.setName(newProposal.getName());
                    proposal.setDescriptionProposal(newProposal.getDescriptionProposal());
                    proposal.setProposer(proposerRepository.findById(
                            newProposal.getProposer().getId()).get());
                    proposal.setFocusedPeople(newProposal.getFocusedPeople());
                    proposal.setDescriptionActivities(newProposal.getDescriptionActivities());
                    proposal.setTotalMoney(newProposal.getTotalMoney());
                    proposal.setBeginningDate(newProposal.getBeginningDate());
                    return mapper.toProposal(repository.save(proposal));
                }).orElseThrow(()-> new ProposalNotFoundException(id)));
    }

    @Override
    public Boolean deleteProposal(Integer id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
