package com.comfama.project.domain.ports;

import com.comfama.project.domain.models.ReceivedProposal;

import java.util.List;
import java.util.Optional;

public interface IReceivedProposalRepository {

    List<ReceivedProposal> getReceivedProposals();

    Optional<ReceivedProposal> getReceivedProposal(Long id);

    ReceivedProposal createReceivedProposal(ReceivedProposal receivedProposal);

    Boolean deleteReceivedProposal(Long id);
}
