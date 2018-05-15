import java.util.*;
import java.lang.*;
import java.io.*;
class Proyecto

{

    static double [] losLG;
    static int n=0,m=0, u=0, breaks =0; 
    static Float r=0f, speed=0f, Tmax,Smax, st_customer, Q =0f, Qini =0f;
    static Digraph g;
    static ArrayList<Pair<Float,Float>> array= new ArrayList<Pair<Float,Float>>();
    static Digraph gs;
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
        ////////////OJO
        linea=lector.readLine();
        linea=lector.readLine();
        linea=lector.readLine();
        lineaPartida = linea.split(" ");
        ///if(lineaPartida[0].equals("l")){
        losLG= new double[3];
        for(int i=0; i<3;i++){
            //linea=lector.readLine();
            String [] losLpri = linea.split(" ");
            losLG[i]=Double.parseDouble(losLpri[3]);
            linea=lector.readLine();

        }

        //}
        linea=lector.readLine();
        linea=lector.readLine();
        linea=lector.readLine();
        for(int i=0;i<3;i++){
            //linea=lector.readLine();
            String [] losGpri = linea.split(" ");
            losLG[i]= Double.parseDouble(losGpri[3])/losLG[i];           
            linea=lector.readLine();
        }
        return g;
    }

    public static long time1(){
        long estimatedTime=0;
        try{
            long startTime = System.currentTimeMillis();
            Digraph g= leer("tc2c320s38ct1.txt");
            estimatedTime= System.currentTimeMillis() - startTime;

        }catch(Exception e){}
        return estimatedTime;
    }

    public static long time2(){
        long estimatedTime=0;
        try{
            Digraph g= leer("tc2c320s24ct4.txt");
            long startTime = System.currentTimeMillis();
            //AgenteViajero(g);
            estimatedTime= System.currentTimeMillis() - startTime;

        }catch(Exception e){}
        return estimatedTime;
    }

    public static void main(String[] args) throws IOException
    {
        Digraph g = leer("tc2c320s24cf1.txt");
        //Ruta route= new Ruta();
        //route.AgenteViajero(g);

        // ArrayList<Integer> solucion = elVecinoMasCercanoParaTSP(g);
        System.out.println(AgenteViajero(g,Tmax,speed));
    }

    public static float AgenteViajero(Digraph g,float Tmax,float speed) {
        float orTime=0;
        float Tback;
        int v=0;
        int de=0;//depósito
        float tiempo=0;
        float totalT=0;
        int temp=0;
        float energ=0f;
        int verticesucesor=0;
        int contSC=0;
        float distanciaT=0;
        float pesosucesor=0;
        int ruta=1;
        boolean[] visitados = new boolean[g.size()];
        ArrayList<Integer> sol=new ArrayList<Integer>();
        for(int j=0;j<g.size()-1;j++){
            
            int i;
            sol.add(v);
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
                //sol.add(i);

            }
            int a=0;
            if (g.getInfo(verticesucesor).contains("c"))
            { tiempo=time(v,verticesucesor,g)+st_customer;
                energ= pesosucesor* r;
                if(Q-energ<=Q*(30/100)){
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
                    verticesucesor=a;
                    pesosucesor=gs.getWeight(v,verticesucesor);
                    tiempo=(float)demora+time(v,a,gs)+st_customer;
                    energ= pesosucesor* r;
                    Q=Qini;
                }else{
                    Q=Qini;
                }
            }else{
                tiempo=time(v,verticesucesor,g);
                contSC++;
            }

            distanciaT=distanciaT+pesosucesor;
            totalT+=tiempo;
            v=verticesucesor;
            if(totalT>=Tmax||(totalT+time(verticesucesor,0,g))>=Tmax){
                sol.add(de);
                System.out.println(Arrays.toString(sol.toArray()));
                System.out.println(contSC);
                System.out.println("Ruta "+ ruta);
                sol=new ArrayList();
                v=0;
                ruta++;
                totalT=0;
                contSC=0;
                i--;

            }

        }
        sol.add(v);
        sol.add(0);
        System.out.println(Arrays.toString(sol.toArray()));
        distanciaT=distanciaT+ g.getWeight(verticesucesor,0);
        totalT+=time(v,0,g);
        System.out.println(ruta);
        return totalT;
    }

    public static float time(int prev, int next, Digraph g){
        float time;
        float dist=g.getWeight(prev, next);
        float sp=speed;
        time = dist/sp;
        return time;
    }

}