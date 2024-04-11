import java.util.Scanner;

public class Daycare {
    /* Doggy daycare
    *  user should be able to input the number of spots available
    *
    *
    * */

    // Variables
    static Scanner console = new Scanner(System.in);
    static String[] daycareSpaces;
    static int capacity;

    // Main
    public static void main(String[] args) {

        startUp();
    } // main closes

    // Methods

    public static void startUp(){
        System.out.println("---Welcome to doggy daycare---");
        System.out.println("Please enter the number of spaces available for today: ");
        capacity = Integer.parseInt(console.nextLine());
        daycareSpaces = new String[capacity];

        menu();
    }

    public static void menu(){

        boolean exit = false;
        do{
            System.out.println("What would you like to do?");
            System.out.println("1. Check a dog into daycare");
            System.out.println("2. Check a dog out of daycare");
            System.out.println("3. View all dogs in our care");
            System.out.println("4. Exit");
            System.out.println("Please enter your choice: [1-4]");

            int choice = Integer.parseInt(console.nextLine());

            switch(choice){
                case 1:
                    checkIn();
                    break;
                case 2:
                    checkOut();
                    break;
                case 3:
                    viewAllDogs();
                    break;
                case 4:
                    System.out.println("----- Thank you for visiting doggy daycare, Have a nice day! ----- ");
                    exit = true;
                    break;
                default:
                    System.out.println("That's not a valid choice, please try again");
            }

        }while(!exit);
    }

    public static void checkIn(){
        System.out.println("\n Who is the good dog visiting us today?: ");
        String dogName = console.nextLine();;

        for (int i = 0; i < daycareSpaces.length ; i++) {
            if(daycareSpaces[i] == null){
                daycareSpaces[i] = dogName;
                System.out.println("\n" + dogName + "has been checked in to daycare!");
                return;
            }
        }
        System.out.println("\n Sorry, there is no available spaces for today. We are fully booked");
    }

    public static void checkOut(){
        System.out.print("\n What is the name of the dog you are picking up: ");
        String dogName = console.nextLine();

        for (int i = 0; i < daycareSpaces.length; i++) {
            if(daycareSpaces[i] != null && daycareSpaces[i].equalsIgnoreCase(dogName)){
                daycareSpaces[i] = null;
                System.out.println("\n" + dogName + "has been picked up by the owner");
                return;
            }
        }
        System.out.println("\n Sorry, we cannot find your dog, I do not think its checked in to our daycare today.");
    }

    public static void viewAllDogs(){
        System.out.println("\n Current Dogs in our care:");

        int availableSpace = 0;
        for (int i =0 ; i< daycareSpaces.length; i++){
            if(daycareSpaces[i] != null){
                System.out.println(daycareSpaces[i]);
            } else {
                availableSpace++;
            }
        }
        System.out.println("Available Spaces: " + availableSpace);
    }




} // class close
