
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
		int answer = 0;
		try {
			answer = a/b;
		} catch(Exception e) {
			System.out.println("Error : " + e.getClass());
		}
		return answer;
//		return a/b;
	}
	// https://github.com/Dinesh0727/OOP-Testing
	public int divideWithoutArithmeticException(int a, int b) {
		if(b == 0) return -1;
		return a/b;
	}
	
	public double computeCircleArea(double radius) {
		return Math.PI * radius * radius;
	}
	
	public static void main(String[] args) {
		MathUtils mathUtils = new MathUtils();
		System.out.println(mathUtils.add(10, 1));
		System.out.println(mathUtils.divide(10, 0));
	}
}
