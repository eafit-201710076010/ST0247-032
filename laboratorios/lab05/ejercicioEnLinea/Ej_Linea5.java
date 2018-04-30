
/**
 * Write a description of class a here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
public class Ej_Linea5
{
    public static void main (String [] args) throws IOException {
        //Scanner lector = new Scanner(System.in);
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int esc=Integer.parseInt(lector.readLine());

        for(int i=0;i<esc;i++){
            String stam=lector.readLine();
            String[] stamAr= stam.split(" ");
            //tamaño del escenario
            int tam=Integer.parseInt(stamAr[0]);
            
            ArrayList<Pair> coord=new ArrayList<Pair>(tam);
            //coordenadas (inicial y posteriormente, desechos)
            Pair pos1;
            String spos;
            spos=lector.readLine();
            String[] posAr=spos.split(" ");
            pos1=Pair.makePair(Integer.parseInt(posAr[0]),Integer.parseInt(posAr[1]));
            coord.add(pos1);
            int ncoord=Integer.parseInt(lector.readLine());
            for(int j=0;j<ncoord;j++){
                String lineaAc=lector.readLine();
                String[] lineaAcAr=lineaAc.split(" ");
                Pair pos=Pair.makePair(Integer.parseInt(lineaAcAr[0]),Integer.parseInt(lineaAcAr[1]));
                coord.add(pos);
            }
            Digraph g=new DigraphAL(coord.size()); //por espacio
            for(int k=0; k<coord.size();k++){
                for(int l=0; l<coord.size();l++){
                    if(k!=l){
                        int peso=Math.abs((int)coord.get(k).first-(int)coord.get(l).first)
                               + Math.abs((int)coord.get(k).second-(int)coord.get(l).second);
                        g.addArc(k,l,peso);
                    }
                }
            }
            int res=HeldKarp.heldKarp(g);
            System.out.println("The shortest path has length "+res);

        }

    }
}
