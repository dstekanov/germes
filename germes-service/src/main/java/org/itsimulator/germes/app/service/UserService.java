package org.itsimulator.germes.app.service;

import org.itsimulator.germes.app.model.entity.person.User;

import java.util.List;
import java.util.Optional;

/**
 * Provides API for the user management
 *
 * @author Morenets
 */
public interface UserService {
    /**
     * Saves(creates or modifies) specified user instance
     *
     * @param user
     */
    void save(User user);

    /**
     * Returns user with specified identifier boxed into Optional
     *
     * @param userId
     * @return
     */
    Optional<User> findById(int userId);

    /**
     * Returns user with specified username
     *
     * @param userName
     * @return
     */
    Optional<User> findByUserName(String userName);

    /**
     * Delete city with specified identifier
     *
     * @param userId
     */
    void delete(int userId);

    /**
     * Returns all the cities
     *
     * @return
     */
    List<User> findAll();

}
