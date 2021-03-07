package persistence;

import model.Manhua;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Code sourced from JsonSerializationDemo - JsonTest
public class JsonTest {
    protected void checkManhua(String title, String website, Manhua manhua) {
        assertEquals(title, manhua.getTitle());
        assertEquals(website, manhua.getWebsite());
    }
}

