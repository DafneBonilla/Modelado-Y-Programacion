package Ships;

public abstract class ShipFactory {

    protected ShipBuilder builder;

    public abstract Ship build(int i);

}
