package idc;


import java.io.*;
//import javax.jms; utilisation des JMS

public class Message implements Cipherable{
	private long size;
	private File file;//fichier à envoyer
	private String str;
	
	public Message(File my_file){
		
		try{
		file=my_file.getAbsoluteFile();
		str="Envoie du fichier "+file.getName();
		}catch(SecurityException err){
			System.out.println(err);
		}
		
		size=file.length();
	}
	
	public Message(String msg){
		str=msg; 
	}
	
}