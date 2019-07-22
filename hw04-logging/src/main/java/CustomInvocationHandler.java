import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class CustomInvocationHandler implements InvocationHandler {
    private final Object object;
    private final Set<Method> logMethods = new HashSet<>();

    public CustomInvocationHandler(Object obj) {
        this.object = obj;
        Arrays.stream(obj.getClass().getInterfaces())
                .flatMap(clazz -> Arrays.stream(clazz.getDeclaredMethods()))
                .filter(method -> method.isAnnotationPresent(Log.class))
                .forEach(logMethods::add);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (logMethods.contains(method)) {
            System.out.printf("executed method: %s, params:", method.getName());
            Stream.of(args).forEach(arg -> System.out.print(" " + arg));
            System.out.println();
        }
        return method.invoke(object, args);
    }
}
