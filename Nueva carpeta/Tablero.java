import javax.swing.*;
import java.util.*;


public class Tablero{
	//private int numeroIntro = 0;
	
	
	
	private Casilla[][] matriz= new Casilla[9][9];
	
	
	public Tablero(){   
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[i].length;j++){
				this.matriz[i][j]=new Casilla();
			}                    
		}
		
		
		
		
		
		
		//
		
		int i;
		for(i = 0; i< 8; i++){
			Cas[i] = Casilla.getCas();
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
			incons = inconsistencia(sector, celda);
			if(incons == false){
				setValor(sector, celda, numeroIntro);
			}else if(incons == true){
				System.out.println("CAUSO INCONSISTENCIA!");
			}
		}

		//
	}
	
	
	
	public void usoRandom(){
		Random ran = new Random();
		int num, num1, num2, num3, num4 = 0;
		while(num4 < 10){
			num = ran.nextInt(4);
			while(num < 5){
				num1 = ran.nextInt(8);
				num2 = ran.nextInt(8);
				num3 = ran.nextInt(8);
				this.matriz[num1][num2]=new Casilla(num3,false);// aquí se tiene que poner true
				num++;
			}
			num4++;
		}
	}
	
	
	
	/* public boolean setValor(int fila, int columna, int valor)
	{
	this.matriz[fila][columna].setValor(valor);
	
	}
	*/
	
	public void inconsistencia(int fila, int columna){
	}
	
	/*
	public boolean gano()
	{
	}
	
	*/
	
	
	public void imprimeTablero() 
	{  System.out.println("    " + "0"+"   " + "1"+"   " + "2"+"   " + "3"+"   " + "4"+"   " + "5"+"   " + "6"+"   " + "7"+"   " + "8" );   
	System.out.println("  "+(char)201 + "" +(char)205+ "" +(char)205+ "" +(char)205+ "" +(char)203+ "" +(char)205+ "" +(char)205+ "" +(char)205+ "" +(char)203+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)219+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)203+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)203+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)219+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)203+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)203+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)187);
	System.out.println("0"+" " +(char)186 +" "+ (this.matriz[0][0].getValor()==0?" ":this.matriz[0][0].getValor())+ " "  + (char)186+ " "+ (this.matriz[0][1].getValor()==0?" ":this.matriz[0][1].getValor())+ " "  + (char)186+ " "+ (this.matriz[0][2].getValor()==0?" ":this.matriz[0][2].getValor())+ " "    + (char)219+ " "+ (this.matriz[0][3].getValor()==0?" ":this.matriz[0][3].getValor())+ " "    + (char)186+ " "+ (this.matriz[0][4].getValor()==0?" ":this.matriz[0][4].getValor())+ " "    + (char)186+ " "+ (this.matriz[0][5].getValor()==0?" ":this.matriz[0][5].getValor())+ " "    + (char)219+ " "+ (this.matriz[0][6].getValor()==0?" ":this.matriz[0][6].getValor())+ " "    + (char)186+ " "+ (this.matriz[0][7].getValor()==0?" ":this.matriz[0][7].getValor())+ " "    + (char)186+ " "+ (this.matriz[0][8].getValor()==0?" ":this.matriz[0][8].getValor())+ " "    + (char)186); 
	System.out.println("  "+(char)186 + "" +(char)205+ "" +(char)205+ "" +(char)205+ "" +(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205+ "" +(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)219+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)219+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)186);                                                                    
	System.out.println("1"+" " +(char)186 +" "+ (this.matriz[1][0].getValor()==0?" ":this.matriz[1][0].getValor())+ " "  + (char)186+ " "+ (this.matriz[1][1].getValor()==0?" ":this.matriz[1][1].getValor())+ " "  + (char)186+ " "+ (this.matriz[1][2].getValor()==0?" ":this.matriz[1][2].getValor())+ " "    + (char)219+ " "+ (this.matriz[1][3].getValor()==0?" ":this.matriz[1][3].getValor())+ " "    + (char)186+ " "+ (this.matriz[1][4].getValor()==0?" ":this.matriz[1][4].getValor())+ " "    + (char)186+ " "+ (this.matriz[1][5].getValor()==0?" ":this.matriz[1][5].getValor())+ " "    + (char)219+ " "+ (this.matriz[1][6].getValor()==0?" ":this.matriz[1][6].getValor())+ " "    + (char)186+ " "+ (this.matriz[1][7].getValor()==0?" ":this.matriz[1][7].getValor())+ " "    + (char)186+ " "+ (this.matriz[1][8].getValor()==0?" ":this.matriz[1][8].getValor())+ " "    + (char)186); 
	System.out.println("  "+(char)186 + "" +(char)205+ "" +(char)205+ "" +(char)205+ "" +(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205+ "" +(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)219+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)219+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)186); 
	System.out.println("2"+" " +(char)186 +" "+ (this.matriz[2][0].getValor()==0?" ":this.matriz[2][0].getValor())+ " "  + (char)186+ " "+ (this.matriz[2][1].getValor()==0?" ":this.matriz[2][1].getValor())+ " "  + (char)186+ " "+ (this.matriz[2][2].getValor()==0?" ":this.matriz[2][2].getValor())+ " "    + (char)219+ " "+ (this.matriz[2][3].getValor()==0?" ":this.matriz[2][3].getValor())+ " "    + (char)186+ " "+ (this.matriz[2][4].getValor()==0?" ":this.matriz[2][4].getValor())+ " "    + (char)186+ " "+ (this.matriz[2][5].getValor()==0?" ":this.matriz[2][5].getValor())+ " "    + (char)219+ " "+ (this.matriz[2][6].getValor()==0?" ":this.matriz[2][6].getValor())+ " "    + (char)186+ " "+ (this.matriz[2][7].getValor()==0?" ":this.matriz[2][7].getValor())+ " "    + (char)186+ " "+ (this.matriz[2][8].getValor()==0?" ":this.matriz[2][8].getValor())+ " "    + (char)186); 
	System.out.println("  "+(char)219 + "" +(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219 + ""+(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219 + ""+(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219 + ""+(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219 + ""+(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219 + ""+(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219 + ""+(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219 + ""+(char)219);
	System.out.println("3"+" " +(char)186 +" "+ (this.matriz[3][0].getValor()==0?" ":this.matriz[3][0].getValor())+ " "  + (char)186+ " "+ (this.matriz[3][1].getValor()==0?" ":this.matriz[3][1].getValor())+ " "  + (char)186+ " "+ (this.matriz[3][2].getValor()==0?" ":this.matriz[3][2].getValor())+ " "    + (char)219+ " "+ (this.matriz[3][3].getValor()==0?" ":this.matriz[3][3].getValor())+ " "    + (char)186+ " "+ (this.matriz[3][4].getValor()==0?" ":this.matriz[3][4].getValor())+ " "    + (char)186+ " "+ (this.matriz[3][5].getValor()==0?" ":this.matriz[3][5].getValor())+ " "    + (char)219+ " "+ (this.matriz[3][6].getValor()==0?" ":this.matriz[3][6].getValor())+ " "    + (char)186+ " "+ (this.matriz[3][7].getValor()==0?" ":this.matriz[3][7].getValor())+ " "    + (char)186+ " "+ (this.matriz[3][8].getValor()==0?" ":this.matriz[3][8].getValor())+ " "    + (char)186); 
	System.out.println("  "+(char)186 + "" +(char)205+ "" +(char)205+ "" +(char)205+ "" +(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205+ "" +(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)219+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)219+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)186); 
	System.out.println("4"+" " +(char)186 +" "+ (this.matriz[4][0].getValor()==0?" ":this.matriz[4][0].getValor())+ " "  + (char)186+ " "+ (this.matriz[4][1].getValor()==0?" ":this.matriz[4][1].getValor())+ " "  + (char)186+ " "+ (this.matriz[4][2].getValor()==0?" ":this.matriz[4][2].getValor())+ " "    + (char)219+ " "+ (this.matriz[4][3].getValor()==0?" ":this.matriz[4][3].getValor())+ " "    + (char)186+ " "+ (this.matriz[4][4].getValor()==0?" ":this.matriz[4][4].getValor())+ " "    + (char)186+ " "+ (this.matriz[4][5].getValor()==0?" ":this.matriz[4][5].getValor())+ " "    + (char)219+ " "+ (this.matriz[4][6].getValor()==0?" ":this.matriz[4][6].getValor())+ " "    + (char)186+ " "+ (this.matriz[4][7].getValor()==0?" ":this.matriz[4][7].getValor())+ " "    + (char)186+ " "+ (this.matriz[4][8].getValor()==0?" ":this.matriz[4][8].getValor())+ " "    + (char)186); 
	System.out.println("  "+(char)186 + "" +(char)205+ "" +(char)205+ "" +(char)205+ "" +(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205+ "" +(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)219+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)219+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)186); 
	System.out.println("5"+" " +(char)186 +" "+ (this.matriz[5][0].getValor()==0?" ":this.matriz[5][0].getValor())+ " "  + (char)186+ " "+ (this.matriz[5][1].getValor()==0?" ":this.matriz[5][1].getValor())+ " "  + (char)186+ " "+ (this.matriz[5][2].getValor()==0?" ":this.matriz[5][2].getValor())+ " "    + (char)219+ " "+ (this.matriz[5][3].getValor()==0?" ":this.matriz[5][3].getValor())+ " "    + (char)186+ " "+ (this.matriz[5][4].getValor()==0?" ":this.matriz[5][4].getValor())+ " "    + (char)186+ " "+ (this.matriz[5][5].getValor()==0?" ":this.matriz[5][5].getValor())+ " "    + (char)219+ " "+ (this.matriz[5][6].getValor()==0?" ":this.matriz[5][6].getValor())+ " "    + (char)186+ " "+ (this.matriz[5][7].getValor()==0?" ":this.matriz[5][7].getValor())+ " "    + (char)186+ " "+ (this.matriz[5][8].getValor()==0?" ":this.matriz[5][8].getValor())+ " "    + (char)186); 
	System.out.println("  "+(char)219 + "" +(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219 + ""+(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219 + ""+(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219 + ""+(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219 + ""+(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219 + ""+(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219 + ""+(char)219+ "" +(char)219+ "" +(char)219+ "" +(char)219 + ""+(char)219);
	System.out.println("6"+" " +(char)186 +" "+ (this.matriz[6][0].getValor()==0?" ":this.matriz[6][0].getValor())+ " "  + (char)186+ " "+ (this.matriz[6][1].getValor()==0?" ":this.matriz[6][1].getValor())+ " "  + (char)186+ " "+ (this.matriz[6][2].getValor()==0?" ":this.matriz[6][2].getValor())+ " "    + (char)219+ " "+ (this.matriz[6][3].getValor()==0?" ":this.matriz[6][3].getValor())+ " "    + (char)186+ " "+ (this.matriz[6][4].getValor()==0?" ":this.matriz[6][4].getValor())+ " "    + (char)186+ " "+ (this.matriz[6][5].getValor()==0?" ":this.matriz[6][5].getValor())+ " "    + (char)219+ " "+ (this.matriz[6][6].getValor()==0?" ":this.matriz[6][6].getValor())+ " "    + (char)186+ " "+ (this.matriz[6][7].getValor()==0?" ":this.matriz[6][7].getValor())+ " "    + (char)186+ " "+ (this.matriz[6][8].getValor()==0?" ":this.matriz[6][8].getValor())+ " "    + (char)186); 
	System.out.println("  "+(char)186 + "" +(char)205+ "" +(char)205+ "" +(char)205+ "" +(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205+ "" +(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)219+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)219+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)186); 
	System.out.println("7"+" " +(char)186 +" "+ (this.matriz[7][0].getValor()==0?" ":this.matriz[7][0].getValor())+ " "  + (char)186+ " "+ (this.matriz[7][1].getValor()==0?" ":this.matriz[7][1].getValor())+ " "  + (char)186+ " "+ (this.matriz[7][2].getValor()==0?" ":this.matriz[7][2].getValor())+ " "    + (char)219+ " "+ (this.matriz[7][3].getValor()==0?" ":this.matriz[7][3].getValor())+ " "    + (char)186+ " "+ (this.matriz[7][4].getValor()==0?" ":this.matriz[7][4].getValor())+ " "    + (char)186+ " "+ (this.matriz[7][5].getValor()==0?" ":this.matriz[7][5].getValor())+ " "    + (char)219+ " "+ (this.matriz[7][6].getValor()==0?" ":this.matriz[7][6].getValor())+ " "    + (char)186+ " "+ (this.matriz[7][7].getValor()==0?" ":this.matriz[7][7].getValor())+ " "    + (char)186+ " "+ (this.matriz[7][8].getValor()==0?" ":this.matriz[7][8].getValor())+ " "    + (char)186);   
	System.out.println("  "+(char)186 + "" +(char)205+ "" +(char)205+ "" +(char)205+ "" +(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205+ "" +(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)219+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)219+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)206+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)186); 
	System.out.println("8"+" " +(char)186 +" "+ (this.matriz[8][0].getValor()==0?" ":this.matriz[8][0].getValor())+ " "  + (char)186+ " "+ (this.matriz[8][1].getValor()==0?" ":this.matriz[8][1].getValor())+ " "  + (char)186+ " "+ (this.matriz[8][2].getValor()==0?" ":this.matriz[8][2].getValor())+ " "    + (char)219+ " "+ (this.matriz[8][3].getValor()==0?" ":this.matriz[8][3].getValor())+ " "    + (char)186+ " "+ (this.matriz[8][4].getValor()==0?" ":this.matriz[8][4].getValor())+ " "    + (char)186+ " "+ (this.matriz[8][5].getValor()==0?" ":this.matriz[8][5].getValor())+ " "    + (char)219+ " "+ (this.matriz[8][6].getValor()==0?" ":this.matriz[8][6].getValor())+ " "    + (char)186+ " "+ (this.matriz[8][7].getValor()==0?" ":this.matriz[8][7].getValor())+ " "    + (char)186+ " "+ (this.matriz[8][8].getValor()==0?" ":this.matriz[8][8].getValor())+ " "    + (char)186); 
	System.out.println("  "+(char)200 + "" +(char)205+ "" +(char)205+ "" +(char)205+ "" +(char)202+ "" +(char)205+ "" +(char)205+ "" +(char)205+ "" +(char)202+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)219+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)202+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)202+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)219+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)202+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)202+ "" +(char)205+ "" +(char)205+ "" +(char)205 + ""+(char)188);
	
	
	} 
	
	
	
	
	public static void main(String args[]){
	
	Tablero a= new Tablero();	
	a.usoRandom();
	a.imprimeTablero();
	}
}