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
        g2.addArc(11,2,1);
        g2.addArc(7,11,1);
        g2.addArc(7,8,1);
        g2.addArc(11,9,1);
        g2.addArc(11,10,1);
        g2.addArc(3,8,1);
        g2.addArc(3,10,1);
        g2.addArc(8,9,1);
        System.out.println(bfsRetornador(g2,7));

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
            //vi[actual] = true;
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

}