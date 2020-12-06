package com.beadando.dao.relational;



import com.beadando.dao.BdDAO;
import com.beadando.exceptions.*;
import com.beadando.model.Bd;
import com.beadando.model.Rate;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class BdDAORelationalTest {
@Test
    public void test() throws ReleaseDateBad, BadDiscNumber, DistributorEmpty, NameEmpty, BdAddedBefore, BdNotFound {
    Bd ob=new Bd();
    BdDAO dao=new BdDAORelational();
    ob.setName("Az élet szép");
    ob.setRate(Rate.CR);
    ob.setDistributor("Pro-video");
    ob.setNumOfDisc(1);
    ob.setReleaseDate(LocalDate.of(2009,02,12));

    dao.createBd(ob);
    //System.out.println(dao.readBd("29dad4f1-b356-4db8-ba2c-8bbafe4a94b5"));
    //dao.removeBd("29dad4f1-b356-4db8-ba2c-8bbafe4a94b5");
}
}