import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    void courseNameAndInstructor() {
        Course c = new Course("Java Basics");
        assertEquals("Java Basics", c.getCourseName());
        assertNull(c.getInstructorName());

        c.setInstructorName("Mr. Smith");
        assertEquals("Mr. Smith", c.getInstructorName());

        c.setCourseName("Advanced Java");
        assertEquals("Advanced Java", c.getCourseName());
    }

    @Test
    void toStringIsCourseName() {
        Course c = new Course("DSA");
        assertEquals("DSA", c.toString());
    }

    @Test
    void detailedStringFormatsProperly() {
        Course c = new Course("DBMS");
        String ds = c.detailedString();
        assertTrue(ds.contains("Course: DBMS"));
        assertTrue(ds.contains("No instructor"));

        c.setInstructorName("Dr. Khan");
        ds = c.detailedString();
        assertTrue(ds.contains("Instructor: Dr. Khan"));
    }
}
