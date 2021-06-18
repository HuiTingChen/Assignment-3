package Assignment3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registration extends JFrame {
	
	private Image img_close = new ImageIcon(Home.class.getResource("closebtn.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image img_return = new ImageIcon(Home.class.getResource("return.png")).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
	
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtContact;
	private JTextField txtEmail;
	private JTextField txtDate;
	private JTable table;
	private JComboBox sltPackage;
	private JComboBox sltTime;
	protected JFrame frame;
	private JTextArea textArea;
	private JTextField txtTotal;
	private JLabel lblDisscountMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
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
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
					model.addRow(new Object[]{
						txtName.getText(),
						txtContact.getText(),
						txtEmail.getText(),
						sltPackage.getSelectedItem(),
						sltTime.getSelectedItem(),
						txtDate.getText(),			
					});
					
					
				//for display register information in text area
				//for select day time or night time
				String t = "";
				if (sltTime.getSelectedItem().equals("Day Time")) 
					t = " This software training will be started from 10.00a.m.-13.00p.m.";
			
				else if (sltTime.getSelectedItem().equals("Night Time"))
					t = " This software training will be started from 19.00p.m.-22.00p.m.";
				
				
				//for select desire package and fee
				double fee;
				double totalFee;
				double discount;
				PaymentF f = new TotalFee();
				String pac = "";
				if (sltPackage.getSelectedItem().equals("1 - Excel")) { 
					fee = 600;
					totalFee = fee;
					txtTotal.setText(String.format("%.2f", totalFee));
					pac = " Excel - is a 2 day training (3 hours per day)";
				}
				else if (sltPackage.getSelectedItem().equals("2 - Adobe Photoshop")) { 
					fee = 1600;
					totalFee = fee;
					txtTotal.setText(String.format("%.2f", totalFee));
					pac = " Adobe Photoshop - is a 6 day training (3 hours per day)";
				}
				else if (sltPackage.getSelectedItem().equals("3 - Adobe Premiere Pro")) { 
					fee = 2000;
					totalFee = fee;
					txtTotal.setText(String.format("%.2f", totalFee));
					pac = " Adobe Premiere Pro - is a 6 day training (3 hours per day)";
				}
				else if (sltPackage.getSelectedItem().equals("4 - Photoshop & Premiere Pro")) { 
					fee = 1600 + 2000;
					txtTotal.setText(String.format("%.2f", f.getPayment(fee)));
					pac = " Adobe Photoshop - is a 6 day training (3 hours per day)" +
						  "\n Adobe Premiere Pro - is a 6 day training (3 hours per day)";
					
					lblDisscountMessage.setText("Cash back RM 20.");
				}
				else if (sltPackage.getSelectedItem().equals("5 - All 3 types")) {
					fee = 600 + 1600 + 2000;
					discount = 0.05;
					txtTotal.setText(String.format("%.2f", f.getPayment(fee,discount)));
					pac = " Excel - is a 2 day training (3 hours per day)" +
						  "\n Adobe Photoshop - is a 6 day training (3 hours per day)" +
						  "\n Adobe Premiere Pro - is a 6 day training (3 hours per day)";
					
					lblDisscountMessage.setText("Cash back RM 30 and 5% discount.");
				}
			
				//Display information in text area
				textArea.setText(" Name\t: " + txtName.getText()
				        	 + "\n Contact\t: " + txtContact.getText()
				        	 + "\n Email\t: " + txtEmail.getText()
				        	 + "\n Package\t: " + sltPackage.getSelectedItem()
				        	 + "\n Date\t: " + txtDate.getText()
				        	 + "\n\n" + t
				        	 + "\n_____________________________________________________________"
				        	 + "\n" + pac);
				

				JOptionPane.showMessageDialog(null, "You have successfully registered.", "Registration System",
							JOptionPane.OK_OPTION);
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(204, 204, 255));
		btnNewButton.setBounds(22, 15, 140, 41);
		panel_1_1.add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtContact.setText("");
				txtEmail.setText("");
				sltPackage.setSelectedItem("Select Package");
				sltTime.setSelectedItem("Select Time");
				txtDate.setText("");
				textArea.setText("");
				lblDisscountMessage.setText("");
			}
		});
		btnClear.setForeground(new Color(0, 0, 0));
		btnClear.setFont(new Font("Dialog", Font.BOLD, 20));
		btnClear.setBackground(new Color(204, 204, 255));
		btnClear.setBounds(182, 15, 140, 41);
		panel_1_1.add(btnClear);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int i = table.getSelectedRow();
			    if(i>=0) //if single row is selected than update
			    {
			    	
			    	model.setValueAt(txtName.getText(), i, 0);
			    	model.setValueAt(txtContact.getText(), i, 1);
			    	model.setValueAt(txtEmail.getText(), i, 2);
			    	model.setValueAt(sltPackage.getSelectedItem(), i, 3);
			    	model.setValueAt(sltTime.getSelectedItem(), i, 4);
					model.setValueAt(txtDate.getText(), i, 5);
					
					JOptionPane.showMessageDialog(null, "Update Successfully");
			    
			    }
			    else 
			    {
			    	JOptionPane.showMessageDialog(null, "Please Select a Row First!");
			    }
			
			}
		});
		btnUpdate.setForeground(new Color(0, 0, 0));
		btnUpdate.setFont(new Font("Dialog", Font.BOLD, 20));
		btnUpdate.setBackground(new Color(204, 204, 255));
		btnUpdate.setBounds(340, 15, 140, 41);
		panel_1_1.add(btnUpdate);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//change e with other variable
				try {
					textArea.print();
				} catch (java.awt.print.PrinterException e) {
					System.err.format("No printer found", e.getMessage());
				}
			}
		});
		btnPrint.setForeground(Color.BLACK);
		btnPrint.setFont(new Font("Dialog", Font.BOLD, 20));
		btnPrint.setBackground(new Color(204, 204, 255));
		btnPrint.setBounds(656, 15, 140, 41);
		panel_1_1.add(btnPrint);
		
		JButton btnUpload = new JButton("Upload");
		btnUpload.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				Sales s = new Sales();
				s.setVisible(true);
				
				Sales.AddRowToJtable(new Object[] {
					txtName.getText(),
					sltPackage.getSelectedItem(),
					sltTime.getSelectedItem(),
					txtDate.getText(),
					txtTotal.getText(),
				});
			}
		});
		btnUpload.setForeground(Color.BLACK);
		btnUpload.setFont(new Font("Dialog", Font.BOLD, 20));
		btnUpload.setBackground(new Color(204, 204, 255));
		btnUpload.setBounds(819, 15, 140, 41);
		panel_1_1.add(btnUpload);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				if(table.getSelectedRow()==-1) {
					if(table.getRowCount()==0) {
						JOptionPane.showMessageDialog(null,"No data to delete",
								"Membership Management System", JOptionPane.OK_OPTION);
					}else {
						JOptionPane.showMessageDialog(null,"Select a row to delete",
								"Membership Management System", JOptionPane.OK_OPTION);
					}
				}else {
					model.removeRow(table.getSelectedRow());
				}
			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Dialog", Font.BOLD, 20));
		btnDelete.setBackground(new Color(204, 204, 255));
		btnDelete.setBounds(506, 15, 140, 41);
		panel_1_1.add(btnDelete);
		
		JLabel lblNewLabel_1 = new JLabel("Registration");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 26));
		lblNewLabel_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(23, 74, 240, 54);
		panel.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(23, 139, 380, 339);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(10, 11, 132, 39);
		panel_2.add(lblName);
		
		txtName = new JTextField();
		txtName.setBackground(new Color(204, 255, 255));
		txtName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtName.setColumns(10);
		txtName.setBounds(129, 17, 243, 35);
		panel_2.add(txtName);
		
		JLabel lblContactNo = new JLabel("Contact No.");
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContactNo.setBounds(10, 61, 132, 39);
		panel_2.add(lblContactNo);
		
		txtContact = new JTextField();
		txtContact.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtContact.setColumns(10);
		txtContact.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtContact.setBackground(new Color(204, 255, 255));
		txtContact.setBounds(129, 67, 243, 35);
		panel_2.add(txtContact);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(10, 111, 132, 39);
		panel_2.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		txtEmail.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtEmail.setBackground(new Color(204, 255, 255));
		txtEmail.setBounds(129, 117, 243, 35);
		panel_2.add(txtEmail);
		
		JLabel lblPackage = new JLabel("Package");
		lblPackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPackage.setBounds(10, 161, 132, 39);
		panel_2.add(lblPackage);
		
		sltPackage = new JComboBox();
		sltPackage.setModel(new DefaultComboBoxModel(new String[] {"Select Package", "1 - Excel", "2 - Adobe Photoshop", "3 - Adobe Premiere Pro", "4 - Photoshop & Premiere Pro", "5 - All 3 types"}));
		sltPackage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sltPackage.setBackground(Color.WHITE);
		sltPackage.setBounds(129, 163, 241, 35);
		panel_2.add(sltPackage);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTime.setBounds(10, 211, 132, 39);
		panel_2.add(lblTime);
		
		sltTime = new JComboBox();
		sltTime.setModel(new DefaultComboBoxModel(new String[] {"Select Time", "Day Time", "Night Time"}));
		sltTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sltTime.setBackground(Color.WHITE);
		sltTime.setBounds(129, 213, 132, 35);
		panel_2.add(sltTime);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate.setBounds(10, 261, 132, 39);
		panel_2.add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDate.setColumns(10);
		txtDate.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtDate.setBackground(new Color(204, 255, 255));
		txtDate.setBounds(129, 267, 243, 35);
		panel_2.add(txtDate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(428, 139, 535, 74);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Contact No.", "Email", "Package", "Time", "Date"
			}
		));
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(428, 228, 534, 208);
		panel.add(scrollPane_1);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Calibri", Font.PLAIN, 15));
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_1.setViewportView(textArea);
		
		JLabel lblreturn = new JLabel("");
		lblreturn.setBounds(931, 74, 55, 55);
		panel.add(lblreturn);
		lblreturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminMain am = new AdminMain();
				am.setVisible(true);
				dispose();
			}
		});
		lblreturn.setHorizontalAlignment(SwingConstants.CENTER);
		lblreturn.setBorder(new LineBorder(Color.WHITE, 1, true));
		lblreturn.setBackground(Color.WHITE);
		lblreturn.setIcon(new ImageIcon(img_return));
		
		txtTotal = new JTextField();
		txtTotal.setHorizontalAlignment(SwingConstants.TRAILING);
		txtTotal.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtTotal.setColumns(10);
		txtTotal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtTotal.setBackground(Color.WHITE);
		txtTotal.setBounds(844, 443, 119, 35);
		panel.add(txtTotal);
		
		JLabel lblName_1 = new JLabel("Total   : RM");
		lblName_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName_1.setBounds(719, 441, 138, 39);
		panel.add(lblName_1);
		
		lblDisscountMessage = new JLabel("");
		lblDisscountMessage.setForeground(Color.RED);
		lblDisscountMessage.setBounds(428, 443, 229, 25);
		panel.add(lblDisscountMessage);
	}
	
}
