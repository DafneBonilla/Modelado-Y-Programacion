public class ModoRecoleccion implements EstadoRobot{

	Robot mecha;

	public ModoRecoleccion(Robot mecha){
		this.mecha = mecha;
	}

	public void activar(){
		System.out.println("***MODO RECOLECCION***\nMECHA DEMOLEDOR ya esta activado.");
	}

	public void caminar(){
		System.out.println("***MODO RECOLECCION***\nMECHA DEMOLEDOR no puede caminar mientras recolecta escombros.");
	}

	public void demoler(){
		System.out.println("***MODO RECOLECCION***\nMECHA DEMOLEDOR no puede demoler nada mas.");
	}

	public void recolectar(){
		if(!mecha.getEscombrosLimpios()){
			mecha.reducirEscombros();
			System.out.println("***MODO RECOLECCION***\nMECHA DEMOLEDOR esta recolectando los escombros.");
		} else {
			System.out.println("***MODO RECOLECCION***\nMECHA DEMOLEDOR ha recolectado todos los escombros.");
		}
	}
	public void apagarse(){
		if(!mecha.getEscombrosLimpios()){
			System.out.println("***MODO RECOLECCION***\nMECHA DEMOLEDOR no ha acabado de recolectar escombros.");
		} else {
			System.out.println("***MODO RECOLECCION***\nMECHA DEMOLEDOR pasara al MODO SUSPENDIDO");
			mecha.asignarNuevoEstado(mecha.getEstadoSuspendido());
		}
	}
}