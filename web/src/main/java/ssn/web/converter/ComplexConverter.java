package ssn.web.converter;

import org.springframework.core.convert.ConversionService;

public interface ComplexConverter {
    Object setConversionService(ConversionService conversionService);
}
