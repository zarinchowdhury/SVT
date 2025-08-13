import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;


class Student1Test {

    @Test
    void constructorAndGettersWork() {
        Student1 s = new Student1(7, "Alice", 21, "0123456789", "alice@example.com");
        assertAll(
                () -> assertEquals(7, s.getId()),
                () -> assertEquals("Alice", s.getName()),
                () -> assertEquals(21, s.getAge()),
                () -> assertEquals("0123456789", s.getContactNumber()),
                () -> assertEquals("alice@example.com", s.getEmail())
        );
    }

    @Test
    void settersUpdateState() {
        Student1 s = new Student1(1, "A", 18, "0", "a@x.com");
        s.setName("Bob");
        s.setAge(19);
        s.setContactNumber("999");
        s.setEmail("bob@example.com");

        assertAll(
                () -> assertEquals("Bob", s.getName()),
                () -> assertEquals(19, s.getAge()),
                () -> assertEquals("999", s.getContactNumber()),
                () -> assertEquals("bob@example.com", s.getEmail())
        );
    }

    @Test
    void toStringContainsIdAndName() {
        Student1 s = new Student1(42, "Charlie", 20, "01", "c@e.com");
        String t = s.toString();
        assertTrue(t.contains("42"));
        assertTrue(t.contains("Charlie"));
    }

    @Test
    void detailedStringContainsAllFields() {
        Student1 s = new Student1(5, "Dana", 22, "01711", "d@e.com");
        String d = s.detailedString();
        assertAll(
                () -> assertTrue(d.contains("ID: 5")),
                () -> assertTrue(d.contains("Name: Dana")),
                () -> assertTrue(d.contains("Age: 22")),
                () -> assertTrue(d.contains("Contact: 01711")),
                () -> assertTrue(d.contains("Email: d@e.com"))
        );
    }
}
