import java.util.Scanner;

public class CocinaDeCheems{

    public static void main(String[] args){

        CheemsCocinero cheems = new CheemsCocinero();

        Scanner sc = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("\n***BIENVENIDO A MCDONALDS***"
                        + "\n¿Puedo tomar tu orden?"
                        + "\n1.- Combo 1"
                        + "\n2.- Combo 2"
                        + "\n3.- Combo 3"
                        + "\n4.- Arma tu combo"
                        + "\n0.- Salir");

            while (true){
                try {
                    String opcionUsuario = sc.nextLine();
                    opcion = Integer.parseInt(opcionUsuario);
                    break;
                }catch (NumberFormatException ex){
                    System.out.println("Ingresa una opcion valida."
                        + "\n1.- Combo 1"
                        + "\n2.- Combo 2"
                        + "\n3.- Combo 3"
                        + "\n4.- Arma tu combo"
                        + "\n0.- Salir");
                }
            }

            switch(opcion){
                case 1:
                    Comida combo1 = cheems.preparaComboUno();
                    System.out.println("\nComida Combo 1");
                    combo1.muestraComida();
                    System.out.println("Total: " + combo1.obtenCosto());
                    break;
                case 2:
                    Comida combo2 = cheems.preparaComboDos();
                    System.out.println("\nComida Combo 2");
                    combo2.muestraComida();
                    System.out.println("Total: " + combo2.obtenCosto());
                    break;
                case 3:
                    Comida combo3 = cheems.preparaComboTres();
                    System.out.println("\nComida Combo 3");
                    combo3.muestraComida();
                    System.out.println("Total: " + combo3.obtenCosto());
                    break;
                case 4: 
                    Comida aElegir = cheems.preparaComida();
                    System.out.println("\nComida preparada");
                    aElegir.muestraComida();
                    System.out.println("Total: " + aElegir.obtenCosto());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Ingresa una opcion valida.");
                    break;
            }
        }while(opcion != 0);
    }
}