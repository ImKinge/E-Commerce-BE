package com.ecommerce.mapper;

import com.ecommerce.dto.FavouritesDto;
import com.ecommerce.entity.Favourites;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class FavouritesMapperImpl implements FavouritesMapper{
    @Override
    public FavouritesDto toFavouritesDto(Favourites favourites) {

        if(favourites == null) {
            return null;
        }

        FavouritesDto favouritesDto = new FavouritesDto();

        favouritesDto.setId(favourites.getId());
        favouritesDto.setUser(favourites.getUserData());
        favouritesDto.setProduct(favourites.getProduct());


        return favouritesDto;
    }

    @Override
    public Set<FavouritesDto> toFavouritesDtoList(Set<Favourites> favouritesSet) {

        Set<FavouritesDto> favouritesDtoSet = new HashSet<>();

        for(Favourites favourites : favouritesSet) {
            favouritesDtoSet.add(toFavouritesDto(favourites));
        }

        return favouritesDtoSet;
    }
}
