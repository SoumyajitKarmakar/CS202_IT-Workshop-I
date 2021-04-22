package EndSem;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class WelcomeFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Frame1 f = new Frame1();
	}
	

}


class Frame1 extends JFrame{
	public Frame1() {
		
		
		
		JButton b1 = new JButton("Admin");
		b1.setBounds(130, 100, 100, 40);
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AdminGUI();
			}
		});
		
		JButton b2 = new JButton("User");
		b2.setBounds(130, 130, 100, 40);
		b2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new UserGUI();
			}
		});
		
		add(b1);
		add(b2);
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}