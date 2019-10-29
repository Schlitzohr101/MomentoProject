import java.util.*;
public class Tester {
    /* This class is used to test the functionality of the IceCreamCone class */
    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // AdvancedIceCreamCone IC = new AdvancedIceCreamCone();
        // char choice;
        // choice = Character.toUpperCase(in.nextLine().charAt(0));
        Create();

    }
    public static void Create(){
        Scanner input = new Scanner(System.in);
        IceCreamStateTaker manager = new IceCreamStateTaker();
        AdvancedIceCreamCone IC = new AdvancedIceCreamCone();
        char choice;
        int Tcount = 0;
        choice = ' ';
        int scoops;
        System.out.println("Welcome to Mimi's Ice Cream shop!");
        while(choice!='Q'){
            System.out.println("Select a Ice Cream Flavor");
            System.out.print("Flavors:  V)anilla  C)hocolate  S)trawberry  M)imi's Mint\n:");
            choice = Character.toUpperCase(input.nextLine().charAt(0));
            do {
                
            } while (ICtaker(choice) != null);
            IC.setFlavor(ICtaker(choice));
            System.out.println("How many scoops?");
            scoops = input.nextInt();
            IC.addScoop(scoops);
            System.out.println("What type of cone?");
            CMenu();
            choice = Character.toUpperCase(input.nextLine().charAt(0));
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
            while(choice!='N') {
                System.out.println("Enter a topping");
                IC.addToppings(input.nextLine());
                Tcount++;
                System.out.println("More Toppings?(y/n)");
                choice = Character.toUpperCase(input.nextLine().charAt(0));
                //Arraylist.add<> "top" variable
            }
            manager.add(IC.saveState());
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
    

    public static String ICtaker(char i) {
        
        Map<Character,String> temp = new HashMap<Character,String>();
        temp.put('C', "Chocolate");
        temp.put('V', "Vanilla");
        temp.put('S', "Strawberry");
        temp.put('M', "Mimi's Mint");
        return temp.get(i);
    }
    public static void CMenu(){
        System.out.println("Cones:\nS)ugar\nW)affle\nT)raffic");
    }

}