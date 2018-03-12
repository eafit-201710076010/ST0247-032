import java.util.*;
public class Lab03 {    
    //basado en http://codegists.com/snippet/java/nqueensjava_ajayramesh23_java

    //PUNTO 1.1
    private static boolean puedoPonerReina(int r, int c, int[] tablero) {
        // complete...
        for (int i = 0; i < r; i++) {
            if (tablero[i] == c || (i - r) == (tablero[i] - c) ||(i - r) == (c - tablero[i])) 
            {
                return false;
            }
        }
        return true;
    }

    public static int[] nReinas(int n) {

        int[] tablero= new int[n];
        return nReinas(0, tablero.length,tablero) ? tablero  : null;

    }

    private static boolean nReinas(int r, int n, int[] tablero) {
        for (int c = 0; c < n; c++) {
            if (puedoPonerReina(r, c,tablero)) {
                tablero[r] = c;
                if (r == n - 1) {
                    return true;
                } else if(nReinas(r + 1, n,tablero)){
                    return true;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(Arrays.toString(nReinas(5)));
        long finalTime = System.nanoTime()-startTime;
        System.out.println(finalTime);

        Digraph g2 = new DigraphAM(12);
        g2.addArc(5,11,1);
        g2.addArc(11,2,2);
        g2.addArc(7,11,5);
        g2.addArc(7,8,6);
        g2.addArc(11,9,3);
        g2.addArc(11,10,4);
        g2.addArc(3,8,7);
        g2.addArc(3,10,8);
        g2.addArc(8,9,9);
        //System.out.println(caminoCortoDFS(g2,5,10));

        DigraphAL g3 = new DigraphAL(4);
        g2.addArc(0,1,1);
        g2.addArc(0,2,2);
        g2.addArc(0,3,5);
        g2.addArc(1,0,6);
        g2.addArc(1,2,3);
        g2.addArc(1,3,4);
        g2.addArc(3,0,7);
        g2.addArc(3,1,8);
        g2.addArc(3,2,9);
        System.out.println(hayCaminoDfs(g3,1,3));
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
        vi[v] = true;
        q.add(v);
        l.add(v);
        while(!q.isEmpty()){
            int actual = q.poll();
            vi[actual] = true;
            ArrayList<Integer>  sucesores = g.getSuccessors(actual);
            if (sucesores != null){
                for(Integer sucesor: sucesores){

                    if (!vi[sucesor]) {// vi[sucesor] == false
                        vi[sucesor] = true;
                        q.add(sucesor);
                        l.add(sucesor);}
                }

            }

        }

    }	
    //HAY CAMINO ENTRE DOS NODOS DFS
    public static ArrayList<Integer>hayCaminoDfs(Digraph g,int nodo, int objetivo){
        ArrayList<Integer> aux = new ArrayList<>();
        int distancias[] = new int[g.size];
        for (int i = 0; i < distancias.length; i++) {
            distancias[i] = Integer.MAX_VALUE;
        }
        distancias [nodo]=0;

        boolean pasos[]= new boolean[g.size()];
        ArrayList <Integer>camino=new ArrayList<Integer>();

        return dfss(g,nodo, objetivo,pasos,camino, distancias,aux,0);

    }

    private static ArrayList<Integer> dfss(Digraph g, int nodo, int objetivo, boolean[] visitados, ArrayList<Integer> list,int []costos,ArrayList<Integer> aux, int in) {

        visitados[nodo] = true;
        list.add(nodo);
        ArrayList<Integer> sucesores = g.getSuccessors(nodo);
        if(nodo==objetivo){
            if(in<costos[0]){
                costos[0]=in;
                list=(ArrayList)aux.clone();

            } 
            else
                return list;
        }

        if (sucesores != null){
            for(Integer sucesor: sucesores){
                if (!visitados[sucesor]){// vi[sucesor] != false
                    visitados[sucesor]=true;
                    int pes=g.getWeight(nodo, sucesor);
                    dfss(g,sucesor,objetivo,  visitados,list, costos, aux, pes);
                }

            }
        }
        return list;
    }

}