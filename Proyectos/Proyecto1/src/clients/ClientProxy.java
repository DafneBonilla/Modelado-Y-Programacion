package clients;

import java.util.Iterator;

import walmart.Walmart2;

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
    public Coupon getCoupon() {
        return client.getCoupon();
    }

    @Override
    public void update() {
        client.update();
    }

    @Override
    public boolean check(Iterator<Country> iter) {
        return client.check(iter);
    }

    @Override
    public void setWalmart(Walmart2 walmart) {
        client.setWalmart(walmart);
    }

}
