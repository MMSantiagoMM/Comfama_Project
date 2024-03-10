package com.comfama.project.application.service.receivedProposal;

import com.comfama.project.application.dto.ReceivedProposalDTO;
import com.comfama.project.domain.models.ReceivedProposal;

import java.util.List;
import java.util.Optional;

public interface IReceivedProposalService {

    List<ReceivedProposal> getReceivedProposals();

    Optional<ReceivedProposal> getReceivedProposal(Long id);

    ReceivedProposal createReceivedProposal(ReceivedProposalDTO dto);

    Optional<ReceivedProposal> updateReceivedProposal(Long id, ReceivedProposalDTO dto);

    Boolean deleteReceivedProposal(Long id);


}
