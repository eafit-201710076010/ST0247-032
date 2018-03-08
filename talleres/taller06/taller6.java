import java.util.ArrayList;
import java.util.Arrays;
/**
 * This class contains algorithms for digraphs
 * Adapted from: http://cs.fit.edu/~ryan/java/programs/graph/Dijkstra-java.html
 * @author Mauricio Toro
 * @version 1
 */
public class taller6
{   
    
   public static int recorrido(Digraph g) {
        int v=0;
        int verticesucesor=0;
        int costo=0;
        int pesosucesor=0;
        boolean[] visitados = new boolean[g.size()];
        for(int j=0;j<g.size()-1;j++){
            ArrayList<Integer> sucesores= g.getSuccessors(v);
            visitados[v] = true;
            verticesucesor=-1;
            pesosucesor= Integer.MAX_VALUE;
            for(int i=0; i<sucesores.size(); i++){
                if(g.getWeight(v,sucesores.get(i))<pesosucesor && !visitados[sucesores.get(i)]){
                    verticesucesor= sucesores.get(i);
                    pesosucesor=g.getWeight(v,verticesucesor);
                }    
            }
            costo=costo+pesosucesor;
            v=verticesucesor;
        }
         costo=costo+ g.getWeight(verticesucesor,0);
         return costo;
  }
}