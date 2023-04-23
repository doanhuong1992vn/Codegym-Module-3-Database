package model.dao.iplm;

import model.dao.ITicketDAO;
import model.domain.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketDAO implements ITicketDAO {
    private static final String INSERT_TICKET = "INSERT INTO TICKET (ID_USER, ID_SEAT, PRICE, TIME_BOOKING, PAID, TIME_PAYMENT, CHECKED) VALUES (?,?,?,?,?,?,?);";
    private static final String SELECT_ALL = "SELECT * FROM TICKET;";
    private static final ITicketDAO ticketDAO = new TicketDAO();
    private TicketDAO (){}
    public static ITicketDAO getTicketDAO() {
        return ticketDAO;
    }
    @Override
    public List<Ticket> getAll() {
        List<Ticket> tickets = new ArrayList<>();
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("ID");
                long idUser = resultSet.getLong("ID_USER");
                long idSeat = resultSet.getLong("ID_SEAT");
                double price = resultSet.getLong("PRICE");
                Date timeBooking = resultSet.getTimestamp("TIME_BOOKING");
                Date timePayment = resultSet.getTimestamp("TIME_PAYMENT");
                boolean paid = resultSet.getBoolean("PAID");
                boolean checked = resultSet.getBoolean("CHECKED");
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tickets;
    }

    @Override
    public void insertTicket(Ticket ticket) {

    }
}
