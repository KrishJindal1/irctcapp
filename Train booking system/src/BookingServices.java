import javax.print.attribute.standard.Destination;
import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookingServices {
    private List<Train> trainList = new ArrayList<>();
    private List<Ticket> ticketList = new ArrayList<>();

    public BookingServices(){
        trainList.add(new Train(101,"Rajdhani Express","Delhi","Nagpur",100));
        trainList.add(new Train(102,"Nagpur Express","Nagpur","Delhi",80));
        trainList.add(new Train(103,"Shatabdi Express","Delhi","goa",70));
        trainList.add(new Train(104,"local Express","Delhi","Mumbai",110));
        trainList.add(new Train(105,"NewDelhi Express","Kolkata","Delhi",50));
        trainList.add(new Train(106,"Vande Bharat Express","Delhi","Bihar",40));

    }
// to add here date for search thing(Extra work)
    public List<Train> searchTrain(String Source, String Destination){
       List<Train> res = new ArrayList<>();
       for(Train train:trainList){
           if (train.getSource().equalsIgnoreCase(Source) && train.getDestination().equalsIgnoreCase(Destination)){
               res.add(train);
           }
       }
        return res;
    }

    public Ticket bookTicket(User user ,int trainId,int seatCount){
        for(Train train:trainList){
            if ( train.getTrainId()==trainId){
                if(train.bookSeat(seatCount)){
                    Ticket ticket = new Ticket(user,train,seatCount);
                    ticketList.add((ticket));
                    return ticket;
                }
                else {
                    System.out.println("Not enough seats available");
                    return null;
                }
            }
        }
        System.out.println("Train Id not found");
        return null;
    }

    public List<Ticket> getTicketByUser(User user){
        List<Ticket> res = new ArrayList<>();
        for(Ticket ticket:ticketList){
            if(ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername())){
                res.add(ticket);
            }
        }
        return res;
    }

    public  boolean cancelTicket(int ticketId , User user){
        Iterator<Ticket> iterator = ticketList.listIterator();
        while(iterator.hasNext()){
            Ticket ticket = iterator.next();
            if(ticket.getTicketId()==ticketId &&
                    ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername())){
                Train train = ticket.getTrain();
                train.cancelSeat(ticket.getSeatBooked());
                iterator.remove();
                System.out.println("Ticket"+ticketId+"Cancelled Successfully");
                return true;
            }
        }
        System.out.println("Ticket not found or belong to the current user");
        return false;
    }

    public void listAllTrains(){
        System.out.println("List of the all trains:");
        for(Train train:trainList){
            System.out.println(train);
        }
    }

}
