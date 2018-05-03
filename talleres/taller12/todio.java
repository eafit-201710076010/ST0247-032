public class Todio
{
       
 public static int numeroAtaque(int[] tablero) {
         int contador=0;
        for(int i = 0; i < tablero.length; i++)
            for(int j = i+1; j < tablero.length; j++)
                if (tablero[i] == tablero[j] || Math.abs(tablero[i] - tablero[j]) == Math.abs(i - j))
                    contador++; 
        return contador;

    }
    
    public static void
    taller_12(int nreinas){
        int [] arreglo= new int [nreinas];
        int papa= numeroAtaque(arreglo);
    }

    public static void aux(int [] papito){

    }
}
