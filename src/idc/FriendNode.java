/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idc;
import idc.Node;
/**
 *
 * @author fridim
 * 
 * On ajoute à Node une adresse pour pouvoir s'y connecter. Il s'agit d'une
 * connexion directe.
 */
public class FriendNode extends Node {
    private String address;
    
    public FriendNode(String nickname, String id, String address) {
        super(nickname, id);
        
        this.address = address;
        integrity();
    }
    
    protected void integrity() {
        super.integrity();
        
        assert(address != null);
        assert(address.length() > 0);
    }
    
    
}