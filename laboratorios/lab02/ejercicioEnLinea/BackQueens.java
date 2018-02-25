
/**
 * Write a description of class BackQueens here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//basado en https://github.com/eafit-201710150010/ST0247-032/blob/master/laboratorios/lab02/ejercicioEnLinea/Lab2.java
import java.util.*;
public class BackQueens

{
    static int hueco [][];
    public static void main(String [] args) {
        ArrayList<Integer> casos = new ArrayList<Integer>();
        String a;
        Scanner s = new Scanner (System.in); 
        int q; 
        q = s.nextInt();

        while(q!=0){
            hueco= new int [q][q];
            for(int i=0; i<q;i++){
                a=s.next();
                for(int j=0; j<q;j++){

                    if (a.charAt(j)=='*'){
                        hueco[i][j]=-1;
                    }
                }
            }
            casos.add(nReinas(q));
            q=s.nextInt();
            contador=0;
        }

        for (int k=0; k<casos.size();k++){
                System.out.println("Case "+(k+1)+": "+casos.get(k));
            
        }

    }

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

    private static int nReinas(int n) {
        int contador=0;
        int[] tablero= new int[n];
        contador=contador + nReinas(0, tablero.length,tablero);
        return contador;
    }

    private static int nReinas(int r, int n, int[] tablero) {

        for (int c = 0; c < n; c++) {
            if(hueco[r][c]!=-1){
                if (puedoPonerReina(r, c,tablero)) {
                    tablero[r] = c;
                    if (r == n - 1) {
                        contador++;
                    } else {
                        nReinas(r + 1, n,tablero);
                    }
                }
            }
        }
        return contador;
    }
}

