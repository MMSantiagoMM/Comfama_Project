package com.comfama.project.domain.ports;

import com.comfama.project.domain.models.Proposer;

import java.util.List;
import java.util.Optional;

public interface IProposerRepository {

    List<Proposer> getProposers();

    Proposer createProposer(Proposer proposer);

    Optional <Proposer> getProposer(Long id);

    Optional<Proposer> update(Long id, Proposer proposer);

    Boolean deleteProposer(Long id);

}
