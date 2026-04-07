import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    TrainConsistManagementApp app = new TrainConsistManagementApp();

    @Test
    void testCargo_SafeAssignment() {
        String result = app.assignCargo("Cylindrical", "Petroleum");
        assertEquals("SUCCESS", result);
    }

    @Test
    void testCargo_UnsafeAssignment() {
        String result = app.assignCargo("Rectangular", "Petroleum");
        assertTrue(result.contains("FAILED"));
    }
}