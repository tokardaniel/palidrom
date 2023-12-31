package palidrom;

public class Palidrom {

	public static void main(String[] args) {
		CalculatePalidrom calculatePalidrom = new CalculatePalidrom();

		long startTime = System.nanoTime();
		calculatePalidrom.calc();
		long endTime = System.nanoTime();

		long totalTime = endTime - startTime;
		double totalTimeInSeconds = totalTime / 1_000_000_000;

		System.out.println(String.format("A keresés %s ideig tartott", totalTimeInSeconds));
	}

}
