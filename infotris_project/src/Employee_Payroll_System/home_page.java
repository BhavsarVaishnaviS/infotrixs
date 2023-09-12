package Employee_Payroll_System;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class home_page extends JFrame implements ActionListener {

    JLabel l1;
    JPanel p1;
    Font f; 

    home_page() {
        super("Employee Payroll System");
        setSize(1600, 690);

        f = new Font("Arial", Font.BOLD, 16);

        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Employee");
        JMenu m2 = new JMenu("Update");
        JMenu m3 = new JMenu("Attendance");
        JMenu m4 = new JMenu("Exit");

        m1.setFont(f);
        m2.setFont(f);
        m3.setFont(f);
        m4.setFont(f);

        JMenuItem mt1 = new JMenuItem("New Employee");
        ImageIcon img1 = new ImageIcon(home_page.class.getResource("/icon/icon1.jpg"));
        Image image = img1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(image);
        mt1.setIcon(img2);
        mt1.setMnemonic('Y');
        mt1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        mt1.addActionListener(this);

		
		JMenuItem mt2 = new JMenuItem("Salary");
		ImageIcon img3 = new ImageIcon(home_page.class.getResource("/icon/icon2.jpg"));		Image image1 = img3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		ImageIcon img4 = new ImageIcon(image1);
		mt2.setIcon(img4);
		mt2.setMnemonic('S');
		mt2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		mt2.addActionListener(this);
		
		JMenuItem mt3 = new JMenuItem("Employee List");
		ImageIcon img5 = new ImageIcon(home_page.class.getResource("/icon/icon3.jpg"));
		Image image2 = img5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		ImageIcon img6 = new ImageIcon(image);
		mt3.setIcon(img6);
		mt3.setMnemonic('I');
		mt3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
		mt3.addActionListener(this);
		
		JMenuItem mt4 = new JMenuItem("Update Employee");
		ImageIcon img7 = new ImageIcon(home_page.class.getResource("/icon/icon4.jpg"));
		Image image3 = img7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon img8 = new ImageIcon(image3);
		mt4.setIcon(img8);
		mt4.setMnemonic('E');
		mt4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		mt4.addActionListener(this);
		
		JMenuItem mt5 = new JMenuItem("Update Salary");
		ImageIcon img9 = new ImageIcon(home_page.class.getResource("/icon/icon5.jpg"));
		Image image4 = img9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon img10 = new ImageIcon(image4);
		mt5.setIcon(img10);
		mt5.setMnemonic('X');
		mt5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		mt5.addActionListener(this);
		
		JMenuItem mt6 = new JMenuItem("Take Attendance");
		ImageIcon img11 = new ImageIcon(home_page.class.getResource("/icon/icon6.jpg"));
		Image image5 = img11.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		ImageIcon img12 = new ImageIcon(image5);
		mt6.setIcon(img12);
		mt6.setMnemonic('A');
		mt6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		mt6.addActionListener(this);
		
		JMenuItem mt7 = new JMenuItem("List Attendance");
		ImageIcon img13 = new ImageIcon(home_page.class.getResource("/icon/icon7.jpg"));
		Image image6 = img13.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		ImageIcon img14 = new ImageIcon(image6);
		mt7.setIcon(img14);
		mt7.setMnemonic('L');
		mt7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
		mt7.addActionListener(this);
		
		JMenuItem mt8 = new JMenuItem("Generate Pay Slip");
		ImageIcon img15 = new ImageIcon(home_page.class.getResource("/icon/icon8.jpg"));
		Image image7 = img15.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		ImageIcon img16 = new ImageIcon(image7);
		mt8.setIcon(img16);
		mt8.setMnemonic('G');
		mt8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
		mt8.addActionListener(this);
		
		JMenuItem mt9 = new JMenuItem("Exit");
		ImageIcon img17 = new ImageIcon(home_page.class.getResource("/icon/icon9.jpg"));
		Image image8 = img17.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		ImageIcon img18 = new ImageIcon(image8);
		mt9.setIcon(img18);
		mt9.setMnemonic('Z');
		mt9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK));
		mt9.addActionListener(this);
		
		mt1.setFont(f);
		mt2.setFont(f);
		mt3.setFont(f);
		mt4.setFont(f);
		mt5.setFont(f);
		mt6.setFont(f);
		mt7.setFont(f);
		mt8.setFont(f);
		mt9.setFont(f);
		
		m1.add(mt1);
		m1.add(mt2);
		m1.add(mt3);

		m2.add(mt4);
		m2.add(mt5);
		
		m3.add(mt6);
		m3.add(mt7);
		m3.add(mt8);
		
		m4.add(mt9);
		
		mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        mb.add(m4);

        setJMenuBar(mb);
        
        JPanel p1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon img19 = new ImageIcon(home_page.class.getResource("/icon/ems.jpg"));
                g.drawImage(img19.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        setLayout(new BorderLayout());
        add(p1, BorderLayout.CENTER); 

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comnd = e.getActionCommand();
        if (comnd.equals("New Employee")) {
            new new_Employee().setVisible(true);
        } else if (comnd.equals("Salary")) {
            new salary().setVisible(true);
        } else if (comnd.equals("Employee List")) {
            new employee_list().setVisible(true);
        } else if (comnd.equals("Update Employee")) {
            new update_employee().setVisible(true);
        } else if (comnd.equals("Update Salary")) {
            new update_salary().setVisible(true);
        } else if (comnd.equals("Take Attendance")) {
            new t_attendance().setVisible(true);
        } else if (comnd.equals("List Attendance")) {
            new l_attendance().setVisible(true);
        } else if (comnd.equals("Generate Pay Slip")) {
            // You need to define the g_payslip class and its behavior
        } else if (comnd.equals("Exit")) {
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "Sorry you pressed the wrong button");
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        System.setProperty("sun.java2d.d3d", "false");

        SwingUtilities.invokeLater(() -> {
            new home_page().setVisible(true);
        });
    }
}