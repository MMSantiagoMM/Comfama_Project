package com.comfama.project.application.mappers;


import com.comfama.project.application.dto.RepresentativeDTO;
import com.comfama.project.domain.models.Representative;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RepresentativeMapperDto {

    Representative toRepresentative(RepresentativeDTO dto);

}
