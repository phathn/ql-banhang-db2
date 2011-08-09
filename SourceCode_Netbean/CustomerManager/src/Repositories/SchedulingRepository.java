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
public class SchedulingRepository {

    public static ArrayList<Scheduling> selectAll() {
        ArrayList<Scheduling> lst = new ArrayList<Scheduling>();
        String SQL_QUERY = "from Scheduling prod";
        Query query = (Query) HibernateUtil.getSessionFactory().openSession().createQuery(SQL_QUERY);
        for (Iterator it = query.iterate(); it.hasNext();) {
            lst.add((Scheduling) it.next());
        }
        return lst;
    }

    public static Scheduling selectByID(int id) {
        return (Scheduling) HibernateUtil.getSessionFactory().openSession().get(Scheduling.class, id);
    }

    public static ArrayList<Scheduling> selectByMonthAndYear(int month, int year) {
        ArrayList<Scheduling> lst = new ArrayList<Scheduling>();
        String SQL_QUERY = "from Scheduling item where item.month='" + month + "' and item.year='" + year + "'";
        Query query = (Query) HibernateUtil.getSessionFactory().openSession().createQuery(SQL_QUERY);
        for (Iterator it = query.iterate(); it.hasNext();) {
            lst.add((Scheduling) it.next());
        }
        return lst;
    }

    public static ArrayList<Scheduling> selectByDayMonthAndYear(int day, int month, int year) {
        ArrayList<Scheduling> lst = new ArrayList<Scheduling>();
        String SQL_QUERY = "from Scheduling item where Day(item.dateschedule)='" + day + "' and Month(item.dateschedule)='" + month + "' and Year(item.dateschedule)='" + (year + 2000) +  "'";
        Query query = (Query) HibernateUtil.getSessionFactory().openSession().createQuery(SQL_QUERY);
        for (Iterator it = query.iterate(); it.hasNext();) {
            lst.add((Scheduling) it.next());
        }
        return lst;
    }
    
    public static boolean save(Scheduling prod) {
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

            Scheduling prod = selectByID(id);
            sess.delete(prod);

            tr.commit();
            sess.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean insert(Scheduling prod) {
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
