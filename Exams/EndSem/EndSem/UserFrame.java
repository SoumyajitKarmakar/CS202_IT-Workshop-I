package EndSem;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import EndSem.Server.Student;

public class UserFrame {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub


	}

}

class UserGUI extends JFrame{
	JTextField tfName;
	JTextField tfRoll;
	JTextArea ta;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	
	public void connectReadName(String s) throws IOException{
	
		Socket socket = new Socket("localhost", 1234);
	
	
//		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
	
		output.writeObject(s);
		output.flush();
	}
	
	public void connectReadRoll(int n) throws IOException{
		
		Socket socket = new Socket("localhost", 1234);
	
	
//		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
	
		output.writeObject(n);
		output.flush();
	}
	
	public UserGUI() {
		
		tfName = new JTextField("Enter Name");
		tfRoll = new JTextField("Enter Roll");
		
		ta = new JTextArea();
		ta.setBounds(70, 150, 200, 70);
		
		tfName.setBounds(130, 40, 200, 30);
		tfRoll.setBounds(130, 40, 200, 30);
		
		tfName.setVisible(false);
		tfRoll.setVisible(false);
		ta.setVisible(false);
		
		b1 = new JButton("By Roll No.");
		b1.setBounds(130, 80, 100, 40);
		
		b2 = new JButton("By Name");
		b2.setBounds(130, 120, 100, 40);
		
		b3 = new JButton("Submit");
		b3.setBounds(130, 130, 100, 40);
		
		b4 = new JButton("Submit");
		b4.setBounds(130, 1300, 100, 40);
		
		add(tfName);
		add(tfRoll);
		add(ta);
		add(b1);
		add(b2);
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tfRoll.setVisible(true);
			}
		});
		
		
		b2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tfName.setVisible(true);
			}
		});
		
		
		
	}
	//View details by roll number, View details by name
}