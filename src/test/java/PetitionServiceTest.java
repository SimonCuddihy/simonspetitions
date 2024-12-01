
import org.example.model.Petition;
import org.example.service.PetitionService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    /*
    ************************** TESTING STRATEGY *******************************
    (SOURCE: https://learn.microsoft.com/en-us/dotnet/core/testing/unit-testing-best-practices)

    Arrange, Act, Assert is a common pattern when unit testing.
    As the name implies, it consists of three main actions:

    Arrange: Set up the test conditions
    Act: Perform the action being tested
    Assert: Verify the results

    Why?
    Clearly separates what is being tested from the arrange and assert steps.
    Less chance to intermix assertions with "Act" code.
    ************************************************************************** */

public class PetitionServiceTest {

    /*
    ************************** TESTING STRATEGY *******************************
    First Test (testCreatePetition):
    - Tests that creating a petition works correctly
    - Checks that all fields (title, description, creator) are set correctly
    - Uses assertNotNull and assertEquals to verify results
    ************************************************************************** */

    @Test
    public void testCreatePetition() {
        // Arrange
        PetitionService service = new PetitionService();
        String title = "Test Petition";
        String description = "Test Description";
        String creator = "Test Creator";

        // Act
        Petition petition = service.createPetition(title, description, creator);

        // Assert
        assertNotNull(petition);
        assertEquals(title, petition.getTitle());
        assertEquals(description, petition.getDescription());
        assertEquals(creator, petition.getCreator());
    }

    /*
    ************************** TESTING STRATEGY *******************************
    Second Test (testGetAllPetitions):
    - Tests that the list of petitions grows when adding a new petition
    - Checks the size before and after adding a petition
    - Verifies that the size increased by exactly one
    ************************************************************************** */

    @Test
    public void testGetAllPetitions() {
        // Arrange
        PetitionService service = new PetitionService();

        // Act
        int initialSize = service.getAllPetitions().size();
        service.createPetition("Test Petition", "Description", "Creator");

        // Assert
        assertEquals(initialSize + 1, service.getAllPetitions().size());
    }
}