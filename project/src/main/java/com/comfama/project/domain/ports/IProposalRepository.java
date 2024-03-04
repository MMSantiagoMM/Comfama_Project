package com.comfama.project.domain.ports;

import com.comfama.project.domain.models.Proposal;
import com.comfama.project.infrastructure.entities.ProposerEntity;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

import java.util.List;
import java.util.Optional;

public interface IProposalRepository {

    List<Proposal> getProposals();

    Optional<Proposal> getProposal(Integer id);

    Proposal createProposal(Proposal proposal);

    Boolean deleteProposal(Integer id);


}
