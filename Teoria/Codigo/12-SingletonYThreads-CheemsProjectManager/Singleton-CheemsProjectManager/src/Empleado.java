import java.lang.Math;

public class Empleado extends Thread{
	private String usuario;
	private int idEmpleado;

	public Empleado(String usuario, int idEmpleado){
		this.usuario = usuario;
		this.idEmpleado = idEmpleado;
	}

	public String getUsuario(){
		return usuario;
	}

	public int getIdEmpleado(){
		return idEmpleado;
	}

	@Override
	public void run(){
		int dormido = (int)(Math.random()*1000);
		/*Verificacion de tiempo dormido.
		System.out.println(getIdEmpleado() + " " + dormido);*/
		try {
			Thread.sleep(dormido);
		} catch (InterruptedException ex){
			ex.printStackTrace();
		}
		Host nuevaSesion = Host.obtenerHost(this);
		nuevaSesion.infoSesion();
	}

}