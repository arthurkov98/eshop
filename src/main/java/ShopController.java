public class ShopController extends MenuHandler {
    @MenuHandleInfo(desc = "1. Buy item", num=1)
    public void buy(){
        System.out.println("Buy");
    }
    @MenuHandleInfo(desc = "2. Sell item", num=2)
    public void sell(){
        System.out.println("Sell");
    }
    @MenuHandleInfo(desc = "3. Exit", num=3)
    public void exit(){
        this.isWorking = false;
        System.out.println("Bye");
    }
}