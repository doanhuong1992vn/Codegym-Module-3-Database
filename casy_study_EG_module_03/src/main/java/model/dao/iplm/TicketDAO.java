package model.dao.iplm;

import model.builder.ticket_builder.ITicketBuilder;
import model.builder.ticket_builder.TicketConcreteBuilder;
import model.dao.ITicketDAO;
import model.domain.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketDAO implements ITicketDAO {
    private static final String INSERT_TICKET = "INSERT INTO TICKET ( PRICE, ID_USER, ID_SEAT, TIME_BOOKING, PAID, TIME_PAYMENT, CHECKED) VALUES (?,?,?,?,?,?,?);";
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

                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tickets;
    }

    @Override
    public long insertTicket(Ticket ticket) {
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TICKET, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setDouble(1, ticket.getPrice());
            preparedStatement.setLong(2, ticket.getIdUser());
            preparedStatement.setLong(3, ticket.getIdSeat());
            preparedStatement.setTimestamp(4, new Timestamp(ticket.getTimeBooking().getTime()));
            preparedStatement.setBoolean(5, ticket.isPaid());
            Timestamp timePayment = ticket.getTimePayment() == null ? null : new Timestamp(ticket.getTimePayment().getTime());
            preparedStatement.setTimestamp(6, timePayment) ;
            preparedStatement.setBoolean(7, ticket.isChecked());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Ticket getTicket(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("ID_TICKET");
        long idUser = resultSet.getLong("ID_USER");
        long idSeat = resultSet.getLong("ID_SEAT");
        double price = resultSet.getLong("PRICE_TICKET");
        Date timeBooking = resultSet.getTimestamp("TIME_BOOKING");
        Date timePayment = resultSet.getTimestamp("TIME_PAYMENT");
        boolean paid = resultSet.getBoolean("PAID");
        boolean checked = resultSet.getBoolean("CHECKED");
        ITicketBuilder ticketBuilder = new TicketConcreteBuilder()
                .price(price)
                .idSeat(idSeat)
                .idUser(idUser)
                .isChecked(checked)
                .isPaid(paid)
                .timeBooking(timeBooking)
                .timePayment(timePayment)
                .id(id);
        return ticketBuilder.build();
    }
}
