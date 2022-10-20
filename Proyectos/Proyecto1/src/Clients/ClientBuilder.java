package Clients;

public abstract class ClientBuilder {

    protected String username;

    protected String password;

    protected Country nationality;

    protected String name;

    protected long phone;

    protected String address;

    protected long bankNumber;

    public abstract Client build();

    public abstract ClientBuilder username(String username);

    public abstract ClientBuilder password(String password);

    public abstract ClientBuilder nationality(Country nationality);

    public abstract ClientBuilder name(String name);

    public abstract ClientBuilder phone(long phone);

    public abstract ClientBuilder address(String address);

    public abstract ClientBuilder bankNumber(long bankNumber);

}
