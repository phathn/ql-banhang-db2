package Helpers;

import Persistences.Customers;
import Persistences.Salepromotion;
import Repositories.SalePromotionRepository;
import Repositories.SchedulingRepository;
import SendMails.SendingMail;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import javax.swing.JLabel;

public class SendingEmailThread implements Runnable {

    Thread t;
    JLabel lblStatus;

    public SendingEmailThread(JLabel _lblStatus) {
        lblStatus = _lblStatus;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        // TODO add your handling code here:
        lblStatus.setText("Sending mail to customers...");
        for (Iterator it = GlobalVariables.gCustomers.values().iterator(); it.hasNext();) {
            SendingMail processMail = new SendingMail();
            Customers cus = (Customers) it.next();
            Salepromotion sale = null;
            ArrayList<Salepromotion> arr = SalePromotionRepository.selectByIDCustomer(cus.getId());
            if (arr.size() > 0) {
                sale = arr.get(0);
            }
            if (sale != null) {
                if (processMail.sendMail(cus.getEmail(), "Promotion email", processMail.readFile(), sale.getCode())) {
                    lblStatus.setText("Sent promotion email to customer: " + cus.getName() + " with email: " + cus.getEmail());
                    System.out.println("Sent promotion email to customer: " + cus.getName() + " with email: " + cus.getEmail());
                }
            } else {
                String promotionCode = GlobalVariables.generateRandomCharacters();
                if (processMail.sendMail(cus.getEmail(), "Promotion email", processMail.readFile(), promotionCode)) {
                    lblStatus.setText("Sent promotion email to customer: " + cus.getName() + " with email: " + cus.getEmail());
                    System.out.println("Sent promotion email to customer: " + cus.getName() + " with email: " + cus.getEmail());
                }
                sale = new Salepromotion();
                sale.setIdcustomer(cus);
                sale.setCode(promotionCode);
                sale.setDatestore(new Date());
                SalePromotionRepository.insert(sale);
            }

        }
        SchedulingRepository.delete(GlobalVariables.GetMinSchedule().getId());
        GlobalVariables.gSchedulings.remove(String.valueOf(GlobalVariables.GetMinSchedule().getId()));
        lblStatus.setText("Send mails finished");
    }
}
