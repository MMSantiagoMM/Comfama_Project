package com.comfama.project.application.mappers;


import com.comfama.project.application.dto.ProposerDTO;
import com.comfama.project.domain.models.Proposer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProposerMapperDto {

    Proposer toProposer(ProposerDTO dto);


}
