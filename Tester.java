import java.util.*;
public class Tester {
    /* This class is used to test the functionality of the IceCreamCone class */
    public static void main(String[] args) {
        Scanner in = new Scanner System.in;
        AdvancedIceCreamCone IC = new AdvancedIceCreamCone();
        char choice;
        choice = Character.toUpperCase(input.nextLine().charAt(0));

    }
    public static void Create(){
        Scanner in = new Scanner System.in;
        AdvancedIceCreamCone IC = new AdvancedIceCreamCone();
        char choice;
        int Tcount = 0;
        choice = Character.toUpperCase(input.nextLine().charAt(0));
        int scoops;
        while(choice!='Q'){
            System.out.println("First Select a Flavor");
            ICMenu();
            switch(choice) {
                case 'C':
                    System.out.println("How many scoops?");
                    scoops = input.nextInt();
                    System.out.println("What type of cone?");
                    choice = Character.toUpperCase(input.nextLine().charAt(0));
                    CMenu();
                    switch (choice) {
                        case 'S':
                            String cone = "Sugar";
                            break;
                        case 'W':
                            String cone = "Waffle";
                            break;
                        case 'T':
                            String cone = "Traffic";
                            break;
                    }
                    System.out.println("Toppings?(y/n)");
                    choice = Character.toUpperCase(input.nextLine().charAt(0));
                    while(choice!='N') {
                        System.out.println("Choose a topping");
                        TMenu();
                        toppingchoice = Character.toUpperCase(input.nextLine().charAt(0));
                        switch (toppingchoice) {
                            case 'P':
                                String top = "Peanut";
                                break;
                            case 'S':
                                String top = "Waffle";
                                break;
                            case 'C':
                                String top = "Traffic";
                                break;
                        }
                        Tcount++;
                        System.out.println("More Toppings?(y/n)");
                        choice = Character.toUpperCase(input.nextLine().charAt(0));
                        //Arraylist.add<> "top" variable
                    }
            }
        }
    }




        }
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
    }

    public static void ICMenu(){
        System.out.println("Flavors: \nV)anilla\nC)hocolate\nS)trawberry\nM)imi's Mint");
    }
    public static void CMenu(char c){
        c = Character.toUpperCase(input.nextLine().charAt(0));
        System.out.println("Cones:\nS)ugar\nW)affle\nT)raffic")
    }
    public static void TMenu(){
        Scanner input = new Scanner(System.in);
        char choice;
        System.out.println("Toppings: \nP)eanuts(Warning contains Peanuts)\nS)prinkles\nC)herries");
        choice = Character.toUpperCase(input.nextLine().charAt(0));
        return choice;
    }
}