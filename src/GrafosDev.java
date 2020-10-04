/* FeatureIDE - A Framework for Feature-Oriented Software Development
 * Copyright (C) 2005-2019  FeatureIDE team, University of Magdeburg, Germany
 *
 * This file is part of FeatureIDE.
 * 
 * FeatureIDE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * FeatureIDE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with FeatureIDE.  If not, see <http://www.gnu.org/licenses/>.
 *
 * See http://featureide.cs.ovgu.de/ for further information.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import grafosdev.estrategy.SearchBFS;
import grafosdev.estrategy.SearchDFS;
import grafosdev.factory.GrafoDirected;
import grafosdev.factory.GrafoUndirected;
import grafosdev.factory.Grafos;
import grafosdev.structure.Arco;
import grafosdev.structure.Nodo;

/**
 * 
 * @author Deivis Vergel
 */
public class GrafosDev {

	public static void main(String[] args) throws Exception {
		List<String> list = Arrays.asList(args);
		Grafos instancia = null;
		String prueba = "Ejemplo de una Aplicación que use grafos ";
		if (list.contains("Directed")) {
			instancia = new GrafoDirected();
			prueba += "Directos";
		}
		if (list.contains("Undirected")) {
			instancia = new GrafoUndirected();
			prueba += "Indirectos";
		}
		
		if (list.contains("Weighted")) {
			instancia.setWeighted(true);
			prueba += " con Pesos";
		}else {
			prueba += " sin Pesos";
		}
		if (list.contains("DFS")) {
			instancia.setBuscar(new SearchDFS());
			prueba += " y busqueda DFS";
		}else if (list.contains("BFS")) {
			instancia.setBuscar(new SearchBFS());
			prueba += " y busqueda BFS";
		}else {
			instancia.setBuscar(new SearchDFS());
			prueba += " y busqueda DFS";
		}
		
		instancia.addNodo("A");
		instancia.addNodo("B");
		instancia.addNodo("C");

		instancia.addArco("A", "B");
		instancia.addArco("B", "C");

		System.out.println(prueba);
		System.out.println(instancia.existeRuta("A", "C")); 
		System.out.println(instancia.existeRuta("C", "A")); 
		
		instancia.setArcos(new ArrayList<>());
		

		instancia.addArco("A", "B", 10);
		instancia.addArco("B", "C", 12);
		System.out.println("Asignacion de pesos exitosa");
		
		
		instancia.setArcos(new ArrayList<>());

		instancia.addArco("A", "B", 10);
		instancia.addArco("B", "C", 12);
		instancia.addArco("A", "C", 10);

		List<Nodo> nodos = instancia.buscarRuta("A", "C");
		for (Nodo nodo : nodos) {
		    System.out.println(nodo.getNombre());
		} 
	}

}
