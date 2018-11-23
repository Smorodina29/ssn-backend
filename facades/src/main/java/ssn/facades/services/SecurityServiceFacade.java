package ssn.facades.services;

import ssn.facades.exeptions.BadTokenException;
import ssn.facades.exeptions.EntityNotFoundException;
import ssn.facades.exeptions.TokenExpiredException;
import ssn.facades.model.AuthParameters;
import ssn.facades.model.enums.RoleName;

public interface SecurityServiceFacade {

    /**
     * Generate authentication token.
     *
     * @param userId        User id for which token is generated.*
     * @return Auth token in string.
     * @throws EntityNotFoundException
     */
    String generateToken(long userId) throws EntityNotFoundException;

    /**
     * Check token and return id of user who own this token.
     *
     * @param token                 Authentication token.
     * @return user id.
     * @throws TokenExpiredException
     * @throws BadTokenException
     */
    AuthParameters checkToken(String token) throws TokenExpiredException, BadTokenException;

    /**
     * Check user roles
     *
     * @param roleNames role names
     * @param userId user id
     */
    void checkRole(long userId, RoleName[] roleNames) throws EntityNotFoundException;

}
