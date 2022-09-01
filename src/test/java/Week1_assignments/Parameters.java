package Week1_assignments;

public class Parameters {
	
	public static int i=10,j=20,p=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		//int p=method(i,j);
				
		Parameters p1 = new Parameters();
		method(p1);
		System.out.println(p);	

	}

	public static void method(Parameters p1) {
		// TODO Auto-generated method stub
		p = i +j;
		
	}

	public static int method(int x, int y) {
		int n = x+y;		
		return n;
	}

}
