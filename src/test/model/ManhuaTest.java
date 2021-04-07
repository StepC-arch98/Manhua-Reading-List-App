package model;

import exceptions.EmptyTitleException;
import exceptions.EmptyWebsiteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for Manhua Class
class ManhuaTest {
    private Manhua testManhua;

//    @BeforeEach
//    void runBefore() throws EmptyTitleException, EmptyWebsiteException {
//        testManhua = new Manhua("The Fatal Kiss", "Manga Sy");
//    }

    @Test
    void testConstructorWithoutExceptions() {
        try {
            testManhua = new Manhua("The Fatal Kiss", "Manga Sy");
            assertEquals("The Fatal Kiss", testManhua.getTitle());
            assertEquals("Manga Sy", testManhua.getWebsite());
        } catch (EmptyTitleException emptyTitleException){
            fail("EmptyTitleException should not have been caught");
        } catch (EmptyWebsiteException emptyWebsiteException){
        fail("EmptyWebsiteException should not have been caught");
    }
    }

    @Test
    void testConstructorWithTitleExceptionOfEmptyString() {
        try {
            testManhua = new Manhua("", "Manga Sy");
            fail("EmptyTitleException should have been caught");
        } catch (EmptyTitleException emptyTitleException){
            System.out.println("EmptyTitleException has been caught");
        } catch (EmptyWebsiteException emptyWebsiteException){
            fail("EmptyWebsiteException should not have been caught");
        }
    }

//    @Test
//    void testConstructorWithTitleExceptionOfNullValue() {
//        try {
//            testManhua = new Manhua(null, "Manga Sy");
//            fail("EmptyTitleException should have been caught");
//        } catch (EmptyTitleException emptyTitleException){
//            System.out.println("EmptyTitleException has been caught");
//        } catch (EmptyWebsiteException emptyWebsiteException){
//            fail("EmptyWebsiteException should not have been caught");
//        }
//        assertEquals("Manga Sy", testManhua.getWebsite());
//    }

    @Test
    void testConstructorWithWebsiteExceptionOfEmptyString() {
        try {
            testManhua = new Manhua("The Fatal Kiss", "");
            fail("EmptyWebsiteException should have been caught");
        } catch (EmptyTitleException emptyTitleException){
            fail("EmptyTitleException should not have been caught");
        } catch (EmptyWebsiteException emptyWebsiteException){
            System.out.println("EmptyWebsiteException has been caught");
        }
    }

//    @Test
//    void testConstructorWithWebsiteExceptionOfNull() {
//        try {
//            testManhua = new Manhua("The Fatal Kiss", null);
//            fail("EmptyWebsiteException should have been caught");
//        } catch (EmptyTitleException emptyTitleException){
//            fail("EmptyTitleException should not have been caught");
//        } catch (EmptyWebsiteException emptyWebsiteException){
//            System.out.println("EmptyWebsiteException has been caught");
//        }
//        assertEquals("The Fatal Kiss", testManhua.getTitle());
//    }

    @Test
    void testConstructorWithBothExceptionsOfEmptyString() {
        try {
            testManhua = new Manhua("", "");
            fail("Exception should have been caught");
        } catch (EmptyTitleException emptyTitleException){
            System.out.println("EmptyTitleException has been caught");
        } catch (EmptyWebsiteException emptyWebsiteException){
            fail("EmptyWebsiteException should not have been caught");
        }
    }

//    @Test
//    void testConstructorWithBothExceptionsOfNull() {
//        try {
//            testManhua = new Manhua(null, null);
//            fail("Exception should have been caught");
//        } catch (EmptyTitleException emptyTitleException){
//            System.out.println("EmptyTitleException has been caught");
//        } catch (EmptyWebsiteException emptyWebsiteException){
//            fail("EmptyWebsiteException should not have been caught");
//        }
//    }

    @Test
    void testToFormat() throws EmptyTitleException, EmptyWebsiteException {
        testManhua = new Manhua("The Fatal Kiss", "Manga Sy");
        assertEquals("Title = The Fatal Kiss, Website = Manga Sy", testManhua.toFormat());
        assertTrue( testManhua.toFormat().contains("Title = The Fatal Kiss, Website = Manga Sy"));
    }
}


