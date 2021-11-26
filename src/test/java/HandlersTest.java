import com.luxoft.oleksandr_shevchenko.web_server.ResourceReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class HandlersTest {

    @Test
    void testResourceReader() throws IOException {
        String path = "src/main/resources/webapp/index.html";
        File file = new File(path);
        ResourceReader resourceReader = new ResourceReader(path);
        assertTrue(resourceReader.response(file).contains("HELLO World!"));
    }
}
