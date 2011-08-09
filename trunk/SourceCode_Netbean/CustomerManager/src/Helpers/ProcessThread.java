/**
 * @copyright 2008 JackHome Production. 
 */
package Helpers;

import OtherForms.DlgSchedulingAndConfigs;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

/**
 * ProgressConnectDialog.java
 * @author Ashok Das
 * @version 1.2 May 26, 2008
 */
public class ProcessThread extends JDialog {

    /**
     * Attributes
     */
    private Thread processThread;
    private ImageIcon imageloading = new ImageIcon(
            System.getProperty("user.dir") + File.separator
            + "src/Images/progress_bar.gif");
    private JLabel lblProgress = new JLabel("", imageloading, JLabel.HORIZONTAL);
    public JTable TblScheduling;
    public Calendar CalScheduling;
    
    /**
     * Ham tao phuc vu cho viec kiem tra co mail moi hay khog moi khi chuong trinh khoi dong
     * @param aThis
     * @param title
     * @param AccountID
     */
    public ProcessThread(String title) {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(title);
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent we) {
                //Do nothing....
            }
        });
        setSize(350, 180);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        setLocation(width / 3, height / 3);

        getContentPane().add(lblProgress);
        addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent me) {
                dispose();
            }
        });
        setVisible(true);
    }

    public ProcessThread(JTable tbl, Calendar cal, String title) {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(title);
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent we) {
                //Do nothing....
            }
        });
        TblScheduling = tbl;
        CalScheduling = cal;
        setSize(350, 180);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        setLocation(width / 3, height / 3);

        getContentPane().add(lblProgress);
        addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent me) {
                dispose();
            }
        });
        setVisible(true);
    }
    
    /**
     * The Method getLblProgress.
     * @return
     * @return		JLabel
     */
    public JLabel getLblProgress() {
        return lblProgress;
    }

    /**
     * The Method setLblProgress.
     * @param lblProgress
     * @return		void
     */
    public void setLblProgress(JLabel lblProgress) {
        this.lblProgress = lblProgress;
    }

    public void startLoadScheduling() {
        processThread = new Thread(new Runnable() {

            public void run() {
                try {
                    ShowSchedulingForm();
                } catch (Exception ex) {
                    Logger.getLogger(ProcessThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        processThread.start();
        this.setVisible(true);
    }

    public void startReloadScheduling() {
        processThread = new Thread(new Runnable() {

            public void run() {
                try {
                    reloadScheduling();
                } catch (Exception ex) {
                    Logger.getLogger(ProcessThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        processThread.start();
        this.setVisible(true);
    }

    public void reloadScheduling(){
        MonthCalendar.TableMonthTask.disableDayNotBelongMonth(TblScheduling, CalScheduling);
        this.dispose();
    }

    public void ShowSchedulingForm() {
        DlgSchedulingAndConfigs dlg = new DlgSchedulingAndConfigs(null, rootPaneCheckingEnabled);
        dlg.show();
        this.dispose();
    }
}
