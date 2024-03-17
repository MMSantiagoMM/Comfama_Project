package com.comfama.project.application.service.representative;

import com.comfama.project.application.dto.RepresentativeDTO;
import com.comfama.project.domain.models.Representative;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IRepresentativeService {

    Optional<List<?>> getRepresentatives();
    Optional<?> getRepresentativeById(Integer id);
    Optional<?> saveRepresentative(RepresentativeDTO dto);

    Optional<?> updateRepresentative(Integer id, RepresentativeDTO dto);
    Boolean deleteRepresentative(Integer id);

}
