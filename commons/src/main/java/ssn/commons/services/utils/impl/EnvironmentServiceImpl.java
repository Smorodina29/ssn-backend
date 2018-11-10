package ssn.commons.services.utils.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ssn.commons.services.utils.EnvironmentService;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@Component
public class EnvironmentServiceImpl implements EnvironmentService {
    @Override
    public String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        }
        catch (UnknownHostException e) {
            log.warn("Impossible to detect localhost hostname.", e);
            return null;
        }
    }
}
