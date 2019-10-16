package by.training.gym.service;

import by.training.gym.dao.ConnectionWrapper;
import by.training.gym.dao.DAOException;
import by.training.gym.dao.UserDAO;
import by.training.gym.domain.User;
import by.training.gym.domain.UserRole;
import by.training.gym.service.validator.UserValidator;
import org.apache.commons.codec.digest.DigestUtils;


import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Service class for User entity.
 * @author AlesyaHlushakova
 */
public class UserService {

    private static final String SPLIT_SYMBOL = " ";

    private static final int FIRST_NAME_INDEX = 0;
    private static final int LAST_NAME_INDEX = 1;

    /**
     * method gets authorized user.
     * @param login    the user's login.
     * @param password the user's password.
     * @return the User.
     * @throws ServiceException object if execution of method is failed.
     */
    public User login(String login, String password) throws ServiceException {
        try (ConnectionWrapper connectionWrapper = new ConnectionWrapper()) {
            UserDAO userDAO = new UserDAO(connectionWrapper.getConnection());
            password = DigestUtils.shaHex(password);

            return userDAO.selectUserByLoginAndPassword(login, password);
        } catch (DAOException exception) {
            throw new ServiceException("Exception during logging in.", exception);
        }
    }

    /**
     * The method registers user into data base.
     *
     * @param login     the user's login.
     * @param password  the user's password.
     * @param firstName the user's first name.
     * @param lastName  the user's last name.
     * @return true if operation was made successful and false otherwise.
     * @throws ServiceException object if execution of method is failed.
     */
    public boolean register(String login, String password, String firstName,
                            String lastName, String telephone) throws ServiceException {
        try (ConnectionWrapper connectionWrapper = new ConnectionWrapper()) {
            UserDAO userDAO = new UserDAO(connectionWrapper.getConnection());

            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            UserRole userRole = UserRole.CLIENT;
            user.setUserRole(userRole);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setTelephone(telephone);

            return userDAO.insert(user);
        } catch (DAOException exception) {
            throw new ServiceException("Exception during register operation.", exception);
        }
    }
    /**
     * method discards user.
     * @param subId the sub id.
     * @return true if operation was successful and false otherwise.
     * @throws ServiceException object if execution of query is failed.
     */
    public boolean deleteUser(int subId) throws ServiceException {

        ConnectionWrapper connectionWrapper = new ConnectionWrapper();
        try {
            connectionWrapper.startTransaction();

            UserDAO userDAO = new UserDAO(connectionWrapper.getConnection());



            boolean isSubDeleted = userDAO.deleteById(subId);
            if (!isSubDeleted) {
                connectionWrapper.rollbackTransaction();
                return false;
            }

            connectionWrapper.commitTransaction();
            return true;
        } catch (DAOException exception) {
            connectionWrapper.rollbackTransaction();

            throw new ServiceException("Exception during discard of client.", exception);
        } finally {
            connectionWrapper.endTransaction();
            connectionWrapper.close();
        }
    }
    /**
     * The method registers coach into data base.
     *
     * @param login     the user's login.
     * @param password  the user's password.
     * @param firstName the user's first name.
     * @param lastName  the user's last name.
     * @return true if operation was made successful and false otherwise.
     * @throws ServiceException object if execution of method is failed.
     */
    public boolean registerCoach(String login, String password, String firstName,
                            String lastName, String telephone) throws ServiceException {
        try (ConnectionWrapper connectionWrapper = new ConnectionWrapper()) {
            UserDAO userDAO = new UserDAO(connectionWrapper.getConnection());

            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            UserRole userRole = UserRole.COACH;
            user.setUserRole(userRole);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setTelephone(telephone);

            return userDAO.insert(user);
        } catch (DAOException exception) {
            throw new ServiceException("Exception during register operation.", exception);
        }
    }

    /**
     * The method updates user into data base.
     *
     * @param login     the user's login.
     * @param password  the user's password.
     * @param firstName the user's first name.
     * @param lastName  the user's last name.
     * @param clientID user id.
     * @return true if operation was made successful and false otherwise.
     * @throws ServiceException object if execution of method is failed.
     */
    public boolean update(int clientID, String login, String password, String firstName,
                          String lastName, String telephone, InputStream inputStream) throws ServiceException {
        try (ConnectionWrapper connectionWrapper = new ConnectionWrapper()) {
            UserDAO userDAO = new UserDAO(connectionWrapper.getConnection());
            password = DigestUtils.shaHex(password);
        int res = userDAO.update(clientID, login, password, firstName, lastName, telephone, inputStream);
        if (res>0) {
            return true;
        }

            return false ;
        } catch (DAOException exception) {
            throw new ServiceException("Exception during update operation.", exception);
        }
    }

    public byte[] retrieveImage (int userId) throws ServiceException {
        try (ConnectionWrapper connectionWrapper = new ConnectionWrapper()) {
            UserDAO userDAO = new UserDAO(connectionWrapper.getConnection());
         return userDAO.selectImageById(userId);
        } catch (DAOException  exception) {
            throw new ServiceException("Exception during image retrieval operation.", exception);
        }
    }

    /**
     * method checks user login for uniqueness.
     * @param login the user's login.
     * @return true if login is unique and false if not.
     * @throws ServiceException object if execution of method is failed.
     */
    public boolean checkUserLoginForUniqueness(String login) throws ServiceException {
        try (ConnectionWrapper connectionWrapper = new ConnectionWrapper()) {
            UserDAO userDAO = new UserDAO(connectionWrapper.getConnection());

            return userDAO.checkLoginForUniqueness(login);
        } catch (DAOException exception) {
            throw new ServiceException("Exception during check user login for unique operation.", exception);
        }
    }

    /**
     * method finds user by full name.
     * @param name the user's first name.
     * @return List of users.
     * @throws ServiceException object if execution of method is failed.
     */
    public List<User> findClientByName(String name) throws ServiceException {
        try (ConnectionWrapper connectionWrapper = new ConnectionWrapper()) {
            UserValidator userDataValidator = new UserValidator();
            UserDAO userDAO = new UserDAO(connectionWrapper.getConnection());
            boolean isNameFull = userDataValidator.isNameFull(name);
            if (isNameFull) {
                String[] names = name.split(SPLIT_SYMBOL);
                String firstName = names[FIRST_NAME_INDEX];
                String lastName = names[LAST_NAME_INDEX];

                return userDAO.selectClientByFullName(firstName, lastName);
            } else {
                return userDAO.selectClientByNamePart(name);
            }
        } catch (DAOException exception) {
            throw new ServiceException("Exception during finding client by name operation.", exception);
        }
    }

    /**
     * method finds all clients.
     * @return Map of clients and number of records.
     * @throws ServiceException object if execution of method is failed.
     */
    public Map<List<User>, Integer> findAllClientsByPages(int offSet, int numberOfRecords) throws ServiceException {
        try (ConnectionWrapper connectionWrapper = new ConnectionWrapper()) {
            UserDAO userDAO = new UserDAO(connectionWrapper.getConnection());
            ;
            Map<List<User>, Integer> clients = new HashMap<>();

            List<User> findClient = userDAO.selectAllClients(offSet, numberOfRecords);
            Integer countOfRecords = userDAO.getNumberOfRecords();

            clients.put(findClient, countOfRecords);

            return clients;
        } catch (DAOException exception) {
            throw new ServiceException("Exception during finding all clients by pages operation.", exception);
        }
    }

    /**
     * method finds all coaches.
     * @return Map of coaches and number of records.
     * @throws ServiceException object if execution of method is failed.
     */
    public Map<List<User>, Integer> findAllCoachesByPages(int offSet, int numberOfRecords) throws ServiceException {
        try (ConnectionWrapper connectionWrapper = new ConnectionWrapper()) {
            UserDAO userDAO = new UserDAO(connectionWrapper.getConnection());

            Map<List<User>, Integer> coaches = new HashMap<>();

            List<User> findCoach = userDAO.selectAllCoaches(offSet, numberOfRecords);
            Integer countOfRecords = userDAO.getNumberOfRecords();

            coaches.put(findCoach, countOfRecords);

            return coaches;
        } catch (DAOException exception) {
            throw new ServiceException("Exception during finding all clients by pages operation.", exception);
        }
    }

    /**
     * method finds all clients of the coach and programs id .
     * @param trainerId the trainer id.
     * @return List with results.
     * @throws ServiceException object if execution of method is failed.
     */
    public List<User> findPersonalClients(int trainerId) throws ServiceException {
        try (ConnectionWrapper connectionWrapper = new ConnectionWrapper()) {
            UserDAO userDAO = new UserDAO(connectionWrapper.getConnection());

            return userDAO.selectPersonalClients(trainerId);
        } catch (DAOException exception) {
            throw new ServiceException("Exception during search for personal clients operation.", exception);
        }
    }

    /**
     * method finds clients for program creation.
     * @return Map with id and name.
     * @throws ServiceException object if execution of method is failed.
     */
    public Map<Integer, String> findClientsForProgramCreation() throws ServiceException {
        try (ConnectionWrapper connectionWrapper = new ConnectionWrapper()) {
            UserDAO userDAO = new UserDAO(connectionWrapper.getConnection());

            return userDAO.selectClientIdAndNameForProgramCreation();
        } catch (DAOException exception) {
            throw new ServiceException("Exception during find clients id and name operation.", exception);
        }
    }

}