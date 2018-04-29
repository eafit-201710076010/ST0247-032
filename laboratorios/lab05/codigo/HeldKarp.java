
import java.util.*;
import java.io.*;
// Tomado de https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/TravelingSalesmanHeldKarp.java
//Por: Tushar Roy 

public class HeldKarp{
    public static int heldKarp(Digraph g){
        Map<Index,Integer> minCostDP = new HashMap();
        Map<Index,Integer> parent = new HashMap();

        Set<Integer> sets = new HashSet<Integer>();
        for(int i =0;i<g.size()-1;i++){
            sets.add(i+1);
        }

        List<Set<Integer>> elMeroSet =  generateCombination(g.size()-1);

        for(Set<Integer> set: elMeroSet){
            for(int v=1;v<g.size();v++){
                if(set.contains(v)){
                    continue;
                }
                Index index =Index.createIndex(v,set);
                int minCost = Integer.MAX_VALUE;
                int minPrevVertex=0;

                Set<Integer> copySet = new HashSet<>(set);
                for(int prev :set){
                    int cost= g.getWeight(prev,v)+ getCost(copySet,prev,minCostDP);
                    if(cost<minCost){
                        minCost=cost;
                        minPrevVertex= prev;
                    }

                }
                if(set.size() ==0){
                    minCost=g.getWeight(0,v);
                }
                minCostDP.put(index,minCost);
                parent.put(index,minPrevVertex);
            }
        }
        int min =Integer.MAX_VALUE;
        int prev=-1;
        Set<Integer> copyelMeroSet= new HashSet<>(sets);
        for(int k : sets){
            int cost= g.getWeight(k,0) + getCost(copyelMeroSet,k, minCostDP);
            if(cost<min){
                min=cost;
                prev = k;
            }
        }
        parent.put(Index.createIndex(0, sets), prev);
        return min;
    }
  
    //combinaciones    
        private static class SetSizeComparator implements Comparator<Set<Integer>>{
        @Override
        public int compare(Set<Integer> o1, Set<Integer> o2) {
            return o1.size() - o2.size();
        }
    }

    private static List<Set<Integer>> generateCombination(int n) {
        int input[] = new int[n];
        for(int i = 0; i < input.length; i++) {
            input[i] = i+1;
        }
        List<Set<Integer>> allSets = new ArrayList<>();
        int result[] = new int[input.length];
        generateCombination(input, 0, 0, allSets, result);
        Collections.sort(allSets, new SetSizeComparator());
        return allSets;
    }

    private static void generateCombination(int input[], int start, int pos, List<Set<Integer>> allSets, int result[]) {
        if(pos == input.length) {
            return;
        }
        Set<Integer> set = createSet(result, pos);
        allSets.add(set);
        for(int i=start; i < input.length; i++) {
            result[pos] = input[i];
            generateCombination(input, i+1, pos+1, allSets, result);
        }
    }

    private static Set<Integer> createSet(int input[], int pos) {
        if(pos == 0) {
            return new HashSet<>();
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < pos; i++) {
            set.add(input[i]);
        }
        return set;
    }

    private static int getCost(Set<Integer> set, int prevVertex, Map<Index, Integer> minCostDP) {
        set.remove(prevVertex);
        Index index = Index.createIndex(prevVertex, set);
        int cost = minCostDP.get(index);
        set.add(prevVertex);
        return cost;
    }
}
