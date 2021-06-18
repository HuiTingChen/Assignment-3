package Assignment3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Admin extends JFrame{
	
	private Image img_admin = new ImageIcon(Home.class.getResource("adminicon.png")).getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	private Image img_ex = new ImageIcon(Home.class.getResource("exicon.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image img_password = new ImageIcon(Home.class.getResource("passwordicon.png")).getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH);
	private Image img_pr = new ImageIcon(Home.class.getResource("pricon.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image img_ps = new ImageIcon(Home.class.getResource("psicon.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image img_close = new ImageIcon(Home.class.getResource("closebtn.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JLabel lblLoginMessage = new JLabel("");
	
	private UserMain usermain;
	private STDetails stdetails;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		usermain = new UserMain();
		usermain.setLocation(0, 0);
		stdetails = new STDetails();
		stdetails.setLocation(0, 0);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(0, 0, 986, 563);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 102));
		panel_1.setBounds(0, 0, 986, 74);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chen Software Training Centre");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame = new JFrame();
				if (JOptionPane.showConfirmDialog(frame, "Are you confirm to exit", "Software Training Registration System", 
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 11, 966, 52);
		panel_1.add(lblNewLabel);
		
		JLabel lblclose = new JLabel("");
		lblclose.setHorizontalAlignment(SwingConstants.CENTER);
		lblclose.setBounds(955, 3, 30, 30);
		lblclose.setIcon(new ImageIcon(img_close));
		panel_1.add(lblclose);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(0, 0, 102));
		panel_1_1.setBounds(0, 489, 986, 74);
		panel.add(panel_1_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 85, 966, 395);
		panel.add(tabbedPane);
		
		JPanel userpanel = new JPanel();
		userpanel.setBackground(new Color(204, 255, 255));
		tabbedPane.addTab("User", null, userpanel, "for user use");
		userpanel.setLayout(null);
		
		JPanel panelMain = new JPanel();
		panelMain.setBackground(new Color(204, 255, 255));
		panelMain.setBounds(0, 0, 961, 367);
		userpanel.add(panelMain);
		panelMain.setLayout(null);
		
		panelMain.add(usermain);
		panelMain.add(stdetails);
		menuClicked(usermain);
		
		JPanel adminpanel = new JPanel();
		adminpanel.setBackground(new Color(204, 255, 255));
		adminpanel.setToolTipText("");
		tabbedPane.addTab("Admin", null, adminpanel, "for admin use only");
		adminpanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Login as Admin");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(286, 31, 394, 45);
		adminpanel.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(286, 87, 394, 55);
		adminpanel.add(panel_4);
		panel_4.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBorder(null);
		txtUsername.setBackground(new Color(255, 255, 255));
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(txtUsername.getText().equals("Username")) {
					txtUsername.setText(null);
				}
				else {
					txtUsername.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(txtUsername.getText().equals("")) 
					txtUsername.setText("Username");
			}
		});
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUsername.setText("Username");
		txtUsername.setBounds(77, 11, 311, 35);
		panel_4.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lbluser = new JLabel("");
		lbluser.setHorizontalAlignment(SwingConstants.CENTER);
		lbluser.setBounds(0, 0, 74, 55);
		lbluser.setIcon(new ImageIcon(img_admin));
		panel_4.add(lbluser);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(new Color(255, 255, 255));
		panel_4_1.setLayout(null);
		panel_4_1.setBounds(286, 153, 394, 55);
		adminpanel.add(panel_4_1);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBorder(null);
		pwdPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(pwdPassword.getText().equals("Password")) {
					pwdPassword.setEchoChar('●');
					pwdPassword.setText("");
				}
				else {
					pwdPassword.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(pwdPassword.getText().equals("")) {
					pwdPassword.setText("Password");
					pwdPassword.setEchoChar((char)0);
				}	
			}
		});
		pwdPassword.setEchoChar((char)0);
		pwdPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pwdPassword.setText("Password");
		pwdPassword.setBounds(77, 11, 311, 35);
		panel_4_1.add(pwdPassword);
		
		JLabel lblpassword = new JLabel("");
		lblpassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblpassword.setBounds(0, 0, 74, 55);
		lblpassword.setIcon(new ImageIcon(img_password));
		panel_4_1.add(lblpassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(135, 206, 250));
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserAccount ua = new UserAccount();
				DefaultTableModel model = (DefaultTableModel)ua.tableup.getModel();
				//int i = ua.tableup.getRowHeight();
				
				for (int i = 0 ; i < model.getRowCount() ; i++) {
			        // null or not Integer will throw exception
			        String uu = String.valueOf(model.getValueAt(i, 0));
			        String ss = String.valueOf(model.getValueAt(i, 1));
					
			    	
			     if (txtUsername.getText().equals(uu)|| pwdPassword.getText().equals(cc)) {
			    	 JOptionPane.showMessageDialog(null, "The account already exist.");
			     }
				
			   // else if (txtUsername.getText().equals("chen") && pwdPassword.getText().equals("123huiting")) {
				//	JOptionPane.showMessageDialog(null, "Login Successful.");
				//}
				
				else if (txtUsername.getText().equals("") || txtUsername.getText().equals("Username") ||
						pwdPassword.getText().equals("") || pwdPassword.getText().equals("Password")) {
					lblLoginMessage.setText("Please input username and password.");
				}
				else {
					lblLoginMessage.setText("Incorrect username and password!");
					JOptionPane.showMessageDialog(null, "Login Unsuccessful.");
				}
				}
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnLogin.setBackground(new Color(125, 205, 249));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnLogin.setBackground(new Color(135, 206, 250));
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnLogin.setBackground(new Color(145, 207, 251));
			}
		});
		
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnLogin.setToolTipText("");
		btnLogin.setBounds(286, 251, 394, 45);
		adminpanel.add(btnLogin);
		
		lblLoginMessage.setForeground(new Color(255, 0, 0));
		lblLoginMessage.setBounds(286, 215, 394, 25);
		adminpanel.add(lblLoginMessage);
		
	}
	public void menuClicked(JPanel panel) {
		usermain.setVisible(false);
		stdetails.setVisible(false);
		panel.setVisible(true);
	}
}
