import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #5
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller5 {

    public static boolean mColoring(Digraph g, int m) {
        int colors[]=new int[m];
        
    }

    // recomendacion
    private static boolean isSafe(Digraph g, int v, int[] colors, int c) {
        ArrayList<Integer> losSucesoresDelVerticeVenElGrafoG = g.getSuccessors(v);
        for (Integer vecino:  losSucesoresDelVerticeVenElGrafoG){
            if(vecino<v){
                if (colors[vecino] == c){
                    return false;
                }
            }

        }
        return true;
    }

    // recomendacion
    private static boolean mColoring(Digraph g, int v, int[] colors, int m) {
        if(isSafe(g, v, colors,))
        if (v ==g.size())
          return true;
        else
          return mColoring(g,v+1,colors,m);
    }

}