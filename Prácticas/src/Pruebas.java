public class Pruebas {

    public static void main(String[] args) {

        Fighter p1 = new Korby();
        Fighter p2 = new Korby();

        System.out.println(p1.getBlock());
        System.out.println(p1.getName());
        System.out.println(p1.getSkillName());
        p1.transform();
        System.out.println(p1.getSkillName());
        p2.defend();
        System.out.println(p2.getHP());
        System.out.println(p2.getBlock());
        System.out.println(p1.hit(p2));
        System.out.println(p2.getHP());
        p2.lowerHealth(70);
        System.out.println(p2.isAlive());
        System.out.println(p1.hit(p2));

    }

}
