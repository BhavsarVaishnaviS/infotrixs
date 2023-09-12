package Employee_Payroll_System;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class employee_list extends JFrame implements ActionListener {

    JTable tb;
    DefaultTableModel model;
    JButton b1;
    Font f;

    employee_list() {
        super("Employee List");
        setSize(900, 400);
        setLocation(100, 100);
        setResizable(false);

        f = new Font("arial", Font.BOLD, 16);
        model = new DefaultTableModel();
        tb = new JTable(model);
        model.addColumn("id");
        model.addColumn("Name");
        model.addColumn("Contact_No");
        model.addColumn("Email");
        model.addColumn("Qualification");
        model.addColumn("Age");
        model.addColumn("Gender");
        model.addColumn("State");
        model.addColumn("City");
        model.addColumn("position");
        model.addColumn("department");

        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "SELECT * FROM new_employee";
            ResultSet r = obj.str.executeQuery(q);
            while (r.next()) {
                model.addRow(new Object[] { 
                    r.getString("id"),
                    r.getString("Name"),
                    r.getString("Contact_No"),
                    r.getString("Email"),
                    r.getString("Qualification"),
                    r.getString("Age"),
                    r.getString("Gender"),
                    r.getString("State"),
                    r.getString("City"),
                    r.getString("position"),
                    r.getString("department") 
                });
            }
            tb.setFont(f);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        b1 = new JButton("Print");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(f);
        b1.addActionListener(this);

        JScrollPane js = new JScrollPane(tb); 
        add(js, BorderLayout.CENTER); 
        add(b1, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                tb.print();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            employee_list frame = new employee_list();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
