import java.util.*;
import java.io.*;
// Tomado de https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/TravelingSalesmanHeldKarp.java
//Por: Tushar Roy
public  class Index {
    int currentVertex;
    Set<Integer> vertexSet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Index index = (Index) o;

        if (currentVertex != index.currentVertex) return false;
        return !(vertexSet != null ? !vertexSet.equals(index.vertexSet) : index.vertexSet != null);
    }

    @Override
    public int hashCode() {
        int result = currentVertex;
        result = 31 * result + (vertexSet != null ? vertexSet.hashCode() : 0);
        return result;
    }

    public static Index createIndex(int vertex, Set<Integer> vertexSet) {
        Index i = new Index();
        i.currentVertex = vertex;
        i.vertexSet = vertexSet;
        return i;
    }
}