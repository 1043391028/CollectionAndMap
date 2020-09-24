package CollectionAndMap.Set;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet books = new LinkedHashSet();
        books.add("Java");
        books.add("LittleHan");
        System.out.println(books);

        //删除 Java
//        books.remove("Java");
//        books.remove("LittleHan");
        //重新添加 Java
        books.add("Java");
        System.out.println(books);//元素输出的顺序和添加的一样，而且不能重复添加，重复添加，顺序不变
    }

}
