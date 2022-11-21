public class ModoDemolicion implements EstadoRobot{

	Robot mecha;

	public ModoDemolicion(Robot mecha){
		this.mecha = mecha;
	}

	public void activar(){
		System.out.println("***MODO DEMOLICION***\nMECHA DEMOLEDOR ya esta activado.");
	}

	public void caminar(){
		System.out.println("***MODO DEMOLICION***\nMECHA DEMOLEDOR no puede caminar mientras destruye.");	
	}

	public void demoler(){
		if(!mecha.getDemolicionAcabada()){
			mecha.reducirHP();
			System.out.println("***MODO DEMOLICION***\nMECHA DEMOLEDOR esta destruyendo su objetivo.");
		} else {
			System.out.println("***MODO DEMOLICION***\nMECHA DEMOLEDOR ha destruido a su objetivo.");
		}
	}

	public void recolectar(){
		if(!mecha.getDemolicionAcabada()){
			System.out.println("***MODO DEMOLICION***\nMECHA DEMOLEDOR no ha terminado de demoler.");
		} else {
			System.out.println("***MODO DEMOLICION***\nMECHA DEMOLEDOR pasara al MODO RECOLECCION");
			mecha.asignarNuevoEstado(mecha.getEstadoRecoleccion());
		}
	}
	public void apagarse(){
		System.out.println("***MODO DEMOLICION***\nMECHA DEMOLEDOR no puede suspenderse mientras destruye.");
	}
}