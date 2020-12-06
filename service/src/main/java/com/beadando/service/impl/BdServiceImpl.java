package com.beadando.service.impl;

import com.beadando.dao.BdDAO;
import com.beadando.exceptions.*;
import com.beadando.model.Bd;
import com.beadando.service.BdService;
import com.beadando.model.Rate;

import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Collectors;

public class BdServiceImpl implements BdService {
    BdDAO dao;
    public BdServiceImpl(BdDAO dao) {
        this.dao=dao;
    }

    @Override
    public void addBd(Bd lemez) throws BdAddedBefore{
    dao.createBd(lemez);
    }

    @Override
    public Collection<Bd> getEveryBd() {
        Collection<Bd>result=dao.readAllBd();
        return result;
    }

    @Override
    public Bd getBdById(String id) throws BdNotFound {
        Bd result=dao.readBd(id);
        return result;
    }

    @Override
    public void updateBd(String id, String name, LocalDate releasedate, int discnumb, Rate rate, String distributor) throws BdNotFound, NameEmpty, BadDiscNumber, ReleaseDateBad, DistributorEmpty {
            dao.modifyBd(id,name,releasedate,discnumb,rate,distributor);

    }

    @Override
    public void removeBd(String id) throws BdNotFound {
            dao.removeBd(id);
    }


    @Override
    public Collection<Bd> getEveryBdByDistributor(String distributor) {
        Collection<Bd> bds=getEveryBd();
        Collection<Bd> result=bds.stream().filter(d -> d.getDistributor()==distributor).collect(Collectors.toList());
        return result;
    }

    @Override
    public Collection<Bd> getEveryBdByRate(Rate rate) {
        Collection<Bd> bds=getEveryBd();
        Collection<Bd> result=bds.stream().filter(d -> d.getRate()==rate).collect(Collectors.toList());
        return result;
    }
}
