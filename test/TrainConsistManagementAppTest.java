import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    TrainConsistManagementApp app = new TrainConsistManagementApp();

    @Test
    void testBinarySearch_BogieFound() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(app.binarySearch(ids, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(app.binarySearch(ids, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(app.binarySearch(ids, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(app.binarySearch(ids, "BG550"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] ids = {};
        assertFalse(app.binarySearch(ids, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] ids = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        assertTrue(app.binarySearch(ids, "BG205"));
    }
}
