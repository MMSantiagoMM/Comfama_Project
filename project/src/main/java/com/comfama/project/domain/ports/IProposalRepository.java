package com.comfama.project.domain.ports;

import com.comfama.project.domain.models.Proposal;

import java.util.List;
import java.util.Optional;

public interface IProposalRepository {

    Optional<List<?>> getProposals();

    Optional<Proposal> getProposal(Integer id);
    Proposal createProposal(Proposal proposal);

    Optional<Proposal> updateProposal(Integer id, Proposal proposal);

    Boolean deleteProposal(Integer id);


}
