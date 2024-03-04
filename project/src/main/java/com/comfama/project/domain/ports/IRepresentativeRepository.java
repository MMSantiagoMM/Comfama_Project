package com.comfama.project.domain.ports;

import com.comfama.project.domain.models.Representative;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IRepresentativeRepository {

    Iterable<Representative> getAllRepresentatives();
    Optional<Representative> getRepresentative(Integer id);
    Representative saveRepresentative(Representative representative);
    Boolean deleteRepresentative(Integer id);

}
