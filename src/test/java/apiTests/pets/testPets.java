package apiTests.pets;

import apiTests.BasePets;
import core.assertion.ApiAssertions;
import core.configuration.PetsConfig;
import core.dataProvider.DP;
import core.uttility.ApiBodyBuilder;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import petstore.CreatePets;

import java.util.ArrayList;
import java.util.List;

public class testPets extends BasePets {
    private ApiBodyBuilder api;
    private CreatePets createPets;
    private Long petID;
    private String  json = "src/main/java/core/payload/pets.json";

    @BeforeMethod
    public void initializePage() {
        api = new ApiBodyBuilder();
        createPets = new CreatePets();

        createPets.setNameStatus("Buddy", "Available");
        petID = api.returnPetID(PetsConfig.createUpdatePets(), createPets);
    }

    @Test(dataProvider = "petData", dataProviderClass = DP.class)
    public void testAddNewPet(String name, String status, List<String> photoUrls) {
        createPets.setNameStatus(name, status);
        String response = api.post(PetsConfig.createUpdatePets(), createPets);
        ApiAssertions.assertJsonField(response, "name", name);
    }

    @Test
    public void testAddNewPetJson() {
        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("url1");
        String response = api.postJson(PetsConfig.createUpdatePets(), json, "Buddy", "Available", photoUrls);
        ApiAssertions.assertJsonField(response, "name", "Buddy");
    }

    @Test
    public void testUpdateNameStatus() {
        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("url1");
        String response = api.put(PetsConfig.createUpdatePets(), json, petID,"Buddy Updated", "Updated", photoUrls);
        ApiAssertions.assertJsonField(response, "name", "Buddy Updated");
        ApiAssertions.assertJsonField(response, "status", "Updated");
    }

    @Test
    public void testUpdatePhoto() {
        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("urlUpdate");
        String response = api.put(PetsConfig.createUpdatePets(), json,petID,"Buddy Updated", "Updated", photoUrls);
        System.out.println("id: " + petID);
        ApiAssertions.assertJsonField(response, "name", "Buddy Updated");
        ApiAssertions.assertJsonField(response, "status", "Updated");
    }

    @Test
    public void testDeletePet() {
        String url = PetsConfig.deletePets();
        String deleteUrl = url + petID;
        Response response = api.delete(deleteUrl);
        int actualStatusCode = response.getStatusCode();
        ApiAssertions.assertResponseCode(actualStatusCode,200);
    }


}
