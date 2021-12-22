package com.BeerstockApplication.BeerstockApplication.BeerDTO;

import com.BeerstockApplication.BeerstockApplication.Enums.BeerType;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeerDTO {


    private Long id;

    @NotNull
    @Size(min = 1, max = 200)
    private  String Brand;

    @NotNull
    @Max(500)
    private Integer max;

    @NotNull
    @Size(min =1, max = 200)
    private String name;

    @NotNull
    @Max(100)
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    @NotNull
    private BeerType type;



}
