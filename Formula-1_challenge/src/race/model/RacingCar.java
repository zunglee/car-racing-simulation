package race.model;

public class RacingCar {
    
	private  int carNumber ;
	private int currentPosition ;
	private float topSpeed;
	private float currentSpeed;
	private float distanceCovered;
	private float accl ;
	private float finishingTime ;
	private boolean nitroUsed;
	private float startPosition;
	private boolean reached ;
	
	
	
	public int getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}
	public float getTopSpeed() {
		return topSpeed;
	}
	public void setTopSpeed(float topSpeed) {
		this.topSpeed = topSpeed;
	}
	public float getCurrentSpeed() {
		return currentSpeed;
	}
	public void setCurrentSpeed(float currentSpeed) {
		this.currentSpeed = currentSpeed;
	}
	public float getDistanceCovered() {
		return distanceCovered;
	}
	public void setDistanceCovered(float distanceCovered) {
		this.distanceCovered = distanceCovered;
	}
	public float getAccl() {
		return accl;
	}
	public void setAccl(float accl) {
		this.accl = accl;
	}
	public float getFinishingTime() {
		return finishingTime;
	}
	public void setFinishingTime(float finishingTime) {
		this.finishingTime = finishingTime;
	}
	public boolean isNitroUsed() {
		return nitroUsed;
	}
	public void setNitroUsed(boolean nitroUsed) {
		this.nitroUsed = nitroUsed;
	}
	
	public boolean isReached() {
		return reached;
	}
	public void setReached(boolean reached) {
		this.reached = reached;
	}
	public int getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}
	public float getStartPosition() {
		return startPosition;
	}
	public void setStartPosition(float startPosition) {
		this.startPosition = startPosition;
	}
	
	
	
}
