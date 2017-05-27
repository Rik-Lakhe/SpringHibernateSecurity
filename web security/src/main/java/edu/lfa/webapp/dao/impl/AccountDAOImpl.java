/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.webapp.dao.impl;

import edu.lfa.webapp.dao.AccountDAO;
import edu.lfa.webapp.entity.Account;
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
@Repository(value = "accountDAO")
public class AccountDAOImpl implements AccountDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Transaction trans;
    private Session session;

    @Override
    public int insert(Account t) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        int result = (int) session.save(t);
        trans.commit();
        session.close();
        return result;

    }

    @Override
    public void update(Account t) {
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
        Account account = (Account) session.get(Account.class, id);
        if (account != null) {
            session.delete(account);
            success = true;
        }
        trans.commit();
        session.close();
        return success;
    }

    @Override
    public Account getById(int id) {
        session = sessionFactory.openSession();
        Account account = (Account) session.get(Account.class, id);
        session.close();
        return account;
    }

    @Override
    public List<Account> getAll() {
        List<Account> accounts = null;
        session = sessionFactory.openSession();
        accounts = session.createQuery("SELECT a FROM Account a").list();
        session.close();
        return accounts;
    }

}
