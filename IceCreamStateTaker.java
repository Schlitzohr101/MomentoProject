//This is the caretaker class
//caretaker stores and restores states from memento
import java.util.ArrayList;
class IceCreamStateTaker {
    private ArrayList<IceCreamState> states = new ArrayList<IceCreamState>();

    public void add(IceCreamState s) {

        //need to save this incoming state to a file within this 

        states.add(s);
    }

    public IceCreamState getAt(int index) {
        return states.get(index);
    }
}