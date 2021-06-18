package Assignment3;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserMain extends JPanel {

	private STDetails stdetails;
	private JLayeredPane layeredPane;
	/**
	 * Create the panel.
	 */
	public UserMain() {
		stdetails = new STDetails();
		stdetails.setSize(961, 439);
		stdetails.setLocation(0, 0);
		STDetails stdetails = new STDetails();
		stdetails.setBounds(0, 0, 961, 439);
		layeredPane.add(stdetails);
		
		setBackground(new Color(204, 255, 255));
		setBounds(0, 0, 961, 439);
		setLayout(null);
		
		JButton btnNewButton = new JButton("More");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_screen(stdetails);
			}
		});
		
		
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(51, 51, 204));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton.setToolTipText("Show more details");
		btnNewButton.setBounds(770, 25, 145, 46);
		add(btnNewButton);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(0, 0, 961, 439);
		add(layeredPane_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(30, 25, 695, 389);
		layeredPane_1.add(panel_2);
		
		JTextArea txtrwelcomeToChen = new JTextArea();
		txtrwelcomeToChen.setText(" _________Welcome to Chen Software Training Centre_________\r\n");
		txtrwelcomeToChen.setFont(new Font("Calibri", Font.BOLD, 23));
		txtrwelcomeToChen.setBounds(27, 22, 639, 27);
		panel_2.add(txtrwelcomeToChen);
		
		JTextArea txtrContactNoThere = new JTextArea();
		txtrContactNoThere.setText("\t\t                  Contact No:+604-5986302          ");
		txtrContactNoThere.setFont(new Font("Calibri", Font.PLAIN, 13));
		txtrContactNoThere.setBounds(27, 49, 639, 21);
		panel_2.add(txtrContactNoThere);
		
		JTextArea txtrThereAre = new JTextArea();
		txtrThereAre.setText(" There are 3 types of Software Training available at this moment.\r\n Select one of the packages:\r\n 1 - Excel\r\n 2 - Adobe Photoshop\r\n 3 - Adobe Premiere Pro\r\n 4 - Adobe Photoshop & Premiere Pro\r\n 5 - All 3 types \r\n");
		txtrThereAre.setFont(new Font("Calibri", Font.PLAIN, 17));
		txtrThereAre.setBounds(27, 85, 639, 153);
		panel_2.add(txtrThereAre);
		
		JTextArea txtrYouWillGet = new JTextArea();
		txtrYouWillGet.setText(" You will get 5.0% discount if you join all 3 of the software training.\r\n");
		txtrYouWillGet.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtrYouWillGet.setBounds(27, 263, 639, 21);
		panel_2.add(txtrYouWillGet);
		
		JTextArea txtrforMoreInformation = new JTextArea();
		txtrforMoreInformation.setText("\r\n *For more information and reference please visit \r\n  -https://www.facebook.com\r\n  -https://www.instagram.com\r\n");
		txtrforMoreInformation.setFont(new Font("Calibri", Font.PLAIN, 13));
		txtrforMoreInformation.setBounds(27, 277, 639, 70);
		panel_2.add(txtrforMoreInformation);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(null);
		panel_2_1.setBackground(new Color(25, 25, 112));
		panel_2_1.setBounds(23, 20, 695, 389);
		layeredPane_1.add(panel_2_1);
	}
	
	public void Switch_screen(JPanel p) {
		layeredPane.removeAll();
		layeredPane.add(p);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

}
