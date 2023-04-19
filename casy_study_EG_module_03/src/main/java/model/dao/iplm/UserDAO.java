package model.dao.iplm;

import case_study_Enjoy_Galaxy.model.builder.user_builder.IUserBuilder;
import case_study_Enjoy_Galaxy.model.builder.user_builder.UserConcreteBuilder;
import case_study_Enjoy_Galaxy.model.dao.IUserDAO;
import case_study_Enjoy_Galaxy.model.entity.users.abstraction.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDAO implements IUserDAO {
    private static final UserDAO userDAO = new UserDAO();
    private static final String INSERT_USER = "INSERT INTO USER (TYPE, FULLNAME, PHONE_NUMBER, EMAIL, PASSWORD) VALUES (?,?,?,?,?);";
    private static final String SELECT_ALL = "SELECT * FROM USER;";

    private UserDAO() {
    }
    public static UserDAO getInstance() {
        return userDAO;
    }

    @Override
    public void insertUser(User user) {
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setString(1, user.getType());
            preparedStatement.setString(2, user.getFullName());
            preparedStatement.setString(3, user.getPhoneNumber());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = ConnectionDAO.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String type = resultSet.getString("type");
                String fullName = resultSet.getString("fullname");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                double wallet = resultSet.getDouble("wallet");
                String education = resultSet.getString("education");
                String jobTitle = resultSet.getString("jobtitle");
                double salary = resultSet.getDouble("salary");
                Date birthDay = resultSet.getDate("birthday");
                String address = resultSet.getString("address");
                IUserBuilder userBuilder = new UserConcreteBuilder()
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
                        .salary(salary);
                userList.add(userBuilder.build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }
}
