
/**
 * Write a description of class ej_linea4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
public class ej_linea4
{
    // Basado en el ejercicio en linea por Mateo Florez
    public static void main (String args [])  throws IOException {
        //BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        Scanner lector=new Scanner(System.in);

        int n=0;
        int d=0;
        int r=0;
        ArrayList resp = new ArrayList<Integer>();

        /*int n=lector.nextInt();
        int d=lector.nextInt();
        int r=lector.nextInt();*/
        while (((n=lector.nextInt())!=0 && (d=lector.nextInt())!=0 && (r=lector.nextInt())!=0)){
            if ((n<=100)&&(d<=10000)&&(r<=5)){
                BufferedReader lector2 = new BufferedReader(new InputStreamReader(System.in));
                String rutaM= lector2.readLine();
                String[] duracionRutaM = rutaM.split(" ");
                String rutaT= lector2.readLine();
                String[] duracionRutaT = rutaT.split(" ");

                //horas totales recorridas de rutas
                int totalM=0;
                int totalT=0;
                for(int i=0; i<n; i++){
                    totalM+=Integer.parseInt(duracionRutaM[i]);
                    totalT+=Integer.parseInt(duracionRutaT[i]);
                }

                //valor de horas extra
                int valorM=(totalM-d)*r;
                int valorT=(totalT-d)*r;
                int elmeroTotal= valorM + valorT;

                resp.add(elmeroTotal);

                //System.out.println(elmeroTotal);
            }else{
                System.out.println("algunos datos no cumplen las condiciones dadas");
            }

        }

        for (int i=0; i<resp.size();i++){
            System.out.println(resp.get(i));
        }
    }
}
