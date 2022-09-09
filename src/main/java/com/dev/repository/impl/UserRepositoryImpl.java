/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.repository.impl;

import com.dev.pojo.Prescription;
import com.dev.pojo.PrescriptionDetail;
import com.dev.pojo.User;
import com.dev.repository.UserRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Thanh_Tam
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    LocalSessionFactoryBean sessionFactory;

    @Override
    public User getUser(int userID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(User.class);
        Root root = query.from(User.class);

        query.where(builder.equal(root.get("id").as(Integer.class), userID));

        Query q = session.createQuery(query);

        return (User) q.getSingleResult();
    }

    @Override
    public boolean addUser(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(user);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public List<User> getUsers(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query.select(root);
//                if (!username.isEmpty()) {
        if (username != null) {
            Predicate p = builder.equal(root.get("username").as(String.class), username.trim());
            query.where(p);
            Query q = session.createQuery(query);
            return q.getResultList();
        }
        Query q = session.createQuery(query);//tự thêm
        return q.getResultList();//tự thêm
//                return null;

    }

    @Override
    public List<User> getUsersRoleDoctor(int userRoleID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query.where(builder.equal(root.get("userRoleId"), userRoleID));
        Query q = session.createQuery(query);
        return q.getResultList();

    }

    @Override
    public boolean deleteUser(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            User m = session.get(User.class, id);
            session.delete(m);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
