/*
package com.bobocode.basics;

/**
 * {@link Box} is a container class that can store a value of any given type. Using Object as a field type
 * is flexible, because we can store anything we want there. But it is not safe, because it requires runtime casting
 * and there is no guarantee that we know the type of the stored value.
 * <p>
 * todo: refactor this class so it uses generic type "T" and run {@link com.bobocode.basics.BoxTest} to verify it

public class Box {
    private Object value;

    public Box(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
Problem with Current Box

Current code:

private Object value;

Because it's Object, you can store anything:

intBox.setValue(222);
intBox.setValue("abc"); // allowed ❌

Then later:

(int) intBox.getValue()

If "abc" is stored → ❌ ClassCastException at runtime

Goal:

Fail at compile time instead
 */

package Generics;

public class Box<T> {

    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
