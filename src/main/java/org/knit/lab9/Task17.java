package org.knit.lab9;

import java.lang.annotation.*;
import java.lang.reflect.Field;


public class Task17 {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User(null, "LongUsernameHere", 16);

        Validator.validate(user);
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotNull {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Min {
    int value();
}

class User {
    @NotNull
    private String name;

    @MaxLength(10)
    private String username;

    @Min(18)
    private int age;

    public User(String name, String username, int age) {
        this.name = name;
        this.username = username;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }
}

class Validator {
    public static void validate(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true); // Доступ к private полям
            Object value = field.get(obj);

            // Проверка @NotNull
            if (field.isAnnotationPresent(NotNull.class) && value == null) {
                System.out.println("Ошибка: Поле " + field.getName() + " не должно быть null.");
            }

            // Проверка @MaxLength
            if (field.isAnnotationPresent(MaxLength.class) && value instanceof String) {
                int maxLength = field.getAnnotation(MaxLength.class).value();
                if (((String) value).length() > maxLength) {
                    System.out.println("Ошибка: Поле " + field.getName() + " превышает максимальную длину " + maxLength + ".");
                }
            }

            // Проверка @Min
            if (field.isAnnotationPresent(Min.class) && value instanceof Integer) {
                int minValue = field.getAnnotation(Min.class).value();
                if ((Integer) value < minValue) {
                    System.out.println("Ошибка: Поле " + field.getName() + " меньше минимального значения " + minValue + ".");
                }
            }
        }
    }
}
