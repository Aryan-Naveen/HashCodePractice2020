import java.util.ArrayList;
import java.util.Arrays;


public class Vehicle {
    
    public int currentTime;
    public int[] currentPos;
    public ArrayList<Ride> rides = new ArrayList<Ride>();
    public int id;
    public int score;

    
    

    public Vehicle(int id) {
        this.currentTime = 0;
        int[] cp = {0, 0};
        this.currentPos = cp;
        this.id = id;
    }

    //Check if possible to get bonus
    public boolean checkForBonus(Ride rider) {
        int distanceTo = Math.abs(rider.start[0] - currentPos[0]) + Math.abs(rider.start[1] - currentPos[1]);
        if(distanceTo <= rider.startT) {
            return true;
        }  
        return false;
    }

    //Add a path to self
    public void addRide(Ride rider, int bonus, boolean bonusA) {
        int distanceTo = Math.abs(rider.start[0] - currentPos[0]) + Math.abs(rider.start[1] - currentPos[1]);
        currentTime += distanceTo;
        currentTime = Math.max(currentTime, rider.startT);
        currentTime += rider.rideDistance;
        currentPos = rider.finish;
        score += rider.rideDistance;
        if(bonusA){
            score += bonus;
        }
        rides.add(rider);
    }
    
    public boolean checkPossible(Ride rider) {
        int distanceTo = Math.abs(rider.start[0] - currentPos[0]) + Math.abs(rider.start[1] - currentPos[1]) + rider.rideDistance;
        return (currentTime + distanceTo) < rider.finishT;
    }

    public void output() {
        String output = id + " ";
        for(Ride r: rides){
            output += r.id + " ";
        }

        System.out.println(output);
    }

}