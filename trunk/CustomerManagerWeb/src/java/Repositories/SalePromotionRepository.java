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
public class SalePromotionRepository {

    public static ArrayList<Salepromotion> selectAll() {
        ArrayList<Salepromotion> lst = new ArrayList<Salepromotion>();
        String SQL_QUERY = "from Salepromotion prod";
        Query query = (Query) HibernateUtil.getSessionFactory().openSession().createQuery(SQL_QUERY);
        for (Iterator it = query.iterate(); it.hasNext();) {
            lst.add((Salepromotion) it.next());
        }
        return lst;
    }

    public static Salepromotion selectByID(int id) {
        return (Salepromotion) HibernateUtil.getSessionFactory().openSession().get(Salepromotion.class, id);
    }

    public static ArrayList<Salepromotion> selectByIDCustomer(int idcustomer) {
        ArrayList<Salepromotion> lst = new ArrayList<Salepromotion>();
        String SQL_QUERY = "from Salepromotion item where idcustomer='" + idcustomer + "'";
        Query query = (Query) HibernateUtil.getSessionFactory().openSession().createQuery(SQL_QUERY);
        for (Iterator it = query.iterate(); it.hasNext();) {
            lst.add((Salepromotion) it.next());
        }
        return lst;
    }

    public static ArrayList<Salepromotion> selectByCode(String code) {
        ArrayList<Salepromotion> lst = new ArrayList<Salepromotion>();
        String SQL_QUERY = "from Salepromotion item where code='" + code + "'";
        Query query = (Query) HibernateUtil.getSessionFactory().openSession().createQuery(SQL_QUERY);
        for (Iterator it = query.iterate(); it.hasNext();) {
            lst.add((Salepromotion) it.next());
        }
        return lst;
    }
    
    public static boolean save(Salepromotion prod) {
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

            Salepromotion prod = selectByID(id);
            sess.delete(prod);

            tr.commit();
            sess.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean insert(Salepromotion prod) {
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
