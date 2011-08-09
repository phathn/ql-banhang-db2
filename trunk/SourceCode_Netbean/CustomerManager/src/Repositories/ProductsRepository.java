/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Persistences.*;
import java.util.*;
import org.hibernate.*;

/**
 *
 * @author db2admin
 */
public class ProductsRepository {

    public static ArrayList<Products> selectAll() {
        ArrayList<Products> lst = new ArrayList<Products>();
        String SQL_QUERY = "from Products prod";
        Query query = (Query) HibernateUtil.getSessionFactory().openSession().createQuery(SQL_QUERY);
        for (Iterator it = query.iterate(); it.hasNext();) {
            lst.add((Products) it.next());
        }
        return lst;
    }

    public static Products selectByID(int id) {
        return (Products) HibernateUtil.getSessionFactory().openSession().get(Products.class, id);
    }

    public static boolean save(Products prod) {
        try {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = sess.beginTransaction();

            sess.update(prod);

            tr.commit();
            sess.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean delete(int id) {
        try {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = sess.beginTransaction();

            Products prod = selectByID(id);
            sess.delete(prod);

            tr.commit();
            sess.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean insert(Products prod) {
        try {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = sess.beginTransaction();

            sess.save(prod);

            tr.commit();
            sess.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static ArrayList<Products> selectByIDProductCategory(int id) {
        ArrayList<Products> lst = new ArrayList<Products>();
        String SQL_QUERY = "from Products prod where prod.IDProductCategory='" + id + "'";
        Query query = (Query) HibernateUtil.getSessionFactory().openSession().createQuery(SQL_QUERY);
        for (Iterator it = query.iterate(); it.hasNext();) {
            lst.add((Products) it.next());
        }
        return lst;
    }
}
