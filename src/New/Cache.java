package New;

import java.util.ArrayList;

/**
 *
 * @author mark_
 */
public class Cache {

    public static String[] enderecoi = new String[2];

    public void mostraCache() {
        System.out.println("");
        System.out.println("- CACHE DE DISCO ULTIMOS USADOS -");
        for (int i = 0; i < enderecoi.length; i++) {
            System.out.println(enderecoi[i]);
        }
        System.out.println("");
    }
    int contador1 = 0;
    

    public void guardaCache(String vemR1, String vemR2) {
        enderecoi[0] = vemR1;
        enderecoi[1] = vemR2;
    }
    
    String[] hit1 = new String[2];
    String[] hit2 = new String[2];
    
    public int  verificaHitCache(String indice)
    {
       if (contador1 < 2)
       {
           hit1[contador1] = indice;
       }else{
           contador1 = 0;
           if (indice == hit1[0] || indice == hit2[1])
           {
               System.out.println("HIT NA CACHE !");
               return 1;
           }
       }
       contador1++;
       return 0;
    }
    
}
