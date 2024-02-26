package hw8_21000506_nguyenthithanhhuong.ex02;

import hw8_21000506_nguyenthithanhhuong.ex01.EdgeInterface;
import hw8_21000506_nguyenthithanhhuong.ex01.GraphInterface;
import hw8_21000506_nguyenthithanhhuong.ex01.VertexInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedWeightedGraph<V, E> implements GraphInterface<V, E> {
    private boolean directed;
    private boolean weighted;
    protected final int DEFAULT_SIZE = 4;
    public EdgeInterface<E>[][] adjacencyMatrix;
    public Map<VertexInterface<V>, Integer> vertices;

    public DirectedWeightedGraph(boolean directed, boolean weighted) {
        this.directed = directed;
        this.weighted = weighted;
        this.adjacencyMatrix = new EdgeInterface[DEFAULT_SIZE][DEFAULT_SIZE];
        this.vertices = new HashMap<>();
    }

    private class Vertex implements VertexInterface<V> {
        public V element;

        public Vertex(V element) {
            this.element = element;
        }

        @Override
        public V getElement() {
            return null;
        }
    }

    private class Edge implements EdgeInterface<E> {
        public E element;
        public VertexInterface<?>[] endVertices;

        public Edge(VertexInterface<?> u, VertexInterface<?> v, E element) {
            this.element = element;
            this.endVertices = new VertexInterface<?>[] {u, v};
        }

        @Override
        public E getElement() {
            return null;
        }
    }

    @Override
    public boolean isDirected() {
        return directed;
    }

    @Override
    public boolean isWeighted() {
        return weighted;
    }

    @Override
    public int degree() {
        int degree = 0;
        for (VertexInterface<V> vertex : vertices()) {
            degree += outDegree(vertex) + inDegree(vertex);
        }
        return degree;
    }

    @Override
    public int numVertices() {
        return vertices.size();
    }

    @Override
    public Iterable<VertexInterface<V>> vertices() {
        return vertices.keySet();
    }

    @Override
    public VertexInterface<V> getVertex(int i) {
        if (i >= 0 && i < vertices.size()) {
            for (Map.Entry<VertexInterface<V>, Integer> entry : vertices.entrySet()) {
                if (entry.getValue() == i) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    @Override
    public int numberEdges() {
        int count = 0;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                if (adjacencyMatrix[i][j] != null) {
                    count++;
                }
            }
        }
        return isDirected()? count : count/2;
    }

    @Override
    public Iterable<EdgeInterface<E>> edges() {
        List<EdgeInterface<E>> edgeList = new ArrayList<>();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                if (adjacencyMatrix[i][j] != null) {
                    edgeList.add(adjacencyMatrix[i][j]);
                }
            }
        }
        return edgeList;
    }

    @Override
    public EdgeInterface<E> getEdge(VertexInterface<V> u, VertexInterface<V> v) {
        int uIdx = vertices.get(u);
        int vIdx = vertices.get(v);
        return adjacencyMatrix[uIdx][vIdx];
    }

    @Override
    public VertexInterface<V>[] endVertices(EdgeInterface<E> e) {
        VertexInterface<V>[] endVertices = (VertexInterface<V>[]) new VertexInterface[2];

        for (Map.Entry<VertexInterface<V>, Integer> entry : vertices.entrySet()) {
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                if (adjacencyMatrix[entry.getValue()][i] == e) {
                    endVertices[0] = entry.getKey();
                }
                if (adjacencyMatrix[i][entry.getValue()] == e) {
                    endVertices[1] = entry.getKey();
                }
            }
        }

        return endVertices;
    }

    @Override
    public VertexInterface<V> opposite(VertexInterface<V> v, EdgeInterface<E> e) {
        VertexInterface<V>[] end = endVertices(e);
        if (end[0].equals(v)) {
            return end[1];
        }
        if (end[1].equals(v)) {
            return end[0];
        }
        return null;
    }

    @Override
    public int outDegree(VertexInterface<V> v) {
        if (v == null || !vertices.containsKey(v)) return 0;
        int count = 0;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[vertices.get(v)][i] != null) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int inDegree(VertexInterface<V> v) {
        if (v == null || !vertices.containsKey(v)) return 0;
        int count = 0;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[i][vertices.get(v)] != null) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Iterable<EdgeInterface<E>> outgoingEdges(VertexInterface<V> v) {
        if (v == null || !vertices.containsKey(v)) return null;
        List<EdgeInterface<E>> outgoing = new ArrayList<>();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[vertices.get(v)][i] != null) {
                outgoing.add(adjacencyMatrix[vertices.get(v)][i]);
            }
        }
        return outgoing;
    }

    @Override
    public Iterable<EdgeInterface<E>> incomingEdges(VertexInterface<V> v) {
        if (v == null || !vertices.containsKey(v)) return null;
        List<EdgeInterface<E>> incoming = new ArrayList<>();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[i][vertices.get(v)] != null) {
                incoming.add(adjacencyMatrix[i][vertices.get(v)]);
            }
        }
        return incoming;
    }

    @Override
    public boolean insertVertex(V x) {
        if (vertices.size() >= adjacencyMatrix.length) enlarge();
        VertexInterface<V> newVertex = new Vertex(x);
        vertices.put(newVertex, vertices.size());

        return true;
    }

    protected void enlarge() {
        EdgeInterface<E>[][] newMatrix = new EdgeInterface[adjacencyMatrix.length * 2][adjacencyMatrix.length * 2];

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            System.arraycopy(adjacencyMatrix[i], 0, newMatrix[i], 0, adjacencyMatrix[i].length);
        }

        adjacencyMatrix = newMatrix;
    }

    @Override
    public boolean insertEdge(VertexInterface<V> u, VertexInterface<V> v, E x) {
        if (u == null || v == null) return false;
        if (!vertices.containsKey(u) || !vertices.containsKey(v)) return false;

        int uIndex = vertices.get(u);
        int vIndex = vertices.get(v);
        adjacencyMatrix[uIndex][vIndex] = new Edge(u, v, x);

        if (!isDirected()) {
            adjacencyMatrix[vIndex][uIndex] = new Edge(u, v, x);
        }

        return true;
    }

    @Override
    public boolean removeVertex(VertexInterface<V> v) {
        if (!vertices.containsKey(v)) {
            return false;
        }

        vertices.remove(v);

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            adjacencyMatrix[i][vertices.get(v)] = null;
            adjacencyMatrix[vertices.get(v)][i] = null;
        }

        return true;
    }

    @Override
    public boolean removeEdge(EdgeInterface<E> e) {
        if (e == null) return false;
        boolean result = false;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j] == e) {
                    adjacencyMatrix[i][j] = null;
                    result = true;
                }
            }
        }
        return result;
    }
}
