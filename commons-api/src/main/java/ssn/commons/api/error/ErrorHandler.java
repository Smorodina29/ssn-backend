package ssn.commons.api.error;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ssn.commons.api.response.ApiError;
import ssn.commons.api.response.ApiResponseFactory;
import ssn.commons.services.utils.EnvironmentService;
import ssn.commons.services.utils.TimeService;
import ssn.facades.exeptions.EntityNotFoundException;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Iterator;

@ControllerAdvice
@Slf4j
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private TimeService timeService;
    @Autowired
    private EnvironmentService environmentService;

    @Value("${ru.ddg.stalt.commons_api.show_error_message}")
    private boolean showErrorMessage;
    @Value("${ru.ddg.stalt.commons_api.show_error_trace}")
    private boolean showErrorTrace;

    private static HttpHeaders getJsonContentType() {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(final EntityNotFoundException ex, final WebRequest request) {
        return handleExceptionInternal(
                ex,
                Errors.ENTITY_NOT_FOUND,
                getJsonContentType(),
                HttpStatus.NOT_FOUND,
                request
        );
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        return handleValidation(ex, request);
    }

    protected ResponseEntity<Object> handleValidation(final MethodArgumentNotValidException ex, final WebRequest request) {
        return handleExceptionInternal(
                ex,
                ApiResponseFactory.failure(ex.getBindingResult()),
                getJsonContentType(),
                HttpStatus.BAD_REQUEST,
                request
        );
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(final Exception ex, Object body, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        if (body == null) {
            log.warn("Exception handled with empty body on request {}", request, ex);
            //get first api error
            ApiError apiError = Errors.UNKNOWN_ERROR.getErrors().get(0);
            body = ApiResponseFactory.failure(status.getReasonPhrase(),
                    apiError.getCode());
        }
        if (log.isDebugEnabled()) {
            log.debug("Exception handled on request {}", request, ex);
        }
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        final StringBuilder stringBuilder = new StringBuilder(256);
        final Throwable cause = ex.getCause();
        String unrecognizedPropertyName = "";
        if (cause instanceof UnrecognizedPropertyException) {
            final UnrecognizedPropertyException unrecognizedPropertyException = (UnrecognizedPropertyException) cause;

            unrecognizedPropertyName = unrecognizedPropertyException.getPropertyName();

            stringBuilder.append("unknown property: ").append('\'').append(unrecognizedPropertyName).append('\'');

            final Collection<Object> knownPropertyIds = unrecognizedPropertyException.getKnownPropertyIds();

            if (knownPropertyIds == null) {
                stringBuilder.append(" and object don't have any properties");
            } else {
                stringBuilder.append(", known properties: {");
                for (final Iterator<Object> iterator = knownPropertyIds.iterator(); iterator.hasNext(); ) {
                    final Object knownPropertyId = iterator.next();
                    stringBuilder.append('\'').append(knownPropertyId).append('\'');

                    if (iterator.hasNext()) {
                        stringBuilder.append(',');
                    }
                }
                stringBuilder.append('}');
            }
        }
        if (cause instanceof InvalidFormatException) {
            final InvalidFormatException invalidFormatException = (InvalidFormatException) cause;
            final Object value = invalidFormatException.getValue();
            final String className = invalidFormatException.getTargetType().toString();
            stringBuilder.append("invalid value: ").append(value).append(" for type ").append(className);
        }

        return handleExceptionInternal(ex, ApiResponseFactory.failure(stringBuilder.toString(), Errors.JSON_UNRECOGNIZED_PROPERTY.getError().getCode(), unrecognizedPropertyName), headers, status, request);
    }

    private String createMessage(Throwable ex) {
        if (showErrorMessage) {
            if (ex.getMessage() == null) {
                return ex.getClass().toString();
            }
            return ex.getMessage();
        }
        return "Internal server error host=" + environmentService.getHostName() + ", time=" + timeService.getCurrentUtcTime();
    }

    private String createTrace(Throwable ex) {
        if (showErrorTrace) {
            StringWriter stringWriter = new StringWriter();
            ex.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }
        return null;
    }
}