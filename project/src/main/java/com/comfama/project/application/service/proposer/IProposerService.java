package com.comfama.project.application.service.proposer;

import com.comfama.project.application.dto.ProposerDTO;
import com.comfama.project.domain.models.Proposer;

import java.util.List;

public interface IProposerService {

    List<Proposer> getProposers();

    Proposer getProposer(Long id);

    Proposer createProposer(ProposerDTO dto);
    Boolean deleteProposer(Long id);




}
