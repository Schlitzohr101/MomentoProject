
/*  William Murray, Adrian Seth
    October 31th, 2019
    Purpose: Program is the virtual version of Mimi's Mini Ice Cream Shop
    Users must create 4 various cones with different flavors
    program writes changes to file, and reads file once the user makes a selection
*/
import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Tester {
    /* This class is used to test the functionality of the IceCreamCone class */
    public static void main(String[] args) {
        AdvancedIceCreamCone IC = new AdvancedIceCreamCone();
        IceCreamStateTaker caretaker = new IceCreamStateTaker();
        System.out.println("Welcome to Mimi's Mini Ice Cream shop!");
        System.out.println("We know making decisions is hard :/");
        System.out.println("Here we let you create 4 cones of our limited menu\nbefore forcing you to choose one!");
        Create("Vanilla", caretaker);
        Create("Chocolate", caretaker);
        Create("Strawberry", caretaker);
        Create("Mimi's Mint", caretaker);
        // write each of the cones states stored in the caretaker to file
        caretaker.writeStates();
        System.out.println("Ok, which cone would you like?");
        char choice;
        boolean done = false;
        choice = FinalChoice();
        while (!done) {
            try {
                if (choice == 'V') {
                    IC.setFromState(caretaker.getState("Vanilla"));
                    done = true;
                } else if (choice == 'C') {
                    IC.setFromState(caretaker.getState("Chocolate"));
                    done = true;
                } else if (choice == 'S') {
                    IC.setFromState(caretaker.getState("Strawberry"));
                    done = true;
                } else if (choice == 'M') {
                    IC.setFromState(caretaker.getState("Mimi's Mint"));
                    done = true;
                } else {
                    System.out.println("Ok seriously, you have to pick a valid flavor. Or Else");
                    FinalChoice();
                    choice = FinalChoice();
                }
            } catch (Exception e) {
                // error handleing if fileNotFound
                done = true;
                System.out.print(
                        "Mimi's Ice Cream shop has burned all records of your Ice cream, we apologize.\nPlease leave the store");
                break;
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append("Okay so you decided on the " + IC.getFlavor() + " today, took long enough\n");
        builder.append("At " + String.format("%.2f", priceTaker(choice)) + " per scoop for " + IC.getNumberOfScoops()
                + " scoops\n");
        if (IC.getToppings().size() > 0) {
            builder.append("With " + IC.getToppings().size() + " topping" + (IC.getToppings().size() == 1 ? " " : "s ")
                    + "for 50 cents each\n");
        }
        double total = BigDecimal
                .valueOf((priceTaker(choice) * IC.getNumberOfScoops()) + (IC.getToppings().size() * .5))
                .setScale(2, RoundingMode.HALF_UP).doubleValue();
        builder.append("Your total is " + String.format("$%.2f", total) + " Please Pay immediately\n");
        builder.append("Goodbye for an extended period of time!\n");
        System.out.print(builder.toString());
    }

    public static void Create(String x, IceCreamStateTaker caretaker) {
        Scanner in = new Scanner(System.in);
        AdvancedIceCreamCone IC = new AdvancedIceCreamCone(x);
        char choice;
        choice = ' ';
        System.out.println("Please select a cone for your " + x + " ice cream");
        CMenu();
        choice = Character.toUpperCase(in.nextLine().charAt(0));
        boolean aCone = false;
        do {
            // input handeling
            if (coneTaker(choice) != null) {
                IC.setTypeOfCone(coneTaker(choice));
                aCone = true;
            } else {
                // wrong answer
                System.out
                        .print("Im sorry, but it seems that you had a stroke. Please choose from the options listed\n");
                CMenu();
                choice = Character.toUpperCase(in.nextLine().charAt(0));
            }
        } while (!aCone);
        System.out.println("You currently have one scoop of " + x + ", would you like another?(Y/N)");
        choice = Character.toUpperCase(in.nextLine().charAt(0));
        while (choice != 'N') {
            IC.addScoop();
            System.out.println("Scoop added. Would you like another?");
            choice = Character.toUpperCase(in.nextLine().charAt(0));
        }
        System.out.println("Would you like any toppings?(Y/N)");
        choice = Character.toUpperCase(in.nextLine().charAt(0));
        while (choice != 'N') {
            TMenu();
            do {
                choice = Character.toUpperCase(in.nextLine().charAt(0));
                if (toppingTaker(choice) == null) {
                    System.out.println("It would seem you didn't read the menu, allow me to show you again");
                    TMenu();
                } else {
                    IC.addToppings(toppingTaker(choice));
                }
            } while (toppingTaker(choice) == null);

            System.out.println("Would you like any more toppings?");
            choice = Character.toUpperCase(in.nextLine().charAt(0));
        }
        // add the state of the IC to the caretaker
        caretaker.add(IC.saveState());
    }

    /**
     * coneTaker: based on the char given, will return string of cone
     * 
     * @param i first letter of cone name
     * @return string of cone or null if invalid param
     */
    public static String coneTaker(char i) {
        Map<Character, String> temp = new HashMap<Character, String>();
        temp.put('W', "Waffle");
        temp.put('T', "Traffic");
        temp.put('S', "Sugar");
        return temp.get(i);
    }

    /**
     * toppingTaker: based on the char given, will return string of topping
     * 
     * @param i first letter of topping
     * @return string of topping or null if invalid param
     */
    public static String toppingTaker(char t) {
        Map<Character, String> temp = new HashMap<Character, String>();
        temp.put('P', "Peanut");
        temp.put('S', "Sprinkles");
        temp.put('C', "Cherries");
        return temp.get(t);
    }

    /**
     * priceTaker: based on the char given, will return price of ice cream
     * 
     * @param i first letter of ice cream
     * @return price of ice cream or null if invalid param
     */
    public static double priceTaker(char i) {
        Map<Character, Double> temp = new HashMap<Character, Double>();
        temp.put('C', 1.00);
        temp.put('V', .75);
        temp.put('M', 1.10);
        temp.put('S', 1.25);
        return temp.get(i);
    }

    /**
     * CMenu: menu of Cones
     */
    public static void CMenu() {
        System.out.println("What kind of cone would you like?");
        System.out.print("Cones:\nS)ugar\nW)affle\nT)raffic\n:");
    }

    /**
     * TMenu: menu of Toppings
     */
    public static void TMenu() {
        System.out.println("Toppings: \nP)eanuts(Warning contains Peanuts)\nS)prinkles\nC)herries");
    }

    /**
     * FinalChoice: takes the final choice of ice cream from user
     * 
     * @return first letter of user input
     */
    public static char FinalChoice() {
        Scanner in = new Scanner(System.in);
        System.out.print("V)anilla\nC)hocolate\nS)trawberry\nM)imi's Mint\n:");
        return Character.toUpperCase(in.nextLine().charAt(0));
    }
}
