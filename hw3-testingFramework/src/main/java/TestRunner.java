import annotation.AfterAll;
import annotation.AfterEach;
import annotation.BeforeAll;
import annotation.BeforeEach;
import annotation.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static java.lang.reflect.Modifier.isStatic;

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

    private static void run(Class<?> clazz) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Constructor<?> constructor = clazz.getConstructor();

        List<Method> testMethods = new ArrayList<>();
        List<Method> beforeMethods = new ArrayList<>();
        List<Method> afterMethods = new ArrayList<>();

        Method beforeAllMethod = null;
        Method afterAllMethod = null;

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(BeforeAll.class)) {
                beforeAllMethod = method;
            } else if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            } else if (method.isAnnotationPresent(BeforeEach.class)) {
                beforeMethods.add(method);
            } else if (method.isAnnotationPresent(AfterEach.class)) {
                afterMethods.add(method);
            } else if (method.isAnnotationPresent(AfterAll.class)) {
                afterAllMethod = method;
            }
        }

        if (beforeAllMethod != null && isStatic(beforeAllMethod.getModifiers())) {
            beforeAllMethod.invoke(null);
        }

        for (Method method : testMethods) {
            Object obj = constructor.newInstance();
            try {
                invokeMethods(beforeMethods, obj);
                method.invoke(obj);
                System.out.println(method.getName());
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            } finally {
                invokeMethods(afterMethods, obj);
            }
        }

        if (afterAllMethod != null && isStatic(afterAllMethod.getModifiers())) {
            afterAllMethod.invoke(null);
        }
    }

    private static void invokeMethods(List<Method> methods, Object object) {
        methods.forEach(method -> {
            try {
                method.invoke(object);
                System.out.println(method.getName());
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }
}
