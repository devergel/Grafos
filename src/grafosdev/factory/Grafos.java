package grafosdev.factory;

import java.util.List;

import grafosdev.estrategy.Search;
import grafosdev.structure.Arco;
import grafosdev.structure.Nodo;

public interface Grafos {
	
	public boolean isWeighted();
	public void setWeighted(boolean isWeighted);
	public void addNodo(String nombre);
	public Nodo buscarNodo(String nombre);
	public void addArco(String origen, String destino) throws Exception;
	public void addArco(String origen, String destino, int peso) throws Exception;
	public boolean existeRuta(String origen, String destino) throws Exception;
	public List<Nodo> buscarRuta(String origen, String destino) throws Exception;
	public Search getBuscar();
	public void setBuscar(Search buscar);
	public void setArcos(List<Arco> arcos);

}
