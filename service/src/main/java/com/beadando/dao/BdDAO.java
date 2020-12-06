package com.beadando.dao;

import com.beadando.exceptions.*;
import com.beadando.model.Bd;
import com.beadando.model.Rate;

import java.time.LocalDate;
import java.util.Collection;

public interface BdDAO {
    void createBd(Bd bd) throws BdAddedBefore;
    Collection<Bd> readAllBd();
    Bd readBd(String id)throws BdNotFound;
    void modifyBd(String id,String name,LocalDate releasedate,int discnumb,Rate rate,String distributor) throws NameEmpty, ReleaseDateBad, BadDiscNumber, DistributorEmpty,BdNotFound;
    void removeBd(String id)throws BdNotFound;
    Collection<Bd>readAllBdOfRate(Rate rate);
    Collection<Bd>readAllBdOfDistributor(String distributor);
}
