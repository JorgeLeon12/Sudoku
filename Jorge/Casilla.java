import javax.swing.*;
import java.util.*;
public class Casilla{
	
//	public int [][] Cas = {{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,}};//prueba!
	
	public int [] Cas = {0,0,0,0,0,0,0,0,0};//prueba!
	
	private int valor;
	private boolean inicial;
	private boolean utilizado;
	
	public Casilla(){
		this.valor = 0;
		this.inicial= false;
		this.utilizado= false;
//	}
//	
//	public int[] getCas(){
		Random ran = new Random();
		int num, num1, num2, num3;
		boolean encontrado = false;
		while(encontrado == false){
			num = ran.nextInt(4);
			while(num > 5){
				num1 = ran.nextInt(8);
				num2 = ran.nextInt(8);
				num3 = ran.nextInt(8);
				/*this.*/Cas[num1] = num3;
				System.out.println(/*this.*/Cas[num1]);
				
				encontrado = true;
				num--;
			}
		}
		//return this.Cas;
	}
	
	public Casilla(int valor, boolean uno){
		this.valor=valor;
		this.inicial=uno;
		this.utilizado=true;
	}
	
	public boolean setValor(int valor){
		if((this.valor>9) || (this.inicial= false)){
			this.valor=this.valor;
			return false;
		}
		else{
			this.valor = valor;
			this.utilizado=true; 
			return true;
		}       
	}
	
	public int getValor(){
		return this.valor;
	}
	
	public boolean getInicial(){
		return this.inicial;
	}
	
	public boolean getUtilizado(){
		return this.utilizado;
	}
	public static void main(String[]  args){
		Casilla B = new Casilla();
	}
}