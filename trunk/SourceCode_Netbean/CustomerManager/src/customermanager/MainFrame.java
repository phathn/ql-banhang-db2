/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainFrame.java
 *
 * Created on Jul 11, 2011, 11:57:59 PM
 */
package customermanager;

import Helpers.GlobalVariables;
import Helpers.ProcessThread;
import OtherForms.*;
import Persistences.Users;
import Repositories.UsersRepository;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author letuan
 */
public class MainFrame extends javax.swing.JFrame {

    /** Creates new form MainFrame */
    public MainFrame() {
        initComponents();
        InitFunctionsWhenLogin();
    }

    public void InitFunctionsWhenLogin() {
        InitGenericFunctions(true);
        InitBusinessFunctions(true);
    }

    public void InitFunctionsWhenLogout() {
        InitGenericFunctions(false);
        InitBusinessFunctions(false);
        menRoles.setEnabled(false);
        menUsers.setEnabled(false);
    }

    public void InitGenericFunctions(boolean val) {
        menLogin.setEnabled(!val);
        menLogout.setEnabled(val);
        menChangePassword.setEnabled(val);
    }

    public void InitBusinessFunctions(boolean val) {
        if (GlobalVariables.CurrentUser != null) {
            if (GlobalVariables.CurrentUser.getIdrole().getRolename().toLowerCase().contains("manager")) {
                menRoles.setEnabled(val);
                menUsers.setEnabled(val);
            } else {
                menRoles.setEnabled(!val);
                menUsers.setEnabled(!val);
            }
            menCustomer.setEnabled(val);
            menProduct.setEnabled(val);
            menOrders.setEnabled(val);
            menScheduling.setEnabled(val);
            menSales.setEnabled(val);
            menHelp.setEnabled(val);
            menAbout.setEnabled(val);
        } else {
            menRoles.setEnabled(true);
            menUsers.setEnabled(true);
            menCustomer.setEnabled(true);
            menProduct.setEnabled(true);
            menOrders.setEnabled(true);
            menScheduling.setEnabled(true);
            menSales.setEnabled(true);
            menHelp.setEnabled(true);
            menAbout.setEnabled(true);
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnProduct = new javax.swing.JButton();
        btnCustomer = new javax.swing.JButton();
        btnScheduling = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menLogin = new javax.swing.JMenuItem();
        menLogout = new javax.swing.JMenuItem();
        menChangePassword = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menRoles = new javax.swing.JMenuItem();
        menUsers = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menCustomer = new javax.swing.JMenuItem();
        menProduct = new javax.swing.JMenuItem();
        menOrders = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menScheduling = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menSales = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        menHelp = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menAbout = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Customer management");

        jPanel1.setLayout(new java.awt.BorderLayout());

        jToolBar1.setBorder(null);
        jToolBar1.setRollover(true);

        btnProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mobi.az.uk.football.arsenalfc_icon.png"))); // NOI18N
        btnProduct.setText("Products");
        btnProduct.setBorder(null);
        btnProduct.setFocusable(false);
        btnProduct.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProduct.setMaximumSize(new java.awt.Dimension(77, 70));
        btnProduct.setMinimumSize(new java.awt.Dimension(49, 70));
        btnProduct.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductActionPerformed(evt);
            }
        });
        jToolBar1.add(btnProduct);

        btnCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/customer_portal.png"))); // NOI18N
        btnCustomer.setText("Customers");
        btnCustomer.setBorder(null);
        btnCustomer.setFocusable(false);
        btnCustomer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCustomer.setMaximumSize(new java.awt.Dimension(77, 67));
        btnCustomer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCustomer);

        btnScheduling.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/chart.png"))); // NOI18N
        btnScheduling.setText("Scheduling");
        btnScheduling.setBorder(null);
        btnScheduling.setFocusable(false);
        btnScheduling.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnScheduling.setMaximumSize(new java.awt.Dimension(77, 67));
        btnScheduling.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnScheduling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSchedulingActionPerformed(evt);
            }
        });
        jToolBar1.add(btnScheduling);

        jPanel1.add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/crm-flow.jpg"))); // NOI18N
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.BorderLayout());

        lblStatus.setText("dadasd");
        lblStatus.setPreferredSize(new java.awt.Dimension(135, 14));
        jPanel2.add(lblStatus, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jMenu1.setText("System");

        menLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Access key.png"))); // NOI18N
        menLogin.setText("Log In");
        menLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menLoginActionPerformed(evt);
            }
        });
        jMenu1.add(menLogin);

        menLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout.png"))); // NOI18N
        menLogout.setText("Log Out");
        menLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menLogoutActionPerformed(evt);
            }
        });
        jMenu1.add(menLogout);

        menChangePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/refresh.png"))); // NOI18N
        menChangePassword.setText("Change Password");
        menChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menChangePasswordActionPerformed(evt);
            }
        });
        jMenu1.add(menChangePassword);
        jMenu1.add(jSeparator1);

        menRoles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Star-icon.png"))); // NOI18N
        menRoles.setText("Roles Management");
        menRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menRolesActionPerformed(evt);
            }
        });
        jMenu1.add(menRoles);

        menUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/User.png"))); // NOI18N
        menUsers.setText("Users Management");
        menUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menUsersActionPerformed(evt);
            }
        });
        jMenu1.add(menUsers);
        jMenu1.add(jSeparator2);

        menExit.setText("Exit");
        menExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menExitActionPerformed(evt);
            }
        });
        jMenu1.add(menExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Businesses");

        menCustomer.setText("Customers");
        menCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCustomerActionPerformed(evt);
            }
        });
        jMenu2.add(menCustomer);

        menProduct.setText("Products");
        menProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menProductActionPerformed(evt);
            }
        });
        jMenu2.add(menProduct);

        menOrders.setText("Orders");
        menOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOrdersActionPerformed(evt);
            }
        });
        jMenu2.add(menOrders);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Promotion");

        menScheduling.setText("Scheduling & Configurations");
        menScheduling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menSchedulingActionPerformed(evt);
            }
        });
        jMenu3.add(menScheduling);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Reports");
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        menSales.setText("Sales");
        menSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menSalesActionPerformed(evt);
            }
        });
        jMenu4.add(menSales);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Helps");

        menHelp.setText("CRM help");
        jMenu5.add(menHelp);
        jMenu5.add(jSeparator3);

        menAbout.setText("About CRM");
        menAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menAboutActionPerformed(evt);
            }
        });
        jMenu5.add(menAbout);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Test");

        jMenuItem15.setText("Producers");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem15);

        jMenuItem16.setText("ProductCategories");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem16);

        jMenuItem17.setText("Distributors");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem17);

        jMenuItem18.setText("Roles");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem18);

        jMenuItem19.setText("CustomerCategories");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem19);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-802)/2, (screenSize.height-509)/2, 802, 509);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
        DlgProducers dlg = new DlgProducers(this, rootPaneCheckingEnabled, false);
        dlg.show();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
        DlgProductCategories dlg = new DlgProductCategories(this, rootPaneCheckingEnabled, false);
        dlg.show();
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
        DlgDistributors dlg = new DlgDistributors(this, rootPaneCheckingEnabled, false);
        dlg.show();
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        // TODO add your handling code here:
        DlgRoles dlg = new DlgRoles(this, rootPaneCheckingEnabled, false);
        dlg.show();
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
        DlgCustomerCategories dlg = new DlgCustomerCategories(this, rootPaneCheckingEnabled, false);
        dlg.show();
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void menCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCustomerActionPerformed
        // TODO add your handling code here:
        DlgCustomers dlg = new DlgCustomers(this, rootPaneCheckingEnabled, false);
        dlg.show();
    }//GEN-LAST:event_menCustomerActionPerformed

    private void menProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menProductActionPerformed
        // TODO add your handling code here:
        DlgProducts dlg = new DlgProducts(this, rootPaneCheckingEnabled, false);
        dlg.show();
    }//GEN-LAST:event_menProductActionPerformed

    private void menRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menRolesActionPerformed
        // TODO add your handling code here:
        DlgRoles dlg = new DlgRoles(this, rootPaneCheckingEnabled, false);
        dlg.show();
    }//GEN-LAST:event_menRolesActionPerformed

    private void menUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menUsersActionPerformed
        // TODO add your handling code here:
        DlgUsers dlg = new DlgUsers(this, rootPaneCheckingEnabled, false);
        dlg.show();
    }//GEN-LAST:event_menUsersActionPerformed

    private void menLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menLoginActionPerformed
        // TODO add your handling code here:
        DlgLogin dlg = new DlgLogin(this, rootPaneCheckingEnabled);
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
                menLoginActionPerformed(evt);
            } else {
                InitFunctionsWhenLogin();
            }
        }
    }//GEN-LAST:event_menLoginActionPerformed

    private void menLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menLogoutActionPerformed
        // TODO add your handling code here:
        InitFunctionsWhenLogout();
    }//GEN-LAST:event_menLogoutActionPerformed

    private void menChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menChangePasswordActionPerformed
        // TODO add your handling code here:
        DlgChangePassword dlg = new DlgChangePassword(this, rootPaneCheckingEnabled);
        dlg.show();
        if (!dlg.DataTransfered.equals("")) {
            GlobalVariables.CurrentUser.setPassword(dlg.DataTransfered);
            if (UsersRepository.save(GlobalVariables.CurrentUser)) {
                JOptionPane.showMessageDialog(null, "Password has been changed.",
                        "Announcement", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(null, "Cannot change password.",
                    "Announcement", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menChangePasswordActionPerformed

    private void menExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menExitActionPerformed

    private void menAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menAboutActionPerformed
        // TODO add your handling code here:
        DlgAbout dlg = new DlgAbout(this, rootPaneCheckingEnabled);
        dlg.show();
    }//GEN-LAST:event_menAboutActionPerformed

    private void menOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menOrdersActionPerformed
        // TODO add your handling code here:
        DlgSelectDate dlg = new DlgSelectDate(this, rootPaneCheckingEnabled);
        dlg.show();
        if (!dlg.DataTransfered.equals("")) {
            String[] comp = dlg.DataTransfered.split("#");
            DlgOrders dlg2 = new DlgOrders(this, rootPaneCheckingEnabled, Integer.parseInt(comp[0]), Integer.parseInt(comp[1]));
            dlg2.show();
        }
    }//GEN-LAST:event_menOrdersActionPerformed

    private void menSchedulingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menSchedulingActionPerformed
        // TODO add your handling code here:
        ProcessThread processDlg;
        processDlg = new ProcessThread("Please wailt");
        processDlg.setLocationRelativeTo(this);
        processDlg.startLoadScheduling();
    }//GEN-LAST:event_menSchedulingActionPerformed

    private void btnProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductActionPerformed
        // TODO add your handling code here:
        DlgProducts dlg = new DlgProducts(this, rootPaneCheckingEnabled, false);
        dlg.show();
    }//GEN-LAST:event_btnProductActionPerformed

    private void btnCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerActionPerformed
        // TODO add your handling code here:
        DlgCustomers dlg = new DlgCustomers(this, rootPaneCheckingEnabled, false);
        dlg.show();
    }//GEN-LAST:event_btnCustomerActionPerformed

    private void btnSchedulingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSchedulingActionPerformed
        // TODO add your handling code here:
        ProcessThread processDlg;
        processDlg = new ProcessThread("Please wailt");
        processDlg.setLocationRelativeTo(this);
        processDlg.startLoadScheduling();
    }//GEN-LAST:event_btnSchedulingActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void menSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menSalesActionPerformed
        // TODO add your handling code here:
        DlgReportBalance dlg = new DlgReportBalance(this, rootPaneCheckingEnabled);
        dlg.show();
    }//GEN-LAST:event_menSalesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCustomer;
    private javax.swing.JButton btnProduct;
    private javax.swing.JButton btnScheduling;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JMenuItem menAbout;
    private javax.swing.JMenuItem menChangePassword;
    private javax.swing.JMenuItem menCustomer;
    private javax.swing.JMenuItem menExit;
    private javax.swing.JMenuItem menHelp;
    private javax.swing.JMenuItem menLogin;
    private javax.swing.JMenuItem menLogout;
    private javax.swing.JMenuItem menOrders;
    private javax.swing.JMenuItem menProduct;
    private javax.swing.JMenuItem menRoles;
    private javax.swing.JMenuItem menSales;
    private javax.swing.JMenuItem menScheduling;
    private javax.swing.JMenuItem menUsers;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the lblStatus
     */
    public javax.swing.JLabel getLblStatus() {
        return lblStatus;
    }

    /**
     * @param lblStatus the lblStatus to set
     */
    public void setLblStatus(javax.swing.JLabel lblStatus) {
        this.lblStatus = lblStatus;
    }
}