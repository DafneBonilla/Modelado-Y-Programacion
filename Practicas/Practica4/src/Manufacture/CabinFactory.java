package Manufacture;

import Parts.*;

public class CabinFactory extends ComponentFactory {

    @Override
    public Component createPart(int i) {
        switch (i) {
            case 1:
                return new CabinOnepilot();
            case 2:
                return new CabinSmallcrew();
            case 3:
                return new CabinArmy();
            default:
                return null;
        }
    }

}
