import java.util.ArrayList;

public class ArbolBinario {
	
	NodoArbolBinario root;
	
	public ArbolBinario(int value){
		root = new NodoArbolBinario(value);
	}
	public Object getRoot(){
		return root.getValue();
	}
	
	public boolean hasElement(int element){
		return this.hasElement(this.root, element);
	}
	
	private boolean hasElement(NodoArbolBinario nodo, int element){
		if(nodo.equals(element)){
			return true;
		}
		else{
			if(this.hasElement(nodo.getLeft(), element) || this.hasElement(nodo.getRight(), element)){
				return true;
			}
		}
		return false;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public void insert(int value){
		if(isEmpty()){
			root = new NodoArbolBinario(value);
		}
		else{
			NodoArbolBinario nodoActual = root;
			boolean terminado = false;
			while(!terminado){
				int comparacion = nodoActual.compare(value);
				if(comparacion < 0){
					if(!nodoActual.hasLeft()){
						nodoActual.setLeft(value);
						terminado = true;
					}
					else{
						nodoActual = nodoActual.getLeft();
					}
				}
				else if(comparacion > 0){
					if(!nodoActual.hasRight()){
						nodoActual.setRight(value);
						terminado = true;
					}
					else{
						nodoActual = nodoActual.getRight();
					}
				}
				else{
					terminado = true;
				}
			}
		}
	}
	
	public ArrayList<Integer> getFrontera(){
		if(isEmpty()){
			return null;
		}
		else{
			ArrayList<Integer> frontera = new ArrayList<Integer>();
			this.recorrerFrontera(frontera, this.root);
			return frontera;
		}
	}
	
	private void recorrerFrontera(ArrayList<Integer> frontera, NodoArbolBinario nodoActual){
		if(nodoActual.isLeaf()){
			frontera.add(nodoActual.getValue());
		}
		else{
			if(nodoActual.hasLeft()){
				recorrerFrontera(frontera, nodoActual.getLeft());
			}
			if(nodoActual.hasRight()){
				recorrerFrontera(frontera, nodoActual.getRight());
			}
		}
	}
}
