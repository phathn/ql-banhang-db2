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
public class OrderDetailsRepository {

    public static ArrayList<Orderdetails> selectAll() {
        ArrayList<Orderdetails> lst = new ArrayList<Orderdetails>();
        String SQL_QUERY = "from Orderdetails prod";
        Query query = (Query) HibernateUtil.getSessionFactory().openSession().createQuery(SQL_QUERY);
        for (Iterator it = query.iterate(); it.hasNext();) {
            lst.add((Orderdetails) it.next());
        }
        return lst;
    }

    public static Orderdetails selectByID(int id) {
        return (Orderdetails) HibernateUtil.getSessionFactory().openSession().get(Orderdetails.class, id);
    }

     public static ArrayList<Orderdetails> selectByOrder(int orderid) {
        ArrayList<Orderdetails> lst = new ArrayList<Orderdetails>();
        String SQL_QUERY = "from Orderdetails item where item.idorder='" + orderid + "'";
        Query query = (Query) HibernateUtil.getSessionFactory().openSession().createQuery(SQL_QUERY);
        for (Iterator it = query.iterate(); it.hasNext();) {
            lst.add((Orderdetails) it.next());
        }
        return lst;
    }
     
    public static boolean save(Orderdetails prod) {
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

            Orderdetails prod = selectByID(id);
            sess.delete(prod);

            tr.commit();
            sess.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean insert(Orderdetails prod) {
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
}
