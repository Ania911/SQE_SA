package core.uttility;

import com.fasterxml.jackson.databind.ObjectMapper;
import petstore.CreatePets;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PetJsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String readAndUpdateToJson(String filePath, Long petId, String newName, String status, List<String> photoUrls) {
        try {
            // Read data from the JSON file
            CreatePets petData = objectMapper.readValue(new File(filePath), CreatePets.class);

            // Update properties using the setAllProperties method
            petData.setNameStatusPhoto(newName, status, photoUrls);

            // Convert the updated object to a JSON string
            return objectMapper.writeValueAsString(petData);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
