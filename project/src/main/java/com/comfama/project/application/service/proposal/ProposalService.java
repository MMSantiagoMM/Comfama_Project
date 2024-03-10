package com.comfama.project.application.service.proposal;


import com.comfama.project.application.dto.ProposalDTO;
import com.comfama.project.application.service.proposer.ProposerService;
import com.comfama.project.domain.models.Proposal;
import com.comfama.project.infrastructure.adapters.proposal.ProposalJpaRepository;
import com.comfama.project.infrastructure.adapters.proposer.IProposerJpaRepository;
import com.comfama.project.infrastructure.adapters.proposer.ProposerJpaRepository;
import com.comfama.project.infrastructure.exceptions.ProposalNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProposalService implements IProposalService {

    private final ProposalJpaRepository repository;
    private final ProposerJpaRepository proposerJpaRepository;

    public ProposalService(ProposalJpaRepository repository, ProposerJpaRepository proposerJpaRepository) {
        this.repository = repository;
        this.proposerJpaRepository = proposerJpaRepository;
    }

    @Override
    public List<Proposal> getProposals() {
        return repository.getProposals();
    }

    @Override
    public Optional<Proposal> getProposal(Integer id) {
        return Optional.of(repository.getProposal(id).get());
    }

    @Override
    public Proposal createProposal(ProposalDTO dto) {
        Proposal proposal = new Proposal();


        proposal.setName(dto.getName());
        proposal.setDescriptionProposal(dto.getDescriptionProposal());
        proposal.setDescriptionActivities(dto.getDescriptionActivities());
        proposal.setFocusedPeople(dto.getFocusedPeople());
        proposal.setBeginningDate(dto.getBeginningDate());
        proposal.setTotalMoney(dto.getTotalMoney());
        proposal.setProposer(proposerJpaRepository.getProposer(dto.getIdProposer()).get());

        return repository.createProposal(proposal);
    }

    @Override
    public Optional<Proposal> updateProposal(Integer id, ProposalDTO dto) {
        return Optional.ofNullable(repository.getProposal(id)
                .map(proposal -> {
                    proposal.setName(dto.getName());
                    proposal.setDescriptionProposal(dto.getDescriptionProposal());
                    proposal.setProposer(proposerJpaRepository.getProposer(dto.getIdProposer()).get());
                    proposal.setFocusedPeople(dto.getFocusedPeople());
                    proposal.setDescriptionActivities(dto.getDescriptionActivities());
                    proposal.setTotalMoney(dto.getTotalMoney());
                    proposal.setBeginningDate(dto.getBeginningDate());
                    repository.updateProposal(id,proposal);
                    return proposal;
                }).orElseThrow(()-> new ProposalNotFoundException(id)));
    }

    @Override
    public Boolean deleteProposal(Integer id) {
        return repository.deleteProposal(id);
    }
}
