package Week1_assignments;

public class Mobile {
	
	String carColur = "Red";
	int numWheels=4;
	long mobileNum = 9840764557L;
	float carPrize = 5.5F;
	double fuelCap = 24.5D;
	char fuelType= 'D';
	boolean isAutomatic = false;
	
	
	public void makeCall() {
		System.out.println("make call");

	}
	public void sendMessage() {
		System.out.println("send messages");

	}
	public void takePhoto() {
		System.out.println("Take Photoes");
		System.out.println(numWheels);	
	}
	
	public static void main(String[] args) {
		Mobile samsung = new Mobile();
		samsung.makeCall();
		samsung.sendMessage();
		samsung.takePhoto();
		System.out.println( samsung.carPrize);
		double capacity = samsung.fuelCap;
		System.out.println(capacity);
		
	}

}
