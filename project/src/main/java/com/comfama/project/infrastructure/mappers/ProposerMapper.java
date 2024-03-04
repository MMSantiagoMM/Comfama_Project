package com.comfama.project.infrastructure.mappers;


import com.comfama.project.domain.models.Proposer;
import com.comfama.project.infrastructure.entities.ProposerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProposerMapper {

    List<Proposer> toProposers(List<ProposerEntity> proposers);

    Proposer toProposer(ProposerEntity proposer);

    ProposerEntity toEntity(Proposer proposer);


}
