package com.comfama.project.application.service.receivedProposal;

import com.comfama.project.application.dto.ReceivedProposalDTO;
import com.comfama.project.application.service.proposal.ProposalService;
import com.comfama.project.application.service.representative.RepresentativeService;
import com.comfama.project.domain.models.ReceivedProposal;
import com.comfama.project.infrastructure.adapters.receivedProposal.ReceivedProposalJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceivedProposalService implements IReceivedProposalService {

    private final ReceivedProposalJpaRepository repository;
    private final ProposalService proposalService;
    private final RepresentativeService representativeService;

    public ReceivedProposalService(ReceivedProposalJpaRepository repository, ProposalService proposalService, RepresentativeService representativeService) {
        this.repository = repository;
        this.proposalService = proposalService;
        this.representativeService = representativeService;
    }


    @Override
    public List<ReceivedProposal> getReceivedProposals() {
        return repository.getReceivedProposals();
    }

    @Override
    public Optional<ReceivedProposal> getReceivedProposal(Long id) {
        return Optional.of(repository.getReceivedProposal(id).get());
    }

    @Override
    public ReceivedProposal createReceivedProposal(ReceivedProposalDTO dto) {
        return null;
    }

    @Override
    public Boolean deleteReceivedProposal(Long id) {
        return repository.deleteReceivedProposal(id);
    }



}
