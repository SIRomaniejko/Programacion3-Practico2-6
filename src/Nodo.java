
public class Nodo {
	Object contenido;
	Nodo nodoSiguiente;
	public Nodo(){
		contenido = null;
		nodoSiguiente = null;
	}
	public Object getContenido() {
		return contenido;
	}
	public Nodo getNodoSiguiente() {
		return nodoSiguiente;
	}
	public void setContenido(Object contenido) {
		this.contenido = contenido;
	}
	public void setNodoSiguiente(Nodo nodoSiguiente) {
		this.nodoSiguiente = nodoSiguiente;
	}
	public int getSize(){
		if(nodoSiguiente != null){
			return 1;
		}
		else{
			return nodoSiguiente.getSize() + 1;
		}
	}
}
