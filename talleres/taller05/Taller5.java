import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #5
 *
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller5 {

    public static boolean mColoring(Digraph g, int m) {
        int colors[]=new int[g.size()];
    return mColoring(g, 0, colors, m);    
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
        if (v ==g.size()) // Condicion de parada
          return true;
        else { // v != g.size()
            for (int c = 0; c < m; c++)
               if(isSafe(g, v, colors,c))
                    return mColoring(g,v+1,colors,m);
            return false;
        }
    }

}
