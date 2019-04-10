package New;

import java.util.ArrayList;

/**
 *
 * @author mark_
 */
public class PaginaFisica {
    
    String[] jogaRam = new String[5];
    
    String PF;
    String[] OF = new String[1];

    public void setOffset(String offsetVirtual) {
        OF[0] = offsetVirtual;
    }
    
    public void setPagina(String indice)
    {
        imprimeFisico(indice);
        PF = indice;
    }
    
    int contador = 0;
    EnderecosProcessador end = new EnderecosProcessador();
    DadosRam ram = new DadosRam();
    
    public void imprimeFisico(String indice) {
        if (contador >= 0) {
            System.out.println("  PAGINA FISICA ");
 
            System.out.println("---------------------");
            System.out.println("|" +indice+ " | " + end.getOffset(contador) +"|");
            System.out.println("---------------------");
            ram.carregaRam(indice);
        }    
        contador++;
        
    }

}
