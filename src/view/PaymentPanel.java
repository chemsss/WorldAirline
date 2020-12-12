package view;

import com.toedter.calendar.JDateChooser;
import controller.BookingController;
import controller.PaymentController;
import controller.TicketController;
import java.awt.Dimension;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Booking;
import model.FlightSeat;
import model.Passenger;
import model.Ticket;

public class PaymentPanel extends javax.swing.JPanel {

    private javax.swing.JTextField cardNumber;
    private javax.swing.JLabel couponCode;
    private javax.swing.JTextField couponCodeField;
    private javax.swing.JLabel creditCards;
    private javax.swing.JTextField dateExp;
    private javax.swing.JLabel amountWithoutDiscount;
    private javax.swing.JLabel lock;
    private javax.swing.JLabel totalPriceLabel;
    private javax.swing.JLabel creditCardsPng;
    private javax.swing.JLabel calendarPng;
    private javax.swing.JTextField securityCode;
    private javax.swing.JButton applicatePromoCode;
    private javax.swing.JButton next;
    private javax.swing.JLabel payUsing1;
    private javax.swing.JLabel payment;
    private javax.swing.JButton previous;
    private javax.swing.JLabel amountWithCoupon;
    private javax.swing.JLabel priceAfterCouponLabel;


    private PassengersInfosFrame frame;

    private ArrayList<Ticket> departTickets;
    private ArrayList<Ticket> returnTickets;
    private ArrayList<Passenger> passengers;
    
    private JLabel[] ticketPriceLabell;
    private ArrayList<JLabel> ticketPriceLabel;
    private ArrayList<JLabel> returnTicketPriceLabel;
    
    private int idCoupon=0;
    private int idAccount;

    public PaymentPanel(PassengersInfosFrame frame) {
        super();
        this.frame = frame;
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        payment = new javax.swing.JLabel();
        amountWithoutDiscount = new javax.swing.JLabel();
        creditCards = new javax.swing.JLabel();
        lock = new javax.swing.JLabel();
        couponCode = new javax.swing.JLabel();
        totalPriceLabel = new javax.swing.JLabel();
        creditCardsPng = new javax.swing.JLabel();
        calendarPng = new javax.swing.JLabel();
        securityCode = new javax.swing.JTextField();
        dateExp = new javax.swing.JTextField();
        couponCodeField = new javax.swing.JTextField();
        previous = new javax.swing.JButton();
        applicatePromoCode = new javax.swing.JButton();
        payUsing1 = new javax.swing.JLabel();
        cardNumber = new javax.swing.JTextField();
        next = new javax.swing.JButton();
        amountWithCoupon = new JLabel();
        priceAfterCouponLabel = new JLabel();

        departTickets = new ArrayList();
        returnTickets = new ArrayList();
        passengers = new ArrayList();

        ticketPriceLabel = new ArrayList();
        returnTicketPriceLabel = new ArrayList();
        
        System.out.println("AAAAAAAAAAAAAAJIOFEJIO3FJIJREJJRJJJIREJIREIJREGJOREIGREIJGREJGRZE\nJIOFEZOIFZEOIFJZEFJOZEOZEJGPREJGZEPOGJREPJGEZRJG\nIREJIOGREJPGERIGJREIOGJERJGOREIG\nFZEOIOFIEROIEZOPGJREIJGREIJGJIRZEG");

        System.out.println(frame.getLoggedInCustomer().toString());
        if (frame.getLoggedInCustomer() == null) {
            idAccount = 0;
            System.out.println("CUSTOMER NUUUUUUUUUUUUULL");
        } else {
            idAccount = frame.getLoggedInCustomer().getIdAccount();
            System.out.println("CUSTOMERRRRRRR " +frame.getLoggedInCustomer().getIdAccount());
        }

        System.out.println("NUMBER OF PASSENGERS : " +frame.getNumberOfPassengers());
        for (int i = 0; i < frame.getNumberOfPassengers(); ++i) {
            departTickets.add(new Ticket(0, (FlightSeat) frame.getDepartAvailableSeatChoice().get(i).getSelectedItem(), frame.getFlights().get(0)));
            System.out.println((new Ticket(0, (FlightSeat) frame.getDepartAvailableSeatChoice().get(i).getSelectedItem(), frame.getFlights().get(0))).toString());
            if (frame.getFlights().size() == 2) {
                returnTickets.add(new Ticket(0, (FlightSeat) frame.getReturnAvailableSeatChoice().get(i).getSelectedItem(), frame.getFlights().get(1)));
            }

            java.util.Date birthDate = ((JDateChooser) frame.getBirthDates().get(i)).getDate();
            java.sql.Date birthDateSql = new java.sql.Date(birthDate.getTime());

            System.out.println(birthDateSql.toString());
            System.out.println();
            passengers.add(new Passenger(((JTextField) frame.getTextFields().get(i)[0]).getText(), ((JTextField) frame.getTextFields().get(i)[1]).getText(),
                    ((JTextField) frame.getTextFields().get(i)[2]).getText(), ((JTextField) frame.getTextFields().get(i)[3]).getText(), birthDateSql,
                    ((JTextField) frame.getTextFields().get(i)[4]).getText(), ((JTextField) frame.getTextFields().get(i)[5]).getText(), ((JTextField) frame.getTextFields().get(i)[6]).getText()));

            System.out.println("Passenger " + (i + 1) + ((JTextField) frame.getTextFields().get(i)[0]).getText());
        }
        
        //ticketPriceLabel = new ArrayList<>(frame.getNumberOfPassengers());
        ticketPriceLabell = new JLabel[frame.getNumberOfPassengers()];
        
       for(int i = 0 ; i < ticketPriceLabell.length ; ++i) {
            ticketPriceLabell[i] = new JLabel();
            ticketPriceLabell[i].setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
            ticketPriceLabell[i].setForeground(new java.awt.Color(255, 255, 255));
            /*ticketPriceLabell[i].setText("Ticket of " +passengers.get(i).getFirstName() +" " +passengers.get(i).getLastName()  
                    +" : " +TicketController.getTicketPriceNotLogged(frame.getFlights().get(0).getIdFlight(), departTickets.get(i).getSeat().getSeatNo()) +"€");*/
            if(i==0 && frame.getLoggedInCustomer()!=null) {
                System.out.println("haaaaaaaajzeijfzef");
                if(frame.getFlights().size()==2) {
                    ticketPriceLabell[i].setText("Depart Ticket of " +passengers.get(i).getFirstName() +" " +passengers.get(i).getLastName()  
                    +" : " +String.format("%.2f", TicketController.getTicketPriceLogged(frame.getFlights().get(0).getIdFlight(), departTickets.get(i).getSeat().getSeatNo(), frame.getLoggedInCustomer())) +"€");
                }
                else
                    ticketPriceLabell[i].setText("Ticket of " +passengers.get(i).getFirstName() +" " +passengers.get(i).getLastName()  
                    +" : " +String.format("%.2f", TicketController.getTicketPriceLogged(frame.getFlights().get(0).getIdFlight(), departTickets.get(i).getSeat().getSeatNo(), frame.getLoggedInCustomer())) +"€");
                
            }
            else {
                if(frame.getFlights().size()==2) {
                    ticketPriceLabell[i].setText("Depart Ticket of " +passengers.get(i).getFirstName() +" " +passengers.get(i).getLastName()  
                    +" : " +String.format("%.2f", TicketController.getTicketPriceLogged(frame.getFlights().get(0).getIdFlight(), departTickets.get(i).getSeat().getSeatNo(), frame.getLoggedInCustomer())) +"€");
                }
                else {
                    ticketPriceLabell[i].setText("Ticket of " +passengers.get(i).getFirstName() +" " +passengers.get(i).getLastName()  
                        +" : " +String.format("%.2f", TicketController.getTicketPriceNotLogged(frame.getFlights().get(0).getIdFlight(), departTickets.get(i).getSeat().getSeatNo())) +"€");
                }
                
                System.out.println("fzefzpejfjpzefjpzefjzefz");
            }
            System.out.println(TicketController.getTicketPriceLogged(frame.getFlights().get(0).getIdFlight(), departTickets.get(i).getSeat().getSeatNo(), frame.getLoggedInCustomer()) +"€");
            System.out.println(TicketController.getTicketPriceNotLogged(frame.getFlights().get(0).getIdFlight(), departTickets.get(i).getSeat().getSeatNo()) +"€");
            
            //ticketPriceLabell[i].setText("Sebastien Pichon's Ticket : 1000.9900€");
            System.out.println(165+((i+1)*15));
            this.add(ticketPriceLabell[i]);
            ticketPriceLabell[i].setBounds(340, 525-((i+1)*15*2), 250, 29);
        }
        if(frame.getFlights().size()==2) {
            for(int i = 0 ; i < ticketPriceLabell.length ; ++i) {
                ticketPriceLabell[i] = new JLabel();
                ticketPriceLabell[i].setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
                ticketPriceLabell[i].setForeground(new java.awt.Color(255, 255, 255));
                /*ticketPriceLabell[i].setText("Ticket of " +passengers.get(i).getFirstName() +" " +passengers.get(i).getLastName()  
                        +" : " +TicketController.getTicketPriceNotLogged(frame.getFlights().get(0).getIdFlight(), departTickets.get(i).getSeat().getSeatNo()) +"€");*/
                if(i==0 && frame.getLoggedInCustomer()!=null) {
                    System.out.println("haaaaaaaajzeijfzef");
                    ticketPriceLabell[i].setText("Return Ticket of " +passengers.get(i).getFirstName() +" " +passengers.get(i).getLastName()  
                        +" : " +String.format("%.2f", TicketController.getTicketPriceLogged(frame.getFlights().get(1).getIdFlight(), departTickets.get(i).getSeat().getSeatNo(), frame.getLoggedInCustomer())) +"€");
                }
                else {
                    ticketPriceLabell[i].setText("Return Ticket of " +passengers.get(i).getFirstName() +" " +passengers.get(i).getLastName()  
                        +" : " +String.format("%.2f", TicketController.getTicketPriceNotLogged(frame.getFlights().get(1).getIdFlight(), departTickets.get(i).getSeat().getSeatNo())) +"€");
                    System.out.println("fzefzpejfjpzefjpzefjzefz");
                }
                System.out.println(TicketController.getTicketPriceLogged(frame.getFlights().get(1).getIdFlight(), departTickets.get(i).getSeat().getSeatNo(), frame.getLoggedInCustomer()) +"€");
                System.out.println(TicketController.getTicketPriceNotLogged(frame.getFlights().get(1).getIdFlight(), departTickets.get(i).getSeat().getSeatNo()) +"€");

                //ticketPriceLabell[i].setText("Sebastien Pichon's Ticket : 1000.9900€");
                System.out.println(165+((i+1)*15));
                this.add(ticketPriceLabell[i]);
                ticketPriceLabell[i].setBounds(340, 525-15-((i+1)*15*2), 250, 29);
            }
        }
        
        
        

        this.setBackground(new java.awt.Color(55, 112, 155));
        this.setLayout(null);

        payment.setFont(new java.awt.Font("Yu Gothic UI", 0, 30)); // NOI18N
        payment.setForeground(new java.awt.Color(255, 255, 255));
        payment.setText("Payment");
        this.add(payment);
        payment.setBounds(260, 20, 160, 40);

        amountWithoutDiscount.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        amountWithoutDiscount.setForeground(new java.awt.Color(255, 255, 255));
        if(frame.getFlights().size()==2) {
            amountWithoutDiscount.setText(String.valueOf(BookingController.getBookingPrice(departTickets, returnTickets, frame.getLoggedInCustomer())) +"€");
        }
        else {
            amountWithoutDiscount.setText(String.valueOf(BookingController.getBookingPrice(departTickets, frame.getLoggedInCustomer())) +"€");
        }
        this.add(amountWithoutDiscount);
        amountWithoutDiscount.setBounds(490, 520, 130, 30);
        
        
        amountWithCoupon.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        amountWithCoupon.setForeground(new java.awt.Color(255, 255, 255));
        
        this.add(amountWithCoupon);
        amountWithCoupon.setBounds(490, 550, 130, 30);

        creditCards.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        creditCards.setIcon(new javax.swing.ImageIcon("img\\paymentMethods.png")); // NOI18N
        this.add(creditCards);
        creditCards.setBounds(170, 150, 420, 40);

        lock.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        lock.setIcon(new javax.swing.ImageIcon("img\\lock_30px.png")); // NOI18N
        this.add(lock);
        lock.setBounds(50, 410, 60, 30);

        couponCode.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        couponCode.setForeground(new java.awt.Color(255, 255, 255));
        couponCode.setText("Coupon code :");
        this.add(couponCode);
        couponCode.setBounds(370, 600, 100, 40);

        totalPriceLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        totalPriceLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalPriceLabel.setText("Total Price :");
        this.add(totalPriceLabel);
        totalPriceLabel.setBounds(340, 520, 130, 30);
        
        priceAfterCouponLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        priceAfterCouponLabel.setForeground(new java.awt.Color(255, 255, 255));
        priceAfterCouponLabel.setText("Total Price after discount :");
        priceAfterCouponLabel.setVisible(false);
        this.add(priceAfterCouponLabel);
        priceAfterCouponLabel.setBounds(196, 550, 304, 30);

        creditCardsPng.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        creditCardsPng.setIcon(new javax.swing.ImageIcon("img\\credit_card_30px.png")); // NOI18N
        this.add(creditCardsPng);
        creditCardsPng.setBounds(50, 310, 40, 30);

        calendarPng.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        calendarPng.setIcon(new javax.swing.ImageIcon("img\\calendar_30px.png")); // NOI18N
        this.add(calendarPng);
        calendarPng.setBounds(50, 350, 30, 50);

        securityCode.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        securityCode.setText("Security Code");
        securityCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        this.add(securityCode);
        securityCode.setBounds(120, 412, 210, 32);

        dateExp.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        dateExp.setText("MM / YY");
        dateExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        this.add(dateExp);
        dateExp.setBounds(120, 362, 210, 32);

        couponCodeField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        couponCodeField.setText("Code");
        couponCodeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        this.add(couponCodeField);
        couponCodeField.setBounds(480, 610, 80, 25);

        previous.setBackground(new java.awt.Color(255, 255, 255));
        previous.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        previous.setText("Previous");
        previous.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        previous.setBorderPainted(false);
        previous.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                frame.getPassengersScrollPane().setVisible(true);
                frame.getFlightDetailsPanel().setVisible(true);
                frame.getPassengersPanel().setVisible(true);
                frame.setSize(643, 815);

                setVisible(false);
            }
        });
        this.add(previous);
        previous.setBounds(30, 670, 90, 30);

        applicatePromoCode.setBackground(new java.awt.Color(255, 255, 255));
        applicatePromoCode.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        applicatePromoCode.setText("OK");
        applicatePromoCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        applicatePromoCode.setBorderPainted(false);
        applicatePromoCode.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(couponCodeField.getText()!=null) {
                    if(BookingController.checkCode(couponCodeField.getText())==true) {
                        System.out.println("CHECK CODE TRUE " +couponCodeField.getText());
                        idCoupon = BookingController.getCouponId( couponCodeField.getText() );
                        if(frame.getFlights().size()==2) {
                            amountWithCoupon.setText(String.valueOf((1-BookingController.getCodeDiscount(couponCodeField.getText())) * BookingController.getBookingPrice(departTickets, returnTickets, frame.getLoggedInCustomer())) +"€");
                        }
                        else {
                            amountWithCoupon.setText(String.valueOf((1-BookingController.getCodeDiscount(couponCodeField.getText())) * BookingController.getBookingPrice(departTickets, frame.getLoggedInCustomer())) +"€");
                        }
                        //amountWithCoupon.setText(String.valueOf(BookingController.getCodeDiscount(couponCodeField.getText())));
                        amountWithCoupon.setVisible(true);
                        priceAfterCouponLabel.setVisible(true);
                    }
                    
                }
                
                
            }
        });
        this.add(applicatePromoCode);
        applicatePromoCode.setBounds(575, 610, 35, 25);

        payUsing1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        payUsing1.setForeground(new java.awt.Color(255, 255, 255));
        payUsing1.setText("Pay using :");
        this.add(payUsing1);
        payUsing1.setBounds(50, 150, 130, 30);

        cardNumber.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        cardNumber.setText("Card number");
        cardNumber.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        this.add(cardNumber);
        cardNumber.setBounds(120, 312, 210, 32);

        next.setBackground(new java.awt.Color(255, 255, 255));
        next.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        next.setText("Confirm Payment");
        next.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        next.setBorderPainted(false);
        next.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                
                /*if(frame.getLoggedInCustomer()==null) {
                    idAccount = 0;
                }
                else {
                    idAccount = frame.getLoggedInCustomer().getIdAccount();
                }*/
                
                /*
                for(int i=0; i < frame.getNumberOfPassengers() ; ++i) {
                    departTickets.add( new Ticket( 0 , (FlightSeat) frame.getDepartAvailableSeatChoice().get(i).getSelectedItem() , frame.getFlights().get(0) ) );
                    if(frame.getFlights().size() == 2){
                            returnTickets.add( new Ticket( 0 , (FlightSeat) frame.getReturnAvailableSeatChoice().get(i).getSelectedItem() , frame.getFlights().get(1) ) );
                    }

                    java.util.Date birthDate = ((JDateChooser)frame.getBirthDates().get(i)).getDate();
                    java.sql.Date birthDateSql = new java.sql.Date(birthDate.getTime());

                    System.out.println(birthDateSql.toString());

                    passengers.add(new Passenger(((JTextField)frame.getTextFields().get(i)[0]).getText() , ((JTextField)frame.getTextFields().get(i)[1]).getText() , 
                    ((JTextField)frame.getTextFields().get(i)[2]).getText() , ((JTextField)frame.getTextFields().get(i)[3]).getText() , birthDateSql , 
                    ((JTextField)frame.getTextFields().get(i)[4]).getText() , ((JTextField)frame.getTextFields().get(i)[5]).getText() , ((JTextField)frame.getTextFields().get(i)[6]).getText()));

                    System.out.println("Passenger " +(i+1) +((JTextField)frame.getTextFields().get(i)[0]).getText() );
                }*/
                 

                java.util.Date todaysDate = Calendar.getInstance().getTime();
                java.sql.Date todaysDateSql = new java.sql.Date(todaysDate.getTime());

                if (frame.getFlights().size() == 2) {

                    Booking booking = new Booking(todaysDateSql, departTickets);
                    System.out.println("avant addReserv");
                    PaymentController.addReservation(booking, idAccount, idCoupon, passengers, returnTickets);
                    System.out.println("apres addReserv");
                } else {
                    Booking booking = new Booking(todaysDateSql, departTickets);
                    System.out.println("avant addReserv");
                    PaymentController.addReservation(booking, idAccount, idCoupon, passengers);
                    System.out.println("apres addReserv");

                }

            }
        });
        this.add(next);
        next.setBounds(490, 670, 110, 30);
        this.setBounds(0, 0, 630, 720);

    }

}
