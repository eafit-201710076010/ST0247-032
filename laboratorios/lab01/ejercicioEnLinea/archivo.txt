	class Bipartite
{
   static int V=-1;    
    public static void recibir(){
        String a= "";
         Scanner s = new Scanner (System.in); 
        int matriz [] [];
        System.out.println("Ingrese nro de vertices");
        V = s.nextInt();
        while(V!=0){            
        System.out.println("Ingrese nro de arcos");  
         s = new Scanner (System.in);      
        int arista=s.nextInt();                           
       System.out.println("Ingrese relaion");   
        s = new Scanner (System.in);   
        String conexiones = s.nextLine ();  
        matriz= new int [V] [V];   
         
        while(conexiones.length()>1){
            matriz[(Integer.parseInt(conexiones.substring(0,1)))][(Integer.parseInt(conexiones.substring(2)))]=1; // c + n*m
             System.out.println("Ingrese relacion"); 
            conexiones = s.nextLine ();   
        }
        if(isBipartite(matriz,0))   
        a=a + "BICOLORABLE \n";else  
        a=a + "NOT BICOLORABLE \n"; 
        V=Integer.parseInt(conexiones); 
    }
    System.out.println(a); 
} O(m*n)
     
    static boolean isBipartite(int G[][],int src)
    {
               int colorArr[] = new int[V];
        for (int i=0; i<V; ++i)
            colorArr[i] = -1;   
 
       
        colorArr[src] = 1;
 
        LinkedList<Integer>q = new LinkedList<Integer>();
        q.add(src);
 
      
        while (q.size() != 0)
        {
            
            int u = q.poll();  
 
            
            if (G[u][u] == 1) 
                return false;  
 
            for (int v=0; v<V; ++v)
            {
               
                if (G[u][v]==1 && colorArr[v]==-1)
                {
                    colorArr[v] = 1-colorArr[u];  
                    q.add(v);    
                }
 
                 else if (G[u][v]==1 && colorArr[v]==colorArr[u])
                    return false;  
            }
        }
        return true;
    }
} 
