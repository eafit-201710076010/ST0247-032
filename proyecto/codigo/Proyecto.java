
import java.util.*;
import java.io.*;
class Proyecto
{
    private static /*ArrayList<Integer>*/void elVecinoMasCercanoParaTSP(Digraph g)
    {
        int posicionDondeEstaElDeposito = 0;
        int verticeActual = posicionDondeEstaElDeposito;
    }  

    public static Digraph leer(String filename) throws IOException
    {
        FileReader fr = new FileReader(filename);
        BufferedReader lector = new BufferedReader(fr);
        int n=0,m=0, u=0, breaks =0; 
        Float r=0f, speed=0f, Tmax,Smax, st_custumer, Q =0f;
        String linea1,linea; 
                

                   linea = lector.readLine();

            String[] lineaPartida = linea.split(" ");
            int [] lospri=new int[4];
           float[] losseg=new float[6];
        
         for(int i=1; i<=10; i++){
              lineaPartida = linea.split(" ");
           if (i<=4){
           lospri[i-1]=Integer.parseInt(lineaPartida[2]);
           }else{
           losseg[i-5]=Float.parseFloat(lineaPartida[2]);          
           }
             linea=lector.readLine();
         }
         n=lospri[0];
         Digraph g = new DigraphAM(n);
         Pair<Float,Float>[] arreglo = new Pair[n];
             linea=lector.readLine();
              linea=lector.readLine();
               linea=lector.readLine();
            //while (linea != null) 
            lineaPartida = linea.split(" ");
     for(int i=0; i<n; i++)   {
        arreglo[i] = new Pair(Float.parseFloat(lineaPartida[2]),Float.parseFloat(lineaPartida[3]));
       linea=lector.readLine();
        lineaPartida = linea.split(" ");
    }
         for(int i=0; i<n; i++){
              for(int j=0;j<n;j++){
                  g.addArc(i,j,((float)Math.sqrt(
                                Math.pow(arreglo[i].first-arreglo[j].first,2) +
                                Math.pow(arreglo[i].second-arreglo[j].second,2)
                            )));
                }
                
                }
                
            /*if (linea.contains("Coordinates")){
            linea=lector.readLine();
              linea=lector.readLine();
            */
           
                            
         
 
      return g;
    }
    public static void main(String[] args) throws IOException
    {
        Digraph g = leer("tc2c320s38ct1.txt");
      // ArrayList<Integer> solucion = elVecinoMasCercanoParaTSP(g);

    }

}
