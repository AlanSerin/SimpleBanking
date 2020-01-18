import java.util.Random;
import java.util.Scanner;

class Infos{
    static int Balance;
    String idnum;
    Random rand = new Random();
    Infos(){
        idnum =(char)(rand.nextInt(26) + 'A') + "" + (char)(rand.nextInt(26) + 'A') + (rand.nextInt(1000)+1000);
    }
    static void Deposit() {
        Scanner scn = new Scanner(System.in);
        int depo;
        System.out.println("Enter an amount to Deposit: ");
        depo = scn.nextInt();
        System.out.println(depo + " Deposited");
        Infos.Balance += depo;
    }

    static void Check() {
        System.out.println("Your Balance is: "+Infos.Balance);
    }

    public void Withdraw() {
        Scanner scn = new Scanner(System.in);
        int amount;
        System.out.println("Enter an amount to Withdraw: ");
        amount = scn.nextInt();
        if(amount > Infos.Balance){
            System.out.println("Not enough money");
            Withdraw();
        }
        else{
            System.out.println(amount + " Withdrawn");
            Infos.Balance -= amount;
        }
    }
}

public class file {
    public static void main(String[] args) {
        String input;
        boolean isbanking = true;
        Scanner scan = new Scanner(System.in);
        Infos person = new Infos();

        System.out.println("Welcome to simple banking\nYour id is: " + person.idnum);
        System.out.println("\nA. Check Your Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Exit");
        while (isbanking) {
            System.out.println("\nEnter an option");
            input = scan.next();
            switch (input) {
                case "A":
                    person.Check();
                    break;
                case "B":
                    person.Deposit();
                    break;
                case "C":
                    person.Withdraw();
                    break;
                case "D":
                    System.out.println("Thank you for usign this app");
                    isbanking = false;
                    break;
                default:
                    System.out.println("Invalid option try again");
                    break;
            }
        }

    }
}
