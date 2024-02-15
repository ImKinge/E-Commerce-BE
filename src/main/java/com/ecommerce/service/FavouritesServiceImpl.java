package com.ecommerce.service;

import com.ecommerce.dto.FavouritesDto;
import com.ecommerce.entity.Favourites;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.UserData;
import com.ecommerce.exception.FavouritesException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.exception.UserException;
import com.ecommerce.mapper.FavouritesMapper;
import com.ecommerce.repository.FavouritesRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class FavouritesServiceImpl implements FavouritesService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FavouritesRepository favouritesRepository;

    @Autowired
    private FavouritesMapper favouritesMapper;

    @Override
    public Favourites addToFavourites(Integer productId, String fiscalCode) throws UserException, ProductException, FavouritesException {

        UserData userData = userRepository.findByFiscalCode(fiscalCode).orElseThrow(() -> new UserException("Non esiste un utente con codice fiscale: " + fiscalCode));
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductException("Non esiste un prodotto con id prodotto: " + productId));

        //Dobbiamo controllare sia se il preferito è già presente filtrandolo per id prodotto e utente
        Boolean favouritesCheck = favouritesRepository.findByProductIdAndUser(productId, fiscalCode).isPresent();

        if(favouritesCheck) {
            throw new FavouritesException("Prodotto già presente tra i preferiti!");
        }

        Favourites favourites = new Favourites(userData, product);

        return favouritesRepository.save(favourites);
    }

    @Override
    public Set<FavouritesDto> getAllFavouritesByUser(String fiscalCode) {

        Set<Favourites> favouritesSet = favouritesRepository.findAllById(fiscalCode);

        return favouritesMapper.toFavouritesDtoList(favouritesSet);
    }

    @Override
    public void removeToFavourites(Integer productId) {
        favouritesRepository.deleteByProductId(productId);
    }
}
