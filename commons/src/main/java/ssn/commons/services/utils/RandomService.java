package ssn.commons.services.utils;

import java.math.BigInteger;

/**
 * Random wrapping service for future purposes.
 */
public interface RandomService {
    BigInteger randomBits(int numBits);
    long rand();

    int randInt();
}
