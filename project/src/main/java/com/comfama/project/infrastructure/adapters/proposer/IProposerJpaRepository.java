package com.comfama.project.infrastructure.adapters.proposer;

import com.comfama.project.domain.models.Proposer;
import com.comfama.project.infrastructure.entities.ProposerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProposerJpaRepository extends JpaRepository<ProposerEntity,Long> {
}
