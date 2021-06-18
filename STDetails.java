package Assignment3;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class STDetails extends JPanel implements PaymentF{

	/**
	 * Create the panel.
	 */
	public STDetails() {
		setBackground(new Color(204, 255, 255));
		setBounds(0, 0, 961, 439);
		setLayout(null);
		setVisible(true);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(30, 25, 695, 389);
		add(panel_2);
		
		JTextArea txtrThereAre = new JTextArea();
		txtrThereAre.setText(" Please select the package that you wish to know better.\r\n");
		txtrThereAre.setFont(new Font("Calibri", Font.BOLD, 20));
		txtrThereAre.setBounds(27, 36, 639, 35);
		panel_2.add(txtrThereAre);
		
		JTextArea txtrThereAre_1 = new JTextArea();
		txtrThereAre_1.setText(" There are 3 types of Software Training available at this moment.\r\n Select one of the packages:\r\n 1 - Excel\r\n 2 - Adobe Photoshop\r\n 3 - Adobe Premiere Pro\r\n 4 - Adobe Photoshop & Premiere Pro\r\n 5 - All 3 types \r\n");
		txtrThereAre_1.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtrThereAre_1.setBounds(27, 96, 639, 153);
		panel_2.add(txtrThereAre_1);
		
		JTextArea txtrYouWillGet = new JTextArea();
		txtrYouWillGet.setText(" You will get 5.0% discount if you join all 3 of the software training.\r\n");
		txtrYouWillGet.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtrYouWillGet.setBounds(27, 260, 639, 21);
		panel_2.add(txtrYouWillGet);
		
		JTextArea txtrforMoreInformation = new JTextArea();
		txtrforMoreInformation.setText("\r\n *For more information and reference please visit \r\n  -https://www.facebook.com\r\n  -https://www.instagram.com\r\n");
		txtrforMoreInformation.setFont(new Font("Calibri", Font.PLAIN, 13));
		txtrforMoreInformation.setBounds(27, 274, 639, 70);
		panel_2.add(txtrforMoreInformation);
		
		JLabel txtDetails = new JLabel("");
		txtDetails.setBounds(27, 36, 639, 307);
		panel_2.add(txtDetails);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(null);
		panel_2_1.setBackground(new Color(25, 25, 112));
		panel_2_1.setBounds(23, 20, 695, 389);
		add(panel_2_1);
		
		JButton btnNewButton = new JButton("More");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(51, 51, 204));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton.setToolTipText("Show more details");
		btnNewButton.setBounds(770, 25, 145, 46);
		add(btnNewButton);
		
		JComboBox pac = new JComboBox();
		pac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double fee;
				double totalFee;
				double discount;
				PaymentF f = new TotalFee();
				
				if (pac.getSelectedItem().equals("Select a package")) {
					txtrThereAre.setText(" Please select the package that you wish to know better.\r\n");
					txtrThereAre_1.setText(" There are 3 types of Software Training available at this moment.\r\n Select one of the packages:\r\n 1 - Excel\r\n 2 - Adobe Photoshop\r\n 3 - Adobe Premiere Pro\r\n 4 - Adobe Photoshop & Premiere Pro\r\n 5 - All 3 types \r\n");
					txtrYouWillGet.setText(" You will get 5.0% discount if you join all 3 of the software training.\r\n");
					txtrforMoreInformation.setText("\r\n *For more information and reference please visit \r\n  -https://www.facebook.com\r\n  -https://www.instagram.com\r\n");
				}
				else if (pac.getSelectedItem().equals("1")){
					fee = 600;
					totalFee = fee;
					
					txtDetails.append("\nExcel" + 
									  "\nThis is a 2 day training (3 hours per day)." + 
									  "\nThe participant will be able to learn:" + "\n- the tutorial on how to use Excel"
										+ "\n- calculate finance report " +
										"Conduct by               : Ahmad" +
										String.format("Total Fee                : RM %.2f", totalFee));
				}
			}
		});
		pac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pac.setModel(new DefaultComboBoxModel(new String[] {"Select a package", "1", "2", "3", "4", "5"}));
		pac.setBackground(new Color(255, 255, 255));
		pac.setBounds(753, 88, 177, 35);
		add(pac);
		
	/*	if (pac.getSelectedItem().equals("Select a package")) {
			txtrThereAre.setText(" Please select the package that you wish to know better.\r\n");
			txtrThereAre_1.setText(" There are 3 types of Software Training available at this moment.\r\n Select one of the packages:\r\n 1 - Excel\r\n 2 - Adobe Photoshop\r\n 3 - Adobe Premiere Pro\r\n 4 - Adobe Photoshop & Premiere Pro\r\n 5 - All 3 types \r\n");
			txtrYouWillGet.setText(" You will get 5.0% discount if you join all 3 of the software training.\r\n");
			txtrforMoreInformation.setText("\r\n *For more information and reference please visit \r\n  -https://www.facebook.com\r\n  -https://www.instagram.com\r\n");
		}
		else {
			
			txtrThereAre.setVisible(false);
			txtrThereAre_1.setVisible(false);
			txtrYouWillGet.setVisible(false);
			txtrforMoreInformation.setVisible(false);
			
			txtDetails.setText(pac.getSelectedItem());
		}*/
		
	}
	
/*	public void setText(String type) {
		double fee;
		double totalFee;
		double discount;
		PaymentF f = new TotalFee();
		
		if (type == "1") {
			System.out.println("Excel");
			System.out.println("This is a 2 day training (3 hours per day).");
			System.out.println("The participant will be able to learn:" + "\n- the tutorial on how to use Excel"
					+ "\n- calculate finance report ");
			
			fee = 600;
			totalFee = fee;
			System.out.println("Conduct by               : Ahmad" );
			System.out.printf("Total Fee                : RM %.2f", totalFee);
			
		} else if (type == "2") {
			System.out.println("Adobe Photoshop");
			System.out.println("This is a 6 days training (3 hours per day).");
			System.out.println("The participant will be able to learn:" + "\n- the tutorial of editing photo"
					+ "\n- designing poster");
			
			fee = 1600;
			totalFee = fee;
			System.out.println("Conduct by               : Jakson Lee");
			System.out.printf("Total Fee                : RM %.2f", totalFee);
			
		} else if (type == "3") {
			System.out.println("Adobe Premiere Pro");
			System.out.println("This is a 6 days training (3 hours per day).");
			System.out.println("The participant will be able to learn:" + "\n- the tutorial of editing video"
					+ "\n- adding effects on the video");
			
			fee = 2000;
			totalFee = fee;
			System.out.println("Conduct by               : Vincen");
			System.out.printf("Total Fee                : RM %.2f", totalFee);
			
		} else if (type == "4") {
			//details for photoshop
			System.out.println("Adobe Photoshop");
			System.out.println("This is a 6 days training (3 hours per day).");
			System.out.println("The participant will be able to learn:" + "\n- the tutorial of editing photo"
					+ "\n- designing poster");
			
			System.out.println("Conduct by               : Jakson Lee");
			System.out.println();
			
			//details for premiere pro
			System.out.println("Adobe Premiere Pro");
			System.out.println("This is a 6 days training (3 hours per day).");
			System.out.println("The participant will be able to learn:" + "\n- the tutorial of editing video"
					+ "\n- adding effects on the video");
			
			System.out.println("Conduct by               : Vincen");
			
			//total fee
			System.out.println();
			fee = 1600 +2000;//1600 for photoshop , 2000 for premiere pro
			System.out.printf("Total Fee                : RM %.2f", f.getPayment(fee));
			
		} else if (type == "5") {
			//details for excel
			System.out.println("Excel");
			System.out.println("This is a 2 day training (3 hours per day).");
			System.out.println("The participant will be able to learn:" + "\n- the tutorial on how to use Excel"
					+ "\n- calculate finance report ");
			
			System.out.println("Conduct by               : Ahmad");
			System.out.println();
			
			//details for photoshop
			System.out.println("Adobe Photoshop");
			System.out.println("This is a 6 days training (3 hours per day).");
			System.out.println("The participant will be able to learn:" + "\n- the tutorial of editing photo"
					+ "\n- designing poster");
			
			System.out.println("Conduct by               : Jakson Lee");
			System.out.println();
			
			//details for premiere pro
			System.out.println("Adobe Premiere Pro");
			System.out.println("This is a 6 days training (3 hours per day).");
			System.out.println("The participant will be able to learn:" + "\n- the tutorial of editing video"
					+ "\n- adding effects on the video");
			
			System.out.println("Conduct by               : Vincen");
			
			//total fee
			System.out.println();
			fee = 600 + 1600 + 2000; //600 for excel, 1600 for photoshop , 2000 for premiere pro
			discount = 0.05;
			System.out.printf("Total Fee                : RM %.2f", f.getPayment(fee,discount));
			}
			
		} */
		public double getPayment(double f) { //Method implementation
			double totalF = f-20; //join 2 classes of software training will get RM20 cash back
			return totalF; 
		}
		
		public double getPayment(double f, double d) { //Method implementation
			double totalF = (f -30) * (1-d);//join 3 classes of software training will get RM30 cash back and 5% discount
			return totalF; 
		
	}
}
