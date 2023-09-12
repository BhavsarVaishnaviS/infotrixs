package Employee_Payroll_System;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class l_attendance extends JFrame implements ActionListener {

    JTable t;
    JButton b1;
    String x[] = { "Employee Id", "First Half", "Second Half", "Date" };
    String y[][] = new String[20][4];
    int i = 0, j = 0;
    Font f;

    l_attendance() {
        super("Attendance List");
        setSize(750, 500);
        setLocation(200, 70);
        setResizable(false);

        f = new Font("arial", Font.BOLD, 16);

        try {
        		ConnectionClass obj = new ConnectionClass();
                String q = "SELECT * FROM t_attendance"; 
                ResultSet r = obj.str.executeQuery(q);
            while (r.next()) {
                y[i][j++] = r.getString("id"); 
                y[i][j++] = r.getString("first_half"); 
                y[i][j++] = r.getString("second_half"); 
                y[i][j++] = r.getString("date"); 
                i++;
                j = 0;
            }
            t = new JTable(y, x);
            t.setFont(f);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        JScrollPane js = new JScrollPane(t);
        add(js, BorderLayout.CENTER); 
        b1 = new JButton("Print");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(f);
        b1.addActionListener(this);
        add(b1, BorderLayout.SOUTH); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                t.print();
            } catch (Exception exx) {
                exx.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            l_attendance frame = new l_attendance();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
