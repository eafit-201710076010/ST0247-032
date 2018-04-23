import java.util.ArrayList;

/**
 * Implementacion de un grafo dirigido usando matrices de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, <su nombre>
 */
public class DigraphAM extends Digraph {
	// complete...
	Float [][] matrix;
        String [] inf;
	public DigraphAM(int size) {
		super(size);
		// complete...
		matrix = new Float[size][size];
		inf= new String [size];
	}
	public void AddInfo(int vertex ,String info){
	   inf[vertex]=info;
	   }
	   public  String getInfo(int vertex){
	       return inf[vertex];
	   }

	public void addArc(int source, int destination, Float weight) {
		// complete...
		
		// recuerde: grafo dirigido!
		matrix[source][destination] = weight;
	}

	public ArrayList<Integer> getSuccessors(int vertex) {
		// complete...
		ArrayList<Integer> s = new ArrayList<>();
		for (int i = 0; i < size; ++i)
			if (matrix[vertex][i] != 0)
				s.add(i);
		return s.size() == 0 ? null : s;
	}

	public Float getWeight(int source, int destination) {
		// complete...
		return matrix[source][destination];
	}

}
