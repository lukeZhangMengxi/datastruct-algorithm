package tools.jackson_json.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

class Student {
    private String name;
    private int age;
    public Student(){}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String toString(){
       return "Student [ name: "+name+", age: "+ age+ " ]";
    }
 }

public class MyTest {
    @Test
    public void simple() {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Mahesh\",\"age\":21}";

        try{
            Student student = mapper.readValue(jsonString, Student.class);
            
            System.out.println(student);
            System.out.println(mapper.writeValueAsString(student));

            assertEquals(jsonString, mapper.writeValueAsString(student));
         }
         catch (JsonParseException e) { e.printStackTrace();}
         catch (JsonMappingException e) { e.printStackTrace(); }
         catch (IOException e) { e.printStackTrace(); }
    }
}
