package com.BeerstockApplication.BeerstockApplication.controller;

import com.BeerstockApplication.BeerstockApplication.BeerDTO.BeerDTO;
import com.BeerstockApplication.BeerstockApplication.BeerDTO.QuantityDTO;
import com.BeerstockApplication.BeerstockApplication.Service.BeerService;
import com.BeerstockApplication.BeerstockApplication.exception.BeerAlreadyRegisteredException;
import com.BeerstockApplication.BeerstockApplication.exception.BeerNotFoundException;
import com.BeerstockApplication.BeerstockApplication.exception.BeerStockExceededException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/beers")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerController implements BeerControllerDocs{
    private final BeerService beerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BeerDTO createBeer(@RequestBody @Valid BeerDTO beerDTO) throws BeerAlreadyRegisteredException{
            return beerService.createBeer(beerDTO);
    }

    public  BeerDTO findByName(@PathVariable String name ) throws BeerNotFoundException{
        return  beerService.findByName(name);
    }
    @GetMapping
    public List<BeerDTO> listBeers() {
        return beerService.listAll();


    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws BeerNotFoundException {
        beerService.deleteById(id);
    }

    @PatchMapping("/{id}/increment")
    public BeerDTO increment(@PathVariable Long id, @RequestBody @Valid QuantityDTO quantityDTO) throws BeerNotFoundException, BeerStockExceededException {
        return beerService.increment(id, quantityDTO.getQuantity());
    }

}
