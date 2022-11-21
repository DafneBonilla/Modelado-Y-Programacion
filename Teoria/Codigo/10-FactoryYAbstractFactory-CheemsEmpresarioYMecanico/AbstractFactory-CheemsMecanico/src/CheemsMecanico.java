public class CheemsMecanico{
	
	public static AbstractFactory getFactory(String opcion){
		if(opcion.equalsIgnoreCase("llanta")){
			return new FabricaLLantas();
		} else if(opcion.equalsIgnoreCase("carroceria")){
			return new FabricaCarrocerias();
		} else if(opcion.equalsIgnoreCase("motor")){
			return new FabricaMotores();
		}
		return null;
	}
}