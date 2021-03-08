package persistence;

import model.Manhua;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Citation: Code sourced and modified from JsonSerializationDemo - JsonTest Class
public class JsonTest {
    protected void checkManhua(String title, String website, Manhua manhua) {
        assertEquals(title, manhua.getTitle());
        assertEquals(website, manhua.getWebsite());
    }
}

