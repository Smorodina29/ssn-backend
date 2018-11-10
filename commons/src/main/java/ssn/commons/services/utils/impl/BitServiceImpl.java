package ssn.commons.services.utils.impl;

import org.springframework.stereotype.Component;
import ssn.commons.services.utils.BitService;

@Component
public class BitServiceImpl implements BitService {
    @Override
    public boolean testBit(int data, int bit) {
        return (data & (1 << bit)) != 0;
    }

    @Override
    public int setBit(int data, int bit) {
        return data | (1 << bit);
    }

    @Override
    public String byteArrayToString(int[] value) {
        String[] hexArr = new String[value.length];
        for(int i = 0; i < value.length; i++){
            hexArr[i] = Integer.toHexString(value[i]);
        }
        return String.join("-", hexArr);
    }
}
