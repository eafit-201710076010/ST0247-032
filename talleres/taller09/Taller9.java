/**
 * Write a description of class Taller9 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 */
//implementacion de: https://github.com/mauriciotoro/ST0247-Eafit/blob/master/laboratorios/lab05/ED2-Laboratorio5%20Vr%204.0.pdf
public class Taller9
{
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
}
