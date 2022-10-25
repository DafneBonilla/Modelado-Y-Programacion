package clients;

/**
 * Abstract class to implement the Builder pattern
 * A client builder will build a client (instance of {@link Client})
 * A client builder has a username, a password, a nationality (instance of
 * {@link Country}), a name, a phone number, an address and a bank number, an
 * amount of money, all of this attributes will be the same as the client that
 * will be built
 */
public abstract class ClientBuilder {

    /* The username of the client to build */
    protected String username;

    /* The password of the client to build */
    protected String password;

    /* The nationality of the client to build */
    protected Country nationality;

    /* The name of the client to build */
    protected String name;

    /* The phone number of the client to build */
    protected long phone;

    /* The address of the client to build */
    protected String address;

    /* The bank number of the client to build */
    protected long bankNumber;

    /* The money of the client to build */
    protected double money;

    /**
     * Builds a client with the attributes of the client builder
     * 
     * @return the client built
     */
    public abstract Client build();

    /**
     * Method to set the username of the client to build
     * 
     * @param username the username of the client to build
     * @return the client builder
     */
    public abstract ClientBuilder username(String username);

    /**
     * Method to set the password of the client to build
     * 
     * @param password the password of the client to build
     * @return the client builder
     */
    public abstract ClientBuilder password(String password);

    /**
     * Method to set the nationality of the client to build
     * 
     * @param nationality the nationality of the client to build
     * @return the client builder
     */
    public abstract ClientBuilder nationality(Country nationality);

    /**
     * Method to set the name of the client to build
     * 
     * @param name the name of the client to build
     * @return the client builder
     */
    public abstract ClientBuilder name(String name);

    /**
     * Method to set the phone number of the client to build
     * 
     * @param phone the phone number of the client to build
     * @return the client builder
     */
    public abstract ClientBuilder phone(long phone);

    /**
     * Method to set the address of the client to build
     * 
     * @param address the address of the client to build
     * @return the client builder
     */
    public abstract ClientBuilder address(String address);

    /**
     * Method to set the bank number of the client to build
     * 
     * @param bankNumber the bank number of the client to build
     * @return the client builder
     */
    public abstract ClientBuilder bankNumber(long bankNumber);

    /**
     * Method to set the money of the client to build
     * 
     * @param money the money of the client to build
     * @return the client builder
     */
    public abstract ClientBuilder money(double money);

}
