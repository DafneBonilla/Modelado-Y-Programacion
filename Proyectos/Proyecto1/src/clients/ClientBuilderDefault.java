package clients;

/**
 * Class to represent a client builder default
 * A client builder default will build a client (instance of {@link Client})
 */
public class ClientBuilderDefault extends ClientBuilder {

    /**
     * Builds a client with the attributes of the client builder
     * In case of an attribute is null, it will return null
     * 
     * @return the client built
     */
    @Override
    public Client build() {
        if (username == null || password == null || nationality == null || name == null || phone == 0 || address == null
                || bankNumber == 0) {
            return null;
        }
        return new Client(this);
    }

    /**
     * Method to set the username of the client to build
     * 
     * @param username the username of the client to build
     * @return the client builder
     */
    @Override
    public ClientBuilder username(String username) {
        this.username = username;
        return this;
    }

    /**
     * Method to set the password of the client to build
     * 
     * @param password the password of the client to build
     * @return the client builder
     */
    @Override
    public ClientBuilder password(String password) {
        this.password = password;
        return this;
    }

    /**
     * Method to set the nationality of the client to build
     * 
     * @param nationality the nationality of the client to build
     * @return the client builder
     */
    @Override
    public ClientBuilder nationality(Country nationality) {
        this.nationality = nationality;
        return this;
    }

    /**
     * Method to set the name of the client to build
     * 
     * @param name the name of the client to build
     * @return the client builder
     */
    @Override
    public ClientBuilder name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Method to set the phone number of the client to build
     * 
     * @param phone the phone number of the client to build
     * @return the client builder
     */
    @Override
    public ClientBuilder phone(long phone) {
        this.phone = phone;
        return this;
    }

    /**
     * Method to set the address of the client to build
     * 
     * @param address the address of the client to build
     * @return the client builder
     */
    @Override
    public ClientBuilder address(String address) {
        this.address = address;
        return this;
    }

    /**
     * Method to set the bank number of the client to build
     * 
     * @param bankNumber the bank number of the client to build
     * @return the client builder
     */
    @Override
    public ClientBuilder bankNumber(long bankNumber) {
        this.bankNumber = bankNumber;
        return this;
    }

    /**
     * Method to set the money of the client to build
     * 
     * @param money the money of the client to build
     * @return the client builder
     */
    @Override
    public ClientBuilder money(double money) {
        this.money = money;
        return this;
    }

}
