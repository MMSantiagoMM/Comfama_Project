package com.comfama.project.application.service.proposal;

import com.comfama.project.application.dto.ProposalDTO;
import com.comfama.project.domain.models.Proposal;

import java.util.List;
import java.util.Optional;

public interface IProposalService {

    Optional<List<?>> getProposals();

    Optional<?> getProposal(Integer id);

    Optional<?> createProposal(ProposalDTO dto);

    Optional<?> updateProposal(Integer id, ProposalDTO dto);

    Boolean deleteProposal(Integer id);


}
