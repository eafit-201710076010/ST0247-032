import java.util.ArrayList;
import java.lang.Math;
class Taller10{
  public static int lcs(String a, String b){
      int[][] tabla =new  int[a.length()+1][b.length()+1];
      for(int i = 0; i <= a.length(); i++)
        tabla[i][0] = 0;
      for(int j = 0; j <= b.length(); j++)
        tabla[0][j] = 0;
      // Voy a hacer ciclos
      for(int i=1; i<=a.length();i++){
          for(int j=1;j<=b.length();j++){
           if (a.charAt(i-1) == b.charAt(j-1))
             tabla[i][j] = tabla[i-1][j-1]+1;
          else // no son iguales
             tabla[i][j] = Math.max(tabla[i-1][j],
                                    tabla[i][j-1]);}}
      return tabla[a.length()][b.length()];
      
  }
  
  
}
