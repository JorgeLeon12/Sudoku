import javax.swing.*;
import java.util.*;

public class Sudoku{
	public static void main(String[] args){
	//Imprimir Tablero
	int sector, celda = 10000, coorX2, coorY2, sector2;
	int coorX = Integer.parseInt(JOptionPane.showInputDialog("Introduce coordenadas en X: "));
	int coorY = Integer.parseInt(JOptionPane.showInputDialog("Introduce coordenadas en Y: "));
	int numeroIntro = Integer.parseInt(JOptionPane.showInputDialog("Introduce el Numero a introducir: "));
	System.out.println(coorX + " - " + coorY);//solo de Pruebas, Borrar!!
	
	if((coorX > 0 && coorX < 4) && (coorY > 0 && coorY < 4)){
		sector = 0;
	}
	else if((coorX > 3 && coorX < 7) && (coorY > 0 && coorY < 4)){
		sector = 1;
	}
	else if((coorX > 6 && coorX < 10) && (coorY > 0 && coorY < 4)){
		sector = 2;
	}
	
	
	else if((coorX > 0 && coorX < 4) && (coorY > 3 && coorY < 7)){
		sector = 3;
	}
	else if((coorX > 3 && coorX < 7) && (coorY > 3 && coorY < 7)){
		sector = 4;
	}
	else if((coorX > 6 && coorX < 10) && (coorY > 3 && coorY < 7)){
		sector = 5;
	}
	
	else if((coorX > 0 && coorX < 4) && (coorY > 6 && coorY < 10)){
		sector = 6;
	}
	else if((coorX > 3 && coorX < 7) && (coorY > 6 && coorY < 10)){
		sector = 7;
	}
	else if((coorX > 6 && coorX < 10) && (coorY > 6 && coorY < 10)){
		sector = 8;
	}
	else{
		System.out.print("Error! Numero Invalido!");
		sector = 9;
	}
	
	if(coorX > 3){
		coorX2 = coorX - 3;
		if(coorX2 > 3){
			coorX2 = coorX2 - 3;
		}
	}
	else{
		coorX2 = coorX;
	}
	if(coorY > 3){
		coorY2 = coorY - 3;
		if(coorY2 > 3){
			coorY2 = coorY2 - 3;
		}
	}
	else{
		coorY2 = coorY;
	}
	
	if(coorY2 == 1){
		celda = coorX2 - 1;
	}
	else if(coorY2 == 2){
		celda = coorX2 + 2;
	}
	else if(coorY2 == 3){
		celda = coorX2 + 5;
	}
	
	
	System.out.println("Cuadro: " + sector);//solo de Pruebas, Borrar!!
	System.out.println("Posicion: " + celda);//solo de Pruebas, Borrar!!
	int[][] Cas = {{5,3,0,6,0,0,0,9,8},{0,7,0,1,9,5,0,0,0},{0,0,0,0,0,0,0,6,0},{8,0,0,4,0,0,7,0,0},{0,6,0,8,0,3,0,2,0},{0,0,3,0,0,1,0,0,6},{0,6,0,0,0,0,0,0,0},{0,0,0,4,1,9,0,8,0},{2,8,0,0,0,5,0,7,9}};//solo de Pruebas, Borrar!!
	
	System.out.println("Numero en Casilla: " + Cas[sector][celda]);//solo de Pruebas, Borrar!!
	
	//inconsistencia(int sector, int celda/*, int numero*/){
		int Buscar = 0;
		if(sector > 3){
			sector2 = sector - 3;
			if(sector > 3){
				sector2 = sector2 - 3;
			}
		}else{
			sector2 = sector;
		}
		for(int i = sector2; i < 9; i = i + 3){
			for(int j = cfelda; j < 9; j = j + 3){
				if(Cas[i][j] == /*this.*/numeroIntro){
					//return false;
					System.out.println("Inconsistencia: NUMERO REPETIDO!");
				}
			}
			for(int j = celda; j >= 0 ; j = j - 3){
				if(Cas[i][j] == /*this.*/numeroIntro){
					//return false;
					System.out.println("Inconsistencia: NUMERO REPETIDO!");
				}
			}
		}
		//return true;
	//}
	
//	if inco = true
//		serValor{
//			valorar en 9 casillas 
//			if = true
//				cambias
//				
//			else
//				no
//		}
	
	
//	System.out.print(coorX);
//	setValor(coorX, coorY, numeroIntro);
		
	}
}