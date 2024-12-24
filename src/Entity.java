import java.lang.reflect.Field;

public abstract class Entity {
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.getClass().getSimpleName()).append(" {");

        // Получаем все поля текущего класса и его суперклассов
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

        // Удаляем последнюю запятую и пробел
        if (result.length() > 2) {
            result.setLength(result.length() - 2);
        }

        result.append("}");
        return result.toString();
    }
}