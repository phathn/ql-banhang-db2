/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonthCalendar;

import Persistences.Scheduling;
import Repositories.SchedulingRepository;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author letuan
 */
public class TableMonthTask {
private static int PREFERRED_SIZE = 10;
    /**
     * disabel rowClickTableMonth,columnClickTableMonth is not belong month which is considering
     * @param table
     * @param calTemp
     */
    public static void disableDayNotBelongMonth(JTable table, Calendar calTemp) {
        Date dateChooser = calTemp.getTime();
        String strDate =
                DateFormat.getInstance().format(dateChooser);
        String[] thanhPhanNgay = strDate.split(" ");
        String date = thanhPhanNgay[0];
        String[] tokenDate = date.split("/");
        /////////////
        int dayBegin = 0;
        int maxDay = 0;
        dayBegin = CalendarFunctions.dayBeginMonth(calTemp);
        if (dayBegin == 1) {
            dayBegin = 8;
        }

        int dayInMonth = 1;
        calTemp.set(Calendar.DATE, 1);

        Date dt = CalendarFunctions.dayBeforeSomeDay(calTemp.getTime(), dayBegin - 1);
        int dayBeforeMonth = dt.getDate();
        int dayAfterMonth = 1;
        maxDay = calTemp.getActualMaximum(Calendar.DAY_OF_MONTH);
        int count = -1;
        ArrayList<CellTable> isChangedColor = new ArrayList<CellTable>();
        table.setFont(new Font("Microsoft Sans Serif", 0, 10));
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                count++;
                if ((count < dayBegin - 1)) {
                    JPanel pnl = new JPanel();
                    pnl.setLayout(new javax.swing.BoxLayout(pnl, javax.swing.BoxLayout.Y_AXIS));
                    JLabel lb = new JLabel();
                    lb.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10));
                    lb.setText(String.valueOf(dayBeforeMonth));
                    pnl.add(lb);
                    int thangTruoc = Integer.parseInt(tokenDate[0]) - 1;
                    int nam = Integer.parseInt(tokenDate[2]);
                    if (thangTruoc == 0) {
                        thangTruoc = 12;
                        nam--;
                    }
                    String strNam;
                    if (nam < 10) {
                        strNam = "0" + String.valueOf(nam);
                    } else {
                        strNam = String.valueOf(nam);
                    }
                    String ngay = String.valueOf(thangTruoc) + "/" + dayBeforeMonth + "/" + strNam;
                    pnl.setName(ngay);
                    loadTaskIntoPnl(pnl, dayBeforeMonth, thangTruoc, nam);
                    //addMouseListenerToMonthItem(pnl);
                    ///////////////////
                    CellTable cell = new CellTable();
                    cell.setRow(i);
                    cell.setColumn(j);
                    isChangedColor.add(cell);
                    table.setValueAt(pnl, i, j);
                    dayBeforeMonth++;
                } else if (count >= maxDay + dayBegin - 1) {
                    JPanel pnl = new JPanel();
                    pnl.setLayout(new javax.swing.BoxLayout(pnl, javax.swing.BoxLayout.Y_AXIS));
                    JLabel lb = new JLabel();
                    lb.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10));
                    lb.setText(String.valueOf(dayAfterMonth));
                    pnl.add(lb);

                    int thangsau = Integer.parseInt(tokenDate[0]) + 1;
                    int nam = Integer.parseInt(tokenDate[2]);
                    if (thangsau == 13) {
                        thangsau = 1;
                        nam++;
                    }
                    String strNam;
                    if (nam < 10) {
                        strNam = "0" + String.valueOf(nam);
                    } else {
                        strNam = String.valueOf(nam);
                    }
                    String ngay = String.valueOf(thangsau) + "/" + dayAfterMonth + "/" + strNam;
                    pnl.setName(ngay);
                    loadTaskIntoPnl(pnl, dayAfterMonth, thangsau, nam);
                    //////////////////////
                    CellTable cell = new CellTable();
                    cell.setRow(i);
                    cell.setColumn(j);
                    isChangedColor.add(cell);
                    table.setValueAt(pnl, i, j);
                    dayAfterMonth++;
                } else {
                    JPanel pnl = new JPanel();
                    pnl.setLayout(new javax.swing.BoxLayout(pnl, javax.swing.BoxLayout.Y_AXIS));
                    JLabel lb = new JLabel();
                    lb.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10));
                    lb.setText(String.valueOf(dayInMonth));
                    if (new Date().getDate() == dayInMonth) {
                        lb.setForeground(Color.red);
                        lb.setBackground(new Color(198, 217, 255));
                        lb.setOpaque(true);
                        lb.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 13));
                    }
                    pnl.add(lb);
                    String ngay = tokenDate[0] + "/" + dayInMonth + "/" + tokenDate[2];
                    pnl.setName(ngay);
                    loadTaskIntoPnl(pnl, dayInMonth, Integer.parseInt(tokenDate[0]), Integer.parseInt(tokenDate[2]));
                    //addMouseListenerToMonthItem(pnl);

                    table.setValueAt(pnl, i, j);

                    dayInMonth++;
                }

            }
        }
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn labelColumn = table.getColumnModel().getColumn(i);
            labelColumn.setCellRenderer(new MyImageCalendarRenderer(isChangedColor));
        }
    }

    /**
     * doc danh sach cac cong viec, dua vao panel
     * @param panel
     * @param Ngay
     */
    public static void loadTaskIntoPnl(JPanel panel, int day, int month, int year) {
        ArrayList<Scheduling> lstItem = SchedulingRepository.selectByDayMonthAndYear(day, month, year);
        if (lstItem.size() > 0) {
            for (Scheduling item : lstItem) {
                JLabel lb = new JLabel();
                String pathImages;
                pathImages = System.getProperty("user.dir") + File.separator +
                        "src/Images/alarm-clock.png";

                ImageIcon imageIcon = new ImageIcon(pathImages);
                if (imageIcon.getIconWidth() > PREFERRED_SIZE || imageIcon.getIconHeight() > PREFERRED_SIZE) {
                    imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(
                            PREFERRED_SIZE, PREFERRED_SIZE, Image.SCALE_SMOOTH));
                }
                lb.setIcon(imageIcon);
                lb.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10));
                lb.setText(item.toString());
                panel.add(lb);
            }
        }
    }
}
