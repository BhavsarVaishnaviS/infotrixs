package Employee_Payroll_System;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class t_attendance extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4;
    JButton b1,b2;
    Choice ch1, ch2, ch3;
    Font f;
    JPanel p1;

    t_attendance() {
        super("Take Attendance");
        setSize(500, 300); 
        setLocation(100, 100);
        setResizable(false);

        f = new Font("Arial", Font.BOLD, 16);

        l1 = new JLabel("First Half");
        l2 = new JLabel("Second Half");
        l3 = new JLabel("Employee ID");

        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);

        ch1 = new Choice();
        ch1.add("Present");
        ch1.add("Absent");

        ch1.setFont(f);

        ch2 = new Choice();
        ch2.add("Present");
        ch2.add("Absent");

        ch2.setFont(f);

        ch3 = new Choice();
        try {
            ConnectionClass obj = new ConnectionClass();
            String q1 = "select id from new_employee";
            ResultSet r1 = obj.str.executeQuery(q1);
            while (r1.next()) {
                ch3.add(r1.getString("id"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ch3.setFont(f);

        b1 = new JButton("Submit");
        b2 = new JButton("Close");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(f);
        b1.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(f);
        b2.addActionListener(this);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 3, 15, 15));
        p1.add(l3);
        p1.add(ch3);
        p1.add(l1);
        p1.add(ch1);
        p1.add(l2);
        p1.add(ch2);
        p1.add(b1);
        p1.add(b2);

        setLayout(new BorderLayout(30, 30));
        add(p1, "Center");
    }

   

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                int id = Integer.parseInt(ch3.getSelectedItem());
                String first_half = ch1.getSelectedItem();
                String second_half = ch2.getSelectedItem();
                
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                String dt = timestamp.toString();
                
                ConnectionClass obj1 = new ConnectionClass();
                String q = "insert into t_attendance values('" + id + "','" + first_half + "','" + second_half + "','" + dt + "')";
                obj1.str.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Record inserted successfully");
                setVisible(false);

            } catch (Exception exx) {
                exx.printStackTrace();
            }
        }
        if(e.getSource()==b2) {
            JOptionPane.showMessageDialog(null, "Are you sure?");
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            t_attendance frame = new t_attendance();
            frame.setVisible(true); 
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
