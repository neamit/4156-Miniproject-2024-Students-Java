package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * Class is a unit test class designed to test the behavior of the Course class.
 */
@SpringBootTest
@ContextConfiguration
public class CourseUnitTests {

  @BeforeAll
  public static void setupCourseForTesting() {
    testCourse = new Course("Griffin Newbold", "417 IAB", "11:40-12:55", 250);
  }

  /** The test course instance used for testing. */
  public static Course testCourse;

  @Test
  public void toStringTest() {
    String expectedResult = "\nInstructor: Griffin Newbold; Location: 417 IAB; Time: 11:40-12:55";
    assertEquals(expectedResult, testCourse.toString());
  }

  @Test
  public void enrollStudent() {
    assertTrue(testCourse.enrollStudent());
  }

  @Test
  public void dropStudent() {
    testCourse.enrollStudent();
    assertTrue(testCourse.dropStudent());
  }

  @Test
  public void getCourseLocation() {
    assertEquals("417 IAB", testCourse.getCourseLocation());
  }

  @Test
  public void getInstructorNameTest() {
    assertEquals("Griffin Newbold", testCourse.getInstructorName());
  }

  @Test
  public void getCourseTimeSlotTest() {
    assertEquals("11:40-12:55", testCourse.getCourseTimeSlot());
  }

  @Test
  public void isCourseFull() {
    if (testCourse.getEnrollmentCapacity() > testCourse.getEnrolledStudentCount()) {
      assertTrue(testCourse.isCourseFull());
    }
  }

}

