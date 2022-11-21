import java.util.Scanner;

public class CheemsCocinero {

   /**
   * Metodo builder especifico para el combo uno. Consiste en
   * una hamburguesa Vegetariana, Coca cola y papas a la Francesa.
   */
   public Comida preparaComboUno(){
      Comida comida = new Comida();
      comida.agregaComponente(new Vegetariana());
      comida.agregaComponente(new CocaCola());
      comida.agregaComponente(new Francesa());
      return comida;
   }   

   /**
   * Metodo builder especifico para el combo dos. Consiste en
   * una hamburguesa Con Tocino, Sprite y papas Curly.
   */
   public Comida preparaComboDos(){
      Comida comida = new Comida();
      comida.agregaComponente(new Tocino());
      comida.agregaComponente(new Sprite());
      comida.agregaComponente(new Curly());
      return comida;
   }

   /**
   * Metodo builder especifico para el combo tres. Consiste en
   * dos hamburguesas Con Tocino, una Coca Cola, un Sprite,
   * unas papas Curly, y unas papas a la Francesa.
   */
   public Comida preparaComboTres(){
      Comida comida = new Comida();
      comida.agregaComponente(new Tocino());
      comida.agregaComponente(new Tocino());
      comida.agregaComponente(new CocaCola());
      comida.agregaComponente(new Sprite());
      comida.agregaComponente(new Curly());
      comida.agregaComponente(new Francesa());
      return comida;
   }

   /**
   * Metodo builder general. Puede crear cualquier combinacion 
   * para una comida.
   * La creacion se delega a los constructores.
   */
   public Comida preparaComida(){
      /* Este proceso se hace por pasos. En cada paso se agrega un nuevo
      Componente de la comida. */
      Comida comida = new Comida();

      Scanner sc = new Scanner(System.in);
      int opcion;

      do{
         System.out.println("***¿Que le quieres poner a tu comida?***"
                     + "\n1.- Hamburguesa"
                     + "\n2.- Papas"
                     + "\n3.- Bebida"
                     + "\n0.- Salir");

         while (true){
            try {
               String opcionUsuario = sc.nextLine();
               opcion = Integer.parseInt(opcionUsuario);
               break;
            }catch (NumberFormatException ex){
               System.out.println("Ingresa una opcion valida."
                     + "\n1.- Hamburguesa"
                     + "\n2.- Papas"
                     + "\n3.- Bebida"
                     + "\n0.- Salir");
            }
         }

         switch(opcion){
            case 1:
               comida.agregaComponente(preparaHamburguesa());
               break;
            case 2:
               comida.agregaComponente(preparaPapas());
               break;
            case 3:
               comida.agregaComponente(preparaBebida());
               break;
            case 0:
               break;
            default:
               System.out.println("Ingresa una opcion valida.");
               break;
         }
      }while(opcion != 0);

      if(comida.obtenCosto() == 0){
         System.out.println("\nNo pediste comida, pero te regalamos unas papas.");
         comida.agregaComponente(new Francesa());
      }
      return comida;
   }

   private Hamburguesa preparaHamburguesa(){
      Scanner sc = new Scanner(System.in);
      int opcion;

      System.out.println("***¿Que hamburguesa quieres?***"
                     + "\n1.- Tocino"
                     + "\n2.- Vegetariana");

      while (true){
         try {
            String opcionUsuario = sc.nextLine();
            opcion = Integer.parseInt(opcionUsuario);
            if((opcion > 0) && (opcion < 3)){
               break;
            } else {
               System.out.println("Ingresa una opcion valida"
                     + "\n1.- Tocino"
                     + "\n2.- Vegetariana");
            }
         }catch (NumberFormatException ex){
            System.out.println("Ingresa una opcion valida"
                     + "\n1.- Tocino"
                     + "\n2.- Vegetariana");
         }
      }

      if(opcion == 1){
         return new Tocino();
      } else {
         return new Vegetariana();
      }
   }

   private Papas preparaPapas(){
      Scanner sc = new Scanner(System.in);
      int opcion;

      System.out.println("***¿Que papas quieres?***"
                     + "\n1.- A la Francesa"
                     + "\n2.- Curly");

      while (true){
         try {
            String opcionUsuario = sc.nextLine();
            opcion = Integer.parseInt(opcionUsuario);
            if(opcion > 0 && opcion < 3){
               break;
            } else {
               System.out.println("Ingresa una opcion valida"
                     + "\n1.- A la Francesa"
                     + "\n2.- Curly");
            }
         }catch (NumberFormatException ex){
            System.out.println("Ingresa una opcion valida"
                     + "\n1.- A la Francesa"
                     + "\n2.- Curly");
         }
      }

      if(opcion == 1){
         return new Francesa();
      } else {
         return new Curly();
      }
   }

   private Bebida preparaBebida(){
      Scanner sc = new Scanner(System.in);
      int opcion;

      System.out.println("***¿Que papas quieres?***"
                     + "\n1.- CocaCola"
                     + "\n2.- Sprite");

      while (true){
         try {
            String opcionUsuario = sc.nextLine();
            opcion = Integer.parseInt(opcionUsuario);
            if(opcion > 0 && opcion < 3){
               break;
            } else {
               System.out.println("Ingresa una opcion valida"
                     + "\n1.- CocaCola"
                     + "\n2.- Sprite");
            }
         }catch (NumberFormatException ex){
            System.out.println("Ingresa una opcion valida"
                     + "\n1.- CocaCola"
                     + "\n2.- Sprite");
         }
      }

      if(opcion == 1){
         return new CocaCola();
      } else {
         return new Sprite();
      }
   }
}