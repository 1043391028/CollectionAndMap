package com.guan.ReflectionAndAnotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class Test01 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> c1 = Class.forName("com.guan.ReflectionAndAnotation.Student");
        // 通过反射获得指定注解；
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        System.out.println("****************************");
        // 通过反射获得指定注解的值；
        studentAnotation stuanotation = (studentAnotation) c1.getAnnotation(studentAnotation.class);
        String value = stuanotation.value();
        System.out.println(value);
        // 通过反射获得字段注解的值；
        Field f = c1.getDeclaredField("name");
        filedAnotation annotation = f.getAnnotation(filedAnotation.class);
        System.out.println(annotation.column_length());
        System.out.println(annotation.column_Name());
        System.out.println(annotation.column_type());
    }

}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface studentAnotation{
    String value() default "guan";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface filedAnotation{
    String column_Name();
    String column_type();
    int column_length();
}

@studentAnotation
class Student{
    @filedAnotation(column_Name="cname01",column_type="student",column_length=3)
    private String name;
    @filedAnotation(column_Name="cname02",column_type="student",column_length=4)
    private int age;
    @filedAnotation(column_Name="cname03",column_type="student",column_length=5)
    private String sex;

    public Student() {
    }

    public Student(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}


