package ssn.facades.services;


public interface SecurityService extends SecurityServiceFacade {
    /**
     * Generate hash for the specified password.
     *
     * @param plainPassword Plain text password.
     * @return string with hash.
     */
    String hashPassword(String plainPassword);

    /**
     * Compare the specified password with the specified password hash.
     * @param plainPassword Plain text password.
     * @param hashPassword Password hash.
     * @return True if password equals with hash, otherwise false.
     */
    boolean comparePassword(String plainPassword, String hashPassword);
}
