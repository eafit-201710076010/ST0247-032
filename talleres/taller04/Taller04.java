import java.util.*;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #4
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller4 {

    /*public static int recorrido(Digraph g) {
    // complete...
    }

    // recomendacion
    private static int recorrido(Digraph g, int v, int[] unvisited) {
    // complete...
    }

    // recomendacion
    private static int[] removeAt(int k, int a[]) {
    // complete...
    }

    public static int costoMinimo(Digraph g, int inicio, int fin) {
    // complete...
    }

    // recomendacion
    private static void dfs(Digraph g, int v, int[] costo) {

    }*/

    //HAY CAMINO ENTRE DOS NODOS DFS
    public static boolean hayCaminoDfs(Digraph g,int nodo, int objetivo){
        boolean pasos[]= new boolean[g.size()];
        ArrayList <Integer>camino=new ArrayList<Integer>();
        return dfss(g,nodo, objetivo,pasos,camino);
    }
     static boolean a=false;
    private static boolean dfss(Digraph g, int nodo, int objetivo, boolean[] visitados, ArrayList<Integer> list) {
        
        visitados[nodo] = true;
        list.add(nodo);
        ArrayList<Integer> sucesores = g.getSuccessors(nodo);
        if(nodo==objetivo){
            a=true;
            return true;
                         }
        if (sucesores != null){
            for(Integer sucesor: sucesores){
                if (!visitados[sucesor])// vi[sucesor] != false
                    dfss(g,sucesor,objetivo,  visitados,list); 
                    
            }}
        return a;
        
    }
    //CAMINO ENTRE DOS NODOS BFS
    public static boolean hayCaminoBfs(Digraph g,int nodo, int objetivo){
        boolean pasos[]= new boolean[g.size()];
        ArrayList <Integer>camino=new ArrayList<Integer>();
        return bfs(g,nodo, objetivo,pasos,camino);
    }

    private static boolean bfs(Digraph g, int nodo, int objetivo, boolean[] visitados, ArrayList<Integer> list) {
        Queue <Integer> q= new LinkedList<Integer>();
        q.add(nodo);
        list.add(nodo);
        while(!q.isEmpty()){
            int actual = q.poll();
            if(actual==objetivo)
                return true;
            visitados[actual] = true; 
            ArrayList<Integer>    sucesores = g.getSuccessors(actual);
            if (sucesores != null){
                for(Integer sucesor: sucesores){
                    if (!visitados[sucesor]) {// vi[sucesor] == false
                        q.add(sucesor);
                        list.add(sucesor);}
                }

            } 

        }

        return false;         
    }

    //RECORRIDO DFS      

    public static ArrayList<Integer> dfsRetornador(Digraph g, int v){
        boolean[] vi = new boolean[g.size()];
        ArrayList<Integer> respuesta = new ArrayList<Integer>();
        dfsRetornador(g, v, respuesta, vi);
        return respuesta;
    }     

    private static void dfsRetornador(Digraph g, int v,ArrayList<Integer> l, boolean[] vi){
        vi[v] = true;
        l.add(v);
        ArrayList<Integer> sucesores = g.getSuccessors(v);
        if (sucesores != null){
            for(Integer sucesor: sucesores){
                if (!vi[sucesor]) // vi[sucesor] != false
                    dfsRetornador(g,sucesor, l, vi); 
            }}
        return;
    }

    //RECORRIDO BFS
    public static ArrayList<Integer> bfsRetornador(Digraph g, int v){
        boolean[] vi = new boolean[g.size()];
        ArrayList<Integer> respuesta = new ArrayList<Integer>();
        bfsRetornador(g, v, respuesta, vi);
        return respuesta;
    }     

    private static void bfsRetornador(Digraph g, int v,ArrayList<Integer> l, boolean[] vi){
        Queue <Integer> q= new LinkedList<Integer>();
        q.add(v);
        l.add(v);
        while(!q.isEmpty()){
            int actual = q.poll();
            vi[actual] = true; 
            ArrayList<Integer>    sucesores = g.getSuccessors(actual);
            if (sucesores != null){
                for(Integer sucesor: sucesores){
                    if (!vi[sucesor]) {// vi[sucesor] == false
                        q.add(sucesor);
                        l.add(sucesor);}
                }

            } 

        }

             
    }	

    public static void main(String [] args){
        DigraphAL g = new DigraphAL(4);
        g.addArc(0,1,1);
        g.addArc(1,3,1);
        g.addArc(0,2,1);
        g.addArc(3,0,1);
        System.out.println(hayCaminoDfs(g,0,3));
    }

}
