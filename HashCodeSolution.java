import java.util.*;

public class HashCodeSolution {

    public static void main(String[] args){
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        ArrayList<Ride> rides = new ArrayList<Ride>();

        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt(); int coloumns = sc.nextInt();
        int vNum = sc.nextInt(); int rideNum = sc.nextInt();
        int bonus = sc.nextInt(); int maxSteps = sc.nextInt();
        
        for(int i = 0; i < vNum; i++) {
            vehicles.add(new Vehicle(i + 1));
        }
        for(int i = 0; i < rideNum; i++) {
            int startX = sc.nextInt(); int startY = sc.nextInt();
            int finishX = sc.nextInt(); int finishY = sc.nextInt();
            int startT = sc.nextInt(); int finishT = sc.nextInt();
            int[] start = {startX, startY};
            int[] finish = {finishX, finishY};
            rides.add(new Ride(start, finish, startT, finishT, i));
        }


        Collections.sort(rides);
        for(Vehicle v: vehicles){
            for(int i = 0; i < rides.size(); i++) {
                Ride ride = rides.get(i);
                if(v.checkForBonus(ride)){
                    v.addRide(ride, bonus, true);
                    rides.remove(ride);
                    i --;
                } else if(v.currentTime > ride.startT){
                    break;
                }
            }
        }
        for(Vehicle v: vehicles){
            for(int i = 0; i < rides.size(); i++) {
                Ride r = rides.get(i);
                if(v.checkPossible(r)){
                    v.addRide(r, bonus, false);
                    rides.remove(r);
                    i--;
                } else if(v.currentTime > r.startT){
                    break;
                }
            }
        }

        int totalScore = 0;
        for(Vehicle v: vehicles){
            v.output();
            totalScore += v.score;
        }
        System.out.println(totalScore);
        
    }
}