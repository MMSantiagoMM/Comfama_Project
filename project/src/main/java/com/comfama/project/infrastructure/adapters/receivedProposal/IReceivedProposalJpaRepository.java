package com.comfama.project.infrastructure.adapters.receivedProposal;

import com.comfama.project.infrastructure.entities.ReceivedProposalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReceivedProposalJpaRepository extends JpaRepository<ReceivedProposalEntity,Long> {
}
