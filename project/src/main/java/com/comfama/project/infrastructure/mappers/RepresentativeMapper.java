package com.comfama.project.infrastructure.mappers;


import com.comfama.project.domain.models.Representative;
import com.comfama.project.infrastructure.entities.RepresentativeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RepresentativeMapper {


    Representative toRepresentative(RepresentativeEntity entity);

    RepresentativeEntity toEntity(Representative model);

    List<Representative> toRepresentatives(List<RepresentativeEntity> entityList);


}
