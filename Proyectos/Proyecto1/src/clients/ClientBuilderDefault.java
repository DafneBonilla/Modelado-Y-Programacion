package clients;

public class ClientBuilderDefault extends ClientBuilder {

    @Override
    public Client build() {
        if (username == null || password == null || nationality == null || name == null || phone == 0 || address == null
                || bankNumber == 0) {
            return null;
        }
        return new Client(this);
    }

    @Override
    public ClientBuilder username(String username) {
        this.username = username;
        return this;
    }

    @Override
    public ClientBuilder password(String password) {
        this.password = password;
        return this;
    }

    @Override
    public ClientBuilder nationality(Country nationality) {
        this.nationality = nationality;
        return this;
    }

    @Override
    public ClientBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ClientBuilder phone(long phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public ClientBuilder address(String address) {
        this.address = address;
        return this;
    }

    @Override
    public ClientBuilder bankNumber(long bankNumber) {
        this.bankNumber = bankNumber;
        return this;
    }

}
