import java.util.*;

/**
 * Implementacion de un grafo dirigido usando matrices de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, <su nombre>
 */
public class DigraphAM extends Digraph {
    // complete...

    int [][] matrizG;
    public DigraphAM(int size) {
        super(size);
        matrizG= new int [size][size];

    }

    public void addArc(int source, int destination, int weight) {
        matrizG [source][destination] = weight;
    }

    public ArrayList<Integer> getSuccessors(int vertex) {
        // recuerde: null si no hay!
        ArrayList Successors = new ArrayList<Integer>();
        for(int i=0; i<size; i++){
            int ps=matrizG[vertex][i];
            if (ps!=0){
                Successors.add(i);
            }

        }

        if (Successors.size()==0)
            return null;
        else{
            Collections.sort(Successors);
        }

        //recorrer la fila del vértice y guardar los valores diferentes de cero, posteriormente organizar la lista
        return Successors;
    }

    public int getWeight(int source, int destination) {
        return matrizG[source][destination];
    }

}
