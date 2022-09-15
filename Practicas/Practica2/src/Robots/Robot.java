package Robots;

import java.util.List;
import Dishes.Dish;
import Menus.MenuIterator;

public class Robot {

    private RobotMode state;

    private Dish dish;

    private boolean withClient;

    private boolean haveOrder;

    private boolean orderIsReady;

    private List<MenuIterator> menus;

    private String cName;

    private RobotMode sleepMode;

    private RobotMode activeMode;

    private RobotMode walkMode;

    private RobotMode attendMode;

    private RobotMode cookMode;

    public Robot(List<MenuIterator> menus, String cName) {
        this.dish = null;
        this.withClient = false;
        this.haveOrder = false;
        this.orderIsReady = false;
        this.menus = menus;
        this.cName = cName;
        this.sleepMode = new SleepMode(this);
        this.activeMode = new ActiveMode(this);
        this.walkMode = new WalkMode(this);
        this.attendMode = new AttendMode(this);
        this.cookMode = new CookMode(this);
        this.state = sleepMode;
    }

    public void sleep() {
        this.state.sleep();
    }

    public void activate() {
        this.state.activate();
    }

    public void walk() {
        this.state.walk();
    }

    public void takeOrder() {
        this.state.takeOrder();
    }

    public void cook() {
        this.state.cook();
    }

    public void deliver() {
        this.state.deliver();
    }

    public void showMenu() {
        this.state.showMenu();
    }

    public Dish searchDish(int id) {
        for (MenuIterator menu : menus) {
            menu.restart();
        }
        for (MenuIterator menu : menus) {
            while (menu.hasNext()) {
                Dish dish = menu.next();
                if (dish.getID() == id) {
                    return dish;
                }
            }
        }
        return null;
    }

    public RobotMode getState() {
        return this.state;
    }

    public void setState(RobotMode state) {
        this.state = state;
    }

    public Dish getDish() {
        return this.dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public boolean isWithClient() {
        return this.withClient;
    }

    public void setWithClient(boolean withClient) {
        this.withClient = withClient;
    }

    public boolean isHaveOrder() {
        return this.haveOrder;
    }

    public void setHaveOrder(boolean haveOrder) {
        this.haveOrder = haveOrder;
    }

    public boolean isOrderIsReady() {
        return this.orderIsReady;
    }

    public void setOrderIsReady(boolean orderIsReady) {
        this.orderIsReady = orderIsReady;
    }

    public List<MenuIterator> getMenus() {
        return this.menus;
    }

    public void setMenus(List<MenuIterator> menus) {
        this.menus = menus;
    }

    public String getCName() {
        return this.cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public RobotMode getSleepMode() {
        return this.sleepMode;
    }

    public RobotMode getActiveMode() {
        return this.activeMode;
    }

    public RobotMode getWalkMode() {
        return this.walkMode;
    }

    public RobotMode getAttendMode() {
        return this.attendMode;
    }

    public RobotMode getCookMode() {
        return this.cookMode;
    }

}
