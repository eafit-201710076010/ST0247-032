
import java.util.*;
import java.io.*;
//El siguiente algoritmo está basado en:https://github.com/201710057010/ST0247-032/tree/master/laboratorios/lab03/ejercicioEnLinea
//Autor:Damiam Londoño
public class EjLinea
{
    public static void main (String args [])  throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String graf = lector.readLine();
        String[] dgraf = graf.split(" ");
        int n=Integer.parseInt(dgraf[0]);
        int m=Integer.parseInt(dgraf[1]);

        DigraphAL g = new DigraphAL(n);
        for (int i=0; i< m; i++){
            String newArc=lector.readLine();
            String [] dArc=newArc.split(" ");
            int ai=Integer.parseInt(dArc[0]);
            int bi=Integer.parseInt(dArc[1]);
            int wi=Integer.parseInt(dArc[2]);
            g.addArc(ai, bi, wi);
        }
        ArrayList fin=recorrer(g,1,g.size);

        if (fin == null) {
            System.out.print("-1");
        }
        else {
            for(int i=0; i< fin.size(); ++i){
                System.out.print(fin.get(i)+ " ");
            }
        }
    }


    public static ArrayList recorrer (DigraphAL g, int inicio, int objetivo){
        boolean[] visitados = new boolean[g.size];
        if (inicio == objetivo){
            return null;
        }
        ArrayList <Integer> resp = new ArrayList <>();
        ArrayList <Integer> aux = new ArrayList<>();
        int distancias[] = new int[g.size];
        for (int i = 0; i < distancias.length; i++) {
            distancias[i] = Integer.MAX_VALUE;
        }
        resp = recorrer(g,visitados,inicio,objetivo,resp,distancias,aux,0);
        resp.add(0,1);
        return resp;
    }

    public static ArrayList recorrer (DigraphAL g, boolean[] visitados, int v, int f,ArrayList resp,int[] distancias,ArrayList aux,int
    pes){
        if (v == f){
            if (pes < distancias[0]){
                distancias[0] = pes;
                resp = (ArrayList)aux.clone();
                return resp;
            }
        }
        else if (pes > distancias[0]){
            return resp;
        }
        try {
            ArrayList<Integer> sucesores = g.getSuccessors(v);
            if(sucesores != null){
                visitados[v-1] = true;
                for(Integer sucesor: sucesores) {
                    aux.add(sucesor);
                    resp = recorrer(g, visitados, sucesor, f, resp, distancias, aux, pes + g.getWeight(v, sucesor));
                    Integer a = sucesor;
                    aux.remove(a);
                }
                visitados[v-1] = false;
            }
            return resp;

        }catch (Exception e){
            return resp;
        }
    }
}
