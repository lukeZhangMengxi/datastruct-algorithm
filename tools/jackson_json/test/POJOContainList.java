package tools.jackson_json.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

class Zoo {
	public String name;
    public String city;
    public List<String> animals;

	@JsonCreator
	public Zoo(@JsonProperty("name") String name, @JsonProperty("city") String city) {
		this.name = name;
        this.city = city;
        this.animals = new ArrayList<>();
	}

}

public class POJOContainList {
    @Test
    public void simple() {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"London Zoo\",\"city\":\"London\",\"animals\":[\"elephant\",\"lion\"]}";

        try{
            Zoo zoo = mapper.readValue(jsonString, Zoo.class);
            System.out.println(zoo.city + ", " + zoo.name);
            System.out.println(mapper.writeValueAsString(zoo));

            assertEquals(jsonString, mapper.writeValueAsString(zoo));
        }
        catch (JsonParseException e) { e.printStackTrace();}
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
    }
}
