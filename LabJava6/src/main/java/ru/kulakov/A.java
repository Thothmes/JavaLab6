package ru.kulakov;

@ToString(value = "NO")
public class A extends Entity {
    @ToString(value = "YES")
    static String s = "hello";
    int x = 42;
    @ToString(value = "NO")
    String y = "world";
}