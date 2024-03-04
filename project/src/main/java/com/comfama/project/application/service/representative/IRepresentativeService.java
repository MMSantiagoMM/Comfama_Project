package com.comfama.project.application.service.representative;

import com.comfama.project.application.dto.RepresentativeDTO;
import com.comfama.project.domain.models.Representative;

import java.util.UUID;

public interface IRepresentativeService {

    Iterable<Representative> getRepresentatives();
    Representative getRepresentativeById(Integer id);
    Representative saveRepresentative(RepresentativeDTO dto);
    Boolean deleteRepresentative(Integer id);

}
