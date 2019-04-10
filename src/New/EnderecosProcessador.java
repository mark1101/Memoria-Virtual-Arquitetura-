package New;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author mark_
 */
public class EnderecosProcessador {

    private String endereco;

    ArrayList<String> end = new ArrayList<>();

    public EnderecosProcessador() {
        end.add("0x00007132");
        end.add("0x00003612");
        end.add("0x00001301");
        end.add("0x00008627");
        end.add("0x00001091");
        end.add("0x00009132");
        end.add("0x00003642");
        end.add("0x00002308");
        end.add("0x00004657");
        end.add("0x00006096");
        
        //Collections.shuffle(end);
    }

    public String getEnd(int indice) {
        return end.get(indice);
    }

    public String getOffset(int j) {
        endereco = end.get(j);
        char[] offset = endereco.toCharArray();
        String offs = "0x";
        for (int i = 7; i < 10; i++) {
            offs += offset[i];
        }
        return offs;
    }

    public String getoTag(int j) {
        endereco = end.get(j);
        char[] tag = endereco.toCharArray();
        String tags = "";
        for (int i = 0; i < 7; i++) {
            tags += tag[i];
        }
        return tags;
    }

}
