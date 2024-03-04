package com.comfama.project.infrastructure.adapters.proposal;

import com.comfama.project.infrastructure.entities.ProposalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProposalJpaRepository extends JpaRepository<ProposalEntity,Integer> {
}
