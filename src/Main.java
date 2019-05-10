
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolBinario navidad = new ArbolBinario(5);
		navidad.insert(3);
		navidad.insert(1);
		navidad.insert(4);
		navidad.insert(2);
		navidad.insert(7);
		navidad.insert(9);
		navidad.insert(6);
		navidad.insert(8);
		MyLinkedList listaLoca = navidad.getFrontera();
		for(Object value: listaLoca){
			System.out.println(value);
		}
		
	}

}
