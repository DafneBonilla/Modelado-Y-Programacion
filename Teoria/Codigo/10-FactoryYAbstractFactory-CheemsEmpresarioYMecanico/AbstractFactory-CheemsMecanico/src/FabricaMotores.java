public class FabricaMotores extends AbstractFactory{
	
	@Override
	public Object getComponente(String tipoComponente){
		return getMotor(tipoComponente);
	}

	public Motor getMotor(String tipoMotor){
		if(tipoMotor == null){
			return null;
		} else if(tipoMotor.equalsIgnoreCase("deportivo")){
			return new MotorDeportivo();
		} else if(tipoMotor.equalsIgnoreCase("monstruo")){
			return new MotorMonstruo();
		}
		return null;
	}	
}