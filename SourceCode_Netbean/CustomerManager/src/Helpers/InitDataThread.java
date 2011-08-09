/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Persistences.*;
import Repositories.*;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JLabel;

/**
 *
 * @author db2admin
 */
public class InitDataThread implements Runnable {

    Thread t;
    JLabel lblStatus;

    public InitDataThread(JLabel _lblStatus) {
        lblStatus = _lblStatus;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        lblStatus.setText("Initialize data...");
        LoadOtherConfigs();
        loadCustomerList();
        loadScheduling();
        //loadSalePromotion();
        lblStatus.setText("Initialize data finished...");
        startListening();
    }

    public void startListening() {
        // Start listening thread
        ListeningThread thread2 = new ListeningThread(lblStatus);
        while (thread2.t.isAlive()) {
            try {
                thread2.t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if (!thread2.t.isAlive()) {
                thread2 = new ListeningThread(lblStatus);
            }
        }
    }

    public void LoadOtherConfigs() {
        ArrayList<Otherconfigs> lstItem = OtherConfigsRepository.selectAll();
        if (lstItem.size() > 0) {
            GlobalVariables.PROMOTION_EXPIRE_DAY =lstItem.get(0).getCodeexpireday();
            GlobalVariables.MAIL_SERVER_USER = lstItem.get(0).getEmailcompany();
            GlobalVariables.MAIL_SERVER_PASSWORD = lstItem.get(0).getPasswordemailcompany();
        }
    }
    
    // Load customer list
    public void loadCustomerList() {
        ArrayList<Customers> lstItem = CustomersRepository.selectAll();
        GlobalVariables.gCustomers = new Hashtable<String, Customers>();
        for (Customers item : lstItem) {
            GlobalVariables.gCustomers.put(String.valueOf(item.getId()), item);
        }
    }

    // Load scheduling list
    public void loadScheduling() {
        ArrayList<Scheduling> lstItem = SchedulingRepository.selectAll();
        GlobalVariables.gSchedulings = new Hashtable<String, Scheduling>();
        for (Scheduling item : lstItem) {
            GlobalVariables.gSchedulings.put(String.valueOf(item.getId()), item);
        }
    }

    // Load sale promotion
    public void loadSalePromotion() {
        ArrayList<Salepromotion> lstItem = SalePromotionRepository.selectAll();
        GlobalVariables.gSalePromotions = new Hashtable<String, Salepromotion>();
        for (Salepromotion item : lstItem) {
            GlobalVariables.gSalePromotions.put(String.valueOf(item.getId()), item);
        }
    }
}
