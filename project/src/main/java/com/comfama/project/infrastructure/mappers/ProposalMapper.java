package com.comfama.project.infrastructure.mappers;

import com.comfama.project.domain.models.Proposal;
import com.comfama.project.infrastructure.entities.ProposalEntity;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProposalMapper {


    Proposal toProposal(ProposalEntity entity);

    List<Proposal> toProposals(List<ProposalEntity> entities);

    //@Mapping(target = "proposer", ignore = true)
    ProposalEntity toEntity(Proposal proposal);
}
