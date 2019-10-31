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
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
class IceCreamStateTaker {
    private ArrayList<IceCreamState> states = new ArrayList<IceCreamState>();
    ObjectOutputStream writer;

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
    public IceCreamState getState(String name) throws Exception{
        IceCreamState newState = new IceCreamState();
        //instantiate objects
        boolean found = false;
        try {
            //make sure the file exist
            FileInputStream file = new FileInputStream("states.dat");
            ObjectInputStream reader = new ObjectInputStream(file);
            do {
                newState = (IceCreamState) reader.readObject();
            } while (!newState.getFlavor().equals(name));
            if(newState.getFlavor().equals(name)) {
                found = true;
            }
            reader.close();
        } catch (IOException e) {
            //handle error
            System.out.print("Error in reading from file\nException: ");
            e.printStackTrace();
            throw e;
        } catch (ClassNotFoundException e) {
            System.out.println("Error in reading from file\nException: ");
            e.printStackTrace();
        }
        if(!found) {
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
            FileOutputStream file = new FileOutputStream("states.dat");
            writer = new ObjectOutputStream(file);
            for (IceCreamState state : states) {
                writer.writeObject(state);
            }
            writer.close();
        } catch (IOException e) {
            System.out.print("Error writing to \"states.txt\" \nException found: ");
            e.printStackTrace();
        }
    }

    // @SuppressWarnings("unchecked")
    // private static <T> T castToAnything(Object obj) {
    //     return (T) obj;
    // }
}