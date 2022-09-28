package main;


public class Graph{

    int vertices, arestas;
    Aresta[] aresta;

    public Graph(int vertices, int arestas){
        this.vertices = vertices;
        this.arestas = arestas;
        
        aresta = new Aresta[arestas];

        for(int i =0; i < arestas; i++){
            aresta[i] = new Aresta();
        }

    }

    public void setArestas(int arestas) {
        this.arestas = arestas;
    }
    public int getArestas(){
        return arestas;
    }

    public int getVertices() {
        return vertices;
    }
    public void setVertices(int vertices) {
        this.vertices = vertices;
    }


    class Aresta{
        int src, dest;
    }
    /*
    public Graph(int vertices, int arestas){
        this.vertices = vertices;
        this.arestas = arestas;

        aresta = new Edge[arestas];

        for(int i =0; i < arestas; i++){
            aresta[i] = new Edge();
        }

    }
    */

}