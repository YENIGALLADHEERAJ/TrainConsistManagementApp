import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    TrainConsistManagementApp app = new TrainConsistManagementApp();

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] emptyIds = {};
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            app.searchWithValidation(emptyIds, "BG101");
        });
        assertEquals("No bogies available in train. Cannot perform search.", exception.getMessage());
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] ids = {"BG101", "BG205"};
        assertDoesNotThrow(() -> {
            app.searchWithValidation(ids, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] ids = {"BG101", "BG205", "BG309"};
        assertTrue(app.searchWithValidation(ids, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] ids = {"BG101", "BG205", "BG309"};
        assertFalse(app.searchWithValidation(ids, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] ids = {"BG101"};
        assertTrue(app.searchWithValidation(ids, "BG101"));
    }
}
