public class ModoMovimiento implements EstadoRobot{

	Robot mecha;

	public ModoMovimiento(Robot mecha){
		this.mecha = mecha;
	}

	public void activar(){
		System.out.println("***MODO MOVIMIENTO***\nMECHA DEMOLEDOR ya esta activado.");
	}

	public void caminar(){
		if(!mecha.getUbicacionCorrecta()){
			mecha.reducirDistancia();
			System.out.println("***MODO MOVIMIENTO***\nMECHA DEMOLEDOR se esta acercando a su objetivo.");
		} else {
			System.out.println("***MODO MOVIMIENTO***\nMECHA DEMOLEDOR ha llegado al objetivo.");
		}
	}

	public void demoler(){
		if(!mecha.getUbicacionCorrecta()){
			System.out.println("***MODO MOVIMIENTO***\nMECHA DEMOLEDOR no ha llegado a su objetivo aun.");
		} else {
			System.out.println("***MODO MOVIMIENTO***\nMECHA DEMOLEDOR pasara al MODO DEMOLICION.");
			mecha.asignarNuevoEstado(mecha.getEstadoDemoler());
		}
	}

	public void recolectar(){
		System.out.println("***MODO MOVIMIENTO***\nMECHA DEMOLEDOR no puede recolectar antes de demoler.");
	}
	public void apagarse(){
		System.out.println("***MODO MOVIMIENTO***\nMECHA DEMOLEDOR pasara al MODO SUSPENDIDO");
		mecha.asignarNuevoEstado(mecha.getEstadoSuspendido());
	}
}