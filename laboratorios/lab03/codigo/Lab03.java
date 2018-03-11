import java.util.Arrays;
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
        System.out.println(Arrays.toString(nReinas(32)));
        long finalTime = System.nanoTime()-startTime;
        System.out.println(finalTime);
    }

}