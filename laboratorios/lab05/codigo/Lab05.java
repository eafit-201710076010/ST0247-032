import java.util.ArrayList;

public class Lab05
{
    //Punto 1.1
    /**
     * Devuelve la cantidad mínina de operaciones 
     * necesarias para que dados dos string, uno se
     * transforme en el otro
     * @param String a
     *      Primer String
     * @param String b
     *      Segundo String
     * @return int con el número de operaciones 
     */
    public static int levenshtein(String a, String b){
        int[][] matriz = new int[a.length() + 1][b.length()+1];
        for (int i = 0; i <= a.length(); i++){
            matriz[i][0] = i;
        }

        for (int j = 1; j <= b.length(); j++){
            matriz[0][j] = j;
        }

        for (int i = 1; i <= a.length(); i++){
            for (int j = 1; j <= b.length(); j++){
                matriz[i][j] = Math.min(matriz[i - 1][j] + 1,
                    Math.min(matriz[i][j - 1] + 1,matriz[i - 1][j - 1]) +
                    ((a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1));
            }
        }
        return matriz[a.length()][b.length()];
    }

    //Punto 1.3

    /**
     * Halla la longitud de la subsecuencia (String en 
     * un mismo orden relativo) más larga entre dos Strings
     * @param String a
     *      Primer String
     * @param String b
     *      Segundo String
     * @return int con la longitud de la subcecuencia más larga 
     */
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

