package com.comfama.project.application.service.representative;


import com.comfama.project.application.dto.RepresentativeDTO;
import com.comfama.project.application.mappers.RepresentativeMapperDto;
import com.comfama.project.domain.errors.RepresentativeError;
import com.comfama.project.domain.models.Representative;
import com.comfama.project.infrastructure.adapters.representative.RepresentativeJpaRepository;
import com.comfama.project.infrastructure.exceptions.representative.RepresentativeNotCreatedException;
import com.comfama.project.infrastructure.exceptions.representative.RepresentativeNotFoundException;
import com.comfama.project.infrastructure.exceptions.representative.RepresentativesNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class RepresentativeService implements IRepresentativeService{

    private final RepresentativeJpaRepository repository;
    private final RepresentativeMapperDto mapper;

    public RepresentativeService(RepresentativeJpaRepository repository, RepresentativeMapperDto mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<?>> getRepresentatives() {
        try {
            if(!repository.getAllRepresentatives().isEmpty()){
                return Optional.of(repository.getAllRepresentatives());
            }else{
                throw new RepresentativesNotFoundException();
            }
        }catch (RepresentativesNotFoundException e){
            RepresentativeError representativeError = new RepresentativeError();
            representativeError.setErrorMessage(e.getMessage());
            List<String> message = List.of(representativeError.getErrorMessage());
            return Optional.of(message);
        }
    }

    @Override
    public Optional<?> getRepresentativeById(Integer id) {

        try {
            return Optional.of(repository.getRepresentative(id).get());
        }catch (RepresentativeNotFoundException e){
            RepresentativeError representativeError = new RepresentativeError();
            representativeError.setErrorMessage(e.getMessage());
            return Optional.of(representativeError.getErrorMessage());
        }
    }

    @Override
    public Optional<?> saveRepresentative(RepresentativeDTO dto) {

        try {
            Representative representative = new Representative();
            validate(dto, representative);

            return Optional.of(repository.saveRepresentative(mapper.toRepresentative(dto)));
        }catch (RepresentativeNotCreatedException e){
            RepresentativeError representativeError = new RepresentativeError();
            representativeError.setErrorMessage(e.getMessage());
            return Optional.of(representativeError.getErrorMessage());
        }
    }



    @Override
    public Optional<?> updateRepresentative(Integer id, RepresentativeDTO dto) {

        try {
            if(repository.getRepresentative(id).isPresent()){
                return Optional.ofNullable(repository.getRepresentative(id)
                        .map(representative -> {
                            validate(dto,representative);
                            repository.updateRepresentative(id,representative);
                            return representative;
                        }).orElseThrow(()-> new RepresentativeNotFoundException(id)));
            }else{
                return Optional.of(new RepresentativeNotFoundException(id));

            }
        }catch (RepresentativeNotCreatedException e){
            RepresentativeError representativeError = new RepresentativeError();
            representativeError.setErrorMessage(e.getMessage());
            return Optional.of(representativeError.getErrorMessage());
        }




    }

    @Override
    public Boolean deleteRepresentative(Integer id) {
        return repository.deleteRepresentative(id);
    }


    private static void validate(RepresentativeDTO dto, Representative representative) {
        if(dto.getName().isEmpty()){
            throw new RepresentativeNotCreatedException("Name is required");
        }else{
            representative.setName(dto.getName());
        }
        if(dto.getLastName().isEmpty()){
            throw new RepresentativeNotCreatedException("Last name is required");
        }else{
            representative.setLastName(dto.getLastName());
        }
        if(dto.getEmail().isEmpty()){
            throw new RepresentativeNotCreatedException("Email is required");
        }else{
            representative.setEmail(dto.getEmail());
        }
        if(dto.getCelPhone().isEmpty()){
            throw new RepresentativeNotCreatedException("Cellphone is required");
        }else{
            representative.setCelPhone(dto.getCelPhone());
        }
        if(dto.getTelephone().isEmpty()){
            throw new RepresentativeNotCreatedException("Telephone is required");
        }else{
            representative.setTelephone(dto.getTelephone());
        }
        if(dto.getTypeDocument().isEmpty()){
            throw new RepresentativeNotCreatedException("Type of document is required");
        }else{
            representative.setTypeDocument(dto.getTypeDocument());
        }
    }
}
