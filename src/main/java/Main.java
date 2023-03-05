public class Main {
    public static void main(String[] args) throws InterruptedException {
        CLInterface clInterface = new CLInterface(new ShopController());
        clInterface.run();
    }
}
