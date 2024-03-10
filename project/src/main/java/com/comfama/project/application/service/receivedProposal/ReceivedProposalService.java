package com.comfama.project.application.service.receivedProposal;

import com.comfama.project.application.dto.ReceivedProposalDTO;
import com.comfama.project.application.service.proposal.ProposalService;
import com.comfama.project.application.service.representative.RepresentativeService;
import com.comfama.project.domain.models.ReceivedProposal;
import com.comfama.project.infrastructure.adapters.proposal.ProposalJpaRepository;
import com.comfama.project.infrastructure.adapters.receivedProposal.ReceivedProposalJpaRepository;
import com.comfama.project.infrastructure.adapters.representative.RepresentativeJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceivedProposalService implements IReceivedProposalService {

    private final ReceivedProposalJpaRepository repository;
    private final ProposalJpaRepository proposalRepository;
    private final RepresentativeJpaRepository representativeRepository;

    public ReceivedProposalService(ReceivedProposalJpaRepository repository, ProposalJpaRepository proposalRepository, RepresentativeJpaRepository representativeRepository) {
        this.repository = repository;
        this.proposalRepository = proposalRepository;
        this.representativeRepository = representativeRepository;
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
        ReceivedProposal receivedProposal =  new ReceivedProposal();
        receivedProposal.setProposal(proposalRepository.getProposal(
                dto.getIdProposal()).get());

        receivedProposal.setRepresentative(representativeRepository.getRepresentative(
                dto.getIdRepresentative()).get());

        receivedProposal.setStatus(dto.getStatus());
        receivedProposal.setPresentationProposalDate(dto.getPresentationProposalDate());
        receivedProposal.setRequestedMoney(dto.getRequestedMoney());

        return repository.createReceivedProposal(receivedProposal);
    }

    @Override
    public Boolean deleteReceivedProposal(Long id) {
        return repository.deleteReceivedProposal(id);
    }



}
