package repository;

// 4 letter acronym that describes the type of functionality for this class
// CRUD -> if we have the same types of operations, what artifact in java can ensure obligations are met

import .model.Flashcard;
import util.ConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlashcardRepository implements DAO<Flashcard> {
    private static final Logger logger = LogManager.getLogger(FlashcardRepository.class);

    @Override
    public void create(Flashcard flashcard) {

        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "insert into flashcards(title, solution, user_id) values (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, flashcard.getTitle());
            stmt.setString(2, flashcard.getSolution());
            stmt.setInt(3, flashcard.getUserId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.warn(e.getMessage(), e);
        }

    }

    @Override
    public Flashcard getById(int id) {
        return null;
    }

    @Override
    public List<Flashcard> getAll() {
        // create an empty list to store our results
        // if we don't find any, returning an empty list is OK
        List<Flashcard> flashcards = new ArrayList<>();

        try(Connection connection = ConnectionFactory.getConnection()) {
            // we don't have a where clause, just get all the records
            String sql = "select * from flashcards";

            // since we don't have any more fields to add to the statement, using a regular statement is fine
            Statement stmt = connection.createStatement();

            ResultSet resultSet = stmt.executeQuery(sql);

            // once we execute the query, we need to iterate through all the rows in the result set
            while(resultSet.next()){
                // for each iteration, add a new Flashcard object to the list
                flashcards.add(
                        new Flashcard(
                                resultSet.getInt("id"),
                                resultSet.getString("title"),
                                resultSet.getString("solution"),
                                resultSet.getInt("user_id")
                        )
                );
            }
        } catch (SQLException e) {
            logger.warn(e.getMessage(), e);
        }

        // return our list whether we have added records or not
        return flashcards;
    }

    public List<Flashcard> getAllByUserId(int userId) {
        List<Flashcard> flashcards = new ArrayList<>();

        try(Connection connection = ConnectionFactory.getConnection()) {
            String sql = "select * from flashcards where user_id = ?";

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, userId);

            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){
                flashcards.add(
                        new Flashcard(
                                resultSet.getInt("id"),
                                resultSet.getString("title"),
                                resultSet.getString("solution"),
                                resultSet.getInt("user_id")
                        )
                );
            }
        } catch (SQLException e) {
            logger.warn(e.getMessage(), e);
        }
        return flashcards;
    }

    @Override
    public void update(Flashcard flashcard) {

    }

    @Override
    public void deleteById(int id) {

    }


}
