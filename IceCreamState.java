/*  William Murray, Adrian Seth
    October 31th, 2019
    Purpose: Program is the virtual version of Mimi's Mini Ice Cream Shop
    Users must create 4 various cones with different flavors
    program writes changes to file, and reads file once the user makes a selection
*/
/*
This is the memento
 */
import java.util.ArrayList;
import java.io.Serializable;
class IceCreamState implements Serializable {
    private int scoopNum;
    private String flavor;
    private String coneType;
    private ArrayList<String> toppings;
    
    //public static final long serialVersionUID = 0;

    /**
     * IceCreamState: 
     * Constructor builds a blank state
     */
    public IceCreamState() {
        scoopNum = 0;
        flavor = "";
        coneType = "";
        toppings = new ArrayList<String>();
    }

    /**
     * IceCreamState: 
     * Constructor builds for each of a Advanced Ice Cream Cone Objects instance variables
     * @param n number of scoops
     * @param f flavor of cone
     * @param c type of cone
     * @param t toppings array
     */
    public IceCreamState(int n, String f, String c, ArrayList<String> t) {
        scoopNum = n;
        flavor = f;
        coneType = c;
        toppings = t;
    }

    /**
     * @param scoopNum the scoopNum to set
     */
    public void setScoopNum(int scoopNum) {
        this.scoopNum = scoopNum;
    }

    /**
     * @param coneType the coneType to set
     */
    public void setConeType(String coneType) {
        this.coneType = coneType;
    }

    /**
     * @param flavor the flavor to set
     */
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    /**
     * @param toppings the toppings to set
     */
    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
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

    /**
     * toString: 
     * returns the state represented as a string
     * no param
     * @return string of builder
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("State Contains:\n");
        builder.append("# of scoops = "+scoopNum+"\n");
        builder.append("flavor = "+flavor+"\n");
        builder.append("type of cone = "+ coneType+"\n");
        builder.append("Toppings: ");
        for (String top : toppings) {
            builder.append(top+", ");
        }
        return builder.toString();
    }

}