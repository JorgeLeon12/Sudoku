import javax.swing.*;
import java.util.*;

public class Sudoku{
	public static void main(String[] args){
	//Imprimir Tablero
	int sector, sector2, celda = 10000000, celda2, coorX, coorX2, coorY, coorY2, numeroIntro;
	boolean error = false;
	coorX = Integer.parseInt(JOptionPane.showInputDialog("Introduce coordenadas en X: "));
	coorY = Integer.parseInt(JOptionPane.showInputDialog("Introduce coordenadas en Y: "));
	numeroIntro = Integer.parseInt(JOptionPane.showInputDialog("Introduce el Numero a introducir: "));
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
	
	
	int[][] Cas = {{5,3,0,6,0,0,0,9,8},{0,7,0,1,9,5,0,0,0},{0,0,0,0,0,0,0,6,0},{8,0,0,4,0,0,7,0,0},{0,6,0,8,0,3,0,2,0},{0,0,3,0,0,1,0,0,6},{0,6,0,0,0,0,0,0,0},{0,0,0,4,1,9,0,8,0},{2,8,0,0,0,5,0,7,9}};//solo de Pruebas, Borrar!!
	
	
	//inconsistencia(int sector, int celda/*, int numero*/){
		//Dentro de su cuadro
		for(int i = 0; i < 9; i++){
			if(Cas[sector][i] == /*this.*/numeroIntro){
				System.out.println("Inconsistencia: EL NUMERO " + /*this.*/numeroIntro +" YA ESTA EN ESTA SECCION, INTENTA CON OTRO NUMERO.");
				//return true;
			}
		}
		//Vertical
		if(sector > 2){
			sector2 = sector - 3;
			if(sector2 > 2){
				sector2 = sector2 - 3;
			}
		}else{
			sector2 = sector;
		}
		if(celda > 2){
			celda2 = celda - 3;
			if(celda2 > 2){
				celda2 = celda2 - 3;
			}
		}else{
			celda2 = celda;
		}
		for(int i = sector2; i < 9; i = i + 3){//analiza verticalmente
			for(int j = celda2; j < 9; j = j + 3){
				if(Cas[i][j] == /*this.*/numeroIntro){
					error = true;
					System.out.println("Inconsistencia: NUMERO REPETIDO VERTICALMENTE!");
				}
			}
		}
		//Horizontal
		if(sector > 0 && sector < 3){
			sector2 = sector - 1;
			if(sector2 == 1){
				sector2 = sector2 - 1;
			}
		}else if(sector > 3 && sector < 6){
			sector2 = sector - 1;
			if(sector2 == 4){
				sector2 = sector2 - 1;
			}
		}else if(sector > 6 && sector < 9){
			sector2 = sector - 1;
			if(sector2 == 7){
				sector2 = sector2 - 1;
			}
		}else{
			sector2 = sector;
		}

		if(celda > 0 && celda < 3){
			celda2 = celda - 1;
			if(celda2 == 1){
				celda2 = celda2 - 1;
			}
		}else if(celda > 3 && celda < 6){
			celda2 = celda - 1;
			if(celda2 == 4){
				celda2 = celda2 - 1;
			}
		}else if(celda > 6 && celda < 9){
			celda2 = celda - 1;
			if(celda2 == 7){
				celda2 = celda2	 - 1;
			}
		}

		for(int i = sector2; i < (sector2 + 3); i++){//analiza Horizontalmente
			for(int j = celda2; j < (celda2 + 3); j++){
				if(Cas[i][j] == /*this.*/numeroIntro){
					error = true;
					System.out.println("Inconsistencia: NUMERO REPETIDO HORIZONTALMENTE!");
				}
			}
		}
		//if(error == true){
			//return true;
		//}else{
			//return false;
		//}
	//}
	}
}