package sopaletras;

public class Main {

	public static void main(String[] args) {
		SopaLetras prueba=new SopaLetras(5, 7, 3);
		char[][] letras= {{'m','r','t','i','u','a','u'},{'c','e','f','g','s','h','j'},{'a','a','s','a','v','j','j'},{'s','s','c','a','x','s','k'},{'c','e','r','o','m','e','l'}};
		String[] palabras= {"casa","mesa","cero"};
		prueba.cargar(letras, palabras);
		int[] a=prueba.buscar("cero");
		for(int i=0; i<a.length; i++) {
			System.out.print(" "+a[i]);
		}
		System.out.println(" ");
		
		char[][] b=prueba.resolver();
		for(int i=0; i<b.length; i++) {
			for(int j=0; j<b[i].length; j++) {
				System.out.print(b[i][j]+" ");
			}
			System.out.println("");
		}

	}

}
