/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idc;

import java.security.*;

/**
 *
 * @author fridim
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Node my_node=new Node("el-indio");
        try{
        System.out.println("Node "+my_node.getNickname()+" created with the id : "+my_node.getId().sign().toString());
        }catch(SignatureException err){
        	System.out.println(err);
        	}
        }
        
        new IDCManager();
    }


}
