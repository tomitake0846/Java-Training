package ch08.ex09;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ScannerUtils {
	public static Stream<String> toLineStream(Scanner s) {
		Iterator<String> iter = new Iterator<String>() {
			String nextLine = null;

			@Override
			public boolean hasNext() {
				if (nextLine != null) {
					return true;
				} else {
					try {
						nextLine = s.nextLine();
					} catch (NoSuchElementException e) {
						nextLine = null;
					}
					return (nextLine != null);
				}
			}

			@Override
			public String next() {
				if (nextLine != null || hasNext()) {
					String line = nextLine;
					nextLine = null;
					return line;
				} else {
					throw new NoSuchElementException();
				}
			}
		};
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
				iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
	}

	public static Stream<String> toWordStream(Scanner s) {
		Iterator<String> iter = new Iterator<String>() {
			String next = null;

			@Override
			public boolean hasNext() {
				if (next != null) {
					return true;
				} else {
					try {
						next = s.next();
					} catch (NoSuchElementException e) {
						next = null;
					}
					return (next != null);
				}
			}

			@Override
			public String next() {
				if (next != null || hasNext()) {
					String line = next;
					next = null;
					return line.replaceAll("\n","").replaceAll("\n\r","").replaceAll("\r","");
				} else {
					throw new NoSuchElementException();
				}
			}
		};
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
				iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
	}
	//String base
	public static Stream<Integer> toIntStream(Scanner s) {
		Iterator<Integer> iter = new Iterator<Integer>() {
			String nextLine = null;
			@Override
			public boolean hasNext() {
				if (nextLine != null) {
					return true;
				} else {
					try {
						nextLine = s.nextLine();
					} catch (NoSuchElementException e) {
						nextLine = null;
					}
					return (nextLine != null);
				}
			}

			@Override
			public Integer next() {
				if (nextLine != null || hasNext()) {
					String line = nextLine;
					nextLine = null;

					return Integer.parseInt(line);
				} else {
					throw new NoSuchElementException();
				}
			}

		};
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
				iter, Spliterator.ORDERED | Spliterator.NONNULL),false);
	}

	//int base
	public static Stream<Integer> toIntStreamAnother(Scanner s) {
		Iterator<Integer> iter = new Iterator<Integer>() {
			int nextInt;
			boolean calledHasNext = false;
			@Override
			public boolean hasNext() {
				try {
					nextInt = s.nextInt();
					calledHasNext = true;
					return true;
				} catch (InputMismatchException e) {
					// it get rid of not number token.
					s.next();
					return hasNext();
				} catch (NoSuchElementException e) {
					return false;
				}
			}

			@Override
			public Integer next() {
				if (calledHasNext || hasNext()) {
					calledHasNext = false;
					return nextInt;
				} else {
					throw new NoSuchElementException();
				}
			}

		};
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
				iter, Spliterator.ORDERED | Spliterator.NONNULL),false);
	}

	//String base
	public static Stream<Double> toDoubleStream(Scanner s) {
		Iterator<Double> iter = new Iterator<Double>() {
			String nextLine = null;
			@Override
			public boolean hasNext() {
				if (nextLine != null) {
					return true;
				} else {
					try {
						nextLine = s.nextLine();
					} catch (NoSuchElementException e) {
						nextLine = null;
					}
					return (nextLine != null);
				}
			}

			@Override
			public Double next() {
				if (nextLine != null || hasNext()) {
					String line = nextLine;
					nextLine = null;

					return Double.parseDouble(line);
				} else {
					throw new NoSuchElementException();
				}
			}

		};
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
				iter, Spliterator.ORDERED | Spliterator.NONNULL),false);
	}

	//double base
	public static Stream<Double> toDoubleStreamAnother(Scanner s) {
		Iterator<Double> iter = new Iterator<Double>() {
			double nextDouble;
			boolean calledHasNext = false;
			@Override
			public boolean hasNext() {
				try {
					nextDouble = s.nextDouble();
					calledHasNext = true;
					return true;
				} catch (InputMismatchException e) {
					// it get rid of not number token.
					s.next();
					return hasNext();
				}  catch (NoSuchElementException e) {
					return false;
				}
			}

			@Override
			public Double next() {
				if (calledHasNext || hasNext()) {
					calledHasNext = false;
					return nextDouble;
				} else {
					throw new NoSuchElementException();
				}
			}

		};
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
				iter, Spliterator.ORDERED | Spliterator.NONNULL),false);
	}
}
