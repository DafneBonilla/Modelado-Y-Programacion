public class FabricaCarrocerias extends AbstractFactory{
	
	@Override
	public Object getComponente(String tipoComponente){
		return getCarroceria(tipoComponente);
	}

	public Carroceria getCarroceria(String tipoCarroceria){
		if(tipoCarroceria == null){
			return null;
		} else if(tipoCarroceria.equalsIgnoreCase("deportiva")){
			return new CarroceriaDeportiva();
		} else if(tipoCarroceria.equalsIgnoreCase("monstruo")){
			return new CarroceriaMonstruo();
		}
		return null;
	}
}