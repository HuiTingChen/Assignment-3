package Assignment3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMain extends JFrame {
	
	private Image img_return = new ImageIcon(Home.class.getResource("return.png")).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
	private Image img_close = new ImageIcon(Home.class.getResource("closebtn.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	
	private JPanel contentPane;
	protected Component frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMain frame = new AdminMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(0, 0, 986, 563);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 102));
		panel_1.setBounds(0, 0, 986, 74);
		panel.add(panel_1);
		
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
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(0, 0, 102));
		panel_1_1.setBounds(0, 489, 986, 74);
		panel.add(panel_1_1);
		
		JLabel lblreturn = new JLabel("");
		lblreturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home window = new Home();
				window.frame.setVisible(true);
				dispose();
			}
		});
		lblreturn.setHorizontalAlignment(SwingConstants.CENTER);
		lblreturn.setBorder(new LineBorder(Color.WHITE, 1, true));
		lblreturn.setBackground(Color.WHITE);
		lblreturn.setBounds(906, 10, 55, 55);
		lblreturn.setIcon(new ImageIcon(img_return));
		panel_1_1.add(lblreturn);
		
		JButton btnUProfile = new JButton("User Profile");
		btnUProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserAccount ua = new UserAccount();
				ua.setVisible(true);
				dispose();
			}
		});
		btnUProfile.setFont(new Font("Century Gothic", Font.BOLD, 25));
		btnUProfile.setBounds(263, 172, 220, 100);
		panel.add(btnUProfile);
		
		JButton btnSales = new JButton("Sales");
		/*btnSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sales s = new Sales();
				s.setVisible(true);
				dispose();
			}
		});*/
		btnSales.setFont(new Font("Century Gothic", Font.BOLD, 25));
		btnSales.setBounds(505, 172, 220, 100);
		panel.add(btnSales);
		
		JButton btnEmp = new JButton("Employee");
		/*btnEmp.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Employee e = new Employee();
			e.setVisible(true);
			dispose();
			}
		});*/
		btnEmp.setFont(new Font("Century Gothic", Font.BOLD, 25));
		btnEmp.setBounds(263, 293, 220, 100);
		panel.add(btnEmp);
		
		JButton btnFinanc = new JButton("Finance");
		/*btnFinanc.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Finance f = new Finance();
			f.setVisible(true);
			dispose();
			}
		});*/
		btnFinanc.setFont(new Font("Century Gothic", Font.BOLD, 25));
		btnFinanc.setBounds(505, 293, 220, 100);
		panel.add(btnFinanc);
	}

}
