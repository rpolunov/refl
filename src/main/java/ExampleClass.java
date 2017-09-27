import java.util.ArrayList;

public class ExampleClass {
    public NewClass newClass;

    public String field1 = "value1";
    public String field2 = "value2";
    public String field3 = "value3";
    public String field4 = "value4";
    public ArrayList<String> stringArrayList;
    public ArrayList<Object> objectArrayList;



    @Override
    public String toString() {
        return "ExampleClass{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                ", stringArrayList=" + stringArrayList +
                ", objectArrayList=" + objectArrayList +
                ", newClass=" + newClass +
                '}';
    }
}
