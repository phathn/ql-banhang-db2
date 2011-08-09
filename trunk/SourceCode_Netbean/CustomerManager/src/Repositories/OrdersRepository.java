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
public class OrdersRepository {

    public static ArrayList<Orders> selectAll() {
        ArrayList<Orders> lst = new ArrayList<Orders>();
        String SQL_QUERY = "from Orders prod";
        Query query = (Query) HibernateUtil.getSessionFactory().openSession().createQuery(SQL_QUERY);
        for (Iterator it = query.iterate(); it.hasNext();) {
            lst.add((Orders) it.next());
        }
        return lst;
    }

    public static Orders selectByID(int id) {
        return (Orders) HibernateUtil.getSessionFactory().openSession().get(Orders.class, id);
    }

    public static ArrayList<Orders> selectByMonthAndYear(int month, int year) {
        ArrayList<Orders> lst = new ArrayList<Orders>();
        String SQL_QUERY = "from Orders item where month(item.orderdate)='" + month + "' and year(item.orderdate)='" + year + "'";
        Query query = (Query) HibernateUtil.getSessionFactory().openSession().createQuery(SQL_QUERY);

        for (Iterator it = query.iterate(); it.hasNext();) {
            lst.add((Orders) it.next());
        }

        return lst;
    }

    public static boolean save(Orders prod) {
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

            Orders prod = selectByID(id);
            sess.delete(prod);

            tr.commit();
            sess.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean insert(Orders prod) {
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
