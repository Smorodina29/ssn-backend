package ssn.web;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Component;
import ssn.web.converter.ComplexConverter;

import java.util.Set;

@Component
@Slf4j
public class ConvertersAutoRegistrationContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private Set<Converter<?, ?>> converters;

    @Autowired
    private ConversionService conversionService;

    @Override
    public void onApplicationEvent(@NotNull final ContextRefreshedEvent event) {
        final GenericConversionService gcs = (GenericConversionService) conversionService;
        for (Converter converter : converters) {
            log.info("add converter " + converter.getClass().getSimpleName());
            gcs.addConverter(converter);

            if (converter instanceof ComplexConverter) {
                ComplexConverter complexConverter = (ComplexConverter) converter;
                complexConverter.setConversionService(gcs);
            }
        }
    }
}
