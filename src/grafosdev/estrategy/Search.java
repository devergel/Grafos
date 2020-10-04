package grafosdev.estrategy;

import java.util.List;

import grafosdev.structure.Nodo;


public interface Search {
	public boolean findPath(List<Nodo> nodosRuta, Nodo nodoOrigen, Nodo nodoDestino);
}
