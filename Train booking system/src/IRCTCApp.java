import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class IRCTCApp {

    private final Scanner scanner = new Scanner(System.in);
    private final UserServices userServices = new UserServices();
    private final BookingServices bookingServices = new BookingServices();


    static void main(String[] args) {
        new IRCTCApp().start();
    }

    public void start() {
        while (true) {
            System.out.println("/n-----Welcome to IRCTCApp-----");
            if (!userServices.isloggedIn()) {
                System.out.println("1. Register:");
                System.out.println("2. Login:");
                System.out.println("3. Exit:");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> resister();
                    case 2 -> Login();
                    case 3 -> ExitApp();
                    default -> System.out.println("Invalid Choice.");
                }
            }else{
                showUserMenu();
            }
        }

    }

    public void resister(){
        System.out.print("Enter Username:");
        String username = scanner.next();
        System.out.print("Enter Password:");
        String password = scanner.next();
        System.out.print("Enter FullName:");
        scanner.nextLine();
        String FullName = scanner.nextLine();
        System.out.print("Enter Contact:");
        String contact = scanner.next();

        userServices.registerUser(username,password,FullName,contact);


    }


    public void Login(){
        System.out.print("Enter Username:");
        String username = scanner.next();
        System.out.print("Enter Password:");
        String password = scanner.next();

        userServices.LoginUser(username,password);
    }


    private void ExitApp(){
        System.out.println("Thanks for Using IRCTCApp");
        System.exit(0);
    }

    private void showUserMenu(){
        while(userServices.isloggedIn() || userServices.registeredUser()){
            System.out.println("----User Menu----");
            System.out.println("1. Search Train:");
            System.out.println("2. Book Ticket:");
            System.out.println("3. View Ticket:");
            System.out.println("4. Cancel Ticket:");
            System.out.println("5. View all Trains:");
            System.out.println("6. Logout:");
            System.out.println("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1->SearchTrain();
                case 2->BookTicket();
                case 3->ViewTicket();
                case 4->CancelTicket();
                case 5->bookingServices.listAllTrains();
                case 6->userServices.Logout();
                default -> System.out.println("Invalid Choice.");
            }
        }
    }


    private void SearchTrain(){
        System.out.print("Enter Source Station:");
        String source = scanner.next();
        System.out.print("Enter Destination Station:");
        String destination = scanner.next();

        List<Train> trains = bookingServices.searchTrain(source,destination);
        if(trains.isEmpty()){
            System.out.println("No Train found from"+source+"to"+destination);
            return;
        }
        System.out.println("Trains Found:");
        for(Train train:trains){
            System.out.println(train);
        }

        System.out.print("Do you want to book ticket? (Yes/No):");
        String choice = scanner.next();
        if(choice.equalsIgnoreCase("Yes")){
            System.out.println("Enter TrainId to Book:");
            int TrainId = scanner.nextInt();
            System.out.println("Enter Number of Seats to book:");
            int seats= scanner.nextInt();

            Ticket ticket = bookingServices.bookTicket(userServices.getCurrentUser(),TrainId,seats);
            if(ticket!=null){
                System.out.println("Booking Successfully!");
                System.out.println(ticket);
            }
        }
        else {
                System.out.println("-----Returning to user menu----");
        }

    }

    private void BookTicket(){
        System.out.print("Enter Source Station:");
        String source = scanner.next();
        System.out.print("Enter Destination Station:");
        String destination = scanner.next();

        List<Train> trains = bookingServices.searchTrain(source,destination);
        if(trains.isEmpty()){
            System.out.println("No Train Available for Bookings.");
            return;
        }
        System.out.println("Available Trains:");
        for(Train train:trains){
            System.out.println(train);
        }
        System.out.print("Enter TrainId to Book:");
        int TrainId = scanner.nextInt();
        System.out.print("Enter Number of Seats to book:");
        int seats= scanner.nextInt();

        Ticket ticket = bookingServices.bookTicket(userServices.getCurrentUser(),TrainId,seats);
        if(ticket!=null){
            System.out.println("Booking Successfully!");
            System.out.println(ticket);
        }
    }

    private void ViewTicket(){
        List<Ticket> ticketByUser = bookingServices.getTicketByUser(userServices.getCurrentUser());
        if(ticketByUser.isEmpty()){
            System.out.println("No Tickets Booked yet.");
        }
        else{
            System.out.println("Your Tickets: ");
            for(Ticket ticket:ticketByUser){
                System.out.println(ticket);
            }
        }
    }

    private void CancelTicket(){
        System.out.print("Enter the Ticket Id to Cancel:");
        int TicketId = scanner.nextInt();
        bookingServices.cancelTicket(TicketId,userServices.getCurrentUser());
    }
}
