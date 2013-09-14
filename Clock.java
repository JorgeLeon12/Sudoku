public class Clock
{
   private int hr, min, sec;
   
   public Clock()
      {
          this.hr=12;
          this.min=0;
          this.sec=0;
       }

   public Clock(int hr, int min, int sec)
      {
         this.setTime(hr,min,sec);
      }
    
    public void prinTime()
           //(condicion)?regresoTrue:RegresoFalse
       {
          System.out.println((this.hr<10?("0"+this.hr):this.hr) + ":" + this.min + ":" + this.sec);
        }

    public  void setTime(int hr, int main, int sec)
        {
         this.hr=hr;
         this.min=min;
         this.sec=sec;
              if((this.hr=hr)>23|| this.hr<0)

                   {
                      this.hr=0;

                    }
                if ((this.min=min)>59 || this.min<0)
                     
                    {
                      this.min=0;
                    }
		 if((this.sec=sec)>59 || this.sec<0)
                     {
                       this.sec=0;
                     }


         }
    public void incrementHours() 
         {
            if(this.hr<23)
              {
                  this.hr=this.hr+1;
               }
             else 
               {
                  this.hr=0;
                }
     public void incrementMinutes() 
         {
            if(this.min<59)
              {
                 this.incrementHours();
                 this.hr=0;
               }
             else 
               {
                  this.min++;
                }

      public boolean equals(Clock reloj)
         {
            if (this.hr==reloj.hr && this.min==reloj.min && this.sec==reloj.sec)
                  {
                     return true;
                  }
             else
                   {
                      return false;
                    }


          }
    


      public void incrementSeconds() 
         {
            if(this.sec<59)
              {
                 this.incrementMinutes();
                 this.sec=0;
               }
             else 
               {
                  this.sec++;
                }
             
         }
 
   
     public int gethr()
         {
 
           return this.hr;
          }

      public int sec()
           {
           return this.sec;
           }

      public int min()
          {

           return this.min; 
          }

       public  void makecopy(Clock reloj);
          {
              this.hr=reloj.hr;
              this.min=reloj.min;
              this.sec=reloj.sec;
           }

       public  Clock getCopy()
          {
             return new Clock(this.hr,this.min,this.sec);
          }

    public static void main(String[] args)
        {
          Clock nuevo=new Clock();
          Clock gda=new Clock(8,-10,9000);
          Clock tijuana= new Clock(7,36,0);
          System.out.println(gda.equals(tijuana));

           nuevo.prinTime();
           gda.prinTime();
           tijuana.prinTime();
        }





}