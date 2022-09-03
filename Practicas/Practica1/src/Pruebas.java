import java.util.concurrent.ThreadLocalRandom;

public class Pruebas {

    public static void main(String[] args) {

        Fighter p1 = new Korby();
        Fighter p2 = new MeganMan();
        
        System.out.println(p1.getBlock());

        System.out.println(p1.getName());

        System.out.println(p1.getSkillName());

        //p1.transform();

        System.out.println(p1.getSkillName());

        p2.defend();

        System.out.println(p2.getHP());

        System.out.println(p2.getBlock());

        System.out.println(p1.hit(p2));

        System.out.println(p2.getHP());

        

        System.out.println(p2.isAlive());

        System.out.println(p1.hit(p2));

        int random = ThreadLocalRandom.current().nextInt(1, 3 + 1);

    }
}
