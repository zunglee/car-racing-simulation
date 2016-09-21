package race.main;
import java.util.Scanner;
import race.challenge.RaceCalculaor;

public class F1_Race {

	public static void main(String[] args) {
		
		int noOfCar;
		float trackLength ;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no of Car : ");
		noOfCar = sc.nextInt();
		System.out.print("Enter trackLength in meters : ");
        trackLength = sc.nextFloat();
          
        RaceCalculaor rc = new RaceCalculaor();
        rc.startRace(noOfCar, trackLength);
       
	
	}

}
