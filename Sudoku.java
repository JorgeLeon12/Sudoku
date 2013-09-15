import javax.swing.*;
import java.util.*;

public class Sudoku{
	public static void main(String[] args){
	//Imprimir Tablero
	
	int coorX = Integer.parseInt(JOptionPane.showInputDialog("Introduce coordenadas en X: "));
	int coorY = Integer.parseInt(JOptionPane.showInputDialog("Introduce coordenadas en Y: "));
	int numeroIntro = Integer.parseInt(JOptionPane.showInputDialog("Introduce el Numero a introducir: "));
	
	if((coorX > 0 && coorX < 4) && (coorY > 0 && coorY < 4)){
		int sector = 0;
	}
	else if((coorX > 3 && coorX < 7) && (coorY > 0 && coorY < 4)){
		int sector = 1;
	}
	else if((coorX > 6 && coorX < 10) && (coorY > 0 && coorY < 4)){
		int sector = 2;
	}
	
	
	else if((coorX > 0 && coorX < 4) && (coorY > 3 && coorY < 7)){
		int sector = 3;
	}
	else if((coorX > 3 && coorX < 7) && (coorY > 3 && coorY < 7)){
		int sector = 4;
	}
	else if((coorX > 6 && coorX < 10) && (coorY > 3 && coorY < 7)){
		int sector = 5;
	}
	
	else if((coorX > 0 && coorX < 4) && (coorY > 6 && coorY < 10)){
		int sector = 6;
	}
	else if((coorX > 3 && coorX < 7) && (coorY > 6 && coorY < 10)){
		int sector = 7;
	}
	else if((coorX > 6 && coorX < 10) && (coorY > 6 && coorY < 10)){
		int sector = 8;
	}
	
	if(coorX > 3){
		coorX2 = coorX - 3;
		if(coorX2 > 3){
			coorX2 = coorX2 - 3;
		}
	}
	if(coorY > 3){
		coorY2 = coorY - 3;
		if(coorY2 > 3){
			coorY2 = coorY2 - 3;
		}
	}
	
	if(coorY2 == 2){
		int celda = coorX2 + 3;
	}
	else if(coorY2 == 3){
		int celda = coorX2 + 3;
	}
	
	
	inconsistencia(int sector, int celda, int numero){
		int Buscar = 0;
		
		for(int i = this.celda; i < 9;i++){//corregir condicion
			Buscar = this.Casilla[sector][i];
			if(Buscar == numero){
				return true;
			}
		}
		return true;
	}
//	if inco = true
//		serValor{
//			valorar en 9 casillas 
//			if = true
//				cambias
//				
//			else
//				no
//		}
	
	
	System.out.print(coorX);
//	setValor(coorX, coorY, numeroIntro);
		
	}
}