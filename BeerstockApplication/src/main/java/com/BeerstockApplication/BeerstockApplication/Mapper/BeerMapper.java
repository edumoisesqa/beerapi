package com.BeerstockApplication.BeerstockApplication.Mapper;

import com.BeerstockApplication.BeerstockApplication.BeerDTO.BeerDTO;
import com.BeerstockApplication.BeerstockApplication.entity.Beer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BeerMapper {

    BeerMapper INSTANCE = Mappers.getMapper(BeerMapper.class);

    Beer toModel(BeerDTO beerDTO);

    BeerDTO toDTO (Beer beer);
}
