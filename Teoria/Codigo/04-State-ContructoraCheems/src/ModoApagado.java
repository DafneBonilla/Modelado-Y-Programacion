public class ModoApagado implements EstadoRobot{

	Robot mecha;

	public ModoApagado(Robot mecha){
		this.mecha = mecha;
	}

	public void activar(){
		if(mecha.getOrdenRecibida() && mecha.getUbicacionCorrecta() 
			&& mecha.getDemolicionAcabada() && mecha.getEscombrosLimpios()){
			System.out.println("***MODO APAGADO***\nMECHA DEMOLEDOR ha terminado su trabajo por hoy.");
		} else {
			System.out.println("***MODO APAGADO***\nMECHA DEMOLEDOR pasara al MODO SUSPENDIDO.");
			mecha.ingresarOrden();
			mecha.asignarNuevoEstado(mecha.getEstadoSuspendido());
		}
	}

	public void caminar(){
		if(mecha.getOrdenRecibida() && mecha.getUbicacionCorrecta() 
			&& mecha.getDemolicionAcabada() && mecha.getEscombrosLimpios()){
			System.out.println("***MODO APAGADO***\nMECHA DEMOLEDOR ha terminado su trabajo por hoy.");
		} else {
			System.out.println("***MODO APAGADO***\nMECHA DEMOLEDOR no puede caminar si esta APAGADO.");
		}
	}

	public void demoler(){
		if(mecha.getOrdenRecibida() && mecha.getUbicacionCorrecta() 
			&& mecha.getDemolicionAcabada() && mecha.getEscombrosLimpios()){
			System.out.println("***MODO APAGADO***\nMECHA DEMOLEDOR ha terminado su trabajo por hoy.");
		} else {
			System.out.println("***MODO APAGADO***\nMECHA DEMOLEDOR no puede demoler si esta APAGADO.");
		}
	}

	public void recolectar(){
		if(mecha.getOrdenRecibida() && mecha.getUbicacionCorrecta() 
			&& mecha.getDemolicionAcabada() && mecha.getEscombrosLimpios()){
			System.out.println("***MODO APAGADO***\nMECHA DEMOLEDOR ha terminado su trabajo por hoy.");
		} else {
			System.out.println("***MODO APAGADO***\nMECHA DEMOLEDOR no puede recolectar escombros si esta APAGADO.");
		}
	}
	public void apagarse(){
		System.out.println("***MODO APAGADO***\nMECHA DEMOLEDOR ya esta APAGADO.");
	}
}