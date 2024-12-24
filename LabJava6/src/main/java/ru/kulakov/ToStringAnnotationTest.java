package ru.kulakov;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;

public class ToStringAnnotationTest {

    @Test
    public void testToStringAnnotationOnClass() {
        ToString toStringAnnotation = ExampleClass.class.getAnnotation(ToString.class);
        assertNotNull(toStringAnnotation, "Аннотация @ToString должна присутствовать на классе ExampleClass");
        assertEquals("NO", toStringAnnotation.value(), "Значение свойства value должно быть 'NO'");
    }

    @Test
    public void testToStringAnnotationOnField() throws NoSuchFieldException {
        Field exampleField = ExampleClass.class.getDeclaredField("exampleField");
        ToString toStringAnnotation = exampleField.getAnnotation(ToString.class);
        assertNotNull(toStringAnnotation, "Аннотация @ToString должна присутствовать на поле exampleField");
        assertEquals("YES", toStringAnnotation.value(), "Значение свойства value должно быть 'YES'");
    }
}
@ToString(value = "NO")
class ExampleClass {
    @ToString
    private String exampleField;
}