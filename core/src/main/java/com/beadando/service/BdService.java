package com.beadando.service;

import com.beadando.exceptions.*;
import com.beadando.model.Bd;
import com.beadando.model.Rate;

import java.time.LocalDate;
import java.util.Collection;

public interface BdService {
    void addBd(Bd lemez) throws BdAddedBefore;
    Collection<Bd>getEveryBd();
    Bd getBdById(String id) throws BdNotFound;
    void updateBd(String id, String name, LocalDate releasedate, int discnumb, Rate rate, String distributor) throws BdNotFound, NameEmpty, BadDiscNumber, ReleaseDateBad, DistributorEmpty;
    void removeBd(String id)throws BdNotFound;
    Collection<Bd>getEveryBdByDistributor(String distributor);
    Collection<Bd>getEveryBdByRate(Rate rate);
}
