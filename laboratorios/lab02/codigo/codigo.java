//basado en http://codegists.com/snippet/java/nqueensjava_ajayramesh23_java

  private static boolean puedoPonerReina(int r, int c, int[] tablero) {
        // complete...
        for (int i = 0; i < r; i++) {
            if (tablero[i] == c || (i - r) == (tablero[i] - c) ||(i - r) == (c - tablero[i])) 
            {
                return false;
            }
        }
        return true;
    }
    public static int contador=0;  

    public static int nReinas(int n) {
        int contador=0;
        int[] tablero= new int[n];
        contador=contador + nReinas(0, tablero.length,tablero);
        return contador;
    }

    private static int nReinas(int r, int n, int[] tablero) {

        for (int c = 0; c < n; c++) {
            if (puedoPonerReina(r, c,tablero)) {
                tablero[r] = c;
                if (r == n - 1) {
                    contador++;
                } else {
                    nReinas(r + 1, n,tablero);
                }
            }
        }
        return contador;
    }
