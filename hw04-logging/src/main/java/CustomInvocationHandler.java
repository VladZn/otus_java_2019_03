import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.stream.Stream;

public class CustomInvocationHandler implements InvocationHandler {
    private Object object;

    public CustomInvocationHandler(Object obj) {
        this.object = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Log.class)) {
            System.out.printf("executed method: %s, params:", method.getName());
            Stream.of(args).forEach(arg -> System.out.print(" "+arg));
            System.out.println();
        }
        return method.invoke(object, args);
    }
}
