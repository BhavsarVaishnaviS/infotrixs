package Employee_Payroll_System;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class update_employee extends JFrame implements ActionListener {

    // Declare your variables
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;
    Choice ch1, ch2;
    JButton b1, b2;
    JPanel p1;
    Font f;

    update_employee() {
        super("Update Employee");
        setSize(740, 447);
        setLocation(200, 70);
        setResizable(false);

        f = new Font("arial", Font.BOLD, 16);
        l1 = new JLabel("Employee_ID");
        l2 = new JLabel("Name");
        l3 = new JLabel("Contact_No");
        l4 = new JLabel("Email");
        l5 = new JLabel("Qualification");
        l6 = new JLabel("Age");
        l7 = new JLabel("Gender");
        l8 = new JLabel("State");
        l9 = new JLabel("City");
        l11 = new JLabel("Department");
        l10 = new JLabel("Position");

        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);
        l4.setFont(f);
        l5.setFont(f);
        l6.setFont(f);
        l7.setFont(f);
        l8.setFont(f);
        l9.setFont(f);
        l10.setFont(f);
        l11.setFont(f);
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        t8 = new JTextField();
        t9 = new JTextField();
        t10 = new JTextField();

        t1.setFont(f);
        t2.setFont(f);
        t3.setFont(f);
        t4.setFont(f);
        t5.setFont(f);
        t6.setFont(f);
        t7.setFont(f);
        t8.setFont(f);
        t9.setFont(f);
        t10.setFont(f);

        ch1 = new Choice();
        ch1.add("Male");
        ch1.add("Female");
        ch1.setFont(f);

        ch2 = new Choice();
        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "SELECT id FROM new_employee";
            ResultSet r = obj.str.executeQuery(q);
            while (r.next()) {
                ch2.add(r.getString("id"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ch2.setFont(f);

        b1 = new JButton("Submit");
        b2 = new JButton("Close");
        b1.setFont(f);
        b2.setFont(f);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b2.addActionListener(this);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(12, 2, 8, 8));
        p1.add(l1);
        p1.add(ch2); // Change to the choice component for selecting the Employee ID
        p1.add(l2);
        p1.add(t2);
        p1.add(l3);
        p1.add(t3);
        p1.add(l4);
        p1.add(t4);
        p1.add(l5);
        p1.add(t5);
        p1.add(l6);
        p1.add(t6);
        p1.add(l7);
        p1.add(ch1); // Change to the choice component for selecting Gender
        p1.add(l8);
        p1.add(t7);
        p1.add(l9);
        p1.add(t8);
        p1.add(l11);
        p1.add(t9);
        p1.add(l10);
        p1.add(t10);
        p1.add(b1);
        p1.add(b2);

        setLayout(new BorderLayout(30, 30));
        add(p1, BorderLayout.CENTER);

        try {
            int id = Integer.parseInt(ch2.getSelectedItem());
            ConnectionClass obj1 = new ConnectionClass();
            String q1 = "SELECT * FROM new_employee WHERE id='" + id + "'";
            ResultSet r1 = obj1.str.executeQuery(q1);
            while (r1.next()) {
                t2.setText(r1.getString("Name"));
                t3.setText(String.valueOf(r1.getFloat("Contact_No")));
                t4.setText(r1.getString("Email"));
                t5.setText(r1.getString("Qualification"));
                t6.setText(r1.getString("Age"));
                ch1.select(r1.getString("Gender")); // Set the gender using choice.select()
                t7.setText(r1.getString("State"));
                t8.setText(r1.getString("City"));
                t9.setText(r1.getString("Department"));
                t10.setText(r1.getString("Position"));
            }

        } catch (Exception exx) {
            exx.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            int id = Integer.parseInt(ch2.getSelectedItem());
            String name = t2.getText();
            float contact_no = Float.parseFloat(t3.getText()); // Convert to float
            String email = t4.getText();
            String Qualification = t5.getText();
            String Age = t6.getText();
            String Gender = ch1.getSelectedItem();
            String State = t7.getText();
            String City = t8.getText();
            String position = t10.getText();
            String department = t9.getText();

            
            if (contact_no < 1000000000 || contact_no > 9999999999L) {
                JOptionPane.showMessageDialog(this, "Invalid contact number. Please enter a 10-digit numeric value.");
                return; 
            }
            
            String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9+.-]+$";
            if (!email.matches(emailRegex)) {
                JOptionPane.showMessageDialog(this, "Invalid email address. Please enter a valid email.");
                return;
            }

            try {
                ConnectionClass obj = new ConnectionClass();
                String q = "UPDATE new_employee SET Name='" + name + "', Contact_No ='" + contact_no + "', Email='" + email + "', Qualification='" + Qualification + "', Age='" + Age + "', Gender='" + Gender + "', State='" + State + "', City='" + City + "', position='" + position + "', department='" + department + "' WHERE id=" + id;
                obj.str.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Successfully updated");
                setVisible(false);
                setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == b2) {
            JOptionPane.showMessageDialog(null, "Are you sure?");
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new update_employee().setVisible(true);
    }
}
