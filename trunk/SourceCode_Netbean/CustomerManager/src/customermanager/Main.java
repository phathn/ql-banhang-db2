/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customermanager;

import Helpers.GlobalVariables;
import Helpers.InitDataThread;
import Persistences.Users;
import Repositories.UsersRepository;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        if (UsersRepository.selectAll().size() > 0) {
            DlgLogin dlg = new DlgLogin(null, true);
            dlg.show();
            if (!dlg.DataTransfered.equals("")) {
                String infoText = "";
                boolean success = true;
                String[] comp = dlg.DataTransfered.split("#");
                ArrayList<Users> lstItem = UsersRepository.selectByUserName(comp[0]);
                if (lstItem.size() > 0) {
                    lstItem = UsersRepository.selectByUserNameAndPassword(comp[0], comp[1]);
                    if (lstItem.size() > 0) {
                        GlobalVariables.CurrentUser = lstItem.get(0);
                        infoText = "Hello " + GlobalVariables.CurrentUser.getUsername() + "!";
                    } else {
                        infoText = "Input password is wrong, please try again!";
                        success = false;
                    }
                } else {
                    infoText = "This user is not exist in database";
                    success = false;
                }
                if (!success) {
                    JOptionPane.showMessageDialog(null, infoText,
                            "Announcement", JOptionPane.ERROR_MESSAGE);
                    main(args);
                } else {
                    MainFrame frm = new MainFrame();
                    frm.show();
                    new InitDataThread(frm.getLblStatus());
                }
            }
        } else {
            MainFrame frm = new MainFrame();
            frm.show();
            new InitDataThread(frm.getLblStatus());
        }
    }
}
