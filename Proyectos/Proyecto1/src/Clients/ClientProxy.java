package Clients;

public class ClientProxy implements ClientInterface {

    private Client client;

    public ClientProxy(Client client) {
        this.client = client;
    }

    @Override
    public String getUsername() {
        return client.getUsername();
    }

    @Override
    public String getPassword() {
        return client.getPassword();
    }

    @Override
    public Country getNationality() {
        return client.getNationality();
    }

    @Override
    public String getName() {
        return client.getName();
    }

    @Override
    public long getPhone() {
        return client.getPhone();
    }

    @Override
    public String getAddress() {
        return client.getAddress();
    }

    @Override
    public int getId() {
        return client.getId();
    }

    @Override
    public long getBankNumber() {
        return client.getBankNumber();
    }

    @Override
    public void setCoupon(Coupon coupon) {
        client.setCoupon(coupon);
    }

    @Override
    public Coupon getCoupon() {
        return client.getCoupon();
    }

}
