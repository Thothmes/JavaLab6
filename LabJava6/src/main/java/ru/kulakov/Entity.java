package ru.kulakov;

import java.lang.reflect.Field;

public abstract class Entity {
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Field[] fields = this.getClass().getDeclaredFields();
        boolean classAnnotatedWithNo = this.getClass().isAnnotationPresent(ToString.class) &&
                this.getClass().getAnnotation(ToString.class).value().equals("NO");

        for (Field field : fields) {
            field.setAccessible(true);
            boolean fieldAnnotatedWithNo = field.isAnnotationPresent(ToString.class) &&
                    field.getAnnotation(ToString.class).value().equals("NO");
            boolean fieldAnnotatedWithYes = field.isAnnotationPresent(ToString.class) &&
                    field.getAnnotation(ToString.class).value().equals("YES");

            if ((!classAnnotatedWithNo || fieldAnnotatedWithYes) && !fieldAnnotatedWithNo) {
                try {
                    result.append(field.getName()).append("=").append(field.get(this)).append(", ");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        if (result.length() > 2) {
            result.setLength(result.length() - 2);
        }
        return result.toString();
    }
}