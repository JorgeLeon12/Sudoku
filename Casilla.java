public class Casilla
{
   private int valor;
   private boolean inicial;
   private boolean utilizado;
   

   private static final int[][] intvalor={{0,1,2,3,4,5,6,7,8,9},{0,1,2,3,4,5,6,7,8,9},{0,1,2,3,4,5,6,7,8,9},{0,1,2,3,4,5,6,7,8,9},{0,1,2,3,4,5,6,7,8,9},{0,1,2,3,4,5,6,7,8,9},{0,1,2,3,4,5,6,7,8,9},{0,1,2,3,4,5,6,7,8,9},{0,1,2,3,4,5,6,7,8,9}};

        public Casilla()
          {
           this.valor = 0;
           this.inicial= false;
           this.utilizado= false;
          }
              
        public Casilla(int valor, boolean uno)
          {
          this.valor=valor;
          this.inicial=uno;
          this.utilizadp=true;

          }
       





}