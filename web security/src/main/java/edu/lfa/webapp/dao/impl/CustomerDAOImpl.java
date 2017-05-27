/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.webapp.dao.impl;

import edu.lfa.webapp.dao.CustomerDAO;
import edu.lfa.webapp.entity.Customers;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LAKHE
 */
@Repository(value = "customerDAO")
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Transaction trans;
    private Session session;

    @Override
    public int insert(Customers t) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        int result = (int) session.save(t);
        trans.commit();
        session.close();
        return result;

    }

    @Override
    public void update(Customers t) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        session.saveOrUpdate(t);
        trans.commit();
        session.close();

    }

    @Override
    public boolean delete(int id) {
        boolean success = false;
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        Customers account = (Customers) session.get(Customers.class, id);
        if (account != null) {
            session.delete(account);
            success = true;
        }
        trans.commit();
        session.close();
        return success;
    }

    @Override
    public Customers getById(int id) {
        session = sessionFactory.openSession();
        Customers account = (Customers) session.get(Customers.class, id);
        session.close();
        return account;
    }

    @Override
    public List<Customers> getAll() {
        List<Customers> accounts = null;
        session = sessionFactory.openSession();
        accounts = session.createQuery("SELECT a FROM Customers a").list();
        session.close();
        return accounts;
    }

}
