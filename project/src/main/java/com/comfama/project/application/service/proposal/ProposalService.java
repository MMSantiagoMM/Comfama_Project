package com.comfama.project.application.service.proposal;


import com.comfama.project.application.dto.ProposalDTO;
import com.comfama.project.domain.errors.ProposalError;
import com.comfama.project.domain.models.Proposal;
import com.comfama.project.infrastructure.adapters.proposal.ProposalJpaRepository;
import com.comfama.project.infrastructure.adapters.proposer.ProposerJpaRepository;
import com.comfama.project.infrastructure.exceptions.proposal.ProposalNotCreatedException;
import com.comfama.project.infrastructure.exceptions.proposal.ProposalNotFoundException;
import com.comfama.project.infrastructure.exceptions.proposal.ProposalsNotFoundException;
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
    public Optional<List<?>> getProposals() {
        try{
            if(repository.getProposals().isPresent()){
                return Optional.of(repository.getProposals().get());
            }else{
                throw new ProposalsNotFoundException();
            }

        }catch (Exception e){
            ProposalError proposalError = new ProposalError();
            proposalError.setErrorMessage(e.getMessage());
            List<String> message = List.of(proposalError.getErrorMessage());
            return Optional.of(message);
        }
    }

    @Override
    public Optional<?> getProposal(Integer id) {
        try{
            return Optional.of(repository.getProposal(id).get());
        }catch (Exception e){
            ProposalError proposalError = new ProposalError();
            proposalError.setErrorMessage(e.getMessage());
            return Optional.ofNullable(proposalError.getErrorMessage());
        }
    }

    @Override
    public Optional<?> createProposal(ProposalDTO dto) {
        try{
            Proposal proposal = new Proposal();
            validate(dto, proposal);

            return Optional.of(repository.createProposal(proposal));

        }
        catch (ProposalNotCreatedException e) {
            ProposalError proposalError = new ProposalError();
            proposalError.setErrorMessage(e.getMessage());
            return Optional.of(proposalError.getErrorMessage());
        }
    }

    @Override
    public Optional<?> updateProposal(Integer id, ProposalDTO dto) {
        try{
            if(repository.getProposals().isPresent()){
                return Optional.ofNullable(repository.getProposal(id)
                        .map(proposal -> {
                            validate(dto,proposal);
                            repository.updateProposal(id,proposal);
                            return proposal;

                        }).orElseThrow(()-> new ProposalNotFoundException(id)));
                        }
            else{
                //throw new ProposalNotFoundException(id);
                return Optional.of(new ProposalNotFoundException(id));
            }
        }
        catch (Exception e){
            ProposalError proposalError = new ProposalError();
            proposalError.setErrorMessage(e.getMessage());
            return Optional.of(proposalError.getErrorMessage());
        }
    }

    @Override
    public Boolean deleteProposal(Integer id) {
        return repository.deleteProposal(id);
    }


    private void validate(ProposalDTO dto, Proposal proposal) {
        if(dto.getName().isEmpty()){
            throw new ProposalNotCreatedException("Name is required");
        }else{
            proposal.setName(dto.getName());
        }
        if(dto.getDescriptionProposal().isEmpty()){
            throw new ProposalNotCreatedException("Description Proposal is required");
        }else{
            proposal.setDescriptionProposal(dto.getDescriptionProposal());
        }
        if(dto.getDescriptionActivities().isEmpty()){
            throw new ProposalNotCreatedException("Description activities is required");
        }else{
            proposal.setDescriptionActivities(dto.getDescriptionActivities());
        }
        if(dto.getFocusedPeople().isEmpty()){
            throw new ProposalNotCreatedException("Focused people is required");
        }else{
            proposal.setFocusedPeople(dto.getFocusedPeople());
        }
        if(dto.getBeginningDate()==null){
            throw new ProposalNotCreatedException("Date must not be empty");
        }else{
            proposal.setBeginningDate(dto.getBeginningDate());
        }
        if(dto.getTotalMoney().isNaN() || dto.getTotalMoney()==null){
            throw new ProposalNotCreatedException("Money is required");
        }else{
            proposal.setTotalMoney(dto.getTotalMoney());
        }
        if(proposerJpaRepository.getProposer(dto.getIdProposer()).isEmpty()){
            throw new ProposalNotCreatedException("Proposer is required");
        }else{
            proposal.setProposer(proposerJpaRepository.getProposer(dto.getIdProposer()).get());
        }
    }


}
