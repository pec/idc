/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idc;
import java.util.Date;
/**
 *
 * @author fridim
 */
public class Message {
  private Node sender;
  private long size;
  private Date date;
  private String str;
  private byte[] signature;
  
  public Message(String message, Node sender) {
    this.sender = sender;
    date = new Date();
    str = new String(message);
    
    // ici on calcule signature avec sender+date+str pour éviter les redondances
  }
}
