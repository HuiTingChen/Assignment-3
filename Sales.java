package Assignment3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Sales extends JFrame {
	
	private Image img_close = new ImageIcon(Home.class.getResource("closebtn.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image img_return = new ImageIcon(Home.class.getResource("return.png")).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);

	private JPanel contentPane;
	private static JTable table;
	private JTextField textName;
	private JTextField textDate;
	protected String totalFee;
	protected JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sales frame = new Sales();
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
	public Sales() {
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
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//change e with other variable
				try {
					table.print();
				} catch (java.awt.print.PrinterException e) {
					System.err.format("No printer found", e.getMessage());
				}
			}
		});
		btnPrint.setForeground(Color.BLACK);
		btnPrint.setFont(new Font("Dialog", Font.BOLD, 20));
		btnPrint.setBackground(new Color(204, 204, 255));
		btnPrint.setBounds(627, 15, 140, 41);
		panel_1_1.add(btnPrint);
		
		JButton btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				File file = new File("C:\\Users\\slche\\eclipse-workspace\\EduBusiness\\src\\EduBusiness\\SalesFile.txt");
				if(!file.exists()) {
					file.createNewFile();
					}
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				
				for (int i=0; i<table.getRowCount(); i++) {
					for (int j=0; j<table.getColumnCount(); j++) {
						bw.write(table.getModel().getValueAt(i, j) + "  ");
						}
					bw.write("\n____________________________________________________________________________\n");
					}
					bw.close();
					fw.close();
					JOptionPane.showMessageDialog(null, "Data Exported");
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
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
		btnDelete.setBounds(428, 15, 140, 41);
		panel_1_1.add(btnDelete);
		
		JButton btnAdd = new JButton("Add from Registration");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registration r = new Registration();
				r.setVisible(true);
				//r.pack();
				//r.setLocationRelativeTo(null);
				r.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setFont(new Font("Dialog", Font.BOLD, 20));
		btnAdd.setBackground(new Color(204, 204, 255));
		btnAdd.setBounds(23, 15, 256, 41);
		panel_1_1.add(btnAdd);
		
		JLabel lblNewLabel_1 = new JLabel("Sales");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 26));
		lblNewLabel_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(23, 74, 240, 54);
		panel.add(lblNewLabel_1);
		
		JLabel lblreturn = new JLabel("");
		lblreturn.setHorizontalAlignment(SwingConstants.CENTER);
		lblreturn.setBorder(new LineBorder(Color.WHITE, 1, true));
		lblreturn.setBackground(Color.WHITE);
		lblreturn.setBounds(931, 74, 55, 55);
		panel.add(lblreturn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(428, 139, 535, 339);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Package", "Time", "Date", "Fee"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(23, 139, 380, 221);
		panel.add(panel_2);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(10, 11, 132, 39);
		panel_2.add(lblName);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textName.setColumns(10);
		textName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textName.setBackground(new Color(204, 255, 255));
		textName.setBounds(129, 17, 243, 35);
		panel_2.add(textName);
		
		JLabel lblPackage = new JLabel("Package");
		lblPackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPackage.setBounds(10, 61, 132, 39);
		panel_2.add(lblPackage);
		
		JComboBox sltPackage_1 = new JComboBox();
		sltPackage_1.setModel(new DefaultComboBoxModel(new String[] {"Select Package", "1 - Excel", "2 - Adobe Photoshop", "3 - Adobe Premiere Pro", "4 - Photoshop & Premiere Pro", "5 - All 3 types"}));
		sltPackage_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sltPackage_1.setBackground(Color.WHITE);
		sltPackage_1.setBounds(129, 63, 241, 35);
		panel_2.add(sltPackage_1);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTime.setBounds(10, 111, 132, 39);
		panel_2.add(lblTime);
		
		JComboBox sltTime_1 = new JComboBox();
		sltTime_1.setModel(new DefaultComboBoxModel(new String[] {"Select Time", "Day Time", "Night Time"}));
		sltTime_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sltTime_1.setBackground(Color.WHITE);
		sltTime_1.setBounds(129, 113, 132, 35);
		panel_2.add(sltTime_1);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate.setBounds(10, 161, 132, 39);
		panel_2.add(lblDate);
		
		textDate = new JTextField();
		textDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textDate.setColumns(10);
		textDate.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textDate.setBackground(new Color(204, 255, 255));
		textDate.setBounds(129, 167, 243, 35);
		panel_2.add(textDate);
		
		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
					
				//for display register information in text area
				//for select day time or night time
				String t = "";
				if (sltTime_1.getSelectedItem().equals("Day Time")) 
					t = " This software training will be started from 10.00a.m.-13.00p.m.";
			
				else if (sltTime_1.getSelectedItem().equals("Night Time"))
					t = " This software training will be started from 19.00p.m.-22.00p.m.";
				
				
				//for select desire package and fee
				double fee;
				totalFee = "";
				double discount;
				PaymentF f = new TotalFee();

				if (sltPackage_1.getSelectedItem().equals("1 - Excel")) { 
					fee = 600;
					totalFee = (String.format("%.2f", fee));
				}
				else if (sltPackage_1.getSelectedItem().equals("2 - Adobe Photoshop")) { 
					fee = 1600;
					totalFee = (String.format("%.2f", fee));
				}
				else if (sltPackage_1.getSelectedItem().equals("3 - Adobe Premiere Pro")) { 
					fee = 2000;
					totalFee = (String.format("%.2f", fee));
				}
				else if (sltPackage_1.getSelectedItem().equals("4 - Photoshop & Premiere Pro")) { 
					fee = 1600 + 2000;
					totalFee = (String.format("%.2f", f.getPayment(fee)));
				}
				else if (sltPackage_1.getSelectedItem().equals("5 - All 3 types")) {
					fee = 600 + 1600 + 2000;
					discount = 0.05;
					totalFee = (String.format("%.2f", f.getPayment(fee,discount)));
				}
			
				//Display information to the table
				model.addRow(new Object[]{
					textName.getText(),
					sltPackage_1.getSelectedItem(),
					sltTime_1.getSelectedItem(),
					textDate.getText(),	
					totalFee,
				});
				
				JOptionPane.showMessageDialog(null, "Sales record add successfully.", "Sales System",
							JOptionPane.OK_OPTION);
			}
		});
		btnAdd_1.setForeground(Color.BLACK);
		btnAdd_1.setFont(new Font("Dialog", Font.BOLD, 20));
		btnAdd_1.setBackground(new Color(204, 204, 255));
		btnAdd_1.setBounds(263, 371, 140, 41);
		panel.add(btnAdd_1);
		
		JButton btnClear_1 = new JButton("Clear");
		btnClear_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textName.setText("");
				sltPackage_1.setSelectedItem("Select Package");
				sltTime_1.setSelectedItem("Select Time");
				textDate.setText("");
			}
		});
		btnClear_1.setForeground(Color.BLACK);
		btnClear_1.setFont(new Font("Dialog", Font.BOLD, 20));
		btnClear_1.setBackground(new Color(204, 204, 255));
		btnClear_1.setBounds(23, 371, 140, 41);
		panel.add(btnClear_1);
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int i = table.getSelectedRow();
			    if(i>=0) //if single row is selected than update
			    {
			    	
			    	model.setValueAt(textName.getText(), i, 0);
			    	model.setValueAt(sltPackage_1.getSelectedItem(), i, 1);
			    	model.setValueAt(sltTime_1.getSelectedItem(), i, 2);
					model.setValueAt(textDate.getText(), i, 3);
					model.setValueAt(totalFee, i, 4);
					
					JOptionPane.showMessageDialog(null, "Update Successfully");
			    
			    }
			    else 
			    {
			    	JOptionPane.showMessageDialog(null, "Please Select a Row First!");
			    }
			
			}
		});
		btnUpdate_1.setForeground(Color.BLACK);
		btnUpdate_1.setFont(new Font("Dialog", Font.BOLD, 20));
		btnUpdate_1.setBackground(new Color(204, 204, 255));
		btnUpdate_1.setBounds(23, 423, 140, 41);
		panel.add(btnUpdate_1);
		
		JLabel lblreturn_1 = new JLabel("");
		lblreturn_1.setBounds(931, 74, 55, 55);
		panel.add(lblreturn);
		lblreturn_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminMain am = new AdminMain();
				am.setVisible(true);
				dispose();
			}
		});
		lblreturn_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblreturn_1.setBorder(new LineBorder(Color.WHITE, 1, true));
		lblreturn_1.setBackground(Color.WHITE);
		lblreturn_1.setBounds(931, 74, 55, 55);
		lblreturn_1.setIcon(new ImageIcon(img_return));
		panel.add(lblreturn_1);
	}
	
	public static void AddRowToJtable(Object[] dataRow) {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.addRow(dataRow);
		
	}
}
