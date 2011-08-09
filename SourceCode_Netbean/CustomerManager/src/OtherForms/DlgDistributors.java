/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DlgDistributors.java
 *
 * Created on Jul 12, 2011, 12:44:36 AM
 */

package OtherForms;

import Persistences.*;
import Repositories.*;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author letuan
 */
public class DlgDistributors extends javax.swing.JDialog {

    public String DataTransfered;
    
    /** Creates new form DlgDistributors */
    public DlgDistributors(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadData();
    }

    /** Creates new form DlgDistributors */
    public DlgDistributors(java.awt.Frame parent, boolean modal, boolean enableChoose) {
        super(parent, modal);
        initComponents();
        loadData();
        btnChoose.setEnabled(enableChoose);
    }
    
    public void loadData() {
        ArrayList<Distributors> lstItem = new ArrayList<Distributors>();
        lstItem = DistributorsRepository.selectAll();
        MyTable.TableDistributors.loadDataIntoTableBook(tblData, lstItem);
    }

    public void loadInfoByID(int id) {
        Distributors item = DistributorsRepository.selectByID(id);
        txtID.setText(String.valueOf(item.getId()));
        txtName.setText(item.getName());
    }

    public void resetInputData() {
        txtID.setText("");
        txtName.setText("");
    }

    public boolean validateInputData(AtomicReference<Object> errText) {
        if (txtName.getText().equals("")) {
            errText.set("Name is empty");
            return false;
        }
        return true;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btnChoose = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Distributors");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(300, 422));
        jPanel3.setLayout(new java.awt.BorderLayout());

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tblData.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDataMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(java.awt.SystemColor.textHighlight);
        jPanel1.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("   List of Distributors");
        jPanel1.add(jLabel5, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.add(jPanel3, java.awt.BorderLayout.LINE_START);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24));
        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setText("Distributor Infomation");

        jLabel2.setText("ID");

        jLabel3.setText("Name");

        txtID.setEditable(false);

        btnChoose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Sign-Select-icon.png"))); // NOI18N
        btnChoose.setText("Choose");
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
            }
        });

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Eraser-icon.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/001_29.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/81.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnChoose)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChoose)
                    .addComponent(btnReset)
                    .addComponent(btnDelete)
                    .addComponent(btnSave))
                .addContainerGap(315, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-742)/2, (screenSize.height-511)/2, 742, 511);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void tblDataMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMousePressed
        // TODO add your handling code here:
        int modifiers = evt.getModifiers();
        if ((modifiers & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
            if (this.tblData.getSelectedRow() == -1) {
                return;
            }
            if (tblData.getValueAt(this.tblData.getSelectedRow(), 0) == null) {
                return;
            }
            if (evt.getClickCount() == 1) {
                String id = ((JLabel) tblData.getValueAt(this.tblData.getSelectedRow(), 0)).getName().trim();
                loadInfoByID(Integer.parseInt(id));
            }
        }
    }//GEN-LAST:event_tblDataMousePressed

    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseActionPerformed
        // TODO add your handling code here:
        if(txtID.getText().equals("")){
            return;
        }
        DataTransfered = txtID.getText() + "#" + txtName.getText();
        this.dispose();
    }//GEN-LAST:event_btnChooseActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        resetInputData();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if (txtID.getText().equals("")) {
            return;
        }
        if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this item", "Announcement", JOptionPane.OK_CANCEL_OPTION) == 0) {
            String id = ((JLabel) tblData.getValueAt(this.tblData.getSelectedRow(), 0)).getName().trim();
            if (DistributorsRepository.delete(Integer.parseInt(id))) {
                loadData();
                resetInputData();
                JOptionPane.showMessageDialog(null, "Item has been deleted",
                        "Announcement", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Delete item fail",
                        "Announcement", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        boolean updated = false;
        AtomicReference<Object> errText = new AtomicReference<Object>("");
        if (!validateInputData(errText)) {
            JOptionPane.showMessageDialog(null, errText.get(),
                    "Announcement", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtID.getText().equals("")) {
            // Insert new item
            Distributors item = new Distributors();
            item.setName(txtName.getText());
            if (DistributorsRepository.insert(item)) {
                updated = true;
            }
        } else {
            // Update item
            Distributors item = DistributorsRepository.selectByID(Integer.parseInt(txtID.getText()));
            item.setName(txtName.getText());
            if (DistributorsRepository.save(item)) {
                updated = true;
            }
        }
        if (updated) {
            loadData();
            JOptionPane.showMessageDialog(null, "Item has been updated",
                    "Announcement", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Update item fail",
                    "Announcement", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgDistributors dialog = new DlgDistributors(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChoose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

}
