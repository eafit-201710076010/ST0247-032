import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * Implementación del algoritmo para ruteo de vehículos eléctricos
 * @author Manuela Valencia, Laura Sánchez, Felipe Olaya
 * 
 */
class Proyecto2_0

{

    static double [] losLG;
    static int n=0,m=0, u=0, breaks =0; 
    static Float r=0f, speed=0f, Tmax,Smax, st_customer, Q =0f, Qini =0f;
    static Digraph g;
    static ArrayList<Pair<Float,Float>> array= new ArrayList<Pair<Float,Float>>();
    static Digraph gs;

    /**
     * Método para leer los datos de un archivo .txt para generar un grafo
     * @param filename
     *        nombre del archivo con los datos a leer
     * @return Digraph un DigraphAM con los datos leídos 
     * @throws IOException en caso de que no se halle el archivo
     */
    public static Digraph leer(String filename) throws IOException
    {
        FileReader fr = new FileReader(filename);
        BufferedReader lector = new BufferedReader(fr);

        String linea1,linea; 
        linea = lector.readLine();
        String[] lineaPartida = linea.split(" ");
        int [] lospri=new int[4];
        float [] losseg=new float[6];

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
        m=lospri[1];
        u=lospri[2];
        breaks=lospri[3];
        r=losseg[0];
        speed=losseg[1];
        Tmax=losseg[2];
        Smax=losseg[3];
        st_customer=losseg[4];
        Q=losseg[5];
        Qini=Q;
        g=  new DigraphAM(m+1,m+1);
        gs = new DigraphAM(m+1,u+1);
        Pair<Float,Float>[] arreglo = new Pair[n];
        linea=lector.readLine();
        linea=lector.readLine();
        linea=lector.readLine();
        lineaPartida = linea.split(" ");
        for(int i=0; i<n; i++)   
        { if(lineaPartida[4].equals("c") || lineaPartida[4].equals("d")){
                arreglo[i] = new Pair(Float.parseFloat(lineaPartida[2]),Float.parseFloat(lineaPartida[3]));
                g.AddInfo(i,lineaPartida[1]+""+lineaPartida[5]); 
                linea=lector.readLine();
                lineaPartida = linea.split(" ");
            }else{
                array.add(new Pair(Float.parseFloat(lineaPartida[2]),Float.parseFloat(lineaPartida[3])));
                gs.AddInfo(i-(m+1),lineaPartida[1]+lineaPartida[5]);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0;j<m;j++){
                g.addArc(i,j,((float)Math.sqrt(
                            Math.pow(arreglo[i].first-arreglo[j].first,2) +
                            Math.pow(arreglo[i].second-arreglo[j].second,2)
                        )));

            }

        }
        for(int i=0; i<m; i++){
            for(int j=0;j<array.size();j++){
                gs.addArc(i,j,(float)Math.sqrt(
                        Math.pow(arreglo[i].first-array.get(j).first,2) +
                        Math.pow(arreglo[i].second-array.get(j).second,2)
                    ));
            }}

        linea=lector.readLine();
        linea=lector.readLine();
        linea=lector.readLine();
        lineaPartida = linea.split(" ");

        losLG= new double[3];
        for(int i=0; i<3;i++){

            String [] losLpri = linea.split(" ");
            losLG[i]=Double.parseDouble(losLpri[3]);
            linea=lector.readLine();

        }

        linea=lector.readLine();
        linea=lector.readLine();
        linea=lector.readLine();
        for(int i=0;i<3;i++){

            String [] losGpri = linea.split(" ");
            losLG[i]= Double.parseDouble(losGpri[3])/losLG[i];           
            linea=lector.readLine();
        }
        return g;
    }

    /**
     * Método para tomar el tiempo de ejecución del algoritmo de ruteo
     * @return long un long con el tiempo que se tarda la ejecución
     */

    public static long time1(){
        long estimatedTime=0;
        try{
            long startTime = System.currentTimeMillis();
            Digraph g= leer("tc2c320s38ct1.txt");
            estimatedTime= System.currentTimeMillis() - startTime;

        }catch(Exception e){}
        return estimatedTime;
    }

    /**
     * Método para tomar el tiempo de ejecución del algoritmo de lectura de datos
     * @return long un long con el tiempo que se tarda la ejecución
     */
    public static long time2(){
        long estimatedTime=0;
        try{
            Digraph g= leer("tc2c320s24ct1.txt");
            long startTime = System.currentTimeMillis();
            AgenteViajero(g,Tmax,speed);
            estimatedTime= System.currentTimeMillis() - startTime;

        }catch(Exception e){}
        return estimatedTime;
    }

    public static void main(String[] args) throws IOException
    {
        Digraph g = leer("tc2c320s24cf1.txt");

        AgenteViajero(g,Tmax,speed);
    }
    
    /**
     * Método para calcular cada todas las rutas que se deben llevar a cabo para el recorrido del grafo
     * @param g
     *       Grafo con los datos leídos
     * @param Tmax
     *        Tiempo máximo que puede durar una ruta
     * @param speed
     *        Velocidad que tiene el camión
     */

    public static void AgenteViajero(Digraph g,float Tmax,float speed) {

        int v=0;
        int de=0;//depósito
        float tiempo=0;
        float totalT=0;
        int temp=0;
        float energ=0f;
        int verticesucesor=0;
        String ans="";
        float distanciaT=0;
        float pesosucesor=0;
        int ruta=1;
        boolean[] visitados = new boolean[g.size()];
        ArrayList<Integer> sol=new ArrayList<Integer>();
        for(int j=0;j<g.size()-2;j++){

            int i;
            sol.add(v);
            ans=ans+v+"("+Math.round((tiempo*60))+"min";
            ArrayList<Integer> sucesores= g.getSuccessors(v);
            visitados[v] = true;
            int ant;
            verticesucesor=-1;
            pesosucesor= Integer.MAX_VALUE;
            for( i=0; i<sucesores.size(); i++){
                if(g.getWeight(v,sucesores.get(i))<pesosucesor && !visitados[sucesores.get(i)]){
                    verticesucesor= sucesores.get(i);
                    pesosucesor=g.getWeight(v,verticesucesor);

                }    

            }
            int a=0;
            float enac;
            int vant=0;
            if (verticesucesor!=-1 && g.getInfo(verticesucesor).contains("c"))
            { tiempo=time(v,verticesucesor,g)+st_customer;
                ans+="), ";
                energ= pesosucesor* r;
                enac=Q-energ;
                Q=enac;
                if(enac<=Q*(30/100)){
                    vant=verticesucesor;
                    ArrayList<Integer> sucesoresST= gs.getSuccessors(v);
                    a=sucesoresST.get(0);
                    Float pesoo= gs.getWeight(v,a); 
                    double demora= losLG[Character.digit((g.getInfo(sucesoresST.get(0)))
                                .charAt(g.getInfo(sucesoresST.get(0)).length()-1),10)];
                    for(int k=1;k<sucesoresST.size(); k++){
                        Float peso2= gs.getWeight(v,sucesoresST.get(k));
                        double demora2= losLG[Character.digit((g.getInfo(sucesoresST.get(k))).charAt(g.getInfo(sucesoresST.get(k)).length()-1),10)];
                        if(peso2+demora2<pesoo+demora){
                            a=sucesoresST.get(k);
                            pesoo=peso2;
                            demora=demora2;
                        }
                    }
                    //verticesucesor=a;
                    pesosucesor=gs.getWeight(v,a);
                    tiempo=(float)demora+time(v,a,gs)+st_customer;
                    energ= pesosucesor* r;
                    Q=Qini-enac;
                    verticesucesor=vant;
                }else{

                    Q=Qini-enac;
                }

            }else if(verticesucesor!=-1){
                tiempo=time(v,verticesucesor,g);

            }

            distanciaT=distanciaT+pesosucesor;
            totalT+=tiempo;
            v=verticesucesor;
            if(totalT>=Tmax||(totalT+time(verticesucesor,0,g))>=Tmax){
                sol.add(de);
                ans += de + " (0min)";
                System.out.println("");
                System.out.print("Ruta "+ ruta+ ": " );
                if(!(sol.size()<=2)){

                    System.out.print(ans);

                }

                sol=new ArrayList();
                v=0;
                ruta++;
                totalT=0;
                ans="";

                j--;

            }
        }
        sol.add(v);
        ans += v+"("+Math.round((tiempo*60))+"min),";
        sol.add(de);
        ans += de + " (0min)";
        if(!(sol.size()<=2)){
            System.out.println("");
            System.out.print("Ruta "+ruta+": ");
            //System.out.println(Arrays.toString(sol.toArray())); 
            System.out.print(ans);

        }
        distanciaT=distanciaT+ g.getWeight(verticesucesor,0);
        totalT+=time(v,0,g);

    }

    /**
     * Método que calcula el tiempo que se tarda un camión de ir de un punto a otro en el grafo
     * @param prev
     *        vértice donde está el camión
     * @param prev
     *        vértice al que se quiere llegar
     * @param g
     *        Grafo con la información de vértices y distancias
     * @return float un float con el valor del tiempo de dicho recorrido 
     *         
     *        
     */
    public static float time(int prev, int next, Digraph g){
        float time;
        float dist=g.getWeight(prev, next);
        float sp=speed;
        time = dist/sp;
        return time;
    }

}