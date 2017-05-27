/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.webapp.dao;

import java.util.List;

/**
 *
 * @author LAKHE
 */
public interface GenericDAO<T> {
    int insert(T t);
    void update(T t);
    boolean delete(int id);
    T getById(int id);
    List<T> getAll();
}
