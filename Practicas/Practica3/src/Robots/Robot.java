package Robots;

import java.util.List;
import Dishes.Dish;
import Menus.MenuIterator;

/**
 * Class to represent a robot
 * A robot has a name, a dish, an actual mode, a boolean to know if it is with a
 * client, a boolean to know if it has an order, a boolean to know if the order
 * is ready, a list of menu iterators, a name of a client, a sleep mode, an
 * active mode, a walk mode, an attend mode and a cook mode
 */
public class Robot {

    /* The actual mode */
    private RobotMode state;

    /* The dish */
    private Dish dish;

    /* Boolean to know if the robot is with a client */
    private boolean withClient;

    /* Boolean to know if the robot has an order */
    private boolean haveOrder;

    /* Boolean to know if the order is ready */
    private boolean orderIsReady;

    /* The list of menu iterators */
    private List<MenuIterator> menus;

    /* The name of the client */
    private String cName;

    /* The sleep mode */
    private RobotMode sleepMode;

    /* The active mode */
    private RobotMode activeMode;

    /* The walk mode */
    private RobotMode walkMode;

    /* The attend mode */
    private RobotMode attendMode;

    /* The cook mode */
    private RobotMode cookMode;

    /**
     * Creates a new robot
     * 
     * @param menus the list of menu iterators
     * @param cName the name of the client
     */
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

    /**
     * The robot sleeps
     */
    public void sleep() {
        this.state.sleep();
    }

    /**
     * The robot activates himself
     */
    public void activate() {
        this.state.activate();
    }

    /**
     * The robot walks
     */
    public void walk() {
        this.state.walk();
    }

    /**
     * The robot takes the order of the client
     */
    public void takeOrder() {
        this.state.takeOrder();
    }

    /**
     * The robot cooks
     */
    public void cook() {
        this.state.cook();
    }

    /**
     * The robot delivers a dish
     */
    public void deliver() {
        this.state.deliver();
    }

    /**
     * The robot returns to the kitchen
     */
    public void showMenu() {
        this.state.showMenu();
    }

    /**
     * Searches a dish in the menus
     * If the dish is not found, returns null
     * 
     * @param id the id of the dish
     * @return the dish
     */
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

    /**
     * Returns the actual mode
     * 
     * @return the actual mode
     */
    public RobotMode getState() {
        return this.state;
    }

    /**
     * Sets the actual mode
     *
     * @param state the actual mode
     */
    public void setState(RobotMode state) {
        this.state = state;
    }

    /**
     * Returns the dish
     * 
     * @return the dish
     */
    public Dish getDish() {
        return this.dish;
    }

    /**
     * Sets the dish
     * 
     * @param dish the dish
     */
    public void setDish(Dish dish) {
        this.dish = dish;
    }

    /**
     * Returns true if the robot is with a client
     * 
     * @return true if the robot is with a client
     */
    public boolean isWithClient() {
        return this.withClient;
    }

    /**
     * Sets the boolean to know if the robot is with a client
     * 
     * @param withClient the boolean to know if the robot is with a client
     */
    public void setWithClient(boolean withClient) {
        this.withClient = withClient;
    }

    /**
     * Returns true if the robot has an order
     * 
     * @return true if the robot has an order
     */
    public boolean isHaveOrder() {
        return this.haveOrder;
    }

    /**
     * Sets the boolean to know if the robot has an order
     * 
     * @param haveOrder the boolean to know if the robot has an order
     */
    public void setHaveOrder(boolean haveOrder) {
        this.haveOrder = haveOrder;
    }

    /**
     * Returns true if the order is ready
     * 
     * @return true if the order is ready
     */
    public boolean isOrderIsReady() {
        return this.orderIsReady;
    }

    /**
     * Sets the boolean to know if the order is ready
     * 
     * @param orderIsReady the boolean to know if the order is ready
     */
    public void setOrderIsReady(boolean orderIsReady) {
        this.orderIsReady = orderIsReady;
    }

    /**
     * Returns the list of menu iterators
     * 
     * @return the list of menu iterators
     */
    public List<MenuIterator> getMenus() {
        return this.menus;
    }

    /**
     * Sets the list of menu iterators
     * 
     * @param menus the list of menu iterators
     */
    public void setMenus(List<MenuIterator> menus) {
        this.menus = menus;
    }

    /**
     * Returns the name of the client
     * 
     * @return the name of the client
     */
    public String getCName() {
        return this.cName;
    }

    /**
     * Sets the name of the client
     * 
     * @param cName the name of the client
     */
    public void setCName(String cName) {
        this.cName = cName;
    }

    /**
     * Returns the sleep mode
     * 
     * @return the sleep mode
     */
    public RobotMode getSleepMode() {
        return this.sleepMode;
    }

    /**
     * Returns the active mode
     * 
     * @return the active mode
     */
    public RobotMode getActiveMode() {
        return this.activeMode;
    }

    /**
     * Returns the active mode
     * 
     * @return the active mode
     */
    public RobotMode getWalkMode() {
        return this.walkMode;
    }

    /**
     * Returns the attend mode
     * 
     * @return the attend mode
     */
    public RobotMode getAttendMode() {
        return this.attendMode;
    }

    /**
     * Returns the walk mode
     * 
     * @return the walk mode
     */
    public RobotMode getCookMode() {
        return this.cookMode;
    }

}
