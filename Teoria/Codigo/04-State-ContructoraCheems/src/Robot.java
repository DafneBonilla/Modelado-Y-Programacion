import java.util.Scanner;

public class Robot{
	private boolean ordenRecibida;
	private Objetivo objetivoADemoler;
	private boolean ubicacionCorrecta;
	private boolean demolicionAcabada;
	private boolean escombrosLimpios;

	private EstadoRobot estadoActual;

	private EstadoRobot modoApagado;
	private EstadoRobot modoSuspendido;
	private EstadoRobot modoMovimiento;
	private EstadoRobot modoDemolicion;
	private EstadoRobot modoRecoleccion;

	public Robot(){
		ordenRecibida = false;
		ubicacionCorrecta = false;
		demolicionAcabada = false;
		escombrosLimpios = false;

		modoApagado = new ModoApagado(this);
		modoSuspendido = new ModoSuspendido(this);
		modoMovimiento = new ModoMovimiento(this);
		modoDemolicion = new ModoDemolicion(this);
		modoRecoleccion = new ModoRecoleccion(this);

		estadoActual = modoApagado;
	}

	public void ingresarOrden(){
		System.out.println("Recibiendo orden remota...");
		Objetivo construccion = new Objetivo(2, 3, 3);
		recibirOrdenObjetivo(construccion);
		System.out.println("Orden recibida.");
	}

	private void recibirOrdenObjetivo(Objetivo construccion){
		objetivoADemoler = construccion;
		ordenRecibida = true;
	}

	public boolean getOrdenRecibida(){
		return ordenRecibida;
	}

	public boolean getUbicacionCorrecta(){
		if(objetivoADemoler.getDistancia() > 0){
			return ubicacionCorrecta;
		}
		else{
			ubicacionCorrecta = true;
			return ubicacionCorrecta;
		}
	}

	public boolean getDemolicionAcabada(){
		if(objetivoADemoler.getHP() > 0){
			return demolicionAcabada;
		}
		else{
			demolicionAcabada = true;
			return demolicionAcabada;
		}
	}

	public boolean getEscombrosLimpios(){
		if(objetivoADemoler.getEscombros() > 0){
			return escombrosLimpios;
		}
		else{
			escombrosLimpios = true;
			return escombrosLimpios;
		}
	}

	public Objetivo getObjetivo(){
		return objetivoADemoler;
	}

	public void reducirDistancia(){
		objetivoADemoler.setDistancia(objetivoADemoler.getDistancia()-1);
	}

	public void reducirHP(){
		objetivoADemoler.setHP(objetivoADemoler.getHP()-1);
	}

	public void reducirEscombros(){
		objetivoADemoler.setEscombros(objetivoADemoler.getEscombros()-1);
	}

	public void asignarNuevoEstado(EstadoRobot nuevoEstado){
		estadoActual = nuevoEstado;
	}

	public void activar(){
		estadoActual.activar();
	}

	public void caminar(){
		estadoActual.caminar();
	}

	public void demoler(){
		estadoActual.demoler();
	}

	public void recolectar(){
		estadoActual.recolectar();
	}

	public void apagarse(){
		estadoActual.apagarse();
	}

	public EstadoRobot getEstadoSuspendido(){
		return modoSuspendido;
	}

	public EstadoRobot getEstadoCaminar(){
		return modoMovimiento;
	}

	public EstadoRobot getEstadoDemoler(){
		return modoDemolicion;
	}

	public EstadoRobot getEstadoRecoleccion(){
		return modoRecoleccion;
	}

	public EstadoRobot getEstadoApagado(){
		return modoApagado;
	}

}