/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Persistences.Salepromotion;
import Repositories.SalePromotionRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

/**
 *
 * @author db2admin
 */
public class CheckingPromotionCodeThread implements Runnable {

    Thread t;

    public CheckingPromotionCodeThread() {
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        ArrayList<Salepromotion> lstItem = SalePromotionRepository.selectAll();
        GlobalVariables.gSalePromotions = new Hashtable<String, Salepromotion>();
        for (Salepromotion item : lstItem) {
            if(IsSalePromotionExpired(item)){
                SalePromotionRepository.delete(item.getId());
            }
        }
    }

    // Load sale promotion
    public boolean IsSalePromotionExpired(Salepromotion item) {
        Date today = new Date();
        return (((today.getTime() - item.getDatestore().getTime())/1000)/3600)/24 == GlobalVariables.PROMOTION_EXPIRE_DAY;
    }
}
