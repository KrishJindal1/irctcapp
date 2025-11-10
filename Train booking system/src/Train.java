public class Train {

    private int trainId;

    private String name;

    private String source;

    private String destination;

    private int totalSeat;

    private int availableSeat;



    public Train(int trainId, String name, String source, String destination, int totalSeat) {
        this.trainId = trainId;
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.totalSeat = totalSeat;
        this.availableSeat = totalSeat;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public int getAvailableSeat() {
        return availableSeat;
    }

    public void setAvailableSeat(int availableSeat) {
        this.availableSeat = availableSeat;
    }

    public boolean bookSeat (int count){
        if(count<=availableSeat){
            availableSeat-=count;
            return true;
        }
        return false;
    }

    public void cancelSeat(int count){
        availableSeat+=count;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return trainId + "|" + name + "|" + source + " --> " + destination + " AvailableSeats: " + availableSeat;
    }
}