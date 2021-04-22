
import java.util.*; 

public class Ques1 { 
	
	public static int c = 0;
	public static Scanner sc;
	
	public static class ProducerConsumer { 
		  
        LinkedList<Integer> list = new LinkedList<>(); 
        
  
        public void produce() throws InterruptedException { 
            int itemAdd = 0;
            
            while (true) { 
                synchronized (this) 
                { 
                    while (list.size() == c) 
                        wait(); 
  
                    System.out.println("Item produced-" + itemAdd); 
                    
                    list.add(itemAdd++); 
  
                    notify(); 
  
                    Thread.sleep(500); 
                } 
            } 
        } 
  
        public void consume() throws InterruptedException { 
            int itemDel;
        	
        	while (true) { 
                synchronized (this) 
                { 
                    while (list.size() == 0) 
                        wait(); 
  
                    itemDel = list.removeFirst(); 
  
                    System.out.println("Item consumed-" + itemDel); 
  
                    notify(); 
  
                    Thread.sleep(500); 
                } 
            } 
        } 
    } 
	
    public static void main(String[] args) throws InterruptedException {
    	
    	System.out.print("Enter the size of queue : ");
    	sc = new Scanner(System.in);
    	c = sc.nextInt();
    	
    	ProducerConsumer x = new ProducerConsumer(); 
  
        Thread t1 = new Thread(new Runnable() { 
        	
            public void run() 
            { 
                try { 
                    x.produce(); 
                } 
                catch (InterruptedException e) { 
                    e.printStackTrace(); 
                } 
            } 
        }); 
        
        
        Thread t2 = new Thread(new Runnable() { 
        	
            public void run() 
            { 
                try { 
                    x.consume(); 
                } 
                catch (InterruptedException e) { 
                    e.printStackTrace(); 
                } 
            } 
        }); 
  
        
        t1.start(); 
        t2.start(); 
  
        t1.join(); 
        t2.join();
        sc.close();
    }    
} 