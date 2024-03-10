package com.comfama.project.application.service.proposal;


import com.comfama.project.application.dto.ProposalDTO;
import com.comfama.project.application.service.proposer.ProposerService;
import com.comfama.project.domain.models.Proposal;
import com.comfama.project.infrastructure.adapters.proposal.ProposalJpaRepository;
import com.comfama.project.infrastructure.adapters.proposer.IProposerJpaRepository;
import com.comfama.project.infrastructure.adapters.proposer.ProposerJpaRepository;
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
    public Boolean deleteProposal(Integer id) {
        return repository.deleteProposal(id);
    }
}
