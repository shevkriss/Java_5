package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {
    public <T> T inject(T object) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/com/company/test.properties "));
        } catch (IOException e) {
            System.out.println("Error loading properties");
        }
        try {
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                Annotation[] annotations = field.getAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation instanceof AutoInjectable) {
                        String fieldClass = field.getType().toString();
                        fieldClass = fieldClass.substring(fieldClass.indexOf(" ") + 1);
                        String classToInject = properties.getProperty(fieldClass);
                        field.set(object, Class.forName(classToInject).newInstance());
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("Error injecting classes");
        }
        return object;
    }
}
