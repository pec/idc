package idc;

import java.util.*;
import idc.FriendNode;
import javax.crypto.*;

public class Data_Node {
	private String public_key;
	private String private_key;
	private Vector secret_keys;//vecteur de clefs secrète correspondant à chaque conversation privée
	private Vector connection;// qui est un vecteur de FriendNode

	
	
	/**
	 * 
	 * @param msg le message codé
	 * @return le message décodé 
	 * 
	 * la clef ne doit jamais être accessible par les getters, la fonction de décodage se charge de tout.
	 */
	public Message decode(Message msg){
	return msg;
	}
	
	private void integrity(){
		assert(connection.capacity()>0);
	}	
	
	public Data_Node(){
		
	}

}
