import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name1, name2;

        while(true) {
            System.out.println("Player 1 enter your name:");
            name1 = scan.nextLine();

            System.out.println("Player 2 enter your name:");
            name2 = scan.nextLine();

            if (!name1.equals(name2))
                break;

            System.out.println("Players cant have the same name");
        }

        Player player1 = new Player(name1);
        Player player2 = new Player(name2);

        Player tempPlayer = new Player(" ");

        int choice;
        begin:
        while(player1.getStatus() && player2.getStatus()){
            System.out.println("\nIt is " + player1.getName() + "'s turn");
            System.out.println(player1);
            System.out.println(player1.getName() +
                    " do you want to\n" +
                    "(1) - heal,\n" +
                    "(2) - attack or\n" +
                    "(3) - choose new random weapon?\n");
            choice = scan.nextInt();

            if(choice == 1){
                player1.heal();
                System.out.println(player1.getName() + "'s health is " + player1.getHealth());
            }

            else if(choice == 2){
                player2.takeDamage(player1.getWeapon().getDamage());
                System.out.println(player2.getName() + "'s health is " + player2.getHealth());
                player1.getWeapon().minusHealth();

                if(player1.getWeapon().getHealth() == 0){
                    System.out.println(player1.getName() + "'s weapon has broken! New weapon equipped");
                    player1.getWeapon().setWeapon();
                }
            }

            else if(choice == 3){
                player1.getWeapon().setWeapon();
                System.out.println(player1.getName() + " has new weapon: " + player1.getWeapon().getName());
            }

            else{
                System.out.println("Please enter a valid number");
                continue begin;
            }

            //switching player turns
            tempPlayer = player1;
            player1 = player2;
            player2 = tempPlayer;

        }

        if(!player1.getStatus())
            System.out.println(player1.getName() + " died, " + player2.getName() + " wins!");

        if(!player2.getStatus())
            System.out.println(player2.getName() + " died, " + player1.getName() + " wins!");

        System.out.println("( •_•)    (•_• )\n" +
                " ( ง )ง   ୧( ୧ )\n" +
                "  /︶\\     /︶\\");
    }
}
