import java.util.Iterator;


public class NodoIterator implements Iterator<Object>{
	Nodo nodoActual;
	public NodoIterator(Nodo nodo){
		nodoActual = new Nodo();
		nodoActual.setNodoSiguiente(nodo);
	}
	@Override
	public boolean hasNext() {
		return nodoActual.nodoSiguiente != null;
	}

	@Override
	public Object next() {
		nodoActual = nodoActual.getNodoSiguiente();
		return nodoActual.getContenido();
	}
 
}
