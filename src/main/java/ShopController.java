public class ShopController extends Controller{
    @CLIInfo(desc = "1. Buy item", num=1, access = 1)
    public void buy(){
        System.out.println("Buy");
    }
    @CLIInfo(desc = "2. Sell item", num=2, access = 1)
    public void sell(){
        System.out.println("Sell");
    }
}