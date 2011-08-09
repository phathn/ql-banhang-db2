/*
 *  Copyright (C) 2004 Kai Toedter
 *  kai@toedter.com
 *  www.toedter.com
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public License
 *  as published by the Free Software Foundation; either version 2
 *  of the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */
package MyDatePicker;

import Helpers.ProcessThread;
import MyTable.TableOders;
import MyTable.TableReportOders;
import Persistences.Orders;
import Persistences.Targets;
import Repositories.OrdersRepository;
import Repositories.TargetsRepository;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * JCalendar is a bean for entering a date by choosing the year, month and day.
 *
 * @author Kai Toedter
 * @version 1.2
 */
public class JCalendar extends JPanel implements PropertyChangeListener {

    /**
     * @return the checkMode
     */
    public eTableMode getCheckMode() {
        return checkMode;
    }

    /**
     * @param checkMode the checkMode to set
     */
    public void setCheckMode(eTableMode checkMode) {
        this.checkMode = checkMode;
    }

    /**
     * @return the _txtTotal
     */
    public JTextField getTxtTotal() {
        return _txtTotal;
    }

    /**
     * @param txtTotal the _txtTotal to set
     */
    public void setTxtTotal(JTextField txtTotal) {
        this._txtTotal = txtTotal;
    }

    public enum eTableMode {

        REPORT,
        SCHEDULING
    }
    private Calendar calendar;
    private boolean initialized = false;
    /** indicates if weeks of year shall be visible */
    protected boolean weekOfYearVisible = true;
    /** the locale */
    protected Locale locale;
    /** the month chooser */
    protected JMonthChooser monthChooser;
    private JPanel monthYearPanel;
    /** the year chhoser */
    protected JYearChooser yearChooser;
    private JTable _tblCalendar_Month;
    private JTextField _txtTarget;
    private eTableMode checkMode;
    private JTextField _txtTotal;
    private JTextField _txtBalance;
    
    /**
     * Default JCalendar constructor.
     */
    public JCalendar() {
        this(null, null, true, true);
    }

    /**
     * Default JCalendar constructor.
     */
    public JCalendar(JTable tblCalendar_Month) {
        this(null, null, true, true, tblCalendar_Month);
    }

    public JCalendar(JTable tblCalendar_Month, JTextField txtTarget) {
        this(null, null, true, true, tblCalendar_Month, txtTarget);
    }

    public JCalendar(JTable tblCalendar_Month, JTextField txtTarget, JTextField txtTotal, JTextField txtBalance) {
        this(null, null, true, true, tblCalendar_Month, txtTarget, txtTotal, txtBalance);
    }

    /**
     * JCalendar constructor specifying the month spinner type.
     *
     * @param monthSpinner false, if no month spinner should be used
     */
    public JCalendar(boolean monthSpinner, JTable tblCalendar_Month) {
        this(null, null, monthSpinner, true, tblCalendar_Month);
    }

    /**
     * JCalendar constructor which allows the initial date to be set.
     *
     * @param date the date
     */
    public JCalendar(Date date, JTable tblCalendar_Month) {
        this(date, null, true, true, tblCalendar_Month);
    }

    /**
     * JCalendar constructor allowing the initial locale to be set.
     *
     * @param locale the new locale
     */
    public JCalendar(Locale locale, JTable tblCalendar_Month) {
        this(null, locale, true, true, tblCalendar_Month);
    }

    /**
     * JCalendar constructor specifying both the initial date and locale.
     *
     * @param date the date
     * @param locale the new locale
     */
    public JCalendar(Date date, Locale locale, JTable tblCalendar_Month) {
        this(date, locale, true, true, tblCalendar_Month);
    }

    /**
     * JCalendar constructor specifying both the initial date and the month
     * spinner type.
     *
     * @param date the date
     * @param monthSpinner false, if no month spinner should be used
     */
    public JCalendar(Date date, boolean monthSpinner, JTable tblCalendar_Month) {
        this(date, null, monthSpinner, true, tblCalendar_Month);
    }

    /**
     * JCalendar constructor specifying both the locale and the month spinner.
     *
     * @param locale the locale
     * @param monthSpinner false, if no month spinner should be used
     */
    public JCalendar(Locale locale, boolean monthSpinner, JTable tblCalendar_Month) {
        this(null, locale, monthSpinner, true, tblCalendar_Month);
    }

    public JCalendar(Date date, Locale locale, boolean monthSpinner) {
        // needed for setFont() etc.
        monthChooser = null;
        yearChooser = null;

        this.locale = locale;

        if (locale == null) {
            this.locale = Locale.getDefault();
        }

        calendar = Calendar.getInstance();

        setLayout(new BorderLayout());
        monthYearPanel = new JPanel();
        monthYearPanel.setLayout(new BorderLayout());

        monthChooser = new JMonthChooser(monthSpinner);
        yearChooser = new JYearChooser();
        monthChooser.setYearChooser(yearChooser);
        monthYearPanel.add(monthChooser, BorderLayout.WEST);
        monthYearPanel.add(yearChooser, BorderLayout.CENTER);
        monthYearPanel.setBorder(BorderFactory.createEmptyBorder());
        add(monthYearPanel, BorderLayout.NORTH);

        // Set the initialized flag before setting the calendar. This will
        // cause the other components to be updated properly.
        if (date != null) {
            calendar.setTime(date);
        }

        initialized = true;
        setCalendar(calendar);
    }

    public JCalendar(Date date, Locale locale, boolean monthSpinner, boolean weekOfYearVisible) {
        // needed for setFont() etc.
        monthChooser = null;
        yearChooser = null;
        this.weekOfYearVisible = weekOfYearVisible;

        this.locale = locale;

        if (locale == null) {
            this.locale = Locale.getDefault();
        }

        calendar = Calendar.getInstance();

        setLayout(new BorderLayout());
        monthYearPanel = new JPanel();
        monthYearPanel.setLayout(new BorderLayout());

        monthChooser = new JMonthChooser(monthSpinner);
        yearChooser = new JYearChooser();
        monthChooser.setYearChooser(yearChooser);
        monthYearPanel.add(monthChooser, BorderLayout.WEST);
        monthYearPanel.add(yearChooser, BorderLayout.CENTER);
        monthYearPanel.setBorder(BorderFactory.createEmptyBorder());

        monthChooser.addPropertyChangeListener(this);
        yearChooser.addPropertyChangeListener(this);
        add(monthYearPanel, BorderLayout.NORTH);

        // Set the initialized flag before setting the calendar. This will
        // cause the other components to be updated properly.
        if (date != null) {
            calendar.setTime(date);
        }

        initialized = true;
        setCalendar(calendar);
    }

    /**
     * JCalendar constructor with month spinner parameter.
     *
     * @param date the date
     * @param locale the locale
     * @param monthSpinner false, if no month spinner should be used
     * @param weekOfYearVisible true, if weeks of year shall be visible
     */
    public JCalendar(Date date, Locale locale, boolean monthSpinner,
            boolean weekOfYearVisible, JTable tblCalendar_Month) {
        // needed for setFont() etc.
        this._tblCalendar_Month = tblCalendar_Month;
        monthChooser = null;
        yearChooser = null;
        this.weekOfYearVisible = weekOfYearVisible;

        this.locale = locale;

        if (locale == null) {
            this.locale = Locale.getDefault();
        }

        calendar = Calendar.getInstance();

        setLayout(new BorderLayout());
        monthYearPanel = new JPanel();
        monthYearPanel.setLayout(new BorderLayout());

        monthChooser = new JMonthChooser(monthSpinner);
        yearChooser = new JYearChooser();
        monthChooser.setYearChooser(yearChooser);
        monthYearPanel.add(monthChooser, BorderLayout.WEST);
        monthYearPanel.add(yearChooser, BorderLayout.CENTER);
        monthYearPanel.setBorder(BorderFactory.createEmptyBorder());

        monthChooser.addPropertyChangeListener(this);
        yearChooser.addPropertyChangeListener(this);
        add(monthYearPanel, BorderLayout.NORTH);

        // Set the initialized flag before setting the calendar. This will
        // cause the other components to be updated properly.
        if (date != null) {
            calendar.setTime(date);
        }

        initialized = true;
        setCalendar(calendar);
    }

    /**
     * JCalendar constructor with month spinner parameter.
     *
     * @param date the date
     * @param locale the locale
     * @param monthSpinner false, if no month spinner should be used
     * @param weekOfYearVisible true, if weeks of year shall be visible
     */
    public JCalendar(Date date, Locale locale, boolean monthSpinner,
            boolean weekOfYearVisible, JTable tblCalendar_Month, JTextField txtTarget) {
        // needed for setFont() etc.
        this._tblCalendar_Month = tblCalendar_Month;
        _txtTarget = txtTarget;

        monthChooser = null;
        yearChooser = null;
        this.weekOfYearVisible = weekOfYearVisible;

        this.locale = locale;

        if (locale == null) {
            this.locale = Locale.getDefault();
        }

        calendar = Calendar.getInstance();

        setLayout(new BorderLayout());
        monthYearPanel = new JPanel();
        monthYearPanel.setLayout(new BorderLayout());

        monthChooser = new JMonthChooser(monthSpinner);
        yearChooser = new JYearChooser();
        monthChooser.setYearChooser(yearChooser);
        monthYearPanel.add(monthChooser, BorderLayout.WEST);
        monthYearPanel.add(yearChooser, BorderLayout.CENTER);
        monthYearPanel.setBorder(BorderFactory.createEmptyBorder());

        monthChooser.addPropertyChangeListener(this);
        yearChooser.addPropertyChangeListener(this);
        add(monthYearPanel, BorderLayout.NORTH);

        // Set the initialized flag before setting the calendar. This will
        // cause the other components to be updated properly.
        if (date != null) {
            calendar.setTime(date);
        }

        initialized = true;
        setCalendar(calendar);
    }

    public JCalendar(Date date, Locale locale, boolean monthSpinner,
            boolean weekOfYearVisible, JTable tblCalendar_Month, JTextField txtTarget, JTextField txtTotal, JTextField txtBalance) {
        // needed for setFont() etc.
        this._tblCalendar_Month = tblCalendar_Month;
        _txtTarget = txtTarget;
        _txtTotal = txtTotal;
        _txtBalance = txtBalance;
        
        monthChooser = null;
        yearChooser = null;
        this.weekOfYearVisible = weekOfYearVisible;

        this.locale = locale;

        if (locale == null) {
            this.locale = Locale.getDefault();
        }

        calendar = Calendar.getInstance();

        setLayout(new BorderLayout());
        monthYearPanel = new JPanel();
        monthYearPanel.setLayout(new BorderLayout());

        monthChooser = new JMonthChooser(monthSpinner);
        yearChooser = new JYearChooser();
        monthChooser.setYearChooser(yearChooser);
        monthYearPanel.add(monthChooser, BorderLayout.WEST);
        monthYearPanel.add(yearChooser, BorderLayout.CENTER);
        monthYearPanel.setBorder(BorderFactory.createEmptyBorder());

        monthChooser.addPropertyChangeListener(this);
        yearChooser.addPropertyChangeListener(this);
        add(monthYearPanel, BorderLayout.NORTH);

        // Set the initialized flag before setting the calendar. This will
        // cause the other components to be updated properly.
        if (date != null) {
            calendar.setTime(date);
        }

        initialized = true;
        setCalendar(calendar);
    }
    /**
     * Creates a JFrame with a JCalendar inside and can be used for testing.
     *
     * @param s The command line arguments
     */
    /**
     * Returns the calendar property.
     *
     * @return the value of the calendar property.
     */
    public Calendar getCalendar() {
        return calendar;
    }

    /**
     * Returns the locale.
     *
     * @return the value of the locale property.
     *
     * @see #setLocale
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * Gets the monthChooser attribute of the JCalendar object
     *
     * @return the monthChooser value
     */
    public JMonthChooser getMonthChooser() {
        return monthChooser;
    }

    /**
     * Returns "JCalendar".
     *
     * @return "JCalendar"
     */
    public String getName() {
        return "JCalendar";
    }

    /**
     * Gets the yearChooser attribute of the JCalendar object
     *
     * @return the yearChooser value
     */
    public JYearChooser getYearChooser() {
        return yearChooser;
    }

    public void LoadTarget(int month, int year) {
        ArrayList<Targets> lstItem = TargetsRepository.selectByMonthAndYear(month, year);
        if (lstItem.size() > 0) {
            _txtTarget.setText(String.valueOf(lstItem.get(0).getTarget()));
        } else {
            _txtTarget.setText("0");
        }
    }

    public void CalBalance() {
        long total = Long.parseLong(_txtTotal.getText());
        long target = Long.parseLong(_txtTarget.getText());
        _txtBalance.setText(String.valueOf(total - target));
    }
    
    /**
     * JCalendar is a PropertyChangeListener, for its day, month and year
     * chooser.
     *
     * @param evt the property change event
     */
    public void propertyChange(PropertyChangeEvent evt) {
        if (calendar != null) {
            Calendar c = (Calendar) calendar.clone();
            if (evt.getPropertyName().equals("month")) {
                c.set(Calendar.MONTH, ((Integer) evt.getNewValue()).intValue());
                setCalendar(c, false);
                Calendar cal = (Calendar) calendar.clone();

                if (_txtTarget != null) {
                    LoadTarget(getMonthChooser().getMonth() + 1, getYearChooser().getYear());
                }

                if (getCheckMode() == eTableMode.SCHEDULING) {
                    ProcessThread processDlg;
                    processDlg = new ProcessThread(_tblCalendar_Month, cal, "Please wailt");
                    //processDlg.setLocationRelativeTo(this);
                    processDlg.startReloadScheduling();
                    //MonthCalendar.TableMonthTask.disableDayNotBelongMonth(_tblCalendar_Month, cal);
                } else if (getCheckMode() == eTableMode.REPORT) {
                    ArrayList<Orders> lstItem = OrdersRepository.selectByMonthAndYear(getMonthChooser().getMonth() + 1, getYearChooser().getYear());
                    TableReportOders.loadDataIntoTableBook(_tblCalendar_Month, lstItem, _txtTotal);
                }
            } else if (evt.getPropertyName().equals("year")) {
                c.set(Calendar.YEAR, ((Integer) evt.getNewValue()).intValue());
                setCalendar(c, false);
                Calendar cal = (Calendar) calendar.clone();

                if (_txtTarget != null) {
                    LoadTarget(cal.getTime().getMonth(), cal.getTime().getYear());
                }

                if (getCheckMode() == eTableMode.SCHEDULING) {
                    ProcessThread processDlg;
                    processDlg = new ProcessThread(_tblCalendar_Month, cal, "Please wailt");
                    //processDlg.setLocationRelativeTo(this);
                    processDlg.startReloadScheduling();
                    //MonthCalendar.TableMonthTask.disableDayNotBelongMonth(_tblCalendar_Month, cal);
                } else if (getCheckMode() == eTableMode.REPORT) {
                    ArrayList<Orders> lstItem = OrdersRepository.selectByMonthAndYear(getMonthChooser().getMonth() + 1, getYearChooser().getYear());
                    TableReportOders.loadDataIntoTableBook(_tblCalendar_Month, lstItem, _txtTotal);
                }
            } else if (evt.getPropertyName().equals("date")) {
                c.setTime((Date) evt.getNewValue());
                setCalendar(c, true);
            }
            CalBalance();
        }
    }

    /**
     * Sets the background color.
     *
     * @param bg the new background
     */
    public void setBackground(Color bg) {
        super.setBackground(bg);
    }

    /**
     * Sets the calendar property. This is a bound property.
     *
     * @param c the new calendar
     *
     * @see #getCalendar
     */
    public void setCalendar(Calendar c) {
        setCalendar(c, true);
    }

    /**
     * Sets the calendar attribute of the JCalendar object
     *
     * @param c the new calendar value
     * @param update the new calendar value
     */
    private void setCalendar(Calendar c, boolean update) {
        Calendar oldCalendar = calendar;
        calendar = c;

        if (update) {
            // Thanks to Jeff Ulmer for correcting a bug in the sequence :)
            yearChooser.setYear(c.get(Calendar.YEAR));
            monthChooser.setMonth(c.get(Calendar.MONTH));
        }

        firePropertyChange("calendar", oldCalendar, calendar);
    }

    /**
     * Enable or disable the JCalendar.
     *
     * @param enabled the new enabled value
     */
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
    }

    /**
     * Returns true, if enabled.
     *
     * @return true, if enabled.
     */
    public boolean isEnabled() {
        return super.isEnabled();
    }

    /**
     * Sets the font property.
     *
     * @param font the new font
     */
    public void setFont(Font font) {
        super.setFont(font);
    }

    /**
     * Sets the foreground color.
     *
     * @param fg the new foreground
     */
    public void setForeground(Color fg) {
        super.setForeground(fg);
    }

    /**
     * Sets the locale property. This is a bound property.
     *
     * @param l the new locale value
     *
     * @see #getLocale
     */
    public void setLocale(Locale l) {
        if (!initialized) {
            super.setLocale(l);
        } else {
            Locale oldLocale = locale;
            locale = l;
            monthChooser.setLocale(locale);
            firePropertyChange("locale", oldLocale, locale);
        }
    }

    /**
     * Sets the week of year visible.
     *
     * @param weekOfYearVisible true, if weeks of year shall be visible
     */
    public void setWeekOfYearVisible(boolean weekOfYearVisible) {
        setLocale(locale); // hack for doing complete new layout :)
    }

    /**
     * Sets the decoration background visible.
     *
     * @param decorationBackgroundVisible true, if the decoration background
     *        should be visible.
     */
    public void setDecorationBackgroundVisible(
            boolean decorationBackgroundVisible) {
        setLocale(locale); // hack for doing complete new layout :)
    }

    /**
     * Sets the decoration borders visible.
     *
     * @param decorationBordersVisible true, if the decoration borders should
     *        be visible.
     */
    public void setDecorationBordersVisible(boolean decorationBordersVisible) {
        setLocale(locale); // hack for doing complete new layout :)
    }

    /**
     * Returns a Date object.
     *
     * @return a date object constructed from the calendar property.
     */
    public Date getDate() {
        return new Date(calendar.getTimeInMillis());
    }

    /**
     * Sets the date. Fires the property change "date".
     *
     * @param date the new date.
     */
    public void setDate(Date date) {
        Date oldDate = calendar.getTime();
        calendar.setTime(date);

        yearChooser.setYear(calendar.get(Calendar.YEAR));
        monthChooser.setMonth(calendar.get(Calendar.MONTH));

        firePropertyChange("date", oldDate, date);
    }
}
