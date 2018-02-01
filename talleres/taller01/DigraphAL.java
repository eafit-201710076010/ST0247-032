import java.util.*;

/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, Manuela valencia, Laura Sánchez 
 */
public class DigraphAL extends Digraph {
        // complete
        LinkedList lista = new LinkedList <LinkedList>();

        public DigraphAL(int size) {
                super(size);
                for(int i=0; i<size; i++){
                LinkedList lista2 = new LinkedList <Pair>();
                lista.add(lista2);
                }
        }

        public void addArc(int source, int destination, int weight) {
                // complete...
                Pair pair = new Pair(destination, weight);
                lista.add(source, pair);
                // recuerde: grafo dirigido!
        }

        public ArrayList<Integer> getSuccessors(int vertex) {
                // complete...
                // recuerde: null si no hay!
                ArrayList Successors = new ArrayList<Integer>();
                LinkedList l_inside =lista.get(vertex);
                
                return Successors;
        }

        public int getWeight(int source, int destination) {
                // complete...
                return 0;
        }

}

