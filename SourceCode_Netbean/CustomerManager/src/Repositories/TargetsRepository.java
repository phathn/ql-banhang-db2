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
public class TargetsRepository {

    public static ArrayList<Targets> selectAll() {
        ArrayList<Targets> lst = new ArrayList<Targets>();
        String SQL_QUERY = "from Targets prod";
        Query query = (Query) HibernateUtil.getSessionFactory().openSession().createQuery(SQL_QUERY);
        for (Iterator it = query.iterate(); it.hasNext();) {
            lst.add((Targets) it.next());
        }
        return lst;
    }

    public static Targets selectByID(int id) {
        return (Targets) HibernateUtil.getSessionFactory().openSession().get(Targets.class, id);
    }

    public static ArrayList<Targets> selectByMonthAndYear(int month, int year) {
        ArrayList<Targets> lst = new ArrayList<Targets>();
        String SQL_QUERY = "from Targets item where item.month='" + month + "' and item.year='" + year + "'";
        Query query = (Query) HibernateUtil.getSessionFactory().openSession().createQuery(SQL_QUERY);
        for (Iterator it = query.iterate(); it.hasNext();) {
            lst.add((Targets) it.next());
        }
        return lst;
    }

    public static boolean save(Targets prod) {
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

            Targets prod = selectByID(id);
            sess.delete(prod);

            tr.commit();
            sess.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean insert(Targets prod) {
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
