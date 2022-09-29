package Parts;

public abstract class Weapon implements Component {

    protected String name;

    protected String description;

    protected int atk;

    protected int def;

    protected int spd;

    protected int wt;

    protected double price;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getSpd() {
        return spd;
    }

    public int getWt() {
        return wt;
    }

    public double getPrice() {
        return price;
    }

}
