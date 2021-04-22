

import java.io.*;
import java.net.*;
import java.nio.file.*;

public class Ques1Server {

	public static long countLines(String s) {
		long count = 0;
		try {
		      
		      Path file = Paths.get(s);

		      
		      count = Files.lines(file).count();
		     

		} 
		catch (Exception e) {
		      e.getStackTrace();
		}
		return count;
	}
	
	public static long countChar(String st) 
	   {
	      File f1 = new File(st); 
	      String[] words = null;
	      long wc = 0;
	      try {
	    	  FileReader fr = new FileReader(f1);
		      BufferedReader br = new BufferedReader(fr);
		      String s;
		      while((s = br.readLine()) != null)
		      {
		         words = s.split(" ");
		         wc = wc + words.length;
		      }
		      fr.close();
	      }
	      catch(Exception e) {
	    	  
	      }
	      return wc;
	   }
	
	public static String findFile(String name,File file)
    {
        File[] list = file.listFiles();
        String s;
        
        if(list != null)
        for (File fil : list)
        {
            if (name.equalsIgnoreCase(fil.getName()))
            {
                s = new String(fil.getAbsolutePath());
                return s;
            }
        }
        
        return null;
    }
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the server directory to search :  ");
		String directory = br.readLine();
		
		ServerSocket server = new ServerSocket(1234);
		System.out.println("Waiting for client to connect........");
		Socket connection = server.accept();
		System.out.println("Client Connected.......");
		
		DataInputStream input = new DataInputStream(connection.getInputStream());
		DataOutputStream output = new DataOutputStream(connection.getOutputStream());
		
		String s;
		
		String strCli = "", strSer = "";
		
		while(!strCli.equals("stop") || !strSer.equals("stop")) {
			strCli = input.readUTF();
			System.out.println("Client says : " + strCli);
			
			s = findFile(strCli,new File(directory));
			
			if(s != null) {
				strSer = s + "\nWord Count : " + countChar(s) + "\nLine Count : " + countLines(s);
			}
			else {
				strSer = "File not found please enter a valid name.";
			}
			
			
			output.writeUTF(strSer);
			output.flush();
		}
		
		input.close();
		connection.close();
		server.close();
		
	}

}
