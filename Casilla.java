public class Casilla
{
   private int valor;
//   private boolean inicial[][] = {};
   private static final boolean[][] inicial ={
   		{false,false,true,false,true,true,true,false,false},
   		{true,false,true,false,false,false,true,true,true},
		{true,true,true,true,true,true,true,false,true},
		{false,true,true,false,true,true,false,true,true},
		{true,false,true,false,true,false,true,false,true},
		{true,true,false,true,true,false,true,true,false},
		{true,false,true,true,true,true,true,true,true},
		{true,true,true,false,false,false,true,false,true},
		{false,false,true,true,true,false,true,false,false}};
   
   
   private static final boolean[][] utilizado ={
   		{false,false,false,false,false,false,false,false,false},
   		{false,false,false,false,false,false,false,false,false},
		{false,false,false,false,false,false,false,false,false},
		{false,false,false,false,false,false,false,false,false},
		{false,false,false,false,false,false,false,false,false},
		{false,false,false,false,false,false,false,false,false},
		{false,false,false,false,false,false,false,false,false},
		{false,false,false,false,false,false,false,false,false},
		{false,false,false,false,false,false,false,false,false}};

   private static final int[][] intvalor ={
   {5,3,0,6,0,0,0,9,8},
   {0,7,0,1,9,5,0,0,0},
   {0,0,0,0,0,0,0,6,0},
   {8,0,0,4,0,0,7,0,0},
   {0,6,0,8,0,3,0,2,0},
   {0,0,3,0,0,1,0,0,6},
   {0,6,0,0,0,0,0,0,0},
   {0,0,0,4,1,9,0,8,0},
   {2,8,0,0,0,5,0,7,9}};
//   private boolean utilizado;
   



        public Casilla()
          {
          }
              
        public Casilla(int valor, boolean uno)
          {

          }
       





}