
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

    public static int []
    taller_12(int nreinas){
        int [] arreglo= new int [nreinas];
        int papa= numeroAtaque(arreglo);
        int[] nuevo= aux(arreglo,nreinas,papa);
        while(numeroAtaque(nuevo)<numeroAtaque(arreglo)){
            arreglo=nuevo;
            papa=numeroAtaque(arreglo);
            nuevo=aux(arreglo,nreinas,papa);
        }
        return arreglo;
    }

    public static int[] aux(int [] papito,int nreinas,int papa){
        int [] nuevopapi= new int [nreinas] ;
        for(int i=0; i<nreinas; i++){
            
            for(int j=0; j<nreinas; j++){
                papito[i]=j;
                int hijo=numeroAtaque(papito);
                if(hijo<=papa){
                    nuevopapi= papito;
                }

            }
            
        }
        return nuevopapi;
    }
}
