
/**
 * Write a description of class kljklj here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Arrays;
public class MERGESORT1
{
      private static void mergesort(int[] a, int inf, int sup)
      {
          if (inf < sup){
             int mitad = (inf + sup) / 2;
             mergesort(a, inf, mitad);
             mergesort(a, mitad+1, sup);
             a = pegar(Arrays.copyOfRange(a,inf, mitad), Arrays.copyOfRange(a,mitad,sup));
          }
      }

      public static int[] mergesort(int[] a)
      {
          mergesort(a, 0, a.length);
          return a;
      }

       private static void pegar(int[] a, int[] b, int i, int j, int k, int[] respuesta) {
           if (respuesta.length != k)
                     if (i < a.length && j < b.length)
                           if (a[i] < b[j]) {
                              respuesta[k] = a[i];
                              pegar(a,b, i+1, j, k+1, respuesta);
                           }
                           else {
                              respuesta[k] = b[j];
                              pegar(a,b, i, j+1 , k+1, respuesta);
                           }
                      else if (i == a.length) {
                              respuesta[k] = b[j];
                              pegar(a,b, i, j+1 , k+1, respuesta);
                      }
                      else { // (j == b.length)
                              respuesta[k] = a[i];
                              pegar(a,b, i+1, j, k+1, respuesta);
                        }
       }

       public static int[] pegar(int[] a, int[] b){
           int[] respuesta = new int[a.length + b.length];
           pegar(a,b,0,0,0,respuesta);
           return respuesta;
        }
}
