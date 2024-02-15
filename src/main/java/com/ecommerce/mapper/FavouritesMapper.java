package com.ecommerce.mapper;

import com.ecommerce.dto.FavouritesDto;
import com.ecommerce.entity.Favourites;

import java.util.Set;

public interface FavouritesMapper {

    FavouritesDto toFavouritesDto (Favourites favourites);

    Set<FavouritesDto> toFavouritesDtoList (Set<Favourites> favouritesSet);
}
