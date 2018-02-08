import java.util.*;

/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, Manuela valencia, Laura Sánchez 
 */
public class DigraphAL extends Digraph {
        // complete
        private ArrayList <LinkedList<Pair<Integer,Integer>>> lista;

        public DigraphAL(int size) {
                super(size);
                lista = new ArrayList <LinkedList<Pair<Integer,Integer>>>();
                for(int i=0; i<size; i++){
                LinkedList <Pair<Integer,Integer>> lista2 = new LinkedList <Pair<Integer, Integer>>();
                lista.add(lista2);
                }
        }

        public void addArc(int source, int destination, int weight) {
                // complete...
                Pair <Integer, Integer> pair = new Pair (destination, weight);
                lista.get(source).add(pair);
                // recuerde: grafo dirigido!
        }

        public ArrayList<Integer> getSuccessors(int vertex) {
                // complete...
                // recuerde: null si no hay!
                ArrayList Successors = new ArrayList<Integer>();
                LinkedList<Pair<Integer,Integer>> l_inside =lista.get(vertex);
                for(int i=0; i<l_inside.size(); i++){
                Pair var = l_inside.get(i); 
                if(var!=null){
                int val_s = (int)var.first;
                Successors.add(val_s);
                }else
                break;
                
                }
                if (Successors.size()==0) return null;
                else
                Collections.sort(Successors);
                
                return Successors;
        }

        public int getWeight(int source, int destination) {
                // complete...
                LinkedList<Pair<Integer,Integer>> l_inside =lista.get(source);
                Pair var2=null;
                for(int i=0; i<l_inside.size(); i++){
                 var2= l_inside.get(i);
                if ((int)var2.first==destination)
                break;
            
            }
              return (int)var2.second;
               
        }
    }