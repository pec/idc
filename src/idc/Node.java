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
  private PublicKey public_key;
  private PrivateKey private_key;
  private Vector secret_keys;//vecteur de clefs secrète correspondant à chaque conversation privée
  private IDCManager connection;
  private byte[] key;

  public Message decode(Message msg){
    integrity();
    return msg;
  }

            
  public Node(String nickname, String id) {
    if (nickname == null || nickname.length() <= 0) {
      nickname = "Anonymous";
    }
        
        
    this.nickname = new String (nickname);
        
    RSAPublicKeySpec public_key_spec = new RSAPublicKeySpec(new BigInteger("10941738641570527421809707322040357612003732945449205990913842131476349984288934784717997257891267332497625752899781833797076537244027146743531593354333897"),new BigInteger("65537"));
    RSAPrivateKeySpec private_key_spec =new RSAPrivateKeySpec(new BigInteger("10941738641570527421809707322040357612003732945449205990913842131476349984288934784717997257891267332497625752899781833797076537244027146743531593354333897"),new BigInteger("65537"));
        
    try{
      KeyFactory KeyFact=KeyFactory.getInstance("RSA");
        
      public_key=KeyFact.generatePublic(public_key_spec);
      private_key=KeyFact.generatePrivate(private_key_spec);
      data=public_key.toString().getBytes();
      
      id = Signature.getInstance("SHA1withRSA");
      id.initSign(private_key);
      
      /* Update and sign the data */
      id.update(data);
      byte[] sig = id.sign();
      
      id.initVerify(public_key);
	
      /* Update and verify the data */
      id.update(data);
      boolean verifies = id.verify(sig);
      System.out.println("Signature :"+data);
      System.out.println("signature verifies: " + verifies);
        
    }
    catch(SignatureException err){
      System.out.println(err);
    }
    catch(NoSuchAlgorithmException  err){
      System.out.println(err);
    }
    catch(InvalidKeySpecException err){
      System.out.println(err);
    }
    catch(InvalidKeyException err){
      System.out.println(err);
    }
        
    integrity();
        
  }
    
  public String getNickname() {
    integrity();
    return nickname;
  }
  
  public Signature getId() {
    integrity();
    return id;
  }
    
  // vérifie que la signature de la clef publique correspond bien à l'id
  public boolean checkKey() {
    // TODO
    return true;
  }
    
  public void send(Message message) {
    assert(message != null);
    /* C'est le manager qui choisi le noeud ami (connexion directe) pour
     * envoyer le message. Ce dernier va ensuite être routé */
    IDCManager.send(this, message);
  }

  protected void integrity() {
    /*
      assert(nickname != null);  
      assert(id != null);
      assert(nickname.length() > 0);*/
  }
}
