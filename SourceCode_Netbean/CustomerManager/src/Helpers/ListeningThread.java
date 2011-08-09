package Helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class ListeningThread implements Runnable {

    Thread t;
    JLabel lblStatus;

    public ListeningThread(JLabel _lblStatus) {
        lblStatus = _lblStatus;
        t = new Thread(this);
        t.start();
    }

    @Override
    @SuppressWarnings("static-access")
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            checkingPromotionCode();
            // Only wait until meet right time
            if (!GlobalVariables.AlarmTime(GlobalVariables.GetMinSchedule())) {
                try {
                    if (GlobalVariables.GetMinSchedule() != null) {
                        lblStatus.setText("Waiting for sending email at: " + GlobalVariables.GetMinSchedule().toString() + " in " + DateFormat.getInstance().format(GlobalVariables.GetMinSchedule().getDateschedule()).split(" ")[0]);
                    } else {
                        lblStatus.setText("Waiting for sending email");
                    }
                    t.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ListeningThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                break;
            }
        }

        SendingEmailThread thread3 = new SendingEmailThread(lblStatus);

        try {
            thread3.t.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (!thread3.t.isAlive()) {
            System.out.println("SendingEmailThread is alive: "
                    + thread3.t.isAlive());
        }
    }

    public void checkingPromotionCode() {
        // Start listening thread
        CheckingPromotionCodeThread thread2 = new CheckingPromotionCodeThread();
        while (thread2.t.isAlive()) {
            try {
                thread2.t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
