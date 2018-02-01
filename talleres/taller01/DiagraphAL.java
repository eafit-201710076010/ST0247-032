
import java.util.ArrayList;
/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, <su nombre>
 */
import java.util.*;
public class DigraphAL extends Digraph {
	 //private LinkedList<LinkedList<Integer>> peso;
         private LinkedList grafo;
 private LinkedList pesos;
	 public DigraphAL(int size) {
		super(size);
		grafo= new LinkedList<LinkedList>();
		for(int i=0;i<=size-1;i++){
		   pesos = new LinkedList<Pair>();
		  grafo.add(pesos);
		  }
	}

	public void addArc(int source, int destination, int weight) {
		Pair pair = new Pair(destination,weight);
		grafo.add(source,pair);	
		
	}

	public ArrayList<Integer> getSuccessors(int vertex) {
	
	   }

	public int getWeight(int source, int destination) {
	   return 0;	   
        }
    }
