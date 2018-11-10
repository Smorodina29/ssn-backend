package ssn.commons;

import org.springframework.core.convert.ConversionService;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ConversionUtils {

    public static <T> List<T> convertList(final ConversionService conversionService, final List<?> objects, final Class<T> targetType) {
        return objects
            .stream()
            .map(o -> conversionService.convert(o, targetType))
            .collect(toList());
    }
}
