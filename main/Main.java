package main;
import java.io.IOException;
import java.util.Scanner;
import execoes.GrafoException;
import repositorio.Repositorio;


public class Main{
    public static void main(String[] args){

        int numVertices = 5;
        int numArestas = 8;

        boolean continuar = true;
		Scanner sc = new Scanner(System.in);

        Repositorio repositorio = null;
		String arquivoRepositorio = "./repositorioGrafo.txt";

		try {
			repositorio = Repositorio.carregarRepositorio(arquivoRepositorio);
		} catch (IOException e) {
			System.out.println("Não foi possível carregar o repositório.");
			repositorio = new Repositorio();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        
        while(continuar){
            System.out.println("\n\t- - - - - SUDOKU - - - - -\n\n");
			System.out.println("\n1 - Cadastrar GRAFO");
            System.out.println("\n3 - GRAFO");
            System.out.println("\n\n\n0 - Sair."); 
			System.out.println("\nInforme uma opcao: ");
			int leitura = sc.nextInt();
			if (leitura == 1) {
                System.out.println("\n\n\n\n\t - - - - - CADASTRAR GRAFO - - - - -\n");
                
                Graph g = new Graph(numVertices, numArestas);

                g.aresta[0].src = 1;   // edge 1---2
                g.aresta[0].dest = 2;

                g.aresta[1].src = 1;   // edge 1---3
                g.aresta[1].dest = 3;

                g.aresta[2].src = 1;   // edge 1---4
                g.aresta[2].dest = 4;

                g.aresta[3].src = 2;   // edge 2---4
                g.aresta[3].dest = 4;

                g.aresta[4].src = 2;   // edge 2---5
                g.aresta[4].dest = 5;

                g.aresta[5].src = 3;   // edge 3---4
                g.aresta[5].dest = 4;

                g.aresta[6].src = 3;   // edge 3---5
                g.aresta[6].dest = 5;

                g.aresta[7].src = 4;   // edge 4---5
                g.aresta[7].dest = 8;

                for(int i = 0; i < numArestas; i++) {
                    System.out.println(g.aresta[i].src + " -> " + g.aresta[i].dest);
                }
            }
            else if(leitura == 3) {
                System.out.println("\n\n\n\n\t - - - - - GRAFO - - - - -\n");
            }

            else if(leitura == 3) {
                    System.out.println("\n\n\n\n\t - - - - - GRAFOS NO REPOSITORIO - - - - -\n");
                    for (int i = 0; i < repositorio.ultimoID(); i++){
                        try {
                            Graph a = repositorio.recuperar(i);
                            System.out.println(a.toString());
                        } catch (GrafoException e) {
                            System.out.println("\nGrafo: [" + i + "]" + " NÃO FOI ENCONTRADO!\n\n");
                        }
                    }
            }
            else if (leitura == 0) {
                        System.out.println("\n\nEncerrando...");
                        continuar = false;
            }
        }
    }

}