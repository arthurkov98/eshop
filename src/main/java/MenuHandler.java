import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class MenuHandler {
    private final Method[] methods;

    public boolean isWorking;
    public MenuHandler(){
        methods = this.getClass().getDeclaredMethods();
        isWorking = true;
    }
    public List<String> getListMethod(){
        List<String> list = Arrays.stream(methods)
                .map(m -> m.getAnnotation(MenuHandleInfo.class))
                .filter(a -> a != null)
                .sorted(Comparator.comparingInt(x -> x.num()))
                .map(a -> a.desc())
                .collect(Collectors.toList());
        return list;
    }

    public void handleChoice(int num){
        for (Method method : methods){
            MenuHandleInfo a = method.getAnnotation(MenuHandleInfo.class);
            if(a == null) continue;
            if(a.num() == num){
                try {
                    method.invoke(this, null);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                return;
            }
        }
        throw new RuntimeException("Wrong input! This number doesn't exist in menu:" + num);
    }

}
