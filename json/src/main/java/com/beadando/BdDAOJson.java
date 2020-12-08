package com.beadando;

import com.beadando.dao.BdDAO;
import com.beadando.exceptions.*;
import com.beadando.model.Bd;
import com.beadando.model.Rate;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class BdDAOJson implements BdDAO {
    File jsonFile;
    ObjectMapper mapper;

    public BdDAOJson(String jsonFilePath)throws IOException {
        jsonFile=new File(jsonFilePath);
        if(!jsonFile.exists()){
            FileWriter writer=new FileWriter(jsonFile);
            writer.write("[]");
            writer.flush();
            writer.close();
        }
        this.jsonFile=jsonFile;
        mapper=new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    public void createBd(Bd bd) throws BdAddedBefore {
        Collection<Bd>bds=readAllBd();
        Bd result=null;
        try {
            result=readBd(bd.getId());
        }catch (BdNotFound bdNotFound ){
            bds.add(bd);
            try {
                mapper.writeValue(jsonFile,bds);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        throw new BdAddedBefore(bd.getId());
    }

    public Collection<Bd> readAllBd() {
        Collection<Bd>bds=new ArrayList<Bd>();
        TypeReference type= new TypeReference<ArrayList<Bd>>(){};
        try {
            bds= (Collection<Bd>) mapper.readValue(jsonFile,type);
        }catch (IOException e){
            e.printStackTrace();
        }
        return bds;
    }

    public Bd readBd(String id) throws BdNotFound {
        Collection<Bd>bds=readAllBd();
        for (Bd b:bds){
            if(b.getId().equalsIgnoreCase(id)){
                return b;
            }
        }
        throw new BdNotFound(id);
    }

    public void modifyBd(String id, String name, LocalDate releasedate, int discnumb, Rate rate, String distributor) throws NameEmpty, ReleaseDateBad, BadDiscNumber, DistributorEmpty {

    }

    public void removeBd(String id) {

    }

    public Collection<Bd> readAllBdOfRate(Rate rate) {
        return null;
    }

   /* @Override
    public Collection<Bd> readAllBdOfDistributor(String distributor) {
        return null;
    }*/
}
