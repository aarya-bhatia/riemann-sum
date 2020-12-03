interface Function {
	public float eval(float x);
}

public class RiemannSum {

	private static float sum(Function f, int n, float a, float b, float shift){
		float sum = 0;
		float dx = (b-a)/n;
		for(int i = 0; i < n; i++){
			float x = a + i*dx + shift*dx;
			sum += f.eval(x) * dx;
		}
		return sum;
	}
	
	public static float left(Function f, int n, float a, float b){
		float s = sum(f, n, a, b, 0);
		System.out.println("The left riemann sum for n=" + n + " is " + s);	
		return s;
	}

	public static float right(Function f, int n, float a, float b){
		float s = sum(f, n, a, b, 1);
		System.out.println("The right riemann sum for n=" + n + " is " + s);
		return s;
	}

	public static float middle(Function f, int n, float a, float b){
		float s = sum(f, n, a, b, 0.5f);
		System.out.println("The middle riemann sum for n=" + n + " is " + s);
		return s;
	}

	public static void main(String args[]){
		question4();		
	}

	public static void question2(){

		Function f = new Function() {
			public float eval(float x){
				return x*x*2 + 1;
			}
		};

		int a = -1;
		int b = 2;

		float r3 = right(f,3,a,b);
		float r6 = right(f,6,a,b);
		float l3 = left(f,3,a,b);
		float l6 = left(f,6,a,b);
		float m3 = middle(f,3,a,b);
		float m6 = middle(f,6,a,b);
	}

	public static void question3() {
		Function f = new Function(){
			public float eval(float x){
				return (float)(Math.sqrt(x) * 2);
			}
		};

		int a = 0, b = 4;
		right(f, 4, a, b);
		left(f, 4, a, b);
		middle(f, 4, a, b);
	}

	public static void question4() {
		right(new Function(){public float eval(float x){return x*x - 5*x;}},8,0,2);
	}
}

