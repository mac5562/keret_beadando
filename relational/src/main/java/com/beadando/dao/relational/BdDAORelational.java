package com.beadando.dao.relational;

import com.beadando.dao.BdDAO;
import com.beadando.exceptions.*;

import com.beadando.model.Bd;
import com.beadando.model.Rate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.Collection;

public class BdDAORelational implements BdDAO {
    private static SessionFactory factory;
    public  BdDAORelational(){
        factory=new Configuration().configure().buildSessionFactory();
    }

    public void createBd(Bd bd) throws BdAddedBefore{
        try{

            readBd(bd.getId());
        }
        catch (BdNotFound bdNotFound) {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(bd);
            tx.commit();
            session.close();
            return;
        }

        throw new BdAddedBefore(bd.getId());
    }

    public Collection<Bd> readAllBd() {
        Session session=factory.openSession();
        Collection<Bd> result =  session.createQuery("FROM Bd").list();
        return result;
    }

    public Bd readBd(String id) throws BdNotFound  {
        Session session=factory.openSession();
        if(session.get(Bd.class,id)==null){
            throw  new BdNotFound(id);
        }
        Bd result=session.get(Bd.class,id);
        return result;
    }

    public void modifyBd(String id, String name, LocalDate releasedate, int discnumb, Rate rate, String distributor) throws NameEmpty, ReleaseDateBad, BadDiscNumber, DistributorEmpty {
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        Bd object=session.get(Bd.class,id);
        object.setName(name);
        object.setDistributor(distributor);
        object.setNumOfDisc(discnumb);
        object.setRate(rate);
        object.setReleaseDate(releasedate);
        session.update(object);
        tx.commit();
        session.close();
    }


    public void removeBd(String id) {
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        Bd obj=session.get( Bd.class,id);
        session.delete(obj);
        tx.commit();
        session.close();
    }

    public Collection<Bd> readAllBdOfRate(Rate rate) {
        Session session=factory.openSession();
        String hql="From Bd Where rate=:rate";
        Query q=session.createQuery(hql);
        q.setParameter("rate",rate);
        Collection result =q.list();
        return result;
    }

    @Override
    public Collection<Bd> readAllBdOfDistributor(String distributor) {
        Session session=factory.openSession();
        String hql="From Bd Where distributor=:distributor";
        Query q=session.createQuery(hql);
        q.setParameter("distributor",distributor);
        Collection result =q.list();
        return result;
    }
}
