/*  William Murray, Adrian Seth
    October 31th, 2019
    Purpose: Program is the virtual version of Mimi's Mini Ice Cream Shop
    Users must create 4 various cones with different flavors
    program writes changes to file, and reads file once the user makes a selection
*/
//This is the caretaker class
//caretaker stores and restores states from memento
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
class IceCreamStateTaker {
    private ArrayList<IceCreamState> states = new ArrayList<IceCreamState>();
    PrintWriter writer;

    /**
     * add: 
     * adds a state to the list of states
     * @param s state to add
     */
    public void add(IceCreamState s) {
        //need to save this incoming state to a file within this 
        states.add(s);
    }

    /**
     * getAt: 
     * returns states at the passed in index
     * @param index
     * @return state at index
     */
    public IceCreamState getAt(int index) {
        return states.get(index);
    }

    /**
     * getState: 
     * reads from the "states.txt" file and pulls the state with matching flavor as passed in
     * @param name of flavor to find
     * @return state with the flavor
     * @throws FileNotFoundException if the file cannot be opened
     */
    public IceCreamState getState(String name) throws FileNotFoundException{
        IceCreamState newState = new IceCreamState();
        //instantiate objects
        File file = new File("states.txt");
        Scanner reader = new Scanner(System.in);
        String[] split;
        boolean found = false;
        try {
            //make sure the file exist
            reader = new Scanner(file);
            do {
                String stateStr = reader.nextLine();
                //split based on the delimiter
                split = stateStr.split(";");
                if (split[0].equals(name)) {
                    //the flavor has been found
                    found = true;
                }
            } while (reader.hasNext());
            reader.close();
        } catch (Exception e) {
            //handle error
            System.out.print("Error in reading from file\nException: ");
            System.out.println(e);
            reader.close();
            throw e;
        }
        if (found) {
            //if we actually found the flavor and didn't reach eof
            for (int i = 0; i < split.length; i++) {
                //build state from values read in
                switch (i) {
                    case 0: newState.setFlavor(split[i]);
                    break;
                    case 1: newState.setScoopNum(Integer.parseInt(split[i]));
                    break;
                    case 2: newState.setConeType(split[i]);
                    break;
                    case 3: String[] toppings = split[i].split(",");
                            newState.setToppings(new ArrayList<String>(Arrays.asList(toppings)));
                            break;
                    default: System.out.print("Error in parsing state from reader split");
                    break;
                }
            }
        } else {
            System.out.println("It would seem our records do not have" + name + ". What a shame");
        }
        return newState;
        
    }

    /**
     * writeStates: 
     * writes every state in the list to the file defined in the constructor
     */
    public void writeStates() {
        try {
            PrintWriter writer = new PrintWriter("states.txt");
            for (IceCreamState state : states) {
                writer.write(state.getFlavor()+";");
                writer.write(state.getScoopNum()+";");
                writer.write(state.getConeType()+";");
                for (int i = 0; i < state.getToppings().size(); i++) {
                    writer.write(state.getToppings().get(i) + (i+1==state.getToppings().size() ? "" : ","));
                }
                writer.write("\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.print("Error writing to \"states.txt\" \nException found: ");
            System.out.print(e);
        }
    }
}