package controller;

import DataAcessObjectImpl.BookingDAOImpl;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Booking;

public class BookingController {

    public static ArrayList<Booking> getBookings(int idCustomerAccount) {
        return new BookingDAOImpl().findByIdCustomerAccount(idCustomerAccount);

    }

    public static Booking getBooking(int bookingNo) {
        return new BookingDAOImpl().find(bookingNo);

    }

    public static void addBooking(Date date, int idAccount, int idCoupon) {
        if (new BookingDAOImpl().add(date, idAccount, idCoupon) == false) {
            JOptionPane.showMessageDialog(null, "Unable to add booking");
        }

    }

    public static void updateBooking(int bookingNo, Date bookingDate, int idAccount, int idCoupon, int newBookingNo) {
        if (new BookingDAOImpl().update(bookingNo, bookingDate, idAccount, idCoupon, newBookingNo) == false) {
            JOptionPane.showMessageDialog(null, "Unable to update booking");
        }
    }

    public static void deleteBooking(int idBooking) {

        if (new BookingDAOImpl().delete(idBooking) == false) {

            JOptionPane.showMessageDialog(null, "The booking has not been deleted");

        } else {
            new BookingDAOImpl().delete(idBooking);
            JOptionPane.showMessageDialog(null, "The booking has been deleted");
        }
    }

    public static boolean checkBooking(String bookingNo) {

        try {

            int intBookingNo = Integer.parseInt(bookingNo);

            if (new BookingDAOImpl().find(intBookingNo) == null) {

                JOptionPane.showMessageDialog(null, "There is no Booking with this Number");

                return false;

            } else {
                return true;

            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public static ArrayList<Booking> findAllBookings()
    {
        return new BookingDAOImpl().findAllBookings();
    }
}
