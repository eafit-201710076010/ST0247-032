
/**
 * Write a description of class taller12 here.
 * 
 * @author (your name) 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * @version (a version number or a date)
 */

public class taller12
{
    static int contador=0;
    private static boolean numeroataque(int r, int c, int[] tablero) {
        // complete...

        for (int i = c; i < r; i++) {
            if (tablero[i] == c || (i - r) == (tablero[i] - c) ||(i - r) == (c - tablero[i])) 
            {
                contador++;

            }
        }
        return true;
    }

    public static void
    taller_12(int nreinas){
        int [] arreglo= new int [nreinas];
        //   arreglo[1]=1;
        for(int j=0;j<nreinas;j++)
            for(int i=0; i<nreinas; i++){
                numeroataque(j,i,arreglo);
            }
        int a=0;
    }

    public static void aux(int [] papito){

    }
}
