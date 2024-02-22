package com.ecommerce.controller;

import com.ecommerce.dto.AuthResponseDto;
import com.ecommerce.dto.BaseResponse;
import com.ecommerce.dto.FavouritesDto;
import com.ecommerce.dto.ResponseDto;
import com.ecommerce.exception.FavouritesException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.exception.UserException;
import com.ecommerce.mapper.FavouritesMapper;
import com.ecommerce.security.jwt.JWTGenerator;
import com.ecommerce.service.FavouritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/favourites")
@CrossOrigin(origins = "http://localhost:4200" , allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class FavouritesController {

    @Autowired
    private FavouritesService favouritesService;

    @Autowired
    private JWTGenerator jwtGenerator;

    @Autowired
    private FavouritesMapper favouritesMapper;


    @GetMapping("/add-to-favourites")
    public ResponseEntity<?> addProductToFavourites (@RequestParam Integer productId, @RequestHeader (HttpHeaders.AUTHORIZATION) String token) throws UserException, ProductException {

        String fiscalCode = jwtGenerator.getFiscalCodeFromJWT(token);

        try {
            FavouritesDto favouritesDto = favouritesMapper.toFavouritesDto(favouritesService.addToFavourites(productId, fiscalCode));
            return new ResponseEntity<>(new ResponseDto<>(favouritesDto, true), HttpStatus.OK);
        } catch (FavouritesException ex){
            return new ResponseEntity<>(new ResponseDto<>(ex.getMessage(), false), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/delete-to-favourites")
    public ResponseEntity<ResponseDto<String>> removeToFavourites (@RequestParam Integer favouritesIdProduct) {

        favouritesService.removeToFavourites(favouritesIdProduct);

        return new ResponseEntity<>(new ResponseDto<>("Rimozione del prodotto dai preferiti avvenuta con successo!", true), HttpStatus.OK);
    }

    @GetMapping("/get-favourites-details")
    public ResponseEntity<ResponseDto<Set<FavouritesDto>>> getFavouritesDetails (@RequestHeader (HttpHeaders.AUTHORIZATION) String token) {

        String fiscalCode = jwtGenerator.getFiscalCodeFromJWT(token);

        Set<FavouritesDto> favouritesDtoSet = favouritesService.getAllFavouritesByUser(fiscalCode);

        return new ResponseEntity<>(new ResponseDto<>(favouritesDtoSet, true), HttpStatus.OK);
    }
}
