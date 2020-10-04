package grafosdev.factory;

import java.util.ArrayList;
import java.util.List;

import grafosdev.estrategy.Search;
import grafosdev.structure.Arco;
import grafosdev.structure.ArcoPeso;
import grafosdev.structure.Nodo;

public abstract class GrafosAbstract {
	
	List<Nodo> nodos = new ArrayList<>();
	List<Arco> arcos = new ArrayList<>();
	private Search buscar;
	private boolean isWeighted = false;
	
	
	public List<Nodo> getNodos() {
		return nodos;
	}

	public void setNodos(List<Nodo> nodos) {
		this.nodos = nodos;
	}

	public List<Arco> getArcos() {
		return arcos;
	}

	public void setArcos(List<Arco> arcos) {
		this.arcos = arcos;
	}

	public boolean isWeighted() {
		return isWeighted;
	}

	public void setWeighted(boolean isWeighted) {
		this.isWeighted = isWeighted;
	}

	public Search getBuscar() {
		return buscar;
	}

	public void setBuscar(Search buscar) {
		this.buscar = buscar;
	}
	
	public void addNodo(String nombre)
	{
		Nodo nodo = new Nodo();
		nodo.setNombre(nombre);
		nodos.add(nodo);
	}
	
	
	public Nodo buscarNodo(String nombre) 
	{
		for (Nodo nodo: nodos) {
			if (nodo.getNombre().equals(nombre)) {
				return nodo;
			}
		}
		return null;
	}
	
	public void addArco(String origen, String destino) throws Exception {
		
		Nodo nodoOrigen = buscarNodo(origen);
		Nodo nodoDestino = buscarNodo(destino);
		
		// Origen o destino no encontrado
		if (nodoOrigen == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		if (nodoDestino == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		
		addArco(nodoOrigen, nodoDestino);
	}
	
	public void addArco(Nodo nodoOrigen, Nodo nodoDestino)
	{
		Arco arco = new Arco();
		arco.setOrigen(nodoOrigen);
		arco.setDestino(nodoDestino);
		arcos.add(arco);
		nodoOrigen.agregarArco(arco);
	}
	
	public void addArco(String origen, String destino, int peso) throws Exception {
		if(!isWeighted())
			throw new UnsupportedOperationException("Operación no soportada");
		if(peso <= 0)
			throw new RuntimeException("Error al asignar peso , el peso debese ser un numero mayor a 0");
		Nodo nodoOrigen = buscarNodo(origen);
		Nodo nodoDestino = buscarNodo(destino);
		
		// Origen o destino no encontrado
		if (nodoOrigen == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		if (nodoDestino == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		
		addArco(nodoOrigen, nodoDestino, peso);
	}
	
	public void addArco(Nodo nodoOrigen, Nodo nodoDestino, int peso)
	{
		ArcoPeso arco = new ArcoPeso();
		arco.setOrigen(nodoOrigen);
		arco.setDestino(nodoDestino);
		arco.setPeso(peso);
		arcos.add(arco);
		nodoOrigen.agregarArco(arco);
	}
	
	public boolean existeRuta(String origen, String destino) throws Exception {
		if (buscarRuta(origen, destino) != null) {
			return true;
		}
		return false;
	}
	
	public List<Nodo> buscarRuta(String origen, String destino) throws Exception {
		
		Nodo nodoOrigen = buscarNodo(origen);
		Nodo nodoDestino = buscarNodo(destino);
		List<Nodo> nodosRuta = new ArrayList<>();
		
		// Origen o destino no encontrado
		if (nodoOrigen == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		if (nodoDestino == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		
		if (getBuscar().findPath(nodosRuta, nodoOrigen, nodoDestino)) {
			return nodosRuta;
		} else {
			return null;
		}
	}

}
