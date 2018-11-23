package ssn.services.Impl;

import org.springframework.security.crypto.bcrypt.BCrypt;
import ssn.facades.exeptions.BadTokenException;
import ssn.facades.exeptions.EntityNotFoundException;
import ssn.facades.exeptions.TokenExpiredException;
import ssn.facades.model.AuthParameters;
import ssn.facades.model.enums.RoleName;
import ssn.facades.services.SecurityService;

public class SecurityServiceImpl implements SecurityService {
    @Override
    public String hashPassword(String plainPassword) {
        return null;
    }

    @Override
    public boolean comparePassword(String plainPassword, String hashPassword) {
        return BCrypt.checkpw(plainPassword, hashPassword);
    }

    @Override
    public String generateToken(long userId) throws EntityNotFoundException {
        return null;
    }

    @Override
    public AuthParameters checkToken(String token) throws TokenExpiredException, BadTokenException {
        return null;
    }

    @Override
    public void checkRole(long userId, RoleName[] roleNames) throws EntityNotFoundException {

    }
}
