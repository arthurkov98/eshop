import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class Controller {
    private Method[] methods;

    public boolean isWorking;
    public Controller(){
        methods = this.getClass().getDeclaredMethods();
        isWorking = true;
    }
    public List<String> getListMethod(int filter){
        List<String> list = new ArrayList<>();
        List<CLIInfo> anno = new ArrayList<>();
        for (Method method : methods){
            CLIInfo a = method.getAnnotation(CLIInfo.class);
            if(a == null) continue;
            anno.add(a);
        }
        anno.sort((x,y) -> x.num()-y.num());
        for(CLIInfo a: anno) list.add(a.desc());
        return list;
    }

    public void runMethod(int num){
        for (Method method : methods){
            CLIInfo a = method.getAnnotation(CLIInfo.class);
            if(a == null) continue;
            if(a.num() == num){
                try {
                    method.invoke(this, null);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }

}
