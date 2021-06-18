package Assignment3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Container;

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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

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

public class Finance extends JFrame {
	
	private Image img_close = new ImageIcon(Home.class.getResource("closebtn.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image img_return = new ImageIcon(Home.class.getResource("return.png")).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
	
	private JPanel contentPane;
	private JTextField txtName;
	private JComboBox sltType;
	private JComboBox sltTime;
	protected JFrame frame;
	private JTextField txtTotal;
	protected String salary;
	private JTextField totalstudent;
	private JTextField totalclass;
	protected double totalSalary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Finance frame = new Finance();
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
	public Finance() {
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
		btnPrint.setBounds(630, 15, 140, 41);
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
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(234, 15, 140, 41);
		panel_1_1.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int i = table.getSelectedRow();
			    if(i>=0) //if single row is selected than update
			    {
			    	
			    	model.setValueAt(txtName.getText(), i, 0);
			    	model.setValueAt(sltType.getSelectedItem(), i, 1);
			    	model.setValueAt(totalstudent.getText(), i, 2);
					model.setValueAt(totalclass, i, 3);
					model.setValueAt(totalSalary, i, 4);
					
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
		
		JButton btnFinance = new JButton("Finance");
		btnFinance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Finance fin = new Finance();
				//fin.setVisible(true);
				//Finance.txtsalary.setText(totalSalary);
			   
			}
		});
		btnFinance.setForeground(Color.BLACK);
		btnFinance.setFont(new Font("Dialog", Font.BOLD, 20));
		btnFinance.setBackground(new Color(204, 204, 255));
		btnFinance.setBounds(23, 15, 140, 41);
		panel_1_1.add(btnFinance);
		
		JLabel lblNewLabel_1 = new JLabel("Finance");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 26));
		lblNewLabel_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(23, 74, 240, 54);
		panel.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(23, 139, 380, 211);
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
		txtName.setBounds(154, 17, 218, 35);
		panel_2.add(txtName);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblType.setBounds(10, 61, 132, 39);
		panel_2.add(lblType);
		
		sltType = new JComboBox();
		sltType.setModel(new DefaultComboBoxModel(new String[] {"Select Type", "Excel", "Adobe Photoshop", "Adobe Premiere Pro"}));
		sltType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sltType.setBackground(Color.WHITE);
		sltType.setBounds(152, 63, 218, 35);
		panel_2.add(sltType);
		
		JLabel lblStudent = new JLabel("Total Students");
		lblStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStudent.setBounds(10, 111, 132, 39);
		panel_2.add(lblStudent);
		
		totalstudent = new JTextField();
		totalstudent.setFont(new Font("Tahoma", Font.PLAIN, 15));
		totalstudent.setColumns(10);
		totalstudent.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		totalstudent.setBackground(new Color(204, 255, 255));
		totalstudent.setBounds(153, 111, 219, 35);
		panel_2.add(totalstudent);
		
		JLabel lblClass = new JLabel("Total Classes");
		lblClass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClass.setBounds(10, 152, 132, 39);
		panel_2.add(lblClass);
		
		totalclass = new JTextField();
		totalclass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		totalclass.setColumns(10);
		totalclass.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		totalclass.setBackground(new Color(204, 255, 255));
		totalclass.setBounds(153, 158, 219, 35);
		panel_2.add(totalclass);
		
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
		txtTotal.setBounds(789, 443, 174, 35);
		panel.add(txtTotal);
		
		JLabel lblName_1 = new JLabel("Net Profit   : RM");
		lblName_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName_1.setBounds(617, 441, 240, 39);
		panel.add(lblName_1);
		
		JButton btnNewButton = new JButton("Add Records");
		btnNewButton.setBounds(246, 361, 157, 41);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				//for select type and fee
				double fee = 0;
				Payment s = new TotalSalary(); // create a new object 

				if (sltType.getSelectedItem().equals("Excel")) { 
					fee = 600;
				}
				else if (sltType.getSelectedItem().equals("Adobe Photoshop")) { 
					fee = 1600;
				}
				else if (sltType.getSelectedItem().equals("Adobe Premiere Pro")) { 
					fee = 2000;
				}
				
				//for calculate total salary
				int n = Integer.parseInt(totalclass.getText());
				salary = (String.format("%.2f", s.getPayment(fee,n)));
				
				//Display information in table
				model.addRow(new Object[]{
						txtName.getText(),
						sltType.getSelectedItem(),
						totalstudent.getText(),
						totalclass.getText(),	
						salary,
					});
				
				
			    // iterate over all columns
			    for (int i = 0 ; i < model.getRowCount() ; i++) {
			        // null or not Integer will throw exception
			        String slr = String.valueOf(model.getValueAt(i, 4));
			        
			        totalSalary += Double.parseDouble(slr);
			    }
			    
			    txtTotal.setText(String.valueOf(totalSalary));
			    
				JOptionPane.showMessageDialog(null, "You have successfully registered.", "Registration System",
							JOptionPane.OK_OPTION);
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(204, 204, 255));
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(23, 361, 140, 41);
		panel.add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				sltType.setSelectedItem("Select Type");
				totalstudent.setText("");
				totalclass.setText("");	
			}
		});
		btnClear.setForeground(new Color(0, 0, 0));
		btnClear.setFont(new Font("Dialog", Font.BOLD, 20));
		btnClear.setBackground(new Color(204, 204, 255));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(428, 139, 537, 293);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(488, 0, -66, 36);
		panel_3.add(label_1);
		
		JLabel lblNewLabel_2 = new JLabel("RM");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(318, 0, 104, 23);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("RM");
		lblNewLabel_2_1.setBounds(433, 0, 104, 23);
		panel_3.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_2_2 = new JLabel("RM");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_2.setBounds(204, 0, 104, 23);
		panel_3.add(lblNewLabel_2_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(204, 26, 104, 256);
		panel_3.add(panel_4);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBounds(318, 26, 104, 256);
		panel_3.add(panel_4_1);
		
		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setBounds(432, 26, 104, 256);
		panel_3.add(panel_4_1_1);
		
		JLabel label = new JLabel("New label");
		label.setBounds(428, 139, 537, 22);
		panel.add(label);
		
	}
	
}