package io.tripled.adventofcode.daythree;

import java.io.IOException;

public interface InputReader {

  CandidateTriangle read() throws IOException;

  void close() throws IOException;
}
