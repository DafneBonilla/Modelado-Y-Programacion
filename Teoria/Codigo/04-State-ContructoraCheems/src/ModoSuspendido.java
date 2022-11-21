public class ModoSuspendido implements EstadoRobot{

	Robot mecha;

	public ModoSuspendido(Robot mecha){
		this.mecha = mecha;
	}

	public void activar(){
		if(mecha.getUbicacionCorrecta() && mecha.getDemolicionAcabada() && mecha.getEscombrosLimpios()){
			System.out.println("***MODO SUSPENDIDO***\nMECHA DEMOLEDOR ha terminado su trabajo por hoy." +
				"Pasara a MODO APAGADO.");
			mecha.asignarNuevoEstado(mecha.getEstadoApagado());
		} else {
			System.out.println("***MODO SUSPENDIDO***\nMECHA DEMOLEDOR ha sido activado.");
		}
	}

	public void caminar(){
		if(mecha.getUbicacionCorrecta() && mecha.getDemolicionAcabada() && mecha.getEscombrosLimpios()){
			System.out.println("***MODO SUSPENDIDO***\nMECHA DEMOLEDOR ha terminado su trabajo por hoy." +
				"Pasara a MODO APAGADO.");
			mecha.asignarNuevoEstado(mecha.getEstadoApagado());
		} else {
			if(mecha.getOrdenRecibida()){
				System.out.println("***MODO SUSPENDIDO***\nMECHA DEMOLEDOR pasara al MODO MOVIMIENTO.");
				mecha.asignarNuevoEstado(mecha.getEstadoCaminar());
			} else {
				System.out.println("***MODO SUSPENDIDO***\nMECHA DEMOLEDOR no ha recibido una orden. Pasara al MODO APAGADO.");
				mecha.asignarNuevoEstado(mecha.getEstadoApagado());
			}
		}
	}

	public void demoler(){
		if(mecha.getUbicacionCorrecta() && mecha.getDemolicionAcabada() && mecha.getEscombrosLimpios()){
			System.out.println("***MODO SUSPENDIDO***\nMECHA DEMOLEDOR ha terminado su trabajo por hoy." +
				"Pasara a MODO APAGADO.");
			mecha.asignarNuevoEstado(mecha.getEstadoApagado());
		} else {
			System.out.println("***MODO SUSPENDIDO***\nMECHA DEMOLEDOR no puede demoler lejos del objetivo.");
		}
	}

	public void recolectar(){
		if(mecha.getUbicacionCorrecta() && mecha.getDemolicionAcabada() && mecha.getEscombrosLimpios()){
			System.out.println("***MODO SUSPENDIDO***\nMECHA DEMOLEDOR ha terminado su trabajo por hoy." +
				"Pasara a MODO APAGADO.");
			mecha.asignarNuevoEstado(mecha.getEstadoApagado());
		} else {
			System.out.println("***MODO SUSPENDIDO***\nMECHA DEMOLEDOR no puede recolectar antes de demoler.");
		}
	}
	public void apagarse(){
		if(mecha.getUbicacionCorrecta() && mecha.getDemolicionAcabada() && mecha.getEscombrosLimpios()){
			System.out.println("***MODO SUSPENDIDO***\nMECHA DEMOLEDOR ha terminado su trabajo por hoy." +
				"Pasara a MODO APAGADO.");
			mecha.asignarNuevoEstado(mecha.getEstadoApagado());
		} else {
			System.out.println("***MODO SUSPENDIDO***\nMECHA DEMOLEDOR pasara al MODO APAGADO.");
			mecha.asignarNuevoEstado(mecha.getEstadoApagado());
		}
	}
}