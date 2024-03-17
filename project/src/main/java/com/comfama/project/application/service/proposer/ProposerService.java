package com.comfama.project.application.service.proposer;

import com.comfama.project.application.dto.ProposerDTO;
import com.comfama.project.application.mappers.ProposerMapperDto;
import com.comfama.project.domain.errors.ProposerError;
import com.comfama.project.domain.models.Proposer;
import com.comfama.project.infrastructure.adapters.proposer.ProposerJpaRepository;
import com.comfama.project.infrastructure.exceptions.ProposerNotFoundException;
import com.comfama.project.infrastructure.exceptions.proposer.ProposerNotCreatedException;
import com.comfama.project.infrastructure.exceptions.proposer.ProposersNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProposerService implements IProposerService{

    private final ProposerMapperDto mapper;
    private final ProposerJpaRepository repository;

    public ProposerService(ProposerMapperDto mapper, ProposerJpaRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public Optional<List<?>> getProposers() {
        try {
            if(!repository.getProposers().isEmpty()){
                return Optional.of(repository.getProposers());
            }else{
                throw new ProposersNotFoundException();
            }
        }catch (Exception e){
            ProposerError proposerError = new ProposerError();
            proposerError.setErrorMessage(e.getMessage());
            List<String> message = List.of(proposerError.getErrorMessage());
            return Optional.of(message);
        }
    }

    @Override
    public Optional<?> getProposer(Long id) {
        try {
            return Optional.of(repository.getProposer(id).get());
        }catch (Exception e){
            ProposerError proposerError = new ProposerError();
            proposerError.setErrorMessage(e.getMessage());
            return Optional.of(proposerError.getErrorMessage());
        }

    }

    @Override
    public Optional<?> createProposer(ProposerDTO dto) {

        try {
            Proposer proposer = new Proposer();
            validate(dto, proposer);
            return Optional.of(repository.createProposer(mapper.toProposer(dto)));

        }catch (ProposerNotCreatedException e){
            ProposerError proposerError = new ProposerError();
            proposerError.setErrorMessage(e.getMessage());
            return Optional.of(proposerError.getErrorMessage());
        }
    }



    @Override
    public Optional<?> updateProposer(Long id, ProposerDTO dto) {

        try {
            if(repository.getProposer(id).isPresent()){
                return Optional.ofNullable(repository.getProposer(id)
                        .map(proposer -> {
                            validate(dto,proposer);
                            repository.update(id,proposer);
                            return proposer;
                        }).orElseThrow(()-> new ProposerNotFoundException(id)));
            }else{
                return Optional.of(new ProposerNotFoundException(id));
            }
        }catch (ProposerNotCreatedException e){
            ProposerError proposerError = new ProposerError();
            proposerError.setErrorMessage(e.getMessage());
            return Optional.of(proposerError.getErrorMessage());
        }




    }

    @Override
    public Boolean deleteProposer(Long id) {
        return repository.deleteProposer(id);
    }


    private static void validate(ProposerDTO dto, Proposer proposer) {
        if(dto.getName().isEmpty()){
            throw new ProposerNotCreatedException("Name is required");
        }else{
            proposer.setName(dto.getName());
        }
        if(dto.getTypeOfProposer().isEmpty()){
            throw new ProposerNotCreatedException("type of proposer is required");
        }else{
            proposer.setTypeOfProposer(dto.getTypeOfProposer());
        }
        if(dto.getAlliedCompanies().isEmpty()){
            throw new ProposerNotCreatedException("Allied companies are required");
        }else{
            proposer.setAlliedCompanies(dto.getAlliedCompanies());
        }
        if(dto.getUrlDocuments().isEmpty()){
            throw new ProposerNotCreatedException("Trajectory is required");
        }else{
            proposer.setTrajectoryDescription(dto.getTrajectoryDescription());
        }
        if(dto.getUrlDocuments().isEmpty()){
            throw new ProposerNotCreatedException("Url documents are required");
        }
    }
}
