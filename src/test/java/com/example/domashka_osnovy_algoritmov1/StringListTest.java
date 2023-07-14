package com.example.domashka_osnovy_algoritmov1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.internal.matchers.Null;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListTest {

    String[] testing = {"one","two","three","four","five","six", "seven","eighth","nine","ten"};

    StringList stringListTest = new StringListLogic();


    @Test
    void testAdd() {
        String expected = stringListTest.add("hello");
        Assertions.assertEquals(expected, "hello");

    }

    @Test
    void set() {
        String expected = stringListTest.add(1, "hello");
        Assertions.assertEquals(expected, "hello");
    }

    @Test
    void remove() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            stringListTest.remove("hello");
        });
    }

    @Test
    void testRemove() {
        stringListTest.remove(2);
        Assertions.assertNotEquals(testing,"three");

    }

    @Test
    void indexOf() {

        for (int i = 0; i < testing.length; i++) {
            if(testing[i].equals("three")){
               int actual=i;
                Assertions.assertEquals(2,actual);
            }
        }

    }

    @Test
    void lastIndexOf() {
        int actual;
        for (int i = testing.length - 1; i >= 0; i--) {
            if (testing[i].equals("twelfth")) {
                actual = i;
            } else {
                actual = -1;
            }
            Assertions.assertEquals(-1, actual);
        }
    }

    @Test
    void get() {
        String actual;
        actual=testing[2];
        Assertions.assertEquals("three",actual);
    }

    @Test
    void testEquals() {
        String[] actTest =new String[]{"monday","friday"};
        if(testing.equals(actTest)){
            boolean actual= true;
            Assertions.assertEquals(true,actual);
        }
    }

    @Test
    void size() {
        int actualSize= testing.length;
        assertEquals(10,actualSize);

    }


}