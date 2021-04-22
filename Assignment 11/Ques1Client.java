

import java.io.*;
import java.net.*;

public class Ques1Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("Connecting to a server.........");
		Socket socket = new Socket("localhost", 1234);
		
		
		DataInputStream input = new DataInputStream(socket.getInputStream());
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strCli = "", strSer = "";
		
		System.out.println("Connected with a server. Write stop to end the conversation.");
		
		while(!strCli.equals("stop") || !strSer.equals("stop")) {
			strCli = br.readLine();
			output.writeUTF(strCli);
			output.flush();
			strSer = input.readUTF();
			System.out.println("Server says : " + strSer);
		}
		
		output.close();
		socket.close();
		
	}

}
