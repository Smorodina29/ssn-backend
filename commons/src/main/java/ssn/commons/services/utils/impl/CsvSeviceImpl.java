package ssn.commons.services.utils.impl;

import org.springframework.stereotype.Service;
import ssn.commons.services.utils.CsvSevice;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * @author Max
 */
@Service
public class CsvSeviceImpl implements CsvSevice {
    public static final char DEFAULT_SEPARATOR = ';';

    @Override
    public void writeLine(Writer writer, List<String> values) throws IOException {
        writeLine(writer, values, DEFAULT_SEPARATOR);
    }

    @Override
    public void writeLine(Writer writer, List<String> values, char separator) throws IOException {
        boolean first = true;

        StringBuilder stringBuilder = new StringBuilder();

        for (String value : values) {
            if (!first) {
                stringBuilder.append(separator);
            }

            stringBuilder.append(value);

            if (first) {
                first = false;
            }
        }

        stringBuilder.append("\n");

        writer.append(stringBuilder.toString());
    }
}
