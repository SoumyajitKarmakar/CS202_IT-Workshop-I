package EndSem;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import EndSem.Server.*;

public class AdminFrame {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub


	}

}

class AdminGUI extends JFrame {
	JTextField tfName;
	JTextField tfRoll;
	JTextField tfAge;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JButton b6;
	
	
	public void connectWrite(Student stu) throws IOException{
		ObjectOutputStream output = null;
		
		try {
			Socket socket = new Socket("localhost", 1234);
			
			
			
			
//			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			output = new ObjectOutputStream(socket.getOutputStream());
		}
		catch(Exception e){
			System.out.print("connection error");
		}
		output.writeObject(stu);
		output.flush();
	}
	
	
	
	
//	output.writeUTF(strCli);
//	output.flush();
//	strSer = input.readUTF();
	
	
	public AdminGUI() {
		
		tfName = new JTextField("Enter Name");
		tfRoll = new JTextField("Enter Roll No.");
		tfAge = new JTextField("Enter Age");
		
		tfName.setBounds(130, 40, 200, 30);
		tfRoll.setBounds(130, 70, 200, 30);
		tfAge.setBounds(130, 100, 200, 30);
		
		tfName.setVisible(false);
		tfRoll.setVisible(false);
		tfAge.setVisible(false);
		
		add(tfName);
		add(tfRoll);
		add(tfAge);
		
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		b1 = new JButton("Add");
		b1.setBounds(130, 60, 100, 40);
		
		
		b2 = new JButton("Delete");
		b2.setBounds(130, 90, 100, 40);
		
		
		b3 = new JButton("Modify");
		b3.setBounds(130, 120, 100, 40);
		
		b4 = new JButton("Submit");
		b4.setBounds(130, 100, 200, 30);
		b4.setVisible(false);
		
		
		
		b5 = new JButton("Submit");
		b5.setBounds(130, 130, 200, 30);
		b5.setVisible(false);
		
		
		
		b6 = new JButton("Submit");
		b6.setBounds(130, 130, 200, 30);
		b6.setVisible(false);
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tfName.setVisible(true);
				tfRoll.setVisible(true);
				tfAge.setVisible(true);
				b4.setVisible(true);
				b1.setVisible(false);
				b2.setVisible(false);
				b3.setVisible(false);
			}
		});
		b2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tfName.setVisible(true);
				b5.setVisible(true);
				b1.setVisible(false);
				b2.setVisible(false);
				b3.setVisible(false);
			}
		});
		b3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tfName.setVisible(true);
				tfRoll.setVisible(true);
				tfAge.setVisible(true);
				b6.setVisible(true);
				b1.setVisible(false);
				b2.setVisible(false);
				b3.setVisible(false);
			}
		});
		
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s = tfName.getText();
				int r = Integer.parseInt(tfRoll.getText());
				int a = Integer.parseInt(tfAge.getText());
				
				Student stu = new Student(s, r, a);
				
				try {
					connectWrite(stu);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

			}
			
		});
		
		b5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		b6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
		//Add details, Delete details, Modify details
	}
}