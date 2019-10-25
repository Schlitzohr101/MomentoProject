import java.util.ArrayList;
class IceCreamState {
    private int scoopNum;
    private String flavor;
    private String coneType;
    private ArrayList<String> toppings = new ArrayList<String>();

    public IceCreamState(int n, String f, String c, ArrayList<String> t) {
        scoopNum = n;
        flavor = f;
        coneType = c;
        toppings = t;
    }

    /**
     * @return the coneType
     */
    public String getConeType() {
        return coneType;
    }

    /**
     * @return the flavor
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * @return the scoopNum
     */
    public int getScoopNum() {
        return scoopNum;
    }

    /**
     * @return the toppings
     */
    public ArrayList<String> getToppings() {
        return toppings;
    }

}