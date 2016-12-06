package io.tripled.adventofcode.daythree;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Triangle Inequality Theorem
 * <p>
 * http://www.mathwarehouse.com/geometry/triangles/triangle-inequality-theorem-rule-explained.php
 */
public class TriangleVerificatorTest {

  @Test
  public void aTriagleWithEqualSizesIsValid() {
    CandidateTriangle triangle = new CandidateTriangle(10, 10, 10);

    boolean isValid = triangle.isValid();

    assertThat(isValid, is(true));
  }

  @Test
  public void aTriagleWith482IsInValid() {
    CandidateTriangle triangle = new CandidateTriangle(4, 8, 2);

    boolean isValid = triangle.isValid();

    assertThat(isValid, is(false));
  }

  @Test
  public void aTriagleWith567IsValid() {
    CandidateTriangle triangle = new CandidateTriangle(5, 6, 7);

    boolean isValid = triangle.isValid();

    assertThat(isValid, is(true));
  }

  @Test
  public void aTriagleWith6815IsValid() {
    CandidateTriangle triangle = new CandidateTriangle(6, 8, 15);

    boolean isValid = triangle.isValid();

    assertThat(isValid, is(false));
  }
}
