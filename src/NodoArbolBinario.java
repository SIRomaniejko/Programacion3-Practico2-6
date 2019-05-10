import java.util.ArrayList;


public class NodoArbolBinario {
	private Object value;
	private NodoArbolBinario left;
	private NodoArbolBinario right;
	private int debugLeft;
	private int debugRight;
	public NodoArbolBinario(Object value){
		this.value = value;
	}
	public NodoArbolBinario getLeft() {
		return this.left;
	}
	public NodoArbolBinario getRight() {
		return this.right;
	}
	public Object getValue(){
		return this.value;
	}
	public void setLeft(NodoArbolBinario left) {
		this.left = left;
	}
	public void setRight(NodoArbolBinario right) {
		this.right = right;
	}
	public boolean hasLeft(){
		return left != null;
	}
	public boolean hasRight(){
		return right != null;
	}
	public boolean isLeaf(){
		return !hasLeft() && !hasRight();
	}
	public void insert(Object value){
		if(((Integer)value).intValue() < ((Integer)this.value).intValue()){
			if(left == null){
				left = new NodoArbolBinario(value);
			}
			else{
				left.insert(value);
			}
		}
		else if(((Integer)value).intValue() > ((Integer)this.value).intValue()){
			if(right == null){
				right = new NodoArbolBinario(value);
			}
			else{
				right.insert(value);
			}
		}
	}
	public boolean hasElement(Object value){
		if(this.equals(value))
			return true;
		else{
			if(this.hasLeft() && left.hasElement(value) == true){
				return true;
			}
			else if(this.hasRight()){
				return right.hasElement(value);
			}
			else{
				return false;
			}
		}
		
	}
	
	public boolean equals(Object comparado){
		return this.value == comparado || super.equals(comparado);
	}
	
	public int getHeight(){
		if(!hasLeft() && !hasRight()){
			return 1;
		}
		else if(!hasLeft() && hasRight()){
			debugRight = right.getHeight();
			return right.getHeight() + 1;
		}
		else if(hasLeft() && !hasRight()){
			debugLeft = left.getHeight();
			return left.getHeight() + 1;
		}
		else{
			int alturaIzquierda = left.getHeight();
			int alturaDerecha = right.getHeight();
			debugLeft = alturaIzquierda;
			debugRight = alturaDerecha;
			if(alturaIzquierda > alturaDerecha){
				return alturaIzquierda + 1;
			}
			else{
				return alturaDerecha + 1;
			}
		}
	}
	
	public MyLinkedList getLongestBranch(){
		
		if(!hasLeft() && !hasRight()){
			MyLinkedList regreso = new MyLinkedList();
			regreso.addNodoPrincipio(this.value);
			return regreso;
		}
		else if(hasLeft() && hasRight()){
			MyLinkedList listaLeft = this.left.getLongestBranch();
			MyLinkedList listaRight = this.right.getLongestBranch();
			if(listaLeft.getSize() > listaRight.getSize()){
				listaLeft.addNodoPrincipio(this.value);
				return listaLeft;
			}
			else{
				listaRight.addNodoPrincipio(this.value);
				return listaRight;
			}
		}
		else{
			MyLinkedList regreso;
			if(hasLeft())
				regreso = left.getLongestBranch();
			else{
				regreso = right.getLongestBranch();
			}
			regreso.addNodoPrincipio(this.value);
			return regreso;
		}
	}
	
	public MyLinkedList getFrontera(){
		if(this.isLeaf()){
			MyLinkedList regreso = new MyLinkedList();
			regreso.addNodoPrincipio(this.value);
			return regreso;
		}
		else{
			if(left != null && right == null){
				return left.getFrontera();
			}
			else if(left == null && right != null){
				return right.getFrontera();
			}
			else{
				MyLinkedList leftList = left.getFrontera();
				leftList.fusionLista(right.getFrontera());
				return leftList;
			}
		}
	}
	
	public Object getMaxElement(){
		if(!this.hasRight()){
			return this.getValue();
		}
		else{
			return right.getMaxElement();
		}
	}
	
	public MyLinkedList getElementsAtLevel(int level, int levelActual){
		if(level == levelActual){
			MyLinkedList regreso = new MyLinkedList();
			regreso.addNodoPrincipio(this.getValue());
			return regreso;
		}
		else if(this.isLeaf()){
			return new MyLinkedList();
		}
		else if(hasRight() && !hasLeft()){
			return right.getElementsAtLevel(level, ++levelActual);
		}
		else if(!hasRight() && hasLeft()){
			return left.getElementsAtLevel(level, ++levelActual);
		}
		else{
			MyLinkedList leftList = left.getElementsAtLevel(level, ++levelActual);
			leftList.fusionLista(right.getElementsAtLevel(level, levelActual));
			return leftList;
		}
	}
}
