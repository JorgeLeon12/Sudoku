import javax.swing.*;
import java.util.*;


public class Tablero
{
    private Casilla[][] matriz= new Casilla[9][9];


  public Tablero()
      {   
        

 		for(int i=0;i<matriz.length;i++)
                   {
                     for(int j=0;j<matriz[i].length;j++)
                         {
			 this.matriz[i][j]=new Casilla();
                         }                    

                   }
  
      }



   public void usoRandom()
     {

       
         Random ran=new Random();
		int k=0;
                int y=((int)(Math.random()*22));
                int z=((int)(Math.random()*8));

          for(int i=0; i<matriz.length; i++)
               {
                  for(int j=k; j<matriz[i].length;j=j+z)
                           {
                            this.matriz[j][i]=new Casilla((int)(Math.random()*9+1),false);// aquí se tiene que poner true
                           	k+=((int)(Math.random()*9));
				//System.out.println(j);
			   }
			k=k-((int)(Math.random()*9));
			//System.out.println(k);
                }
         

     }



  /* public boolean setValor(int fila, int columna, int valor)
     {
       this.matriz[fila][columna].setValor(valor);
                
     }
  */

   public void inconsistencia(int fila, int columna)
     { 
        

        
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




    public static void main(String args[])
		
        {
           
        Tablero a= new Tablero();
	a.imprimeTablero(); 

        System.out.println("--------------------------------------------------------------");
        a.usoRandom();
        a.imprimeTablero();
  /*
        System.out.println("--------------------------------------------------------------");
       
        int c,d,e;
        String strv;
        strv=JOptionPane.showInputDialog("Escoge la fila: ");
        c=Integer.parseInt(strv);

        strv=JOptionPane.showInputDialog("Escoge la columna: ");
        d=Integer.parseInt(strv);
     
        strv=JOptionPane.showInputDialog("Da el valor ");
        e=Integer.parseInt(strv);
  
           System.out.println(c);
           System.out.println(d);
           System.out.println(e);
   
       
        System.out.println("--------------------------------------------------------------");

        Tablero b=new Tablero(c,d,e);
                b.setValor();
                b.imprimeTablero();
         
          */

        }







}