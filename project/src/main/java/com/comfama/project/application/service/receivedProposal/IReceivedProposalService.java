package com.comfama.project.application.service.receivedProposal;

import com.comfama.project.application.dto.ReceivedProposalDTO;
import com.comfama.project.domain.models.ReceivedProposal;

import java.util.List;
import java.util.Optional;

public interface IReceivedProposalService {

    Optional<List<?>> getReceivedProposals();

    Optional<?> getReceivedProposal(Long id);

    Optional<?> createReceivedProposal(ReceivedProposalDTO dto);

    Optional<?> updateReceivedProposal(Long id, ReceivedProposalDTO dto);

    Boolean deleteReceivedProposal(Long id);


}
