/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package New;

import java.util.ArrayList;

/**
 *
 * @author mark_
 */
public class Disco {
    
    ArrayList<String> dados = new ArrayList<String>();
    
    
    
    public Disco(String indice) {
        dados.add(0,indice);
    }
    
    public void MostraDisco() {
        System.out.println(" ---- Disco ---");
            System.out.println(dados.get(0));
        
    }
    
}
