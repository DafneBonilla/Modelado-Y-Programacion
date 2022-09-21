public class CheemsMomazon{

	public static void main(String[] args){
		Caja inventario = new Caja("INVENTARIO");

		Caja caja1 = new Caja("lote1001");
		Caja caja2 = new Caja("lote1002");
		Caja caja3 = new Caja("lote1003");
		Caja caja4 = new Caja("lote1004");

		Articulo a1 = new Producto("nombre1", 12.5);
		Articulo a2 = new Producto("nombre2", 55);
		Articulo a3 = new Producto("nombre3", 78.3);
		Articulo a4 = new Producto("nombre4", 23.5);
		Articulo a5 = new Producto("nombre5", 99.9);
		Articulo a6 = new Producto("nombre6", 101.3);
		Articulo a7 = new Producto("nombre7", 657);
		Articulo a8 = new Producto("nombre8", 123.5);
		Articulo a9 = new Producto("nombre9", 75);
		Articulo a10 = new Producto("nombre10", 11.5);
		Articulo a11 = new Producto("nombre11", 4.5);
		Articulo a12 = new Producto("nombre12", 1001);
		Articulo a13 = new Producto("nombre13", 987.4);
		Articulo a14 = new Producto("nombre14", 103.7);

		caja1.empacar(a1);
		caja1.empacar(a2);
		caja1.empacar(a3);

		caja2.empacar(a4);
		caja2.empacar(a5);

		caja3.empacar(a6);
		caja3.empacar(a7);
		caja3.empacar(a8);

		caja4.empacar(a9);
		caja4.empacar(a10);
		caja4.empacar(a11);
		caja4.empacar(a12);

		caja4.empacar(caja3);

		inventario.empacar(caja1);
		inventario.empacar(caja2);
		inventario.empacar(a13);
		
		inventario.empacar(caja4);
		inventario.empacar(a14);

		System.out.println("El inventario completo es: \n" + inventario.mostrarInformacion());

		System.out.println("\nEl contenido de la caja 3: \n" + caja3.mostrarInformacion());


	}
}