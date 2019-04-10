package New;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author mark_
 */
public class Memoria {

    private ArrayList<String> tabela = new ArrayList<String>();
    private ArrayList<String> tabela2 = new ArrayList<String>();
    private ArrayList<String> tabela3 = new ArrayList<String>();
    private String PV[] = new String[10];
    private String PF[] = new String[10];

    private String PV2[] = new String[20];
    private String PF2[] = new String[20];

    private String PV3[] = new String[30];
    private String PF3[] = new String[30];

    private String DISCO[] = new String[0];

    private ArrayList<String> vaiTLB = new ArrayList<String>();
     private ArrayList<String> vaiTLB2 = new ArrayList<String>();
      private ArrayList<String> vaiTLB3 = new ArrayList<String>();

    Random r = new Random();

    int aa = r.nextInt(10);

    private int cont = 0;

    EnderecosProcessador cache = new EnderecosProcessador();

    int b = 9;
    int contDisco = 0;
    int disco = 0;

    public void criaTabela(String[] tags) {
        disco++;
        for (int i = 0; i < 10; i++) {
            PV[i] = tags[i];
            PF[i] = "0x" + "000" + i;
            if (i == b) {

                vaiTLB.add("DISCO");
                tabela.add(PV[i] + " " + "DISCO");

                contDisco = i;

            } else {

                tabela.add(PV[i] + " " + PF[i]);
                vaiTLB.add(PF[i]);

            }
        }
    }
    int a = 100;
    public void criaTabela2(String[] tags) {
        
        for (int i = 0; i < 10; i++) {
            PV2[i] = tags[i];
            PF2[i] = "0x" + "00"+(i+10);
            if (i == aa) {

                vaiTLB2.add("DISCO");
                tabela2.add(PV2[i] + " " + "DISCO");
                contDisco = i;

            } else {

                tabela2.add(PV2[i] + " " + PF2[i]);
                vaiTLB2.add(PF2[i]);

            }
        }
    }

    public void criaTabela3(String[] tags) {
        int z = 100;
        for (int i = 0; i < 10; i++) {
            PV3[i] = tags[i];
            PF3[i] = "0x" + "00" +(i+20);
            if (i == z) {

                vaiTLB3.add("DISCO");
                tabela3.add(PV3[i] + " " + "DISCO");

                contDisco = i;

            } else {

                tabela3.add(PV3[i] + " " + PF3[i]);
                vaiTLB3.add(PF3[i]);

            }
        }
    }
    public void mostraTabela1() {

        System.out.println("");
        System.out.println("- TABELA DE MAPEAMENTO 1-");

        for (int i = 0; i < 10; i++) {
            System.out.println(tabela.get(i));
        }

    }

    public void mostraTabela2() {

        System.out.println("");
        System.out.println("- TABELA DE MAPEAMENTO 2-");

        for (int i = 0; i < 10; i++) {
            System.out.println(tabela2.get(i));
        }

    }

    public void mostraTabela3() {

        System.out.println("");
        System.out.println("- TABELA DE MAPEAMENTO 3-");

        for (int i = 0; i < 10; i++) {
            System.out.println(tabela3.get(i));
        }

    }
    ArrayList<Integer> num = new ArrayList<Integer>();
    
    
    public String Busca(String tag) {
       
        num.add(1);
        num.add(2);
        num.add(3);
        Collections.shuffle(num);
        
        for (int i = 0; i < 10; i++) {
            String indice = PV[i]; // indice recebe os elementos de pagina virtual da memoria
            String var = tag; // var recebe o indice aonde eu vou ver se é igual oque esta na memoria

            char[] ram = indice.toCharArray(); // indice é a tag que eu tenho na RAM 
            char[] cache = var.toCharArray(); // var é minha tag de procura 
            String TLB = "";
            
            if (cache[6] == ram[6]) {
               System.out.println("TRADUZIDA A TABELA -> " +num.get(0));
                if (num.get(0) == 1)
                {
                    TLB = vaiTLB.get(i); // vai tlb recebe sempre meu endereco virtual para setar na tlb e passar para FISICO 
                }
                if (num.get(0) == 2)
                {
                   TLB =  vaiTLB2.get(i);
                }
                if (num.get(0) == 3)
                {
                    TLB = vaiTLB3.get(i);
                }
                return TLB;
            }
        }
        return "0";
    }
}
