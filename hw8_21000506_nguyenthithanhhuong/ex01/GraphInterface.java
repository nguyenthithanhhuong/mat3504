package hw8_21000506_nguyenthithanhhuong.ex01;

public interface GraphInterface<V,E> {
    boolean isDirected();

    boolean isWeighted();

    int degree();
    
    int numVertices();

    Iterable<VertexInterface<V>> vertices();

    VertexInterface<V> getVertex(int i);

    int numberEdges();

    Iterable<EdgeInterface<E>> edges();

    EdgeInterface<E> getEdge(VertexInterface<V> u, VertexInterface<V> v);

    VertexInterface<V>[] endVertices(EdgeInterface<E> e);

    VertexInterface<V> opposite(VertexInterface<V> v, EdgeInterface<E> e);

    int outDegree(VertexInterface<V> v);

    int inDegree(VertexInterface<V> v);

    Iterable<EdgeInterface<E>> outgoingEdges(VertexInterface<V> v);

    Iterable<EdgeInterface<E>> incomingEdges(VertexInterface<V> v);

    boolean insertVertex(V x);

    boolean insertEdge(VertexInterface<V> u, VertexInterface<V> v, E x);

    boolean removeVertex(VertexInterface<V> v);

    boolean removeEdge(EdgeInterface<E> e);
}
