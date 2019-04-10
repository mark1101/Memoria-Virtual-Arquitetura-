package New;

import New.*;
import java.util.ArrayList;

/**
 *
 * @author mark_
 */
public class TLB {

    ArrayList<String> pagFisica = new ArrayList<String>();
    ArrayList<String> tagTLB = new ArrayList<String>();

    String pagF[] = new String[2];
    String tagT[] = new String[2];

    Memoria ram = new Memoria();

    public void setTag(int aonde, String tag) {
        
        tagT[aonde] = tag;
    }

    public void setPagFisica(int aonde, String pagFi) {
       
        pagF[aonde] = pagFi;
    }
    int contadorPrin = 0;

    public void mostraTLB() {
        if (contadorPrin == 0) {
            pagF[0] = "null";
            pagF[1] = "null";
            tagT[0] = "null  ";
            tagT[1] = "null  ";
        } else {
            System.out.println("----- TLB -----");
            for (int i = 0; i < tagT.length; i++) {
                System.out.println(tagT[i] + " " + pagF[i]);
            }
        }
        contadorPrin++;
    }

    int contador = 0;
    int verifica1 = 0;
    int verifica2 = 0;

    DadosRam ramm = new DadosRam();
    PaginaFisica paginaFisica = new PaginaFisica();
    Cache cache = new Cache();

    public void BuscaTLB(String[] vem, String tag) {

        contador++;
        verifica1++;
        System.out.println("");
        System.out.println("");
        if (contador > 1) {
            verifica2++;
        }

        ram.criaTabela(vem);
        ram.criaTabela2(vem);
        ram.criaTabela3(vem);

        String tagTemTLB1 = tagT[0];
        String tagTemTLB2 = tagT[1];

        if (tag.equals(tagTemTLB1) || tag.equals(tagTemTLB2)) {

            if (tag.equals(tagTemTLB1)) {
                verifica1 = 0;
                paginaFisica.setPagina(pagF[0]);
            } else if (tag.equals(tagTemTLB2)) {
                verifica2 = 0;
                paginaFisica.setPagina(pagF[1]);
            }
            System.out.println("-> HIT NA TLB");
            
            pagF[0] = "0x0022";
            

        } else {
            System.out.println("-> MISS NA TLB ! ");
            
            String recebe;
            recebe = ram.Busca(tag); // recebe contem meu endereco fisico que foi procurado
           if (recebe.equals("DISCO"))
           {
               System.out.println("FALTA DE PAGINAS !!!!!!!!!!!!!!!!!!!!");
           }
            if (recebe != "0") {
                if (contador > 2) {
                    System.out.println("-> LRU NA TLB ");
                    if (verifica1 > verifica2) {
                        verifica1 = 0;
                        cache.verificaHitCache(recebe);
                        
                        paginaFisica.setPagina(recebe);
                      
                        pagF[0] = recebe;
                        tagT[0] = tag;
                    } else {
                        verifica2 = 0;
                        paginaFisica.setPagina(recebe);
                        cache.verificaHitCache(recebe);
                    
                        pagF[1] = recebe;
                        tagT[1] = tag;
                    }
                } else {
                    if (contador == 1) {
                        paginaFisica.setPagina(recebe);
                      
                        pagF[0] = recebe;
                        tagT[0] = tag;
                    }
                    if (contador == 2) {
                        paginaFisica.setPagina(recebe);
                       
                        pagF[1] = recebe;
                        tagT[1] = tag;
                    }
                }
            }
        }
    }
}
