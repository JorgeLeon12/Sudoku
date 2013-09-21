import javax.swing.*;
//import java.util.*;
public class Sudoku {
	private int numeroIntro = 0;
	private int [][] Cas = {{5,3,0,6,0,0,0,9,8},{0,7,0,1,9,5,0,0,0},{0,0,0,0,0,0,0,6,0},{8,0,0,4,0,0,7,0,0},{0,6,0,8,0,3,0,2,0},{0,0,3,0,0,1,0,0,6},{0,6,0,0,0,0,0,0,0},{0,0,0,4,1,9,0,8,0},{2,8,0,0,0,5,0,7,9}};//prueba!
	//private int [][] Cas = {{5,3,1,6,1,1,1,9,8},{1,7,1,1,9,5,1,1,1},{1,1,1,1,1,1,1,6,1},{8,1,1,4,1,1,7,1,1},{1,6,1,8,1,3,1,2,1},{1,1,3,1,1,1,1,1,6},{1,6,1,1,1,1,1,1,1},{1,1,1,4,1,9,1,8,1},{2,8,1,1,1,5,1,7,9}};//para calar si gano o no
	private boolean [][] inicial ={
   		{false,false,true,false,true,true,true,false,false},
   		{true,false,true,false,false,false,true,true,true},
		{true,true,true,true,true,true,true,false,true},
		{false,true,true,false,true,true,false,true,true},
		{true,false,true,false,true,false,true,false,true},
		{true,true,false,true,true,false,true,true,false},
		{true,false,true,true,true,true,true,true,true},
		{true,true,true,false,false,false,true,false,true},
		{false,false,true,true,true,false,true,false,false}};
		
   private boolean[][] utilizado ={
   		{false,false,false,false,false,false,false,false,false},
   		{false,false,false,false,false,false,false,false,false},
		{false,false,false,false,false,false,false,false,false},
		{false,false,false,false,false,false,false,false,false},
		{false,false,false,false,false,false,false,false,false},
		{false,false,false,false,false,false,false,false,false},
		{false,false,false,false,false,false,false,false,false},
		{false,false,false,false,false,false,false,false,false},
		{false,false,false,false,false,false,false,false,false}};

	public Sudoku(){
		int sector, sector2, celda = 10000000, celda2, coorX, coorX2, coorY, coorY2;
		boolean incons;
		while(gano() == false){
			imprimeTablero();
			boolean error = false;
			coorX = Integer.parseInt(JOptionPane.showInputDialog("Introduce coordenadas en X: "));
			coorY = Integer.parseInt(JOptionPane.showInputDialog("Introduce coordenadas en Y: "));
			numeroIntro = Integer.parseInt(JOptionPane.showInputDialog("Introduce el Numero a introducir en la coordenada (" + coorX + "," + coorY + "): "));
			System.out.print("Coordenadas Introducidas: " + coorX + ", " + coorY);
			System.out.println(". Numero Introducido: " + numeroIntro);
			//Cas = new Array({{5,3,0,6,0,0,0,9,8},{0,7,0,1,9,5,0,0,0},{0,0,0,0,0,0,0,6,0},{8,0,0,4,0,0,7,0,0},{0,6,0,8,0,3,0,2,0},{0,0,3,0,0,1,0,0,6},{0,6,0,0,0,0,0,0,0},{0,0,0,4,1,9,0,8,0},{2,8,0,0,0,5,0,7,9}});
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
			}else{
				coorX2 = coorX;
			}
			
			if(coorY > 3){
				coorY2 = coorY - 3;
				if(coorY2 > 3){
					coorY2 = coorY2 - 3;
				}
			}else{
				coorY2 = coorY;
			}
			
			if(coorY2 == 1){
				celda = coorX2 - 1;
			}else if(coorY2 == 2){
				celda = coorX2 + 2;
			}else if(coorY2 == 3){
				celda = coorX2 + 5;
			}
			incons = inconsistencia(sector, celda);
			if(incons == false){
				//System.out.println("NO CAUSO INCONSISTENCIA! AQUI PONER SETVALOR(...)");
				setValor(sector, celda, numeroIntro);
			}else if(incons == true){
				System.out.println("CAUSO INCONSISTENCIA!");
			}
		}
	}
	private void setValor(int sector, int celda, int numeroIntro){
		if(this.inicial[sector][celda] == true){
			this.Cas[sector][celda] = numeroIntro;
		}
		this.utilizado[sector][celda] = true;
	}
	private boolean gano(){
		int i, j;
		for(i = 0; i < 9; i++){
			for(j = 0; j < 9; j++){
				if(this.Cas[i][j] == 0){
					return false;
				}
			}
		}
		System.out.println("GANASTE! SUDOKU COMPLETADO!!!");
		return true;
	}
	private boolean inconsistencia(int sector, int celda){
		int i, j, sector2, celda2;
		boolean error = false;
		int[][] Cas = this.Cas;
		int numero = this.numeroIntro;
		//Dentro de su cuadro
		for(i = 0; i < 9; i++){
			if(numero == 0){
				break;
			}
			if(Cas[sector][i] == numero){
				System.out.println("Inconsistencia: EL NUMERO " + numero +" YA ESTA EN ESTA SECCION, INTENTA CON OTRO NUMERO.");
				error = true;
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
		
		for(i = sector2; i < 9; i = i + 3){//analiza verticalmente
			if(numero == 0){
				break;
			}
			for(j = celda2; j < 9; j = j + 3){
				if(Cas[i][j] == numero){
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
		celda2 = celda;
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
				celda2 = celda2  - 1;
			}
		}
		
		for(i = sector2; i < (sector2 + 3); i++){//analiza Horizontalmente
			if(numero == 0){
				break;
			}
			for(j = celda2; j < (celda2 + 3); j++){
				if(Cas[i][j] == numero){
					error = true;
					System.out.println("Inconsistencia: NUMERO REPETIDO HORIZONTALMENTE!");
				}
			}
		}
		
		if((error == true) && numero != 0){
			return true;
		}else{
			return false;
		}
	}
	
	private void imprimeTablero(){
		for(int i = 0; i < 5; i++){
			System.out.println("");
		}
		int[][] Cas = this.Cas;
		System.out.println("    1   2   3     4   5   6     7   8   9");
		System.out.print("  ");
		System.out.println((char)201 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)187 + " " + (char)201 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)187 + " " + (char)201 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)187);
		System.out.print("1 ");
		//" + (Cas[][]==0?(" "):Cas[][])  + "
		System.out.println((char)186 + " " + 
			(Cas[0][0]==0?(" "):Cas[0][0])  + " " + (char)186 + " " + (Cas[0][1]==0?(" "):Cas[0][1])  + " " + (char)186 + " " + (Cas[0][2]==0?(" "):Cas[0][2])  + " " + (char)186 + " " + (char)186 + " " + 
			(Cas[1][0]==0?(" "):Cas[1][0])  + " " + (char)186 + " " + (Cas[1][1]==0?(" "):Cas[1][1])  + " " + (char)186 + " " + (Cas[1][2]==0?(" "):Cas[1][2])  + " " + (char)186 + " " + (char)186 + " " + 
			(Cas[2][0]==0?(" "):Cas[2][0])  + " " + (char)186 + " " + (Cas[2][1]==0?(" "):Cas[2][1])  + " " + (char)186 + " " + (Cas[2][2]==0?(" "):Cas[2][2])  + " " + (char)186);
		System.out.print("  ");
		System.out.println((char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185 + " " + (char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185 + " " + (char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185);
		System.out.print("2 ");
		System.out.println((char)186 + " " + 
		(Cas[0][3]==0?(" "):Cas[0][3])  + " " + (char)186 + " " + (Cas[0][4]==0?(" "):Cas[0][4])  + " " + (char)186 + " " + (Cas[0][5]==0?(" "):Cas[0][5])  + " " + (char)186 + " " + (char)186 + " " + 
		(Cas[1][3]==0?(" "):Cas[1][3])  + " " + (char)186 + " " + (Cas[1][4]==0?(" "):Cas[1][4])  + " " + (char)186 + " " + (Cas[1][5]==0?(" "):Cas[1][5])  + " " + (char)186 + " " + (char)186 + " " + 
		(Cas[2][3]==0?(" "):Cas[2][3])  + " " + (char)186 + " " + (Cas[2][4]==0?(" "):Cas[2][4])  + " " + (char)186 + " " + (Cas[2][5]==0?(" "):Cas[2][5])  + " " + (char)186);
		System.out.print("  ");
		System.out.println((char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185 + " " + (char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185 + " " + (char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185);
		System.out.print("3 ");
		System.out.println((char)186 + " " + 
		(Cas[0][6]==0?(" "):Cas[0][6])  + " " + (char)186 + " " + (Cas[0][7]==0?(" "):Cas[0][7])  + " " + (char)186 + " " + (Cas[0][8]==0?(" "):Cas[0][8])  + " " + (char)186 + " " + (char)186 + " " + 
		(Cas[1][6]==0?(" "):Cas[1][6])  + " " + (char)186 + " " + (Cas[1][7]==0?(" "):Cas[1][7])  + " " + (char)186 + " " + (Cas[1][8]==0?(" "):Cas[1][8])  + " " + (char)186 + " " + (char)186 + " " + 
		(Cas[2][6]==0?(" "):Cas[2][6])  + " " + (char)186 + " " + (Cas[2][7]==0?(" "):Cas[2][7])  + " " + (char)186 + " " + (Cas[2][8]==0?(" "):Cas[2][8])  + " " + (char)186);
		System.out.print("  ");
		System.out.println((char)200 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)188 + " " + (char)200 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)188 + " " + (char)200 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)188);
		
		System.out.print("  ");
		System.out.println((char)201 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)187 + " " + (char)201 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)187 + " " + (char)201 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)187);
		System.out.print("4 ");
		System.out.println((char)186 + " " + 
		(Cas[3][0]==0?(" "):Cas[3][0]) + " " + (char)186 + " " + (Cas[3][1]==0?(" "):Cas[3][1]) + " " + (char)186 + " " + (Cas[3][2]==0?(" "):Cas[3][2]) + " " + (char)186 + " " + (char)186 + " " + 
		(Cas[4][0]==0?(" "):Cas[4][0]) + " " + (char)186 + " " + (Cas[4][1]==0?(" "):Cas[4][1]) + " " + (char)186 + " " + (Cas[4][2]==0?(" "):Cas[4][2]) + " " + (char)186 + " " + (char)186 + " " + 
		(Cas[5][0]==0?(" "):Cas[5][0]) + " " + (char)186 + " " + (Cas[5][1]==0?(" "):Cas[5][1]) + " " + (char)186 + " " + (Cas[5][2]==0?(" "):Cas[5][2]) + " " + (char)186);
		System.out.print("  ");
		System.out.println((char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185 + " " + (char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185 + " " + (char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185);
		System.out.print("5 ");
		System.out.println((char)186 + " " + 
		(Cas[3][3]==0?(" "):Cas[3][3]) + " " + (char)186 + " " + (Cas[3][4]==0?(" "):Cas[3][4]) + " " + (char)186 + " " + (Cas[3][5]==0?(" "):Cas[3][5]) + " " + (char)186 + " " + (char)186 + " " + 
		(Cas[4][3]==0?(" "):Cas[4][3]) + " " + (char)186 + " " + (Cas[4][4]==0?(" "):Cas[4][4]) + " " + (char)186 + " " + (Cas[4][5]==0?(" "):Cas[4][5]) + " " + (char)186 + " " + (char)186 + " " + 
		(Cas[5][3]==0?(" "):Cas[5][3]) + " " + (char)186 + " " + (Cas[5][4]==0?(" "):Cas[5][4]) + " " + (char)186 + " " + (Cas[5][5]==0?(" "):Cas[5][5]) + " " + (char)186);
		System.out.print("  ");
		System.out.println((char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185 + " " + (char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185 + " " + (char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185);
		System.out.print("6 ");
		System.out.println((char)186 + " " + 
		(Cas[3][6]==0?(" "):Cas[3][6]) + " " + (char)186 + " " + (Cas[3][7]==0?(" "):Cas[3][7]) + " " + (char)186 + " " + (Cas[3][8]==0?(" "):Cas[3][8]) + " " + (char)186 + " " + (char)186 + " " + 
		(Cas[4][6]==0?(" "):Cas[4][6]) + " " + (char)186 + " " + (Cas[4][7]==0?(" "):Cas[4][7]) + " " + (char)186 + " " + (Cas[4][8]==0?(" "):Cas[4][8]) + " " + (char)186 + " " + (char)186 + " " + 
		(Cas[5][6]==0?(" "):Cas[5][6]) + " " + (char)186 + " " + (Cas[5][7]==0?(" "):Cas[5][7]) + " " + (char)186 + " " + (Cas[5][8]==0?(" "):Cas[5][8]) + " " + (char)186);
		System.out.print("  ");
		System.out.println((char)200 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)188 + " " + (char)200 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)188 + " " + (char)200 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)188);
		
		System.out.print("  ");
		System.out.println((char)201 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)187 + " " + (char)201 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)187 + " " + (char)201 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)187);
		System.out.print("7 ");
		System.out.println((char)186 + " " + 
		(Cas[6][0]==0?(" "):Cas[6][0]) + " " + (char)186 + " " + (Cas[6][1]==0?(" "):Cas[6][1]) + " " + (char)186 + " " + (Cas[6][2]==0?(" "):Cas[6][2]) + " " + (char)186 + " " + (char)186 + " " + 
		(Cas[7][0]==0?(" "):Cas[7][0]) + " " + (char)186 + " " + (Cas[7][1]==0?(" "):Cas[7][1]) + " " + (char)186 + " " + (Cas[7][2]==0?(" "):Cas[7][2]) + " " + (char)186 + " " + (char)186 + " " + 
		(Cas[8][0]==0?(" "):Cas[8][0]) + " " + (char)186 + " " + (Cas[8][1]==0?(" "):Cas[8][1]) + " " + (char)186 + " " + (Cas[8][2]==0?(" "):Cas[8][2]) + " " + (char)186);
		System.out.print("  ");
		System.out.println((char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185 + " " + (char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185 + " " + (char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185);
		System.out.print("8 ");
		System.out.println((char)186 + " " + 
		(Cas[6][3]==0?(" "):Cas[6][3]) + " " + (char)186 + " " + (Cas[6][4]==0?(" "):Cas[6][4]) + " " + (char)186 + " " + (Cas[6][5]==0?(" "):Cas[6][5]) + " " + (char)186 + " " + (char)186 + " " + 
		(Cas[7][3]==0?(" "):Cas[7][3]) + " " + (char)186 + " " + (Cas[7][4]==0?(" "):Cas[7][4]) + " " + (char)186 + " " + (Cas[7][5]==0?(" "):Cas[7][5]) + " " + (char)186 + " " + (char)186 + " " + 
		(Cas[8][3]==0?(" "):Cas[8][3]) + " " + (char)186 + " " + (Cas[8][4]==0?(" "):Cas[8][4]) + " " + (char)186 + " " + (Cas[8][5]==0?(" "):Cas[8][5]) + " " + (char)186);
		System.out.print("  ");
		System.out.println((char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185 + " " + (char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185 + " " + (char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185);
		System.out.print("9 ");
		System.out.println((char)186 + " " + 
		(Cas[6][6]==0?(" "):Cas[6][6]) + " " + (char)186 + " " + (Cas[6][7]==0?(" "):Cas[6][7]) + " " + (char)186 + " " + (Cas[6][8]==0?(" "):Cas[6][8]) + " " + (char)186 + " " + (char)186 + " " + 
		(Cas[7][6]==0?(" "):Cas[7][6]) + " " + (char)186 + " " + (Cas[7][7]==0?(" "):Cas[7][7]) + " " + (char)186 + " " + (Cas[7][8]==0?(" "):Cas[7][8]) + " " + (char)186 + " " + (char)186 + " " + 
		(Cas[8][6]==0?(" "):Cas[8][6]) + " " + (char)186 + " " + (Cas[8][7]==0?(" "):Cas[8][7]) + " " + (char)186 + " " + (Cas[8][8]==0?(" "):Cas[8][8]) + " " + (char)186);
		System.out.print("  ");
		System.out.println((char)200 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)188 + " " + (char)200 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)188 + " " + (char)200 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)188);
	}
	public static void main(String[] args){
		Sudoku C = new Sudoku();        
	}
}