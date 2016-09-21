package race.challenge;

import race.model.RacingCar; 


public class RaceCalculaor {

	private int noOfCar ;
	private float trackLength ;
	public float dist;
	private int time=0 ;

	
	
	
	public void startRace(int noOfCar , float trackLength){
        this.noOfCar = noOfCar;
        this.trackLength = trackLength ;
        
        System.out.println("here in function");
		this.raceCalculate();
	}
	
	private void raceCalculate(){
		RacingCar[] car = new RacingCar[noOfCar];
		for(int i=0 ; i<noOfCar ; i++){
			car[i] =new RacingCar();
		}
		
        //Initialize the values;
		Init(car);
        
		while(!raceComplete(car)){
		
			
			 System.out.println("-------------------------");
	            System.out.println("status at t=" + time);
			
			
			//update distance covered
			for(int i=0 ; i<noOfCar ; i++){
				dist = 2*car[i].getCurrentSpeed();
				car[i].setDistanceCovered(dist + car[i].getDistanceCovered());
				 System.out.println("Distance covered by " + (i+1) + " th car is " + car[i].getDistanceCovered());
			}
			
			//update speed
			float speed ;
			
			for(int i=0 ; i<noOfCar ; i++){
				speed = car[i].getCurrentSpeed() + 2*car[i].getAccl();
				
				if(speed < car[i].getTopSpeed()){
					car[i].setCurrentSpeed(speed);
				}
				System.out.println("New speed of " + (i+1) + " th car is " + car[i].getCurrentSpeed());
			}
			
			//10 meter range check
			for(int i=0 ; i<noOfCar ; i++){
				System.out.println("Looking up for " + (i+1) + " th car.");
			     if(checkForRange(car , i)){
		                  car[i].setCurrentSpeed(car[i].getCurrentSpeed() * 0.8f);	    	 
			     }
			}
			
			// nitro check
			System.out.println("-------------------------");
            System.out.println("Checking to see nitro is required for any car? ");
            
			for(int i=0 ; i<noOfCar ; i++){
				if(isCarLast(car ,i) && !car[i].isNitroUsed()){
					
					float nitroSpeed = car[i].getCurrentSpeed() *2.0f;
					
					if(nitroSpeed > car[i].getTopSpeed()){
						car[i].setCurrentSpeed(car[i].getTopSpeed());
					}else{
						car[i].setCurrentSpeed(nitroSpeed);
					}
					car[i].setNitroUsed(true);
				}
			}			
			CarStatus(car ,time);
			time = time +2 ;
		}
		
		   
        System.out.println("---------------------");
        System.out.println("---------------------");
        
        System.out.println("Race complete in "+ time + " seconds.");
        System.out.println("---------------------");
        System.out.println("Final Speeds of various cars: ");
        
        for(int i=0 ; i<noOfCar ; i++)
        System.out.println("Speed of " + (i+1) + " th car is " + car[i].getCurrentSpeed());
        
        System.out.println("---------------------");
        System.out.println("Race completion times of various cars: ");
        for(int i=0 ; i<noOfCar ; i++)
        System.out.println("Race completion of " + (i+1) + " th car is " + car[i].getFinishingTime());
		
	}
	
	private void CarStatus(RacingCar[] car , int time){
		for(int i=0 ; i<noOfCar ; i++){
			if(!car[i].isReached()){
				if(car[i].getDistanceCovered() > trackLength){
					car[i].setReached(true);
					car[i].setFinishingTime(time);
				}
			}
		}
	}
	
	private boolean isCarLast(RacingCar[] car ,int currentCar){
		for(int i=0 ; i<noOfCar ; i++){
			
			if(i !=currentCar && car[i].getDistanceCovered() < car[currentCar].getDistanceCovered()){
				return false;
			}
		}
		
		return true;
	}
	
	private boolean checkForRange(RacingCar[] car , int currentCar){
		for(int i=0 ; i<noOfCar ; i++){
			
			if(i != currentCar){
				
				float distDiff = car[currentCar].getDistanceCovered() - car[i].getDistanceCovered();
				
				if(distDiff < 10 && distDiff > -10){
					return true;
				}
			}
		}
		return false ;
	}
	
	
	private boolean raceComplete(RacingCar[] car){
	     for(int i=0 ; i < noOfCar ; i++){
	    	 if (car[i].getDistanceCovered() < trackLength )
	    		 return false;
	     }
	     return true;
	}
	
	private void Init(RacingCar[] car){
		
		for(int i=1 ; i<=noOfCar ; i++ ){
			//current position
			car[i-1].setCurrentPosition(i);
			//current speed zero;
			car[i-1].setCurrentSpeed(0);
            //accelaration
			car[i-1].setAccl(2*i);
			//top speed
			car[i-1].setTopSpeed((150 + 10 * i)*5/18.0f);
			//nitro
			car[i-1].setNitroUsed(false);
			//distance covered
			if(i!=1){
			car[i-1].setDistanceCovered(car[i-2].getDistanceCovered()-1*(200 * (i-1)));
			}else{
				car[i-1].setDistanceCovered(0);
			}
			// recached is false;
			car[i-1].setReached(false);
			//finishing time
			car[i-1].setFinishingTime(0);
			//start position
			car[i-1].setStartPosition(-1*(200 * (i-1)));
			
		}
		
		for(int i=0 ; i<noOfCar ; i++ ){
			System.out.println("start position " + car[i].getDistanceCovered());
		}
		

		for(int i=0 ; i<noOfCar ; i++ ){
			System.out.println("acclaration " + car[i].getAccl());
		}
		
		for(int i=0 ; i<noOfCar ; i++ ){
			System.out.println("top speed  " + car[i].getTopSpeed());
		}
	}
		
}
