package com.comfama.project.infrastructure.mappers;


import com.comfama.project.domain.models.Proposal;
import com.comfama.project.domain.models.ReceivedProposal;
import com.comfama.project.infrastructure.entities.ReceivedProposalEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReceivedProposalMapper {

    List<ReceivedProposal> toReceivedProposals(List<ReceivedProposalEntity> entities);

    ReceivedProposal toReceivedProposal(ReceivedProposalEntity entity);

    ReceivedProposalEntity toEntity(ReceivedProposal receivedProposal);

}
