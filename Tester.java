import java.util.*;
public class Tester {
    /* This class is used to test the functionality of the IceCreamCone class */
    public static void main(String[] args) {
        System.out.println("Welcome to Mimi's Mini Ice Cream shop!");
        System.out.println("We know making decisions is hard :/");
        System.out.println("Here we let you create 4 cones of our limited menu\nbefore forcing you to choose one!");

        Create("Vanilla");
        Create("Chocolate");
        Create("Strawberry");
        Create("Mimi's Mint");
        System.out.println("Ok, which cone would you like?");
        FinalChoice();
        char choice;
        choice = FinalChoice();
        if (choice != 'V' || 'C' || 'S' || 'M') {
            System.out.println("Ok seriously, you have to pick a valid flavor.");
            FinalChoice();
            char choice = FinalChoice();
        } else if (choice == 'V') {
            IC.restore(caretaker.getMemento("Vanilla"));
        } else if (choice == 'C') {
            IC.restore(caretaker.getMemento("Chocolate"));
        } else if (choice == 'S') {
            IC.restore(caretaker.getMemento("Strawberry"));
        } else if (choice == 'M') {
            IC.restore(caretaker.getMemento("Mimi's Mint"));
        }
    }

    public static void Create(String x) {
        int scoopCount = 1;
        Scanner in = new Scanner(System.in);
        AdvancedIceCreamCone IC = new AdvancedIceCreamCone();
        char choice;
        choice = ' ';
        System.out.println("Please create a" + x + " cone");
        CMenu();
        choice = Character.toUpperCase(in.nextLine().charAt(0));
        String coneType = "";
        if (choice == 'S') {
            coneType = "Sugar";
        } else if (choice == 'W') {
            coneType = "Waffle";
        } else if (choice == 'T') {
            coneType = "Traffic";
        } else {
            System.out.println("We dont have that cone please choose another");
            CMenu();
        }
        System.out.println("You currently have one scoop of" + x + ",would you like another?(Y/N)");
        choice = Character.toUpperCase(in.nextLine().charAt(0));
        while (choice != 'N') {
            scoopCount++;
            System.out.println("Scoop added. Would you like another?");
            choice = Character.toUpperCase(in.nextLine().charAt(0));
        }
        System.out.println("Would you like any toppings?(Y/N)");
        choice = Character.toUpperCase(in.nextLine().charAt(0));
        while (choice != 'N') {
            String topping = in.nextLine();
            IC.addToppings(topping);
            System.out.println("Would you like any more toppings?");
            choice = Character.toUpperCase(in.nextLine().charAt(0));
        }
        IC = new AdvancedIceCreamCone(x, coneType, scoopCount);
        caretaker.addMemento(IC.save());
    }

    public static String ICtaker(char i) {
        
        Map<Character,String> temp = new HashMap<Character,String>();
        temp.put('C', "Chocolate");
        temp.put('V', "Vanilla");
        temp.put('S', "Strawberry");
        temp.put('M', "Mimi's Mint");
        return temp.get(i);
    }
    public static void CMenu(){
        System.out.println("What kind of cone would you like?");
        System.out.println("Cones:\nS)ugar\nW)affle\nT)raffic");
    }
    public static void TMenu(){
        System.out.println("Toppings: \nP)eanuts(Warning contains Peanuts)\nS)prinkles\nC)herries");
    }
    public static char FinalChoice(){
        Scanner in=new Scanner(System.in);
        char choice;
        System.out.println("V)anilla\nC)hocolate\nS)trawberry\nM)imi's Mint");
        return choice=Character.toUpperCase(in.nextLine().charAt(0));
        }
}


        /*
            do {
                //input handling
            } while (ICtaker(choice) != null);
            IC.setFlavor(ICtaker(choice));
            System.out.println("How many scoops?");
            scoops = input.nextInt();
            IC.addScoop(scoops);
            System.out.println("What type of cone?");
            CMenu();
            coneChoice = Character.toUpperCase(input.nextLine().charAt(0));
            switch (choice) {
                case 'S':
                    IC.setTypeOfCone("Sugar");
                    break;
                case 'W':
                    IC.setTypeOfCone("Waffle");
                    break;
                case 'T':
                    IC.setTypeOfCone("Traffic");
                    break;
            }
            System.out.println("Toppings?(y/n)");
            choice = Character.toUpperCase(input.nextLine().charAt(0));
                Tcount++;
                System.out.println("More Toppings?(y/n)");
                choice = Character.toUpperCase(input.nextLine().charAt(0));
                //Arraylist.add<> "top" variable
                */





                /*IceCreamCaretaker caretaker = new IceCreamCaretaker("abc");
                AdvancedIceCreamCone ICC = new AdvancedIceCreamCone();
                System.out.println("The new cone is: " + ICC);
                ICC.addScoop();
                ICC.addToppings("chips");
                ICC.addToppings("fudge");
                System.out.println("The cone is now: " + ICC);
                caretaker.addMemento( ICC.save());
                ICC = new AdvancedIceCreamCone(2,"chocolate","sugar");
                System.out.println("Cone 2 is: " + ICC);
                ICC.setFlavor("strawberry");
                System.out.println("The flavor of cone one is now " + ICC.getFlavor());
                ICC.setTypeOfCone("waffle");
                System.out.println("The type of cone one is now " + ICC.getTypeOfCone());
                ICC.addScoop();
                System.out.println("Cone 2 is: " + ICC);
                caretaker.addMemento( ICC.save());
                String [] toppings={"sprinkles","chocolate chips","marshmallows",
                        "oreo cookies","nuts","cherry"};
                ICC.addToppings(Arrays.asList(toppings));
                System.out.println("Cone 2 is: " + ICC);
                ICC.restore( caretaker.getMemento("vanilla") );
                System.out.println("The user choice restored to: " + ICC);
                 */
