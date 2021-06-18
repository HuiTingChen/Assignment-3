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
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

public class UserAccount extends JFrame {
	
	private Image img_close = new ImageIcon(Home.class.getResource("closebtn.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image img_return = new ImageIcon(Home.class.getResource("return.png")).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
	
	private JPanel contentPane;
	protected Component frame;
	
	static JTable table;
	JTable tableup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAccount frame = new UserAccount();
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
	public UserAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(0, 0, 986, 563);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 986, 74);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 102));
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
		panel_1_1.setBounds(0, 489, 986, 74);
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(0, 0, 102));
		panel.add(panel_1_1);
		
		JLabel lblreturn = new JLabel("");
		lblreturn.setBorder(new LineBorder(Color.WHITE, 1, true));
		lblreturn.setBackground(Color.WHITE);
		lblreturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminMain am = new AdminMain();
				am.setVisible(true);
				dispose();
			}
		});
		lblreturn.setBounds(906, 10, 55, 55);
		lblreturn.setIcon(new ImageIcon(img_return));
		panel_1_1.add(lblreturn);
		lblreturn.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_1 = new JLabel("User Profile");
		lblNewLabel_1.setBounds(23, 74, 240, 54);
		lblNewLabel_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 26));
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(358, 139, 603, 339);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Lin Boon Kit", "017-6289181", "boonkit@gmail.com", "Male"},
				{"Jonse Tan Chi Min", "012-8271927", "jonse2301@gmail.com", "Male"},
				{"Mellisa Chong Ker Min", "017-7142812", "kermin@gmail.com", "Female"},
				{"Goo Wan Qian", "012-3821251", "wanqian0403@gmail.com", "Female"},
				{"Kirubbanan A/L Bakkarunan", "018-2201296", "kiruba@gmail.com", "Male"},
			},
			new String[] {
				"Name", "Contact No.", "Email", "Gender"
			}
		));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(Color.WHITE);
		scrollPane_1.setBounds(23, 139, 307, 337);
		panel.add(scrollPane_1);
		
		tableup = new JTable();
		tableup.setModel(new DefaultTableModel(
			new Object[][] {
				{"Boon", "5629boon"},
				{"23Jonse", "23jonse01tan"},
				{"Mellisa", "Mellisa02ky"},
				{"WQ", "04wqGOO03"},
				{"kiru", "K029B392"},
			},
			new String[] {
				"Username", "Password"
			}
		));
		scrollPane_1.setViewportView(tableup);
		
	}
	public static void AddRowToJtable(Object[] dataRow) {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.addRow(dataRow);
	}
}
