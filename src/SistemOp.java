
import New.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author mark_
 */
public class SistemOp {

    public static void cls() {
        for (int i = 0; i < 5; i++) {
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Memoria m = new Memoria();
        EnderecosProcessador c = new EnderecosProcessador();
        TLB tlb = new TLB();
        PaginaFisica pagFiisica = new PaginaFisica();
        Cache cache = new Cache();
        EnderecoVirtual pagV[] = new EnderecoVirtual[10];
        String[] tag = new String[10];
        DadosRam ram = new DadosRam();

        // m.carregaVetores();
        for (int i = 0; i < 10; i++) {
            pagV[i] = new EnderecoVirtual(c.getoTag(i), c.getOffset(i));
        }
        for (int i = 0; i < 10; i++) {
            tag[i] = c.getoTag(i); // tag para contruir tabela
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("");

        int contador = 0;
        for (int i = 0; i < 10; i++) {

            cls();
            System.out.println("");
            pagFiisica.setOffset(c.getOffset(i));
            if (i >= 1) {
                System.out.println("ENDERECO DE INICIO :" + c.getEnd(i - 1));
            }
            m.criaTabela(tag);
            m.criaTabela2(tag);
            m.criaTabela3(tag);
            
            //m.mostraTabela1();
            //m.mostraTabela2();
            //m.mostraTabela3();
            
            tlb.mostraTLB();

            System.out.println("");

            System.out.println("");

            System.out.println("1 - SIMULAR ENDEREÇOS");
            System.out.println("2 - TERMINAR ");
            System.out.println("3 - MOSTRAR RAM");
            System.out.println("4 - MOSTRA CACHE");

            int verifica;

            do {
                verifica = scan.nextInt();
            } while (verifica < 1 || verifica > 4);

            if (verifica == 1) {
                tlb.BuscaTLB(tag, c.getoTag(i));
            }
            if (verifica == 2) {
                System.exit(0);
            }
            if (verifica == 3) {
                cls();
                ram.mostraRam();
                i--;
            }
            if (verifica == 4) {
                cls();
                if (contador <= 2) {
                    System.out.println("IMPOSSIVEL VIZUALIZAR A CACHE NO MOMENTO");
                    contador--;
                    i--;
                } else {
                    ram.jogaCache();
                    i--;
                }
            }
            contador++;
        }
    }
}
