import java.util.ArrayList;


 /** Clase abstracta para la implementacion de grafos dirigidos
 *
 * @author Mauricio Toro, Mateo Agudelo
 */
public abstract class Digraph {
	protected int size,size2;

	public Digraph(int vertices,int vertices2) {
		size = vertices;
		size2=vertices2;
	}

	public abstract void addArc(int source, int destination, Float weight);

	public abstract ArrayList<Integer> getSuccessors(int vertex);

	public abstract Float getWeight(int source, int destination);
	
	public abstract void AddInfo(int vertex, String info);
	public abstract String getInfo(int vertex);
	
	public int size() {
		return size;
	}
}
