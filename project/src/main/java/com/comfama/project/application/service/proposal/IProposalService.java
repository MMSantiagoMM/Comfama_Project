package com.comfama.project.application.service.proposal;

import com.comfama.project.application.dto.ProposalDTO;
import com.comfama.project.domain.models.Proposal;

import java.util.List;
import java.util.Optional;

public interface IProposalService {

    List<Proposal> getProposals();

    Optional<Proposal> getProposal(Integer id);

    Proposal createProposal(ProposalDTO dto);

    Boolean deleteProposal(Integer id);


}
