import java.util.ArrayList;
class IceCreamStateTaker {
    private ArrayList<IceCreamState> states = new ArrayList<IceCreamState>();

    public void add(IceCreamState s) {
        states.add(s);
    }

    public IceCreamState getAt(int index) {
        return states.get(index);
    }
}