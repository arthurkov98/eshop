import java.util.Scanner;

public class CLInterface {
    Controller controller;
    public CLInterface(Controller controller){
        this.controller = controller;
    }

    public void run(){
        System.out.println("Program menu:");
        for(String str: controller.getListMethod(1)){
            System.out.println(str);
        }
        System.out.println("");
        System.out.println("Enter menu item number to execute:");
        Scanner scanner = new Scanner(System.in);
        int userChoice = Integer.parseInt(scanner.nextLine());
        this.controller.runMethod(userChoice);
    }
}