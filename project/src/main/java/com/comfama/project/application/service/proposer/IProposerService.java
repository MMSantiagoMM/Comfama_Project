package com.comfama.project.application.service.proposer;

import com.comfama.project.application.dto.ProposerDTO;
import com.comfama.project.domain.models.Proposer;

import java.util.List;
import java.util.Optional;

public interface IProposerService {

    Optional<List<?>> getProposers();

    Optional<?> getProposer(Long id);

    Optional<?> createProposer(ProposerDTO dto);

    Optional<?> updateProposer(Long id, ProposerDTO dto);
    Boolean deleteProposer(Long id);




}
