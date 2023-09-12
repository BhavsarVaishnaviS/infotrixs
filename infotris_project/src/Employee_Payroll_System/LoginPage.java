package Employee_Payroll_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginPage extends JFrame implements ActionListener {

    private JLabel l1, l2;
    private JButton b1, b2;
    private JTextField t1;
    private JPasswordField pf;
    private Font f;
    private JPanel p1,p2;

    public LoginPage() {
        super("Login Page");
        setSize(380, 180);
        setLocation(500, 200);
        setResizable(false);

        f = new Font("Arial", Font.BOLD, 16); 

        l1 = new JLabel("Username"); 
        l2 = new JLabel("Password");
        l1.setFont(f);
        l2.setFont(f);

        t1 = new JTextField();
        t1.setFont(f);

        pf = new JPasswordField(15);
        pf.setFont(f);

        b1 = new JButton("Login");
        b2 = new JButton("Cancel"); 
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b1.setFont(f);
        b2.setFont(f);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(3, 2, 8, 8));

        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(pf);
        p1.add(b1);

        JPanel p2 = new JPanel(); 
        p2.add(b2);
       
        
        getContentPane().add(p1, BorderLayout.CENTER);
        getContentPane().add(p2, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String u_name = t1.getText();
            String p_name = new String(pf.getPassword());

            try {
                ConnectionClass obj = new ConnectionClass();
                String q = "SELECT * FROM login WHERE username='" + u_name + "' AND password='" + p_name + "'";
                ResultSet r = obj.str.executeQuery(q);

                if (r.next()) {
                    new home_page().setVisible(true);
                    this.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Login successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }

                r.close(); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == b2) {
            int response = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                setVisible(false);
            }
        }
    }

    public static void main(String[] args) {
        new LoginPage().setVisible(true);
    }
}
