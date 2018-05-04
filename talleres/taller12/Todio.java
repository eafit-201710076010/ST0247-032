
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
        while(numeroAtaque(nuevo)<papa){
            int j=numeroAtaque(arreglo);
            int al= numeroAtaque(nuevo);
            arreglo=nuevo.clone();
            papa=numeroAtaque(arreglo);
            nuevo=aux(arreglo,nreinas,papa);
        }
        return arreglo;
    }

    public static int[] aux(int [] padre,int nreinas,int papa){
        int [] nuevoPadre= padre.clone();
        int []temp= padre.clone();
        for(int i=0; i<nreinas; i++){

            for(int j=0; j<nreinas; j++){
                padre[i]=j;
                int hijo=numeroAtaque(padre);
                if(hijo<=papa){
                    int a=0;
                    nuevoPadre= padre.clone();
                    papa=hijo;
                }else{
                    nuevoPadre=nuevoPadre;
                }
                padre[i]=temp[i];
            }

        }
        return nuevoPadre;
    }
}
