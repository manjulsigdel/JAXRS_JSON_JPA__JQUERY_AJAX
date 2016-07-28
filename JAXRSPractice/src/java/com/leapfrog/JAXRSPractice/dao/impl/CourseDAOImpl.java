/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.JAXRSPractice.dao.impl;

import com.leapfrog.JAXRSPractice.dao.CourseDAO;
import com.leapfrog.JAXRSPractice.entity.Course;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Manjul Sigdel
 */
public class CourseDAOImpl implements CourseDAO {

    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction trans;

    public CourseDAOImpl() {
        emf = Persistence.createEntityManagerFactory("JPU");
        em = emf.createEntityManager();
    }

    @Override
    public void insert(Course c) {
        trans = em.getTransaction();
        if (!trans.isActive()) {
            trans.begin();
        }
        em.persist(c);
        trans.commit();
    }

    @Override
    public void update(Course c) {
        trans = em.getTransaction();
        if (!trans.isActive()) {
            trans.begin();
        }
        em.merge(c);
        trans.commit();
    }

    @Override
    public boolean delete(int id) {
         trans = em.getTransaction();
        if (!trans.isActive()) {
            trans.begin();
        }
        Course c=getByID(id);
        boolean success=false;
        if(c!=null){
            em.remove(c);
            success=true;
        }
        trans.commit();
        return success;
    }

    @Override
    public Course getByID(int id) {
        return em.find(Course.class, id);
        
    }

    @Override
    public List<Course> getAll() {
        return em.createQuery("Select c FROM Course c").getResultList();
    }

}
