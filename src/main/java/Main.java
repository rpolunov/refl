import java.lang.reflect.Field;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("start");

        System.out.println(createExampleCalss());

        refl(createExampleCalss());

    }


    public static ExampleClass createExampleCalss() {
        ExampleClass exampleClass = new ExampleClass();

        exampleClass.stringArrayList = new ArrayList<String>();
        exampleClass.stringArrayList.add("Value from StringArrayList1");
        exampleClass.stringArrayList.add("Value from StringArrayList2");
        exampleClass.stringArrayList.add("Value from StringArrayList3");
        exampleClass.stringArrayList.add("Value from StringArrayList4");
        exampleClass.stringArrayList.add("Value from StringArrayList5");


        SomeClass someClass1 = new SomeClass();
        someClass1.name = "name1";
        someClass1.age = "1";
        SomeClass someClass2 = new SomeClass();
        someClass2.name = "name2";
        someClass2.age = "2";
        SomeClass someClass3 = new SomeClass();
        someClass3.name = "name3";
        someClass3.age = "3";

        exampleClass.objectArrayList = new ArrayList<Object>();
        exampleClass.objectArrayList.add(someClass1);
        exampleClass.objectArrayList.add(someClass2);
        exampleClass.objectArrayList.add(someClass3);

//        System.out.println(exampleClass);

        return exampleClass;
    }

    public static void refl(Object o) {
        Field field;
        Object value;

        Class aClass = o.getClass();
        Field[] fieldList = o.getClass().getFields();

        try {
            for (Field s : fieldList) {
                field = aClass.getField(s.getName());
                if (field.getType().getSimpleName().equals("String")) {
                    value = (String) field.get(o);
                    System.out.println(field.getName() + " -> " + value);
                } else if (field.getType().getSimpleName().equals("ArrayList")) {
                    if (field.getGenericType().toString().equals("java.util.ArrayList<java.lang.String>")) {
                        System.out.println("NOPE! it's ArrayList Strings");
                        value = (ArrayList) field.get(o);
                        ArrayList<?> ob = (ArrayList<?>) value;
                        for (Object listItem : ob) {
                            System.out.println(listItem);
                        }
                    } else if (field.getGenericType().toString().equals("java.util.ArrayList<java.lang.Object>")) {
                        System.out.println("NOPE! it's ArrayList Object");
                        value = (ArrayList) field.get(o);
                        ArrayList<?> ob = (ArrayList<?>) value;
                        for (int i = 0; i < ((ArrayList<?>) value).size(); i++) {
                            Object aClass1 = ob.get(i);
                            refl(aClass1);
                        }
                    }
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}


