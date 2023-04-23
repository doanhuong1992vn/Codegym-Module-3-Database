package model.dao.iplm;

import model.builder.user_builder.IUserBuilder;
import model.builder.user_builder.UserConcreteBuilder;
import model.dao.IUserDAO;
import model.domain.users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDAO implements IUserDAO {
    private static final String INSERT_USER = "INSERT INTO USER (TYPE, FULLNAME, PHONE_NUMBER, EMAIL, PASSWORD) VALUES (?,?,?,?,?);";
    private static final String SELECT_ALL = "SELECT * FROM USER;";
    private static final String SELECT_USER = "SELECT * FROM USER WHERE (PHONE_NUMBER = ? OR EMAIL = ?) AND PASSWORD = ?;";

    public static IUserDAO getUserDAO() {
        return new UserDAO();
    }

    @Override
    public boolean insert(User user) {
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setString(1, user.getType());
            preparedStatement.setString(2, user.getFullName());
            preparedStatement.setString(3, user.getPhoneNumber());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            return preparedStatement.executeUpdate() != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userList.add(getUser(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User getUserLogged(String loginName, String password) {
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER)) {
            preparedStatement.setString(1, loginName);
            preparedStatement.setString(2, loginName);
            preparedStatement.setString(3, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return getUser(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static User getUser(ResultSet resultSet) throws SQLException, ParseException {
        long id = resultSet.getLong("id");
        String type = resultSet.getString("type");
        String fullName = resultSet.getString("fullName");
        String phoneNumber = resultSet.getString("phone_number");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        double wallet = resultSet.getDouble("wallet");
        String education = resultSet.getString("education");
        String jobTitle = resultSet.getString("jobTitle");
        double salary = resultSet.getDouble("salary");
        Date birthDay = resultSet.getDate("birthday");
        String address = resultSet.getString("address");
        return new UserConcreteBuilder()
                .id(id)
                .jobTitle(jobTitle)
                .type(type)
                .address(address)
                .birthDay(birthDay)
                .email(email)
                .education(education)
                .wallet(wallet)
                .fullName(fullName)
                .password(password)
                .phoneNumber(phoneNumber)
                .salary(salary)
                .build();
    }
}
