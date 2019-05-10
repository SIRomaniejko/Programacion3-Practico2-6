import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class ArbolBinario {
	
	NodoArbolBinario root;
	
	public ArbolBinario(int value){
		root = new NodoArbolBinario(value);
	}
	public Object getRoot(){
		return root.getValue();
	}
	
	public boolean hasElement(Object element){
		return root.hasElement(element);
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public void insert(Object value){
		if(isEmpty()){
			root = new NodoArbolBinario(value);
		}
		else{
			root.insert(value);			
		}
	}
	
	public boolean delete(Object value){
		return true;
	}
	
	public int getHeight(){
		if(!isEmpty()){
			return root.getHeight();
		}
		else{
			return 0;
		}
	}
	
	public void printPosOrder(){
		
	}
	
	public void printPreOrder(){
		
	}
	
	public void printInOrder(){
		
	}
	
	public MyLinkedList getLongestBranch(){
		if(isEmpty()){
			return null;
		}
		else{
			return root.getLongestBranch();
		}
	}
	
	public MyLinkedList getFrontera(){
		if(isEmpty()){
			return null;
		}
		else{
			return root.getFrontera();
		}
	}
	
	public NodoArbolBinario testtest(){
		return root;
	}
	
	public Object getMaxElement(){
		return root.getMaxElement();
	}
	
	public MyLinkedList getElementsAtLevel(int level){
		return root.getElementsAtLevel(level, 1);
	}
}
