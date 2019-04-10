package New;

import java.util.*;

/**
 *
 * @author mark_
 */
public class EnderecoVirtual {

    private String offset = "";
    private String PaginaV = "";

    public EnderecoVirtual(String paginaV, String offset) {
        this.offset = offset;
        this.PaginaV = paginaV;
    }

    public String getOf() {
        return offset;
    }
    
    public String getEndereco(){
        return PaginaV;
    }

}
