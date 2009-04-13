/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idc;

import java.util.*;
import javax.crypto.KeyGenerator;
import javax.crypto.KeyGeneratorSpi;
import java.security.*;
import java.security.spec.*;
import java.math.*;

/**
 *
 * @author fridim
 * 
 * Cette classe identifie un noeud du réseau. Selon le cahier des charges, 
 * un noeud est identifié par un nickname et par un id.
 */
public class Node {
  private String nickname;
  private String id;
  private byte[] key;	
  
  

  public Node(String nickname) {
	  	
        if (nickname == null || nickname.length() <= 0) {
            nickname = "Anonymous";
        }
        
        this.id=new String("id");
        this.nickname = new String (nickname);
        
  }
    
    public String getNickname() {
        integrity();
        return nickname;
    }
    
    public String getId() {
        integrity();
        return id;
    }
    
    protected void integrity() {
        
    	assert(nickname != null);  
        assert(id != null);
        assert(nickname.length() > 0);
        }
}
