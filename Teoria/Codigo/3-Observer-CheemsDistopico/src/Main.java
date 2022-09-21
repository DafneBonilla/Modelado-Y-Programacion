public class Main{
	public static void main(String[] args){
		CheemsDistopico liderCheems = new CheemsDistopico();

		liderCheems.setNoticia("Test");
		liderCheems.notificar();

		System.out.print("\n");
		CasaCiudadano a101 = new CasaCiudadano("a101", "Fulanos", liderCheems);
		CasaCiudadano b202 = new CasaCiudadano("b202", "Menganos", liderCheems);
		CasaCiudadano c303 = new CasaCiudadano("c303", "Zutanos", liderCheems);
		CasaCiudadano d404 = new CasaCiudadano("d404", "Policarpios", liderCheems);

		liderCheems.setNoticia("La guerra es paz. La libertad es esclavitud. La ignorancia es fuerza.");
		System.out.print("\n");
		liderCheems.notificar();

		d404.mostrarDesinteres();

		liderCheems.setNoticia("La produccion agricola ha aumentado en un 52%. El desempleo ha disminuido en un 73%.");
		System.out.print("\n");
		liderCheems.notificar();

		d404 = new CasaCiudadano("d404", "Arzemios", liderCheems);

		liderCheems.setNoticia("Se han abierto 8 nuevas fabricas. Nuestro ejercito avanza energicamente a la victoria.");
		System.out.print("\n");
		liderCheems.notificar();
	}
}