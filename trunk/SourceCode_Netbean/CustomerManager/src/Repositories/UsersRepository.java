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
public class UsersRepository {

    public static ArrayList<Users> selectAll() {
        ArrayList<Users> lst = new ArrayList<Users>();
        String SQL_QUERY = "from Users prod";
        Query query = (Query) HibernateUtil.getSessionFactory().openSession().createQuery(SQL_QUERY);
        for (Iterator it = query.iterate(); it.hasNext();) {
            lst.add((Users) it.next());
        }
        return lst;
    }

    public static Users selectByID(int id) {
        return (Users) HibernateUtil.getSessionFactory().openSession().get(Users.class, id);
    }

    public static ArrayList<Users> selectByUserName(String username) {
        ArrayList<Users> lst = new ArrayList<Users>();
        String SQL_QUERY = "from Users item where item.username='" + username + "'";
        Query query = (Query) HibernateUtil.getSessionFactory().openSession().createQuery(SQL_QUERY);
        for (Iterator it = query.iterate(); it.hasNext();) {
            lst.add((Users) it.next());
        }
        return lst;
    }

     public static ArrayList<Users> selectByUserNameAndPassword(String username, String password) {
        ArrayList<Users> lst = new ArrayList<Users>();
        String SQL_QUERY = "from Users item where item.username='" + username + "' and item.password='" + password + "'";
        Query query = (Query) HibernateUtil.getSessionFactory().openSession().createQuery(SQL_QUERY);
        for (Iterator it = query.iterate(); it.hasNext();) {
            lst.add((Users) it.next());
        }
        return lst;
    }
     
    public static boolean save(Users prod) {
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

            Users prod = selectByID(id);
            sess.delete(prod);

            tr.commit();
            sess.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean insert(Users prod) {
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
