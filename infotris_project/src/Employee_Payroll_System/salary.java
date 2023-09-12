package Employee_Payroll_System;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class salary extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7;
    JTextField t1, t2, t3, t4, t5, t6;
    Choice ch1;
    JButton b1, b2;
    Font f;
    JPanel p1;

    salary() {
        super("Add Salary Details");
        setSize(750, 500);
        setLocation(200, 70);
        setResizable(false);

        f = new Font("arial", Font.BOLD, 16);
        l1 = new JLabel("Select ID");
        l2 = new JLabel("HRA");
        l3 = new JLabel("DA");
        l4 = new JLabel("MID");
        l5 = new JLabel("PF");
        l6 = new JLabel("Basic Salary");

        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);
        l4.setFont(f);
        l5.setFont(f);
        l6.setFont(f);

        ch1 = new Choice();
        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "SELECT id FROM new_employee";
            ResultSet r = obj.str.executeQuery(q);
            while (r.next()) {
                ch1.add(r.getString("id"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ch1.setFont(f);

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();

        t1.setFont(f);
        t2.setFont(f);
        t3.setFont(f);
        t4.setFont(f);
        t5.setFont(f);
        t6.setFont(f);

        b1 = new JButton("Submit");
        b2 = new JButton("Close");
        b1.setFont(f);
        b2.setFont(f);
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);

        b1.addActionListener(this);
        b2.addActionListener(this);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(7, 2, 10, 10));
        p1.add(l1);
        p1.add(ch1);
        p1.add(l2);
        p1.add(t1);
        p1.add(l3);
        p1.add(t2);
        p1.add(l4);
        p1.add(t3);
        p1.add(l5);
        p1.add(t4);
        p1.add(l6);
        p1.add(t5);
        p1.add(b1);
        p1.add(b2);

        setLayout(new BorderLayout(30, 30));
        add(p1, BorderLayout.CENTER);
    }
    @Override
    


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            int id = Integer.parseInt(ch1.getSelectedItem());
            float hra = Float.parseFloat(t1.getText());
            float da = Float.parseFloat(t2.getText());
            float mid = Float.parseFloat(t3.getText());
            float pf = Float.parseFloat(t4.getText());
            float basic = Float.parseFloat(t5.getText());
            try {
                ConnectionClass obj1 = new ConnectionClass();
                String q1 = "INSERT INTO salary (id, hra, da, mid, pf, basic_salary) VALUES ('" + id + "','" + hra + "','" + da + "','" + mid + "','" + pf + "','" + basic + "')";
                obj1.str.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Data added successfully ");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == b2) {
            int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to close this window?", "Confirm Close", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                setVisible(false);
            }
        }
    }

    public static void main(String[] args) {
        new salary().setVisible(true);
    }
}
