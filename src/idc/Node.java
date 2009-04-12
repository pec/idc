/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idc;


import javax.crypto.*;

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
  private String public_key;
  private String private_key;
  private Vector secret_keys;//vecteur de clefs secrète correspondant à chaque conversation privée
  private Vector connection;// qui est un vecteur de FriendNode
  

  public Message decode(Message msg){
    return msg;
  }

  public Node(String nickname, String id) {
        if (nickname == null || nickname.length() <= 0) {
            nickname = "Anonymous";
        }
        
        this.nickname = new String (nickname);
        this.id = new String(id);
        
        integrity();
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
	assert(connection.capacity()>0);  
	assert(id != null);
        assert(nickname.length() > 0);
        assert(id.length() == 32); // SHA256
    }
}
