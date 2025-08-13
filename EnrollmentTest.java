import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class EnrollmentTest {

    @Test
    void enrollmentBindsStudentAndCourse() {
        Student1 s = new Student1(1, "Eva", 19, "017", "e@e.com");
        Course c = new Course("OS");
        Enrollment e = new Enrollment(s, c);

        assertSame(s, e.getStudent());
        assertSame(c, e.getCourse());
        assertEquals("Eva enrolled in OS", e.toString());
    }
}

