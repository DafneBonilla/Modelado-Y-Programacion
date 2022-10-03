package ShipComponents.ShipComponentsFactory;

import ShipComponents.*;

/**
 * Abstract class to represent a factory of the class {@link Component}
 * The factory is used to create components
 */
public abstract class ComponentFactory {

    /**
     * Builds a component
     * 
     * @param i integer for the factory to create the component
     * @return the component built
     */
    public abstract Component build(int i);

}
