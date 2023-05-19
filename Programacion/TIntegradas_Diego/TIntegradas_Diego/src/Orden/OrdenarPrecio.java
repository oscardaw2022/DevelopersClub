package Orden;

import java.util.Comparator;
import Modelos.*;

public class OrdenarPrecio implements Comparator<oferta>{

    @Override
    public int compare(oferta arg0, oferta arg1) {
        // TODO Auto-generated method stub
        if(arg0.getPrecio()==arg1.getPrecio()){        
            if( arg0.getNmegas() > arg1.getNmegas()) {
            	return -1;
            }
        }
        if(arg0.getPrecio()<arg1.getPrecio()){
            return -1;
        }
        return 1;
    }

}