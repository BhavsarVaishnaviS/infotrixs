package Employee_Payroll_System;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class g_payslip extends JFrame implements ActionListener {

    JButton b1;
    JLabel l1, l2, l3, l4, l5, l6;
    JTextArea ta;
    Choice ch;
    Font f;
    JPanel p1;

    g_payslip() {
        super("Generate Pay Slip");
        setSize(500, 500);
        setLocation(100, 100);
        setResizable(false);

        f = new Font("arial", Font.BOLD, 16);

        l1 = new JLabel("Employee Id");
        ch = new Choice();

        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "select * from new_employee";
            ResultSet r = obj.str.executeQuery(q);
            while (r.next()) {
                ch.add(r.getString("id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        b1 = new JButton("Print");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setFont(f);

        ta = new JTextArea();
        JScrollPane sp = new JScrollPane(ta);
        ta.setEditable(false);
        ta.setFont(f);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 3, 10, 10));
        p1.add(l1);
        p1.add(ch);
        p1.add(b1);
        setLayout(new BorderLayout());
        add(sp, BorderLayout.CENTER);
        add(p1, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            ta.setText("-----------Pay Slip----------");
            ConnectionClass obj = new ConnectionClass();
            try {
                int id = Integer.parseInt(ch.getSelectedItem());
                String q = "SELECT * FROM new_employee where id='" + id + "'";
                ResultSet r = obj.str.executeQuery(q);
                while (r.next()) {
                    ta.append("\n\nEmployee Id : " + Integer.parseInt(r.getString("id")));
                    ta.append("\nEmployee Name : " + r.getString("name"));
                    ta.append("\n-------------------------------\n\n");
                }
                String q2 = "select * from salary where id = '" + id + "'";
                ResultSet r1 = obj.str.executeQuery(q2);
                while (r1.next()) {
                    ta.append("\nHRA : " + Float.parseFloat(r1.getString("hra")));
                    ta.append("\nDA : " + Float.parseFloat(r1.getString("da")));
                    ta.append("\nMED : " + Float.parseFloat(r1.getString("mid")));
                    ta.append("\nPF : " + Float.parseFloat(r1.getString("pf")));
                    ta.append("\nBasic Salary : " + Float.parseFloat(r1.getString("basic_salary")));
                    ta.append("\n--------------------------------\n\n");
                    float gross_salary = Float.parseFloat(r1.getString("hra")) + Float.parseFloat(r1.getString("da"))
                            + Float.parseFloat(r1.getString("mid")) + Float.parseFloat(r1.getString("pf"))
                            + Float.parseFloat(r1.getString("basic_salary"));
                    double tax = (gross_salary * 2.1) / 100;
                    ta.append("\nGross Salary : " + gross_salary);
                    ta.append("\nTotal : " + gross_salary);
                    ta.append("\nTax 2.1% of salary : " + tax);
                }
            } catch (Exception exx) {
                exx.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            g_payslip frame = new g_payslip(); 
            frame.setVisible(true);
        });
    }
}
