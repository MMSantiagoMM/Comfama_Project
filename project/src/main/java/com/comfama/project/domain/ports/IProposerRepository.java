package com.comfama.project.domain.ports;

import com.comfama.project.domain.models.Proposer;
import com.comfama.project.infrastructure.entities.ProposerEntity;

import java.util.List;
import java.util.Optional;

public interface IProposerRepository {

    List<Proposer> getProposers();

    Optional<Proposer> getProposer(Long id);

    Proposer createProposer(Proposer proposer);

    Boolean deleteProposer(Long id);

}
