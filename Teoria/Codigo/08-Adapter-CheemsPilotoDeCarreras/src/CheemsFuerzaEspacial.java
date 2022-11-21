public class CheemsFuerzaEspacial{
	
	public static void main(String[] args){
		
		System.out.println("-->X-Wing Doge.");
		Xwing doge = new Xwing();
		doge.pruebaDeSistemas();

		System.out.println("\n-->Pod Racer Cheems.");
		PodRacer podDeCheems = new PodRacer();
		AdapterPodRacer cheems = new AdapterPodRacer(podDeCheems);
		cheems.pruebaDeSistemas();
	} 
}