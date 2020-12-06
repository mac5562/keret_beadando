package com.beadando.model;

import com.beadando.exceptions.BadDiscNumber;
import com.beadando.exceptions.DistributorEmpty;
import com.beadando.exceptions.NameEmpty;
import com.beadando.exceptions.ReleaseDateBad;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

public class Bd {
    private String name;
    private String distributor;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate releaseDate;
    private String id;
    private Rate rate;
    private int numOfDisc;

    public int getNumOfDisc() {
        return numOfDisc;
    }

    public void setNumOfDisc(int numOfDisc) throws BadDiscNumber {
        if (numOfDisc<=0){
            throw new BadDiscNumber(numOfDisc);
        }
        this.numOfDisc = numOfDisc;
    }


    public Bd() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NameEmpty {
        if (name.trim().length()==0){
            throw new NameEmpty();
        }
        this.name = name;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) throws DistributorEmpty {
        if (distributor.trim().length()==0){
            throw new DistributorEmpty();
        }
        this.distributor = distributor;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate releaseDate) throws ReleaseDateBad {
        if(releaseDate==null){
            throw new ReleaseDateBad("A megjelenési dátum nem lehet üres");
        }
        if (releaseDate.isBefore(LocalDate.of(2006,01,01))){
            throw new ReleaseDateBad("A megjelenési dátum nem lehet 2006 előtti");
        }
        this.releaseDate = releaseDate;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

public String toString(){
   return "BD{" +
            "name='" + name + '\'' +
            ", id='" + id + '\'' +
            ", releaseDate=" + releaseDate +
           ", numOfDisc=" + numOfDisc+
            ", rate=" + rate +
            ", distributor=" + distributor +
            '}';
}



}
