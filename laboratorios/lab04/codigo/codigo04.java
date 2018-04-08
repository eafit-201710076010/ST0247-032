import java.util.*;
/**
 * Write a description of class lab04 here.
 * 
 * @author Laura, Manuela, Felipe :) 
 * @version 1
 */
public class lab04
{
	//Punto 1.1
    public static int AgenteViajero(Digraph g) {
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
	//Punto 1.2
  public static void main(String [] args){
    DigraphAL g3 = new DigraphAL(4);
		g3.addArc(0, 0, 0);
		g3.addArc(0, 1, 7);
		g3.addArc(0, 2, 15);
		g3.addArc(0, 3, 6);
		g3.addArc(1, 0, 2);
		g3.addArc(1, 1, 0);
		g3.addArc(1, 2, 7);
		g3.addArc(1, 3, 3);
		g3.addArc(2, 0, 9);
		g3.addArc(2, 1, 6);
		g3.addArc(2, 2, 0);
		g3.addArc(2, 3, 12);
		g3.addArc(3, 0, 10);
		g3.addArc(3, 1, 4);
		g3.addArc(3, 2, 8);
		g3.addArc(3, 3, 0);
		System.out.println(AgenteViajero(g3));
    }

}
