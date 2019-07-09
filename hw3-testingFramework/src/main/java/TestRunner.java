import annotation.BeforeAll;
import annotation.BeforeEach;
import annotation.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author V. Zinchenko
 */
public class TestRunner {
    public static void main(String[] args) throws InvocationTargetException {
        try {
            run(RocketTest.class);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    private static void run(Class<?> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?> constructor = clazz.getConstructor();
//        Object object = constructor.newInstance();

        List<Method> testMethods = new ArrayList<>();
        List<Method> beforeMethods = new ArrayList<>();
        List<Method> afterMethods = new ArrayList<>();

        //Stream.of(clazz.getDeclaredMethods()).forEach(method -> System.out.println(method.getName() + " " + method.getModifiers()));

        for (Method method: clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(BeforeAll.class)){
                method.invoke(null);
            } else if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            } else if (method.isAnnotationPresent(BeforeEach.class)) {
                beforeMethods.add(method);
            }
        }

        for (Method method : testMethods) {
            try {
                Object object = constructor.newInstance();
                beforeMethods.forEach(m -> {
                    try {
                        m.invoke(object);
                        System.out.println(m.getName());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
                method.invoke(object);
                System.out.println(method.getName());
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
