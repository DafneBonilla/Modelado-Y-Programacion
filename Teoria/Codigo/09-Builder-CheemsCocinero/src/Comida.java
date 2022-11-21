import java.util.LinkedList;

public class Comida{
	private LinkedList<Componente> componentes = 
					new LinkedList<Componente>();

	public void agregaComponente(Componente com){
      componentes.add(com);
   }

   public double obtenCosto(){
      double costo = 0;
      
      for (Componente com : componentes) {
         costo += com.precio();
      }		
      return costo;
   }

   public void muestraComida(){
   
      for (Componente com : componentes) {
         System.out.print("Componente : " + com.nombre());
         System.out.println(", Precio : " + com.precio());
      }		
   }	
}