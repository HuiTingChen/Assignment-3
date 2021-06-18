package Assignment3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Window;

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

import javax.swing.JLayeredPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Home extends JFrame implements PaymentF{
	
	private Image img_admin = new ImageIcon(Home.class.getResource("adminicon.png")).getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	private Image img_password = new ImageIcon(Home.class.getResource("passwordicon.png")).getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH);
	private Image img_close = new ImageIcon(Home.class.getResource("closebtn.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image img_return = new ImageIcon(Home.class.getResource("return.png")).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
	private Image img_show = new ImageIcon(Home.class.getResource("show.png")).getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH);
	private Image img_hide = new ImageIcon(Home.class.getResource("hide.png")).getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH);
	private Image img_soft = new ImageIcon(Home.class.getResource("soft.png")).getImage().getScaledInstance(610,520,Image.SCALE_SMOOTH);

	public JFrame frame;
	private JTextField usernA;
	private JPasswordField pwdPassword;
	private JLabel lblLoginMessageA = new JLabel("");
	private JLayeredPane layeredPane;
	private JPanel usermain;
	private JPanel stdetails;
	private JPanel Selection1;
	private JPanel Selection2;
	private JPanel Selection3;
	private JPanel makeSelection;
	private JScrollPane Selection4;
	private JScrollPane Selection5;
	private JPanel wel;
	private JRadioButton lblshow;
	private JPanel s5;
	private JPanel loginsignup;
	private JTextField usernS;
	private JPasswordField passwordS1;
	private JTextField usernL;
	private JPasswordField passwordL;
	private JPanel panellogin;
	private JPanel panelsignup;
	private JPasswordField passwordS2;
	private JLabel lblLoginMessageS;
	private JRadioButton lblshowS2;
	private JRadioButton lblshowL;
	private JButton userLogin;
	private JLabel lblLoginMessageL;
	private JRadioButton lblshowS1;
	private JButton sltSignup;
	private JButton sltLogin;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel adminpanel;

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
	public Home() {
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
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 11, 966, 52);
		panel_1.add(lblNewLabel);
		
		JLabel lblclose = new JLabel("");
		lblclose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame = new JFrame();
				if (JOptionPane.showConfirmDialog(frame, "Are you confirm to exit", "Software Training Registration System", 
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		lblclose.setHorizontalAlignment(SwingConstants.CENTER);
		lblclose.setBounds(955, 3, 30, 30);
		lblclose.setIcon(new ImageIcon(img_close));
		panel_1.add(lblclose);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 85, 966, 467);
		panel.add(tabbedPane);
		
		JPanel userpanel = new JPanel();
		userpanel.setBackground(new Color(204, 255, 255));
		tabbedPane.addTab("User", null, userpanel, "for user use");
		userpanel.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 961, 439);
		userpanel.add(layeredPane);
		
		usermain = new JPanel();
		usermain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				wel.setVisible(true);
			}
		});
		
		usermain.setBackground(new Color(204, 255, 255));
		usermain.setBounds(0, 0, 961, 439);
		layeredPane.add(usermain);
		usermain.setLayout(null);
		
		JLabel lblsoft = new JLabel("");
		lblsoft.setHorizontalAlignment(SwingConstants.CENTER);
		lblsoft.setBounds(493, 130, 600, 450);
		lblsoft.setIcon(new ImageIcon(img_soft));
		usermain.add(lblsoft);
		
		wel = new JPanel();
		wel.setLayout(null);
		wel.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		wel.setBackground(Color.WHITE);
		wel.setBounds(30, 25, 695, 389);
		usermain.add(wel);
		
		JTextArea txtrwelcomeToChen = new JTextArea();
		txtrwelcomeToChen.setText(" _________Welcome to Chen Software Training Centre_________\r\n");
		txtrwelcomeToChen.setFont(new Font("Calibri", Font.BOLD, 23));
		txtrwelcomeToChen.setBounds(27, 22, 639, 27);
		wel.add(txtrwelcomeToChen);
		
		JTextArea txtrContactNoThere = new JTextArea();
		txtrContactNoThere.setText("\t\t                  Contact No:+604-5986302          ");
		txtrContactNoThere.setFont(new Font("Calibri", Font.PLAIN, 13));
		txtrContactNoThere.setBounds(27, 49, 639, 21);
		wel.add(txtrContactNoThere);
		
		JTextArea txtrThereAre = new JTextArea();
		txtrThereAre.setText(" There are 3 types of Software Training available at this moment.\r\n Select one of the packages:\r\n 1 - Excel\r\n 2 - Adobe Photoshop\r\n 3 - Adobe Premiere Pro\r\n 4 - Adobe Photoshop & Premiere Pro\r\n 5 - All 3 types \r\n");
		txtrThereAre.setFont(new Font("Calibri", Font.PLAIN, 17));
		txtrThereAre.setBounds(27, 85, 639, 153);
		wel.add(txtrThereAre);
		
		JTextArea txtrYouWillGet = new JTextArea();
		txtrYouWillGet.setText(" You will get 5.0% discount if you join all 3 of the software training.\r\n");
		txtrYouWillGet.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtrYouWillGet.setBounds(27, 263, 639, 21);
		wel.add(txtrYouWillGet);
		
		JTextArea txtrforMoreInformation = new JTextArea();
		txtrforMoreInformation.setText("\r\n *For more information and reference please visit \r\n  -https://www.facebook.com\r\n  -https://www.instagram.com\r\n");
		txtrforMoreInformation.setFont(new Font("Calibri", Font.PLAIN, 13));
		txtrforMoreInformation.setBounds(27, 277, 639, 70);
		wel.add(txtrforMoreInformation);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(null);
		panel_2_1.setBackground(new Color(25, 25, 112));
		panel_2_1.setBounds(23, 20, 695, 389);
		usermain.add(panel_2_1);
		
		JButton btnNewButton = new JButton("More");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_screen(stdetails);
				makeSelection.setVisible(true);
				Selection2.setVisible(false);
				Selection3.setVisible(false);
				Selection4.setVisible(false);
				Selection5.setVisible(false);
				Selection1.setVisible(false);
				
			}
		});
		btnNewButton.setToolTipText("Show more details");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(51, 51, 204));
		btnNewButton.setBounds(772, 83, 145, 46);
		usermain.add(btnNewButton);
		
		JButton btnRegis = new JButton("Register");
		btnRegis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Switch_screen(loginsignup);
			}
		});
		btnRegis.setToolTipText("Log in or Sign up");
		btnRegis.setForeground(Color.WHITE);
		btnRegis.setFont(new Font("Dialog", Font.BOLD, 20));
		btnRegis.setBackground(new Color(51, 51, 204));
		btnRegis.setBounds(772, 26, 145, 46);
		usermain.add(btnRegis);
		
		stdetails = new JPanel();
		stdetails.setBackground(new Color(204, 255, 255));
		stdetails.setBounds(0, 0, 961, 439);
		layeredPane.add(stdetails);
		stdetails.setLayout(null);
		
		makeSelection = new JPanel();
		makeSelection.setLayout(null);
		makeSelection.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		makeSelection.setBackground(Color.WHITE);
		makeSelection.setBounds(30, 25, 695, 389);
		stdetails.add(makeSelection);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.GRAY);
		separator_1.setBounds(27, 55, 639, 1);
		makeSelection.add(separator_1);
		
		JTextArea txtrThereAre_1 = new JTextArea();
		txtrThereAre_1.setText(" Please select the package that you wish to know better.\r\n");
		txtrThereAre_1.setFont(new Font("Calibri", Font.BOLD, 25));
		txtrThereAre_1.setBounds(27, 22, 639, 35);
		makeSelection.add(txtrThereAre_1);
		
		JTextArea txtrThereAre_1_1 = new JTextArea();
		txtrThereAre_1_1.setText(" There are 3 types of Software Training available at this moment.\r\n Select one of the packages:\r\n 1 - Excel\r\n 2 - Adobe Photoshop\r\n 3 - Adobe Premiere Pro\r\n 4 - Adobe Photoshop & Premiere Pro\r\n 5 - All 3 types \r\n");
		txtrThereAre_1_1.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtrThereAre_1_1.setBounds(27, 79, 639, 153);
		makeSelection.add(txtrThereAre_1_1);
		
		JTextArea txtrYouWillGet_1 = new JTextArea();
		txtrYouWillGet_1.setText(" You will get 5.0% discount if you join all 3 of the software training.\r\n");
		txtrYouWillGet_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtrYouWillGet_1.setBounds(27, 260, 639, 21);
		makeSelection.add(txtrYouWillGet_1);
		
		JTextArea txtrforMoreInformation_1 = new JTextArea();
		txtrforMoreInformation_1.setText("\r\n *For more information and reference please visit \r\n  -https://www.facebook.com\r\n  -https://www.instagram.com\r\n");
		txtrforMoreInformation_1.setFont(new Font("Calibri", Font.PLAIN, 13));
		txtrforMoreInformation_1.setBounds(27, 274, 639, 70);
		makeSelection.add(txtrforMoreInformation_1);
		
		Selection1 = new JPanel();
		Selection1.setLayout(null);
		Selection1.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		Selection1.setBackground(Color.WHITE);
		Selection1.setBounds(30, 25, 695, 389);
		stdetails.add(Selection1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.GRAY);
		separator.setBounds(27, 55, 639, 1);
		Selection1.add(separator);
		
		JTextArea txtrThereAre_1_2 = new JTextArea();
		txtrThereAre_1_2.setText("Excel\r\n");
		txtrThereAre_1_2.setFont(new Font("Calibri", Font.BOLD, 30));
		txtrThereAre_1_2.setBounds(27, 22, 639, 35);
		Selection1.add(txtrThereAre_1_2);
		
		JTextArea txtrThereAre_1_1_1 = new JTextArea();
		txtrThereAre_1_1_1.setText(" This is a 2 day training (3 hours per day).\r\n The participant will be able to learn:\r\n - the tutorial on how to use Excel\r\n - calculate finance report \r\n\r\n Conduct by               : Ahmad");
		txtrThereAre_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtrThereAre_1_1_1.setBounds(27, 79, 639, 153);
		Selection1.add(txtrThereAre_1_1_1);
		
		JTextArea txtDisplaytotal1 = new JTextArea();
		txtDisplaytotal1.setToolTipText("");
		txtDisplaytotal1.setFont(new Font("Calibri", Font.BOLD, 20));
		txtDisplaytotal1.setBounds(27, 233, 639, 47);
		Selection1.add(txtDisplaytotal1);
		
		Selection2 = new JPanel();
		Selection2.setLayout(null);
		Selection2.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		Selection2.setBackground(Color.WHITE);
		Selection2.setBounds(30, 25, 695, 389);
		stdetails.add(Selection2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.GRAY);
		separator_2.setBounds(27, 55, 639, 1);
		Selection2.add(separator_2);
		
		JTextArea txtrThereAre_1_2_1 = new JTextArea();
		txtrThereAre_1_2_1.setText(" Adobe Photoshop\r\n");
		txtrThereAre_1_2_1.setFont(new Font("Calibri", Font.BOLD, 30));
		txtrThereAre_1_2_1.setBounds(27, 22, 639, 35);
		Selection2.add(txtrThereAre_1_2_1);
		
		JTextArea txtrThereAre_1_1_1_1 = new JTextArea();
		txtrThereAre_1_1_1_1.setText(" This is a 6 days training (3 hours per day).\r\n The participant will be able to learn:\r\n - the tutorial of editing photo\r\n - designing poster\r\n\r\n Conduct by               : Jakson Lee");
		txtrThereAre_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtrThereAre_1_1_1_1.setBounds(27, 79, 639, 153);
		Selection2.add(txtrThereAre_1_1_1_1);
		
		JTextArea txtDisplaytotal2 = new JTextArea();
		txtDisplaytotal2.setToolTipText("");
		txtDisplaytotal2.setFont(new Font("Calibri", Font.BOLD, 20));
		txtDisplaytotal2.setBounds(27, 233, 639, 47);
		Selection2.add(txtDisplaytotal2);
		
		Selection3 = new JPanel();
		Selection3.setLayout(null);
		Selection3.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		Selection3.setBackground(Color.WHITE);
		Selection3.setBounds(30, 25, 695, 389);
		stdetails.add(Selection3);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBackground(Color.GRAY);
		separator_2_1.setBounds(27, 55, 639, 1);
		Selection3.add(separator_2_1);
		
		JTextArea txtrThereAre_1_2_1_1 = new JTextArea();
		txtrThereAre_1_2_1_1.setText(" Adobe Premiere Pro\r\n");
		txtrThereAre_1_2_1_1.setFont(new Font("Calibri", Font.BOLD, 30));
		txtrThereAre_1_2_1_1.setBounds(27, 22, 639, 35);
		Selection3.add(txtrThereAre_1_2_1_1);
		
		JTextArea txtrThereAre_1_1_1_1_1 = new JTextArea();
		txtrThereAre_1_1_1_1_1.setText(" This is a 6 days training (3 hours per day).\r\n The participant will be able to learn:\r\n - the tutorial of editing video\r\n - adding effects on the video\r\n \r\n Conduct by               : Vincen");
		txtrThereAre_1_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtrThereAre_1_1_1_1_1.setBounds(27, 79, 639, 153);
		Selection3.add(txtrThereAre_1_1_1_1_1);
		
		JTextArea txtDisplaytotal3 = new JTextArea();
		txtDisplaytotal3.setToolTipText("");
		txtDisplaytotal3.setFont(new Font("Calibri", Font.BOLD, 20));
		txtDisplaytotal3.setBounds(27, 233, 639, 47);
		Selection3.add(txtDisplaytotal3);
		
		Selection4 = new JScrollPane();
		Selection4.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		Selection4.setBounds(30, 25, 695, 389);
		stdetails.add(Selection4);
		
		JPanel s4 = new JPanel();
		Selection4.setViewportView(s4);
		s4.setBorder(null);
		s4.setBackground(Color.WHITE);
		
		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setBackground(Color.GRAY);
		
		JTextArea txtrThereAre_1_2_1_2 = new JTextArea();
		txtrThereAre_1_2_1_2.setText(" Adobe Photoshop\r\n");
		txtrThereAre_1_2_1_2.setFont(new Font("Calibri", Font.BOLD, 30));
		
		JTextArea txtrThereAre_1_1_1_1_2 = new JTextArea();
		txtrThereAre_1_1_1_1_2.setText(" This is a 6 days training (3 hours per day).\r\n The participant will be able to learn:\r\n - the tutorial of editing photo\r\n - designing poster\r\n\r\n Conduct by               : Jakson Lee");
		txtrThereAre_1_1_1_1_2.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JSeparator separator_2_1_1 = new JSeparator();
		separator_2_1_1.setBackground(Color.GRAY);
		
		JTextArea txtrThereAre_1_2_1_1_1 = new JTextArea();
		txtrThereAre_1_2_1_1_1.setText(" Adobe Premiere Pro\r\n");
		txtrThereAre_1_2_1_1_1.setFont(new Font("Calibri", Font.BOLD, 30));
		
		JSeparator separator_2_1_1_1 = new JSeparator();
		separator_2_1_1_1.setBackground(Color.BLACK);
		
		JTextArea txtrThereAre_1_1_1_1_1_1 = new JTextArea();
		txtrThereAre_1_1_1_1_1_1.setText(" This is a 6 days training (3 hours per day).\r\n The participant will be able to learn:\r\n - the tutorial of editing video\r\n - adding effects on the video\r\n \r\n Conduct by               : Vincen");
		txtrThereAre_1_1_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JTextArea txtDisplaytotal4 = new JTextArea();
		txtDisplaytotal4.setToolTipText("");
		txtDisplaytotal4.setFont(new Font("Calibri", Font.BOLD, 20));
		GroupLayout gl_s4 = new GroupLayout(s4);
		gl_s4.setHorizontalGroup(
			gl_s4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_s4.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_s4.createParallelGroup(Alignment.LEADING)
						.addComponent(txtrThereAre_1_2_1_2, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator_2_2, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrThereAre_1_1_1_1_2, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrThereAre_1_2_1_1_1, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator_2_1_1, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrThereAre_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator_2_1_1_1, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDisplaytotal4, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE)))
		);
		gl_s4.setVerticalGroup(
			gl_s4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_s4.createSequentialGroup()
					.addGap(22)
					.addComponent(txtrThereAre_1_2_1_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(separator_2_2, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(txtrThereAre_1_1_1_1_2, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(txtrThereAre_1_2_1_1_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(separator_2_1_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(txtrThereAre_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(separator_2_1_1_1, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(txtDisplaytotal4, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
		);
		s4.setLayout(gl_s4);
		
		Selection5 = new JScrollPane();
		Selection5.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		Selection5.setBounds(30, 25, 695, 389);
		stdetails.add(Selection5);
		
		s5 = new JPanel();
		Selection5.setViewportView(s5);
		s5.setBorder(null);
		s5.setBackground(Color.WHITE);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.GRAY);
		
		JTextArea txtrThereAre_1_2_2 = new JTextArea();
		txtrThereAre_1_2_2.setText("Excel\r\n");
		txtrThereAre_1_2_2.setFont(new Font("Calibri", Font.BOLD, 30));
		
		JTextArea txtrThereAre_1_1_1_2 = new JTextArea();
		txtrThereAre_1_1_1_2.setText(" This is a 2 day training (3 hours per day).\r\n The participant will be able to learn:\r\n - the tutorial on how to use Excel\r\n - calculate finance report \r\n\r\n Conduct by               : Ahmad");
		txtrThereAre_1_1_1_2.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JSeparator separator_2_2_1 = new JSeparator();
		separator_2_2_1.setBackground(Color.GRAY);
		
		JTextArea txtrThereAre_1_2_1_2_1 = new JTextArea();
		txtrThereAre_1_2_1_2_1.setText(" Adobe Photoshop\r\n");
		txtrThereAre_1_2_1_2_1.setFont(new Font("Calibri", Font.BOLD, 30));
		
		JTextArea txtrThereAre_1_1_1_1_2_1 = new JTextArea();
		txtrThereAre_1_1_1_1_2_1.setText(" This is a 6 days training (3 hours per day).\r\n The participant will be able to learn:\r\n - the tutorial of editing photo\r\n - designing poster\r\n\r\n Conduct by               : Jakson Lee");
		txtrThereAre_1_1_1_1_2_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JSeparator separator_2_1_1_2 = new JSeparator();
		separator_2_1_1_2.setBackground(Color.GRAY);
		
		JTextArea txtrThereAre_1_2_1_1_1_1 = new JTextArea();
		txtrThereAre_1_2_1_1_1_1.setText(" Adobe Premiere Pro\r\n");
		txtrThereAre_1_2_1_1_1_1.setFont(new Font("Calibri", Font.BOLD, 30));
		
		JSeparator separator_2_1_1_1_1 = new JSeparator();
		separator_2_1_1_1_1.setBackground(Color.BLACK);
		
		JTextArea txtrThereAre_1_1_1_1_1_1_1 = new JTextArea();
		txtrThereAre_1_1_1_1_1_1_1.setText(" This is a 6 days training (3 hours per day).\r\n The participant will be able to learn:\r\n - the tutorial of editing video\r\n - adding effects on the video\r\n \r\n Conduct by               : Vincen");
		txtrThereAre_1_1_1_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JTextArea txtDisplaytotal5 = new JTextArea();
		txtDisplaytotal5.setToolTipText("");
		txtDisplaytotal5.setFont(new Font("Calibri", Font.BOLD, 20));
		GroupLayout gl_s5 = new GroupLayout(s5);
		gl_s5.setHorizontalGroup(
			gl_s5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_s5.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_s5.createParallelGroup(Alignment.LEADING)
						.addComponent(txtrThereAre_1_2_2, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrThereAre_1_1_1_2, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrThereAre_1_2_1_2_1, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator_2_2_1, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrThereAre_1_1_1_1_2_1, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrThereAre_1_2_1_1_1_1, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator_2_1_1_2, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrThereAre_1_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator_2_1_1_1_1, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDisplaytotal5, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE)))
		);
		gl_s5.setVerticalGroup(
			gl_s5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_s5.createSequentialGroup()
					.addGap(22)
					.addComponent(txtrThereAre_1_2_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(txtrThereAre_1_1_1_2, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(txtrThereAre_1_2_1_2_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(separator_2_2_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(txtrThereAre_1_1_1_1_2_1, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(txtrThereAre_1_2_1_1_1_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(separator_2_1_1_2, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(txtrThereAre_1_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(separator_2_1_1_1_1, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(txtDisplaytotal5, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
		);
		s5.setLayout(gl_s5);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(null);
		panel_2_1_1.setBackground(new Color(25, 25, 112));
		panel_2_1_1.setBounds(23, 20, 695, 389);
		stdetails.add(panel_2_1_1);
		
		JComboBox pac = new JComboBox();
		pac.setToolTipText(" 1 - Excel\r\n 2 - Adobe Photoshop\r\n 3 - Adobe Premiere Pro\r\n 4 - Adobe Photoshop & Premiere Pro\r\n 5 - All 3 types ");
		pac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double fee;
				double totalFee;
				double discount;
				PaymentF f = new TotalFee();
				
				if (pac.getSelectedItem().equals("Select a package")) {
					makeSelection.setVisible(true);
					Selection2.setVisible(false);
					Selection3.setVisible(false);
					Selection4.setVisible(false);
					Selection5.setVisible(false);
					Selection1.setVisible(false);
				}
				else if (pac.getSelectedItem().equals("1")){
					fee = 600;
					totalFee = fee;
					
					makeSelection.setVisible(false);
					Selection2.setVisible(false);
					Selection3.setVisible(false);
					Selection4.setVisible(false);
					Selection5.setVisible(false);
					Selection1.setVisible(true);
					txtDisplaytotal1.setText(String.format(" Total Fee                   : RM %.2f", totalFee));
				}
				else if (pac.getSelectedItem().equals("2")){
					fee = 1600;
					totalFee = fee;
					
					makeSelection.setVisible(false);
					Selection1.setVisible(false);
					Selection3.setVisible(false);
					Selection4.setVisible(false);
					Selection5.setVisible(false);
					Selection2.setVisible(true);
					txtDisplaytotal2.setText(String.format(" Total Fee                   : RM %.2f", totalFee));
				}
				else if (pac.getSelectedItem().equals("3")){
					fee = 2000;
					totalFee = fee;
					
					makeSelection.setVisible(false);
					Selection1.setVisible(false);
					Selection2.setVisible(false);
					Selection4.setVisible(false);
					Selection5.setVisible(false);
					Selection3.setVisible(true);
					txtDisplaytotal3.setText(String.format(" Total Fee                   : RM %.2f", totalFee));
				}
				else if (pac.getSelectedItem().equals("4")){
					fee = 1600 + 2000;
					
					makeSelection.setVisible(false);
					Selection1.setVisible(false);
					Selection2.setVisible(false);
					Selection3.setVisible(false);
					Selection5.setVisible(false);
					Selection4.setVisible(true);
					txtDisplaytotal4.setText(String.format(" Total Fee                   : RM %.2f", f.getPayment(fee)));
				}
				else if (pac.getSelectedItem().equals("5")){
					fee = 600 + 1600 + 2000;
					discount = 0.05;
					
					makeSelection.setVisible(false);
					Selection1.setVisible(false);
					Selection2.setVisible(false);
					Selection3.setVisible(false);
					Selection4.setVisible(false);
					Selection5.setVisible(true);
					txtDisplaytotal5.setText(String.format(" Total Fee                   : RM %.2f", f.getPayment(fee,discount)));
				}
				
			}
		});
		pac.setModel(new DefaultComboBoxModel(new String[] {"Select a package", "1", "2", "3", "4", "5"}));
		pac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pac.setBackground(Color.WHITE);
		pac.setBounds(755, 90, 177, 35);
		stdetails.add(pac);
		
		JLabel lblreturn = new JLabel("");
		lblreturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Switch_screen(usermain);
			}
		});
		lblreturn.setHorizontalAlignment(SwingConstants.CENTER);
		lblreturn.setBounds(906, 384, 55, 55);
		lblreturn.setIcon(new ImageIcon(img_return));
		stdetails.add(lblreturn);
		
		JButton btnRegis_1 = new JButton("Register");
		btnRegis_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Switch_screen(loginsignup);
			}
		});
		btnRegis_1.setToolTipText("Log in or Sign up");
		btnRegis_1.setForeground(Color.WHITE);
		btnRegis_1.setFont(new Font("Dialog", Font.BOLD, 20));
		btnRegis_1.setBackground(new Color(51, 51, 204));
		btnRegis_1.setBounds(772, 26, 145, 46);
		stdetails.add(btnRegis_1);
		
		loginsignup = new JPanel();
		loginsignup.setLayout(null);
		loginsignup.setToolTipText("");
		loginsignup.setBackground(new Color(204, 255, 255));
		loginsignup.setBounds(0, 0, 961, 439);
		layeredPane.add(loginsignup);
		
		panellogin = new JPanel();
		panellogin.setLayout(null);
		panellogin.setBackground(new Color(204, 255, 255));
		panellogin.setBounds(285, 98, 394, 318);
		loginsignup.add(panellogin);
		
		JPanel panel_4_2 = new JPanel();
		panel_4_2.setLayout(null);
		panel_4_2.setBackground(Color.WHITE);
		panel_4_2.setBounds(0, 33, 394, 55);
		panellogin.add(panel_4_2);
		
		usernL = new JTextField();
		usernL.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(usernL.getText().equals("Username")) {
					usernL.setText(null);
				}
				else {
					usernL.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(usernL.getText().equals("")) 
					usernL.setText("Username");
			}
		});
		usernL.setText("Username");
		usernL.setFont(new Font("Tahoma", Font.PLAIN, 18));
		usernL.setColumns(10);
		usernL.setBorder(null);
		usernL.setBackground(Color.WHITE);
		usernL.setBounds(77, 11, 311, 35);
		panel_4_2.add(usernL);
		
		JLabel lbluserL = new JLabel("");
		lbluserL.setHorizontalAlignment(SwingConstants.CENTER);
		lbluserL.setBounds(0, 0, 74, 55);
		lbluserL.setIcon(new ImageIcon(img_admin));
		panel_4_2.add(lbluserL);
		
		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setLayout(null);
		panel_4_1_1.setBackground(Color.WHITE);
		panel_4_1_1.setBounds(0, 99, 394, 55);
		panellogin.add(panel_4_1_1);
		
		lblshowL = new JRadioButton("");
		lblshowL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblshowL.isSelected()) {
					passwordL.setEchoChar((char)0);
					lblshowL.setIcon(new ImageIcon(img_show));
				}
				else {
					passwordL.setEchoChar('●');
					lblshowL.setIcon(new ImageIcon(img_hide));
				}		
			}
		});
		lblshowL.setHorizontalAlignment(SwingConstants.CENTER);
		lblshowL.setBackground(Color.WHITE);
		lblshowL.setBounds(320, 0, 74, 55);
		lblshowL.setIcon(new ImageIcon(img_hide));
		panel_4_1_1.add(lblshowL);
		
		passwordL = new JPasswordField();
		passwordL.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(passwordL.getText().equals("Password")) {
					passwordL.setEchoChar('●');
					passwordL.setText("");
				}
				else {
					passwordL.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(passwordL.getText().equals("")) {
					passwordL.setText("Password");
					passwordL.setEchoChar((char)0);
				}	
			}
		});
		passwordL.setText("Password");
		passwordL.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordL.setEchoChar((char)0);
		passwordL.setBorder(null);
		passwordL.setBounds(77, 11, 237, 35);
		panel_4_1_1.add(passwordL);
		
		JLabel lblpasswordL = new JLabel("");
		lblpasswordL.setHorizontalAlignment(SwingConstants.CENTER);
		lblpasswordL.setBounds(0, 0, 74, 55);
		lblpasswordL.setIcon(new ImageIcon(img_password));
		panel_4_1_1.add(lblpasswordL);
		
		userLogin = new JButton("Login");
		userLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (usernL.getText().equals("chen") && passwordL.getText().equals("123huiting")) {
					JOptionPane.showMessageDialog(null, "Login Successful.");
				}
				
				else if (usernL.getText().equals("") || usernL.getText().equals("Username") ||
						passwordL.getText().equals("") || passwordL.getText().equals("Password")) {
					lblLoginMessageL.setText("Please input username and password.");
				}
				else {
					lblLoginMessageL.setText("Incorrect username and password!");
					JOptionPane.showMessageDialog(null, "Login Unsuccessful.");
				}
			}
		});
		userLogin.setToolTipText("");
		userLogin.setForeground(Color.WHITE);
		userLogin.setFont(new Font("Tahoma", Font.BOLD, 25));
		userLogin.setBackground(new Color(51, 51, 204));
		userLogin.setBounds(0, 223, 394, 55);
		panellogin.add(userLogin);
		
		lblLoginMessageL = new JLabel("");
		lblLoginMessageL.setForeground(Color.RED);
		lblLoginMessageL.setBounds(0, 161, 394, 25);
		panellogin.add(lblLoginMessageL);
		
		panelsignup = new JPanel();
		panelsignup.setLayout(null);
		panelsignup.setBackground(new Color(204, 255, 255));
		panelsignup.setBounds(285, 98, 394, 318);
		loginsignup.add(panelsignup);
		
		JPanel panel_4_2_1 = new JPanel();
		panel_4_2_1.setLayout(null);
		panel_4_2_1.setBackground(Color.WHITE);
		panel_4_2_1.setBounds(0, 33, 394, 55);
		panelsignup.add(panel_4_2_1);
		
		usernS = new JTextField();
		usernS.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(usernS.getText().equals("Username")) {
					usernS.setText(null);
				}
				else {
					usernS.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(usernS.getText().equals("")) 
					usernS.setText("Username");
			}
		});
		usernS.setText("Username");
		usernS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		usernS.setColumns(10);
		usernS.setBorder(null);
		usernS.setBackground(Color.WHITE);
		usernS.setBounds(77, 11, 311, 35);
		panel_4_2_1.add(usernS);
		
		JLabel lbluserS = new JLabel("");
		lbluserS.setHorizontalAlignment(SwingConstants.CENTER);
		lbluserS.setBounds(0, 0, 74, 55);
		lbluserS.setIcon(new ImageIcon(img_admin));
		panel_4_2_1.add(lbluserS);
		
		JPanel panel_4_1_1_1 = new JPanel();
		panel_4_1_1_1.setLayout(null);
		panel_4_1_1_1.setBackground(Color.WHITE);
		panel_4_1_1_1.setBounds(0, 99, 394, 55);
		panelsignup.add(panel_4_1_1_1);
		
		lblshowS1 = new JRadioButton("");
		lblshowS1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblshowS1.isSelected()) {
					passwordS1.setEchoChar((char)0);
					lblshowS1.setIcon(new ImageIcon(img_show));
				}
				else {
					passwordS1.setEchoChar('●');
					lblshowS1.setIcon(new ImageIcon(img_hide));
				}		
			}
		});
		lblshowS1.setHorizontalAlignment(SwingConstants.CENTER);
		lblshowS1.setBackground(Color.WHITE);
		lblshowS1.setBounds(320, 0, 74, 55);
		lblshowS1.setIcon(new ImageIcon(img_hide));
		panel_4_1_1_1.add(lblshowS1);
		
		passwordS1 = new JPasswordField();
		passwordS1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(passwordS1.getText().equals("Password")) {
					passwordS1.setEchoChar('●');
					passwordS1.setText("");
				}
				else {
					passwordS1.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(passwordS1.getText().equals("")) {
					passwordS1.setText("Password");
					passwordS1.setEchoChar((char)0);
				}	
			}
		});
		passwordS1.setText("Password");
		passwordS1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordS1.setEchoChar((char)0);
		passwordS1.setBorder(null);
		passwordS1.setBounds(77, 11, 237, 35);
		panel_4_1_1_1.add(passwordS1);
		
		JLabel lblpasswordS1 = new JLabel("");
		lblpasswordS1.setHorizontalAlignment(SwingConstants.CENTER);
		lblpasswordS1.setBounds(0, 0, 74, 55);
		lblpasswordS1.setIcon(new ImageIcon(img_password));
		panel_4_1_1_1.add(lblpasswordS1);
		
		JButton signup = new JButton("Signup");
		signup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserAccount ua = new UserAccount();
				int i = UserAccount.table.getSelectedRow();
				Object usn = UserAccount.table.getValueAt(i,0);
				Object psw = UserAccount.table.getValueAt(i,5);
				
				if(usernS.getText().equals(usn) && passwordS1.getText().equals(psw) ) {
					JOptionPane.showMessageDialog(null, "This username already exist.");
				}
				
				else if (passwordS1.getText().equals(passwordS2.getText()) && (!(passwordS1.getText().equals("") || passwordS1.getText().equals("Password")
						|| passwordS2.getText().equals("") || passwordS2.getText().equals("Password")))) {
					JOptionPane.showMessageDialog(null, "Signup Successful.");
				}
				
				else if (usernS.getText().equals("") || usernS.getText().equals("Username") ||
						passwordS1.getText().equals("") || passwordS1.getText().equals("Password")
						|| passwordS2.getText().equals("") || passwordS2.getText().equals("Password")) {
					lblLoginMessageS.setText("Please input username and password.");
				}
				else if (!passwordS1.getText().equals(passwordS2.getText()) ) {
					lblLoginMessageS.setText("Please input the correct password.");
					JOptionPane.showMessageDialog(null, "Signup Unsuccessful.");
				}
				else {
					lblLoginMessageS.setText("Incorrect username and password!");
					JOptionPane.showMessageDialog(null, "Signup Unsuccessful.");
				}
			}
		});
		signup.setToolTipText("");
		signup.setForeground(Color.WHITE);
		signup.setFont(new Font("Tahoma", Font.BOLD, 25));
		signup.setBackground(new Color(51, 51, 204));
		signup.setBounds(0, 263, 394, 55);
		panelsignup.add(signup);
		
		lblLoginMessageS = new JLabel("");
		lblLoginMessageS.setForeground(Color.RED);
		lblLoginMessageS.setBounds(0, 227, 394, 25);
		panelsignup.add(lblLoginMessageS);
		
		JPanel panel_4_1_1_1_1 = new JPanel();
		panel_4_1_1_1_1.setLayout(null);
		panel_4_1_1_1_1.setBackground(Color.WHITE);
		panel_4_1_1_1_1.setBounds(0, 165, 394, 55);
		panelsignup.add(panel_4_1_1_1_1);
		
		lblshowS2 = new JRadioButton("");
		lblshowS2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblshowS2.isSelected()) {
					passwordS2.setEchoChar((char)0);
					lblshowS2.setIcon(new ImageIcon(img_show));
				}
				else {
					passwordS2.setEchoChar('●');
					lblshowS2.setIcon(new ImageIcon(img_hide));
				}		
			}
		});
		lblshowS2.setHorizontalAlignment(SwingConstants.CENTER);
		lblshowS2.setBackground(Color.WHITE);
		lblshowS2.setBounds(320, 0, 74, 55);
		lblshowS2.setIcon(new ImageIcon(img_hide));
		panel_4_1_1_1_1.add(lblshowS2);
		
		passwordS2 = new JPasswordField();
		passwordS2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(passwordS2.getText().equals("Confirm Password")) {
					passwordS2.setEchoChar('●');
					passwordS2.setText("");
				}
				else {
					passwordS2.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(passwordS2.getText().equals("")) {
					passwordS2.setText("Confirm Password");
					passwordS2.setEchoChar((char)0);
				}	
			}
		});
		passwordS2.setText("Confirm Password");
		passwordS2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordS2.setEchoChar((char)0);
		passwordS2.setBorder(null);
		passwordS2.setBounds(77, 11, 237, 35);
		panel_4_1_1_1_1.add(passwordS2);
		
		JLabel lblpasswordS2 = new JLabel("");
		lblpasswordS2.setHorizontalAlignment(SwingConstants.CENTER);
		lblpasswordS2.setBounds(0, 0, 74, 55);
		lblpasswordS2.setIcon(new ImageIcon(img_password));
		panel_4_1_1_1_1.add(lblpasswordS2);
		
		sltLogin = new JButton("Login");
		sltLogin.setSelected(true);
		sltLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panellogin.setVisible(true);
				panelsignup.setVisible(false);
				sltLogin.setBackground(new Color(153, 204, 255));
				sltSignup.setBackground(Color.WHITE);
			}
		});
		buttonGroup.add(sltLogin);
		sltLogin.setToolTipText("");
		sltLogin.setForeground(Color.BLACK);
		sltLogin.setFont(new Font("Dialog", Font.BOLD, 30));
		sltLogin.setBackground(new Color(153, 204, 255));
		sltLogin.setBounds(285, 25, 197, 73);
		loginsignup.add(sltLogin);
		
		sltSignup = new JButton("Signup");
		sltSignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelsignup.setVisible(true);
				panellogin.setVisible(false);
				sltSignup.setBackground(new Color(153, 204, 255));
				sltLogin.setBackground(Color.WHITE);
			}
		});
		sltSignup.setSelected(true);
		buttonGroup.add(sltSignup);
		sltSignup.setToolTipText("");
		sltSignup.setForeground(Color.BLACK);
		sltSignup.setFont(new Font("Dialog", Font.BOLD, 30));
		sltSignup.setBackground(Color.WHITE);
		sltSignup.setBounds(482, 25, 197, 73);
		loginsignup.add(sltSignup);
		
		JLabel lblreturnLS = new JLabel("");
		lblreturnLS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Switch_screen(usermain);
			}
		});
		lblreturnLS.setHorizontalAlignment(SwingConstants.CENTER);
		lblreturnLS.setBounds(906, 384, 55, 55);
		lblreturnLS.setIcon(new ImageIcon(img_return));
		loginsignup.add(lblreturnLS);
		
		adminpanel = new JPanel();
		adminpanel.setBackground(new Color(204, 255, 255));
		adminpanel.setToolTipText("");
		tabbedPane.addTab("Admin", null, adminpanel, "for admin use only");
		adminpanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Login as Admin");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel_1.setBounds(285, 25, 394, 73);
		adminpanel.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(285, 131, 394, 55);
		adminpanel.add(panel_4);
		panel_4.setLayout(null);
		
		usernA = new JTextField();
		usernA.setBorder(null);
		usernA.setBackground(new Color(255, 255, 255));
		usernA.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(usernA.getText().equals("Username")) {
					usernA.setText(null);
				}
				else {
					usernA.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(usernA.getText().equals("")) 
					usernA.setText("Username");
			}
		});
		usernA.setFont(new Font("Tahoma", Font.PLAIN, 18));
		usernA.setText("Username");
		usernA.setBounds(77, 11, 311, 35);
		panel_4.add(usernA);
		usernA.setColumns(10);
		
		JLabel lbluserA = new JLabel("");
		lbluserA.setHorizontalAlignment(SwingConstants.CENTER);
		lbluserA.setBounds(0, 0, 74, 55);
		lbluserA.setIcon(new ImageIcon(img_admin));
		panel_4.add(lbluserA);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(new Color(255, 255, 255));
		panel_4_1.setLayout(null);
		panel_4_1.setBounds(285, 197, 394, 55);
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
		
		lblshow = new JRadioButton("");
		lblshow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblshow.isSelected()) {
					pwdPassword.setEchoChar((char)0);
					lblshow.setIcon(new ImageIcon(img_show));
				}
				else {
					pwdPassword.setEchoChar('●');
					lblshow.setIcon(new ImageIcon(img_hide));
				}		
			}
		});
		lblshow.setBackground(Color.WHITE);
		lblshow.setHorizontalAlignment(SwingConstants.CENTER);
		lblshow.setBounds(320, 0, 74, 55);
		lblshow.setIcon(new ImageIcon(img_hide));
		panel_4_1.add(lblshow);
		
		pwdPassword.setEchoChar((char)0);
		pwdPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pwdPassword.setText("Password");
		pwdPassword.setBounds(77, 11, 237, 35);
		panel_4_1.add(pwdPassword);
		
		JLabel lblpassword = new JLabel("");
		lblpassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblpassword.setBounds(0, 0, 74, 55);
		lblpassword.setIcon(new ImageIcon(img_password));
		panel_4_1.add(lblpassword);
		
		JButton btnLoginA = new JButton("Login");
		btnLoginA.setForeground(new Color(255, 255, 255));
		btnLoginA.setBackground(new Color(51, 51, 204));
		btnLoginA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (usernA.getText().equals("chen") && pwdPassword.getText().equals("123huiting")) {
					JOptionPane.showMessageDialog(null, "Login Successful.");
					
					AdminMain am = new AdminMain();
					am.setVisible(true);
					dispose();
				}
				
				else if (usernA.getText().equals("") || usernA.getText().equals("Username") ||
						pwdPassword.getText().equals("") || pwdPassword.getText().equals("Password")) {
					lblLoginMessageA.setText("Please input username and password.");
				}
				else {
					lblLoginMessageA.setText("Incorrect username and password!");
					JOptionPane.showMessageDialog(null, "Login Unsuccessful.");
				}
			}
		});
		
		btnLoginA.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnLoginA.setToolTipText("");
		btnLoginA.setBounds(285, 321, 394, 55);
		adminpanel.add(btnLoginA);
		
		lblLoginMessageA.setForeground(new Color(255, 0, 0));
		lblLoginMessageA.setBounds(285, 259, 394, 25);
		adminpanel.add(lblLoginMessageA);
		
	}
	
	public void Switch_screen(JPanel p) {
		layeredPane.removeAll();
		layeredPane.add(p);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	public double getPayment(double f) { //Method implementation
		double totalF = f-20; //join 2 classes of software training will get RM20 cash back
		return totalF; 
	}
	
	public double getPayment(double f, double d) { //Method implementation
		double totalF = (f -30) * (1-d);//join 3 classes of software training will get RM30 cash back and 5% discount
		return totalF; 
	}
}
