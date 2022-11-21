public class GrupoDoctor{
	private Doctor doctores[] = new Doctor[3];

	public GrupoDoctor(){
		doctores[0] = new Doctor("Roberto", "ETUI23456");
		doctores[1] = new Doctor("Julia", "MHFW57992");
		doctores[2] = new Doctor("Gerardo", "PXWL19304");
	}

	public Iterador getIterador(){
		return new IteradorArreglo();
	}

	private class IteradorArreglo implements Iterador{
		int indice;

		@Override
		public boolean hasNext(){
			if(indice < doctores.length){
				return true;
			}
			return false;
		}

		@Override
		public Object next(){
			if(this.hasNext()){
				return doctores[indice++];
			}
			return null;
		}
	}
}