package rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CbfServer {
	public static void main(String[] args) {

		try{
        	LocateRegistry.createRegistry(1099);
        	System.out.println("LocateRegistry OK");
            
        	Cbf cbf = new CbfServant();        	
            System.out.println("After create");
			
            Naming.bind("Cbf", cbf);
            System.out.println("CBF ready");
        
		}catch(Exception e) {
            System.out.println("CBF server main " + e.getMessage());
        }
		
		
	}
}
