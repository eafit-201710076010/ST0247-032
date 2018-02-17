

/**
 * 
 * 
 * @author Manuela Valencia, Laura Sánchez 
 
public class Taller03 {    
//basado en http://codegists.com/snippet/java/nqueensjava_ajayramesh23_java

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
    public static int contador=0;  

    public static int nReinas(int n) {
        int contador=0;
        int[] tablero= new int[n];
        contador=contador + nReinas(0, tablero.length,tablero);
        return contador;
    }

    private static int nReinas(int r, int n, int[] tablero) {

        for (int c = 0; c < n; c++) {
            if (puedoPonerReina(r, c,tablero)) {
                tablero[r] = c;
                if (r == n - 1) {
                    contador++;
                } else {
                    nReinas(r + 1, n,tablero);
                }
            }
        }
        return contador;
    }

    public static void imprimirTablero(int[] tablero) {
        int n = tablero.length;
        System.out.print("    ");
        for (int i = 0; i < n; ++i)
            System.out.print(i + " ");
        System.out.println("\n");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + "   ");
            for (int j = 0; j < n; ++j)
                System.out.print((tablero[i] == j ? "Q" : "#") + " ");
            System.out.println();
        }
        System.out.println();
    }

    
    public static ArrayList<Integer> camino(Digraph g, int inicio, int fin) {
        ArrayList <Integer>camino=new ArrayList<Integer>();
        boolean pasos[]= new boolean[g.size()];
        dfs (g, inicio, fin, pasos, camino);
        return camino;
    }

    // recomendacion
    private static boolean dfs(Digraph g, int nodo, int objetivo, boolean[] visitados, ArrayList<Integer> list) {
        ArrayList<Integer> successors=g.getSuccessors(nodo);

        if (nodo==objetivo){
            return true;
        }
        else{

            for(int i=0; i<successors.size(); i++){
                    visitados[successors.get(i)]=true;
                    list.add(nodo);
                    dfs(g,successors.get(i),objetivo, visitados, list);
                }   

        }
        return false;
    }

    public static void main (String [] args){
        DigraphAM dg = new DigraphAM(7);
        dg.addArc(0, 1, 5);
        dg.addArc(1, 4, 3);
        dg.addArc(0, 4, 9);
        dg.addArc(3, 6, 7);
        Taller3.camino(dg, 0, 6);

    }

}
