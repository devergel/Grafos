package grafosdev.factory;

public class GrafoUndirected extends GrafosAbstract implements Grafos{
	
	public void addArco(String origen, String destino) throws Exception {
		super.addArco(origen, destino);
		super.addArco(destino, origen);
	}
}
