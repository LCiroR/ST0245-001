public class Linea2D{
  
  private int puntoI, puntoF;
  
  public Punto(int puntoI, int puntoF){
    this.puntoI = puntoI;
    this.puntoF = puntoF;
  }
  
  public int puntoI(){
    return puntoI;
  }
  
   public int puntoF(){
    return puntoF;
  }
  
  public int generador(){
    x = this.puntoI.get();
    y = this.puntoF.get();
  }
  
  public void puntosMedios(){
    int mY = (int)puntoF.y()-(int)puntoI.y();
    int mX = (int)puntoF.x()-(int)puntoI.x();
    
    int i = 0;
    while((puntoI.x()<=mX)&&(puntoI.y()<=mY){
      System.out.println("("puntoI.x()+","puntoI.y()")");
      puntoI.x()++;
      puntoI.y()++;
    }
  }
}
