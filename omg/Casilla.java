public class Casilla
{
   private int valor;
   private boolean inicial;
   private boolean utilizado;
   

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
          this.utilizado=true;
          }
     
       public boolean setValor(int valor)
         {
               if((this.valor>9) || (this.inicial = false))
                  {
                    this.valor=this.valor;
	            return false;
                  }
                else
                   {
                    this.valor = valor;
                    this.utilizado=true; 
                    return true;
                   }       
         }
       
       public int getValor()
         {
            return this.valor;
         }

       public boolean getInicial()
         {
           return this.inicial;
         }

       public boolean getUtilizado()
         {
           return this.utilizado;
         }


 



}