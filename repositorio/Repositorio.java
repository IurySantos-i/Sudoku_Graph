package repositorio;

import java.io.Serializable;
import java.util.ArrayList;

import execoes.GrafoException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import main.Graph;

public class Repositorio implements Serializable{
    ArrayList<Graph> repositorio;

    int idCount;
    int Count;
	int verificar;
    
    public Repositorio(){
        this.repositorio = new ArrayList<Graph>();
        idCount = 0;
    }
    public void adicionarGrafo(Graph item){
        item.setArestas(idCount);
        this.repositorio.add(item);
        idCount++;
    }

    public int ultimoID() {
		if(idCount > 0){
			verificar = idCount;
		}else{
			System.out.println("\n\t\t\tLISTA VAZIA!\n\n");
		}
		return verificar;
	}

	public Graph recuperar(int id) throws GrafoException {
		for (Graph idCoItem : repositorio){
			if (idCoItem.getArestas() == id)
				return (Graph) idCoItem;
		}
		throw new GrafoException("\n\nGrafo: " + "[" + id + "]" + ", NÃO ENCONTRADO!\n\n\n");
	}
	
    public void salvarRepositorio(String caminhoArquivo) throws IOException {
		FileOutputStream fout = new FileOutputStream(caminhoArquivo);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(this);
		oos.close();
	}

	public static Repositorio carregarRepositorio(String caminhoArquivo) throws IOException, ClassNotFoundException {
		FileInputStream fin = new FileInputStream(caminhoArquivo);
		ObjectInputStream ois = new ObjectInputStream(fin);
		Repositorio resp = (Repositorio) ois.readObject();
		ois.close();
		return resp;
	}
}
