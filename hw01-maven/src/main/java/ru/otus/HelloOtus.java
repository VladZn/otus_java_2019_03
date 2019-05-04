package ru.otus;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

import java.util.List;

/**
 * @author V. Zinchenko
 */
public class HelloOtus {
    public static void main(String[] args) {
        List<Integer> ascList = Ints.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> descList = Lists.reverse(ascList);

        System.out.println(String.format("Source list: %s", ascList));
        System.out.println(String.format("Reversed list: %s", descList));
    }
}
