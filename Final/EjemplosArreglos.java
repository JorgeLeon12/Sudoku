//César Alejandro Robles Soltero
//A01226103

public class EjemplosArreglos{

	public static int suma(int[] valores){
		int suma=0;
		for(int i=0;valores.length>i;i++){
			suma+=valores[i];
		}
		return suma;			
	}

	public static int NumMayor(int[] valores){
		int mayor=valores[0];
		for(int i=1;valores.length>i;i++){
			if(valores[i]>mayor){
				mayor=valores[i];
			}
		}
		return mayor;			
	}

	public static int minimo(int[] valores){
		int minimo=valores[1];
		for(int i=1;i<valores.length;i++){
			if(valores[i]<minimo){
				minimo=valores[i];
			}
		}	
		return minimo;
	}

	public static double promedio(int[] valores){
		double suma=0;
		for(int i=0;i<valores.length;i++){
			suma+=valores[i];
		}
		return suma/(valores.length);
	}

	public static void bidemensional(String[][] texto){
		for(int i=0;i<texto.length;i++){
			for(int j=0;j<texto[i].length;j++){
				System.out.print(texto[i][j]+"\t");
			}
		System.out.println();			
		}	
	}

	public static void main(String[] args){  //Contiene los parámetros 
		int[] numeros={10,5,6,3,8,7,2};
		String[][] frase={{"Hola","buenas","tardes"},{"¿Cómo","estás?"}};
		System.out.println("La suma total de los elementos en el arreglo es: ");
		System.out.println(suma(numeros));
		System.out.println(NumMayor(numeros));
		System.out.println(minimo(numeros));
		System.out.println(promedio(numeros));
		bidemensional(frase);	
		
	
		if(args.length!=0){
			int cont=0;
			for(int i=0;i<Integer.parseInt(args[0]);i++){
				for(int j=0;j<Integer.parseInt(args[1]);j++){			
					System.out.print(args[2+cont]+"\t");	
					cont+=1;
				}
				System.out.println();
			}
		}
			

		/*for(int i=0;i<args.length;i++){
			System.out.println("Contenido en args "+i+""+args[i]);
		}*/
	}
}
