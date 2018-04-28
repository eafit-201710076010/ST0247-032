class Taller11
{
  public static void paresOrdenados(String cadena, int size)
  {
     for(int i = 0; i < cadena.length(); i++)
           for(int j = 0; j < cadena.length(); j++)
               System.out.println(cadena.charAt(i)+" "+cadena.charAt(j));
  }
  
  public static void subconjuntos(String respuesta, String pregunta)
  { 
      if (pregunta.length() == 0)
        System.out.println(respuesta);
      else
      {
       subconjuntos(respuesta + pregunta.charAt(0), pregunta.substring(1));
       subconjuntos(respuesta                     , pregunta.substring(1));
      }
  }
  
  public static void subconjuntos(String respuesta, String pregunta, int size)
  { 
      if (pregunta.length() == 0){
        if (respuesta.length() == size)
           System.out.println(respuesta);
      }
      else
      {
       subconjuntos(respuesta + pregunta.charAt(0), pregunta.substring(1),size);
       subconjuntos(respuesta                     , pregunta.substring(1),size);
      }
  }
  
  public static int deSubconjuntoANumero(String conjunto, String subconjunto)
  {
      int suma = 0;
      for(int i = 0; i < conjunto.length(); i++)
         if (subconjunto.contains("" + conjunto.charAt(i)))
           suma = suma + (int) Math.pow(2,conjunto.length() - i -1);
      return suma;  
  }    

}