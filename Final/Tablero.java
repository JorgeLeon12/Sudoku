import javax.swing.*;
import java.util.*;
/*
java Tablero 9 9 5 3 4 6 7 8 9 1 2 6 7 2 1 9 5 3 4 8 1 9 8 3 4 2 5 6 7 8 5 9 7 6 1 4 2 3 4 2 6 8 5 3 7 9 1 7 1 3 9 2 4 8 5 6 9 6 1 5 3 7 2 8 4 2 8 7 4 1 9 6 3 5 3 4 5 2 8 6 1 7 9

java Tablero 9 9 5 3 0 0 7 0 0 0 0 6 0 0 1 9 5 0 0 0 0 9 8 0 0 0 0 6 0 8 0 0 0 6 0 0 0 3 4 0 0 8 0 3 0 0 1 7 0 0 0 2 0 0 0 6 0 6 0 0 0 0 2 8 0 0 0 0 4 1 9 0 0 5 0 0 0 0 8 0 0 7 9
*/

public class Tablero{
	private Casilla[][] matriz= new Casilla[9][9];
	private int numeroIntro = 0;

	
	public Tablero(){
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[i].length;j++){
			this.matriz[i][j]=new Casilla();
			}
		}
		int sector, sector2, celda = 1000000, celda2, coorX, coorX2, coorY, coorY2;
		boolean incons;

		while(gano() == false){
			imprimeTablero();
			boolean error = false;
			coorX = Integer.parseInt(JOptionPane.showInputDialog("Introduce coordenadas en X: "));
			coorY = Integer.parseInt(JOptionPane.showInputDialog("Introduce coordenadas en Y: "));
			numeroIntro = Integer.parseInt(JOptionPane.showInputDialog("Introduce el Numero a introducir en la coordenada (" + coorX + "," + coorY + "): "));
			System.out.print("Coordenadas Introducidas: " + coorX + ", " + coorY);
			System.out.println(". Numero Introducido: " + numeroIntro);
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
			
			System.out.println("");
			incons = inconsistencia(sector, celda);
			if(incons == false){
				//System.out.println("NO CAUSO INCONSISTENCIA! AQUI PONER SETVALOR(...)");
				setValor(sector, celda, numeroIntro);
			}else if(incons == true){
				System.out.println("");
				System.out.println("CAUSO INCONSISTENCIA! HAZ PERDIDO EL JUEGO! D=");
				break;
			}
		}
	}
	
	private boolean gano(){
		int i, j;
		for(i = 0; i < 9; i++){
			for(j = 0; j < 9; j++){
				if(this.matriz[i][j].getValor() == 0){
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
		int numero = this.numeroIntro;
		//Dentro de su cuadro
		for(i = 0; i < 9; i++){
			if(numero == 0){
				break;
			}
			if(this.matriz[sector][i].getValor() == numero){
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
				if(this.matriz[i][j].getValor() == numero){
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
				if(this.matriz[i][j].getValor() == numero){
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
	
	private boolean setValor(int sector, int celda, int numeroIntro){
		if(this.matriz[sector][celda].getInicial() == false){
			this.matriz[sector][celda].setValor(numeroIntro);
		//	this.matriz[sector][celda].setValor();
			return true;
		}
		//this.utilizado[sector][celda] = true;
		return false;
	}
	
	public void usoRandom(){
		Random ran = new Random();
		int num, num1, num2, num3, num4 = 0,sector, celda, numero, j, i, celda2, sector2, matriz2;
		boolean error = false;
		while(num4 < 10){
			num = ran.nextInt(4);
			while(num < 5){
				error = false;
				num1 = ran.nextInt(8);
				num2 = ran.nextInt(8);
				num3 = ran.nextInt(9);
				
				sector2 = 100000;
				celda2 = 10000;
				
				sector = num1;
				celda = num2;
				numero = num3;
				for(i = 0; i < 9; i++){
					if(this.matriz[sector][i].getValor() == numero){
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
					for(j = celda2; j < 9; j = j + 3){
						if(this.matriz[i][j].getValor() == numero){
							error = true;
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
					for(j = celda2; j < (celda2 + 3); j++){
						if(this.matriz[i][j].getValor() == numero){
							error = true;
						}
					}
				}
				
				if(error == false){
					this.matriz[num1][num2]=new Casilla(num3,true);// aquí se tiene que poner true
				}else if(error == true){
					num--;
				}
				num++;
			}
			num4++;
		}
	}
	
	public void imprimeTablero() {
		for(int i = 0; i < 5; i++){
			System.out.println("");
		}

		System.out.println("    1   2   3     4   5   6     7   8   9");
		System.out.print("  ");
		System.out.println((char)201 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)187 + " " + (char)201 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)187 + " " + (char)201 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)187);
		System.out.print("1 ");
		//" + (this.matriz[][].getValor()==0?(" "):this.matriz[][].getValor())  + "
		System.out.println((char)186 + " " + 
			(this.matriz[0][0].getValor()==0?(" "):this.matriz[0][0].getValor())  + " " + (char)186 + " " + (this.matriz[0][1].getValor()==0?(" "):this.matriz[0][1].getValor())  + " " + (char)186 + " " + (this.matriz[0][2].getValor()==0?(" "):this.matriz[0][2].getValor())  + " " + (char)186 + " " + (char)186 + " " + 
			(this.matriz[1][0].getValor()==0?(" "):this.matriz[1][0].getValor())  + " " + (char)186 + " " + (this.matriz[1][1].getValor()==0?(" "):this.matriz[1][1].getValor())  + " " + (char)186 + " " + (this.matriz[1][2].getValor()==0?(" "):this.matriz[1][2].getValor())  + " " + (char)186 + " " + (char)186 + " " + 
			(this.matriz[2][0].getValor()==0?(" "):this.matriz[2][0].getValor())  + " " + (char)186 + " " + (this.matriz[2][1].getValor()==0?(" "):this.matriz[2][1].getValor())  + " " + (char)186 + " " + (this.matriz[2][2].getValor()==0?(" "):this.matriz[2][2].getValor())  + " " + (char)186);
		System.out.print("  ");
		System.out.println((char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185 + " " + (char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185 + " " + (char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185);
		System.out.print("2 ");
		System.out.println((char)186 + " " + 
		(this.matriz[0][3].getValor()==0?(" "):this.matriz[0][3].getValor())  + " " + (char)186 + " " + (this.matriz[0][4].getValor()==0?(" "):this.matriz[0][4].getValor())  + " " + (char)186 + " " + (this.matriz[0][5].getValor()==0?(" "):this.matriz[0][5].getValor())  + " " + (char)186 + " " + (char)186 + " " + 
		(this.matriz[1][3].getValor()==0?(" "):this.matriz[1][3].getValor())  + " " + (char)186 + " " + (this.matriz[1][4].getValor()==0?(" "):this.matriz[1][4].getValor())  + " " + (char)186 + " " + (this.matriz[1][5].getValor()==0?(" "):this.matriz[1][5].getValor())  + " " + (char)186 + " " + (char)186 + " " + 
		(this.matriz[2][3].getValor()==0?(" "):this.matriz[2][3].getValor())  + " " + (char)186 + " " + (this.matriz[2][4].getValor()==0?(" "):this.matriz[2][4].getValor())  + " " + (char)186 + " " + (this.matriz[2][5].getValor()==0?(" "):this.matriz[2][5].getValor())  + " " + (char)186);
		System.out.print("  ");
		System.out.println((char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185 + " " + (char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185 + " " + (char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185);
		System.out.print("3 ");
		System.out.println((char)186 + " " + 
		(this.matriz[0][6].getValor()==0?(" "):this.matriz[0][6].getValor())  + " " + (char)186 + " " + (this.matriz[0][7].getValor()==0?(" "):this.matriz[0][7].getValor())  + " " + (char)186 + " " + (this.matriz[0][8].getValor()==0?(" "):this.matriz[0][8].getValor())  + " " + (char)186 + " " + (char)186 + " " + 
		(this.matriz[1][6].getValor()==0?(" "):this.matriz[1][6].getValor())  + " " + (char)186 + " " + (this.matriz[1][7].getValor()==0?(" "):this.matriz[1][7].getValor())  + " " + (char)186 + " " + (this.matriz[1][8].getValor()==0?(" "):this.matriz[1][8].getValor())  + " " + (char)186 + " " + (char)186 + " " + 
		(this.matriz[2][6].getValor()==0?(" "):this.matriz[2][6].getValor())  + " " + (char)186 + " " + (this.matriz[2][7].getValor()==0?(" "):this.matriz[2][7].getValor())  + " " + (char)186 + " " + (this.matriz[2][8].getValor()==0?(" "):this.matriz[2][8].getValor())  + " " + (char)186);
		System.out.print("  ");
		System.out.println((char)200 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)188 + " " + (char)200 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)188 + " " + (char)200 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)188);
		
		System.out.print("  ");
		System.out.println((char)201 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)187 + " " + (char)201 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)187 + " " + (char)201 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)187);
		System.out.print("4 ");
		System.out.println((char)186 + " " + 
		(this.matriz[3][0].getValor()==0?(" "):this.matriz[3][0].getValor())  + " " + (char)186 + " " + (this.matriz[3][1].getValor()==0?(" "):this.matriz[3][1].getValor())  + " " + (char)186 + " " + (this.matriz[3][2].getValor()==0?(" "):this.matriz[3][2].getValor())  + " " + (char)186 + " " + (char)186 + " " + 
		(this.matriz[4][0].getValor()==0?(" "):this.matriz[4][0].getValor())  + " " + (char)186 + " " + (this.matriz[4][1].getValor()==0?(" "):this.matriz[4][1].getValor())  + " " + (char)186 + " " + (this.matriz[4][2].getValor()==0?(" "):this.matriz[4][2].getValor())  + " " + (char)186 + " " + (char)186 + " " + 
		(this.matriz[5][0].getValor()==0?(" "):this.matriz[5][0].getValor())  + " " + (char)186 + " " + (this.matriz[5][1].getValor()==0?(" "):this.matriz[5][1].getValor())  + " " + (char)186 + " " + (this.matriz[5][2].getValor()==0?(" "):this.matriz[5][2].getValor())  + " " + (char)186);
		System.out.print("  ");
		System.out.println((char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185 + " " + (char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185 + " " + (char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185);
		System.out.print("5 ");
		System.out.println((char)186 + " " + 
		(this.matriz[3][3].getValor()==0?(" "):this.matriz[3][3].getValor())  + " " + (char)186 + " " + (this.matriz[3][4].getValor()==0?(" "):this.matriz[3][4].getValor())  + " " + (char)186 + " " + (this.matriz[3][5].getValor()==0?(" "):this.matriz[3][5].getValor())  + " " + (char)186 + " " + (char)186 + " " + 
		(this.matriz[4][3].getValor()==0?(" "):this.matriz[4][3].getValor())  + " " + (char)186 + " " + (this.matriz[4][4].getValor()==0?(" "):this.matriz[4][4].getValor())  + " " + (char)186 + " " + (this.matriz[4][5].getValor()==0?(" "):this.matriz[4][5].getValor())  + " " + (char)186 + " " + (char)186 + " " + 
		(this.matriz[5][3].getValor()==0?(" "):this.matriz[5][3].getValor())  + " " + (char)186 + " " + (this.matriz[5][4].getValor()==0?(" "):this.matriz[5][4].getValor())  + " " + (char)186 + " " + (this.matriz[5][5].getValor()==0?(" "):this.matriz[5][5].getValor())  + " " + (char)186);
		System.out.print("  ");
		System.out.println((char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185 + " " + (char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185 + " " + (char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185);
		System.out.print("6 ");
		System.out.println((char)186 + " " + 
		(this.matriz[3][6].getValor()==0?(" "):this.matriz[3][6].getValor())  + " " + (char)186 + " " + (this.matriz[3][7].getValor()==0?(" "):this.matriz[3][7].getValor())  + " " + (char)186 + " " + (this.matriz[3][8].getValor()==0?(" "):this.matriz[3][8].getValor())  + " " + (char)186 + " " + (char)186 + " " + 
		(this.matriz[4][6].getValor()==0?(" "):this.matriz[4][6].getValor())  + " " + (char)186 + " " + (this.matriz[4][7].getValor()==0?(" "):this.matriz[4][7].getValor())  + " " + (char)186 + " " + (this.matriz[4][8].getValor()==0?(" "):this.matriz[4][8].getValor())  + " " + (char)186 + " " + (char)186 + " " + 
		(this.matriz[5][6].getValor()==0?(" "):this.matriz[5][6].getValor())  + " " + (char)186 + " " + (this.matriz[5][7].getValor()==0?(" "):this.matriz[5][7].getValor())  + " " + (char)186 + " " + (this.matriz[5][8].getValor()==0?(" "):this.matriz[5][8].getValor())  + " " + (char)186);
		System.out.print("  ");
		System.out.println((char)200 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)188 + " " + (char)200 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)188 + " " + (char)200 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)188);
		
		System.out.print("  ");
		System.out.println((char)201 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)187 + " " + (char)201 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)187 + " " + (char)201 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)203 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)187);
		System.out.print("7 ");
		System.out.println((char)186 + " " + 
		(this.matriz[6][0].getValor()==0?(" "):this.matriz[6][0].getValor())  + " " + (char)186 + " " + (this.matriz[6][1].getValor()==0?(" "):this.matriz[6][1].getValor())  + " " + (char)186 + " " + (this.matriz[6][2].getValor()==0?(" "):this.matriz[6][2].getValor())  + " " + (char)186 + " " + (char)186 + " " + 
		(this.matriz[7][0].getValor()==0?(" "):this.matriz[7][0].getValor())  + " " + (char)186 + " " + (this.matriz[7][1].getValor()==0?(" "):this.matriz[7][1].getValor())  + " " + (char)186 + " " + (this.matriz[7][2].getValor()==0?(" "):this.matriz[7][2].getValor())  + " " + (char)186 + " " + (char)186 + " " + 
		(this.matriz[8][0].getValor()==0?(" "):this.matriz[8][0].getValor())  + " " + (char)186 + " " + (this.matriz[8][1].getValor()==0?(" "):this.matriz[8][1].getValor())  + " " + (char)186 + " " + (this.matriz[8][2].getValor()==0?(" "):this.matriz[8][2].getValor())  + " " + (char)186);
		System.out.print("  ");
		System.out.println((char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185 + " " + (char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185 + " " + (char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185);
		System.out.print("8 ");
		System.out.println((char)186 + " " + 
		(this.matriz[6][3].getValor()==0?(" "):this.matriz[6][3].getValor())  + " " + (char)186 + " " + (this.matriz[6][4].getValor()==0?(" "):this.matriz[6][4].getValor())  + " " + (char)186 + " " + (this.matriz[6][5].getValor()==0?(" "):this.matriz[6][5].getValor())  + " " + (char)186 + " " + (char)186 + " " + 
		(this.matriz[7][3].getValor()==0?(" "):this.matriz[7][3].getValor())  + " " + (char)186 + " " + (this.matriz[7][4].getValor()==0?(" "):this.matriz[7][4].getValor())  + " " + (char)186 + " " + (this.matriz[7][5].getValor()==0?(" "):this.matriz[7][5].getValor())  + " " + (char)186 + " " + (char)186 + " " + 
		(this.matriz[8][3].getValor()==0?(" "):this.matriz[8][3].getValor())  + " " + (char)186 + " " + (this.matriz[8][4].getValor()==0?(" "):this.matriz[8][4].getValor())  + " " + (char)186 + " " + (this.matriz[8][5].getValor()==0?(" "):this.matriz[8][5].getValor())  + " " + (char)186);
		System.out.print("  ");
		System.out.println((char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185 + " " + (char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185 + " " + (char)204 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)206 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)185);
		System.out.print("9 ");
		System.out.println((char)186 + " " + 
		(this.matriz[6][6].getValor()==0?(" "):this.matriz[6][6].getValor())  + " " + (char)186 + " " + (this.matriz[6][7].getValor()==0?(" "):this.matriz[6][7].getValor())  + " " + (char)186 + " " + (this.matriz[6][8].getValor()==0?(" "):this.matriz[6][8].getValor())  + " " + (char)186 + " " + (char)186 + " " + 
		(this.matriz[7][6].getValor()==0?(" "):this.matriz[7][6].getValor())  + " " + (char)186 + " " + (this.matriz[7][7].getValor()==0?(" "):this.matriz[7][7].getValor())  + " " + (char)186 + " " + (this.matriz[7][8].getValor()==0?(" "):this.matriz[7][8].getValor())  + " " + (char)186 + " " + (char)186 + " " + 
		(this.matriz[8][6].getValor()==0?(" "):this.matriz[8][6].getValor())  + " " + (char)186 + " " + (this.matriz[8][7].getValor()==0?(" "):this.matriz[8][7].getValor())  + " " + (char)186 + " " + (this.matriz[8][8].getValor()==0?(" "):this.matriz[8][8].getValor())  + " " + (char)186);
		System.out.print("  ");
		System.out.println((char)200 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)188 + " " + (char)200 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)188 + " " + (char)200 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)202 + "" + (char)205 + "" + (char)205 + "" + (char)205 + "" + (char)188);
	} 
	
	public static void main(String[] args){
		Tablero a = new Tablero();
		a.usoRandom();
		int numeroooooooo = 1000;
		if(args.length != 0){
			int cont = 0;
			for(int i = 0; i < 9; i++){
				for(int j = 0; j < 9; j++){			
					matriz2[i][j].setValor(Integer.parseInt(args[2+cont]));
					//System.out.print(args[2+cont]+"\t");	
					cont+=1;
				}
				System.out.println();
			}
		}else{
			usoRandom();
		}
		//a.imprimeTablero();
	}	
}