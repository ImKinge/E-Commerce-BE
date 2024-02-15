package com.ecommerce.service;

import com.ecommerce.dto.FavouritesDto;
import com.ecommerce.entity.Favourites;
import com.ecommerce.exception.FavouritesException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.exception.UserException;

import java.util.Set;

public interface FavouritesService {

    Favourites addToFavourites (Integer productId, String fiscalCode) throws UserException, ProductException, FavouritesException;
    Set<FavouritesDto> getAllFavouritesByUser(String fiscalCode);

    void removeToFavourites (Integer productId);
}
