import java.util.Iterator;



public class MyLinkedList implements Iterable<Object>{
	Nodo primerNodo;
	Nodo lastNodo;
	int size;
	public MyLinkedList(){
		primerNodo = null;
		lastNodo = null;
		size = 0;
	}
	public Object getNodo(int index){
		Nodo nodoActual = primerNodo;
		for(int x = 0; x < index; x++){
			nodoActual = nodoActual.getNodoSiguiente();
		}
		return nodoActual.getContenido();
	}
	public void print(int index){
		Nodo nodoActual = primerNodo;
		System.out.println(nodoActual.getContenido());
		for(int x = 0; x < index; x++){
			nodoActual = nodoActual.getNodoSiguiente();
			System.out.println(nodoActual.getContenido());
		}
	}
	public void addNodoPrincipio(Object contenido){
		Nodo nNuevo = new Nodo();
		nNuevo.setContenido(contenido);
		nNuevo.setNodoSiguiente(primerNodo);
		primerNodo = nNuevo;
		if(++size == 1){
			lastNodo = nNuevo;
		}
	}
	public Object extractFront(){
		Object regreso = primerNodo.getContenido();
		Nodo nodoSegundo = primerNodo.getNodoSiguiente();
		primerNodo = nodoSegundo;
		if(--size == 0){
			lastNodo = null;
		}
		return regreso;
	}
	
	private Nodo getFront(){
		return primerNodo;
	}
	
	private Nodo getLast(){
		return lastNodo;
	}
	
	public boolean isEmpty(){
		return primerNodo == null;
	}
	public int getSize(){
		return size;
	}
	@Override
	public Iterator<Object> iterator() {
		return new NodoIterator(primerNodo);
	}
	
	public void fusionLista(MyLinkedList listaB){
		Nodo listaBFront = listaB.getFront();
		if(listaBFront != null){
			if(this.primerNodo == null){
				this.primerNodo = listaBFront;
			}
			else{
				this.lastNodo.nodoSiguiente = listaB.getFront();
				this.size += listaB.getSize();
			}
			this.lastNodo = listaB.getLast();
		}
	}
}
