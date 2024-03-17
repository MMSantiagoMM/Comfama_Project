package com.comfama.project.application.service.receivedProposal;

import com.comfama.project.application.dto.ReceivedProposalDTO;
import com.comfama.project.domain.errors.ReceivedProposalError;
import com.comfama.project.domain.models.ReceivedProposal;
import com.comfama.project.infrastructure.adapters.proposal.ProposalJpaRepository;
import com.comfama.project.infrastructure.adapters.receivedProposal.ReceivedProposalJpaRepository;
import com.comfama.project.infrastructure.adapters.representative.RepresentativeJpaRepository;
import com.comfama.project.infrastructure.exceptions.receivedProposal.ReceivedProposalNotFoundException;
import com.comfama.project.infrastructure.exceptions.receivedProposal.ReceivedProposalsNotFoundException;
import com.comfama.project.infrastructure.exceptions.receivedProposal.ReceivedProposalNotCreatedException;
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
    public Optional<List<?>> getReceivedProposals() {
        try{
            if(!repository.getReceivedProposals().isEmpty()){
                return Optional.of(repository.getReceivedProposals());
            }else{
                throw new ReceivedProposalsNotFoundException();
            }
        }catch (ReceivedProposalsNotFoundException e){
            ReceivedProposalError receivedProposalError =  new ReceivedProposalError();
            receivedProposalError.setErrorMessage(e.getMessage());
            List<String> message = List.of(receivedProposalError.getErrorMessage());
            return Optional.of(message);
        }
    }

    @Override
    public Optional<?> getReceivedProposal(Long id) {

        try {
            return Optional.of(repository.getReceivedProposal(id));
        }catch (ReceivedProposalNotFoundException e){
            ReceivedProposalError receivedProposalError = new ReceivedProposalError();
            receivedProposalError.setErrorMessage(e.getMessage());
            return Optional.of(receivedProposalError.getErrorMessage());
        }
    }

    @Override
    public Optional<?> createReceivedProposal(ReceivedProposalDTO dto) {
        try {
            ReceivedProposal receivedProposal =  new ReceivedProposal();
            validate(dto, receivedProposal);
            return Optional.of(repository.createReceivedProposal(receivedProposal));
        }catch (ReceivedProposalNotCreatedException e){
            ReceivedProposalError receivedProposalError = new ReceivedProposalError();
            receivedProposalError.setErrorMessage(e.getMessage());
            return Optional.of(receivedProposalError.getErrorMessage());
        }

    }



    @Override
    public Optional<?> updateReceivedProposal(Long id, ReceivedProposalDTO dto) {

        try {
            if(repository.getReceivedProposal(id).isPresent()){
                return Optional.ofNullable(repository.getReceivedProposal(id)
                        .map(nrp -> {
                            validate(dto,nrp);
                            repository.updateProposal(id,nrp);
                            return nrp;
                        }).orElseThrow(()-> new ReceivedProposalNotFoundException(id)));
            }else {
                throw new ReceivedProposalNotFoundException(id);
            }
        }catch (ReceivedProposalNotCreatedException e){
            ReceivedProposalError receivedProposalError = new ReceivedProposalError();
            receivedProposalError.setErrorMessage(e.getMessage());
            return Optional.of(receivedProposalError.getErrorMessage());
        }





    }

    @Override
    public Boolean deleteReceivedProposal(Long id) {
        return repository.deleteReceivedProposal(id);
    }

    private void validate(ReceivedProposalDTO dto, ReceivedProposal receivedProposal) {
        if(proposalRepository.getProposal(dto.getIdProposal()).isEmpty()){
            throw new ReceivedProposalNotCreatedException("Proposal is required");
        }else {
            receivedProposal.setProposal(proposalRepository.getProposal(
                    dto.getIdProposal()).get());
        }
        if(representativeRepository.getRepresentative(dto.getIdRepresentative()).isEmpty()){
            throw new ReceivedProposalNotCreatedException("Representative is required");
        }else{
            receivedProposal.setRepresentative(representativeRepository.getRepresentative(
                    dto.getIdRepresentative()).get());
        }
        if(dto.getPresentationProposalDate().equals("")){
            throw new ReceivedProposalNotCreatedException("Date is required");
        }else {
            receivedProposal.setPresentationProposalDate(dto.getPresentationProposalDate());
        }
        if(dto.getRequestedMoney().isNaN()){
            throw new ReceivedProposalNotCreatedException("Money is required");
        }else {
            receivedProposal.setRequestedMoney(dto.getRequestedMoney());
        }

        receivedProposal.setStatus(dto.getStatus());
    }



}
