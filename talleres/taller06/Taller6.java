import java.util.*;
/**
 * Clase en la cual se implementan los metodos del Taller de Clase #6
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller6 {

	public static int cambioGreedy(int n, int[] denominaciones) {
		return 0;
	}

	
		public static int recorrido(Digraph g) {
        int v=0;
        int verticesucesor=0;
        int costo=0;
        int pesosucesor=0;
        for(int j=0;j<g.size();j++){
            ArrayList<Integer> sucesores= g.getSuccessors(v);
            verticesucesor=sucesores.get(0);
            pesosucesor=g.getWeight(v,verticesucesor);
            for(int i=1; i<sucesores.size(); i++){
                verticesucesor=sucesores.get(i);
                if(g.getWeight(v,verticesucesor)<pesosucesor){
                    verticesucesor= sucesores.get(i);
                    pesosucesor=g.getWeight(v,verticesucesor);
                }	
                
            }
            costo=costo+pesosucesor;
            v=verticesucesor;
            //verticesucesor=0;
            //pesosucesor=0;
        }
         costo=costo+ g.getWeight(verticesucesor,0);
         return costo;
    }
	}


