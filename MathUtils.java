
public class MathUtils {
	
	public int add(int a, int b) {
		return a + b;
	}
	
	public int subtract(int a, int b) {
		return a- b;
	}
	
	public int multiply(int a, int b) {
		return a * b;
	}
	
	public int divide(int a, int b) {
		return a/b;
	}
	
	public int divideWithoutArithmeticException(int a, int b) {
		if(b == 0) return -1;
		return a/b;
	}
	
	public double computeCircleArea(double radius) {
		return Math.PI * radius * radius;
	}
}
