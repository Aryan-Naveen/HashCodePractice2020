public class Ride implements Comparable<Ride>{

    public int[] start = new int[2];
    public int[] finish = new int[2];
    public int startT;
    public int finishT;
    public int rideDistance;
    public int id;
    
    public Ride(int[] start, int[] finish, int startTime, int finishTime, int id){
        this.start = start;
        this.finish = finish;
        this.startT = startTime;
        this.finishT = finishTime;
        this.rideDistance = Math.abs(finish[0] - start[0]) + Math.abs(finish[1]-start[1]);
        this.id = id;
    }

    @Override
    public int compareTo(Ride r){
        return r.startT - this.startT;
    }
}