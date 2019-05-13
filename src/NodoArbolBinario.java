
public class NodoArbolBinario {
	private int value;
	private NodoArbolBinario left;
	private NodoArbolBinario right;
	public NodoArbolBinario(int value){
		this.value = value;
	}
	public NodoArbolBinario getLeft() {
		return this.left;
	}
	public NodoArbolBinario getRight() {
		return this.right;
	}
	public int getValue(){
		return this.value;
	}
	public void setLeft(int left) {
		this.left = new NodoArbolBinario(left);
	}
	public void setRight(int right) {
		this.right = new NodoArbolBinario(right);
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
	public boolean equals(int comparado){
		return this.value == comparado;
	}
	public int compare(int comparar){
		if(comparar > this.value){
			return 1;
		}
		else if(comparar == this.value){
			return 0;
		}
		else{
			return -1;
		}
	}
}
