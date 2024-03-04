package com.comfama.project.infrastructure.adapters.representative;

import com.comfama.project.infrastructure.entities.RepresentativeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IRepresentativeJpaRepository extends JpaRepository<RepresentativeEntity,Integer> {
}
