package com.brizy.io.web.test.service;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * The `PatternReplacerService` class is a service designed to replace specific patterns
 * in a given data table with random values. It uses the Faker library to generate random
 * data for patterns such as "[random_company_name]", "[random_phone]", "[random_email]",
 * "[random_website]", "[random_country]", and "[random_address]".
 * <p>
 * This service provides a method `processDataTable` to process a data table by iterating
 * through its entries and replacing the patterns with corresponding random values.
 *
 * @version 1.0-SNAPSHOT
 */
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class PatternReplacerService {

    /**
     * The Faker instance used to generate random data.
     */
    Faker faker;

    public PatternReplacerService() {
        this.faker = new Faker();
    }

    /**
     * Private helper method to search for patterns in the given data table cell
     * and replace them with random values. Currently, this method supports replacing
     * the following patterns:
     * <ul>
     * <li> [random_company_name]": Replaced with a random company name in uppercase.</li>
     * <li> [random_phone]: Replaced with a random phone number.</li>
     * <li> [random_email]: Replaced with a random email address.</li>
     * <li> [random_website]: Replaced with a random website URL.</li>
     * <li> [random_country]: Replaced with a random country name.</li>
     * <li> [random_address]: Replaced with a random full address.</li>
     * </ul>
     * <p>
     * You can extend this method by adding support for additional patterns as needed.
     *
     * @param dataTableCell The data table cell containing patterns to replace.
     * @return The data table cell with patterns replaced by random values.
     */
    private String searchForPatternAndReplace(String dataTableCell) {
        if (dataTableCell.contains("[blank]")) {
            dataTableCell = dataTableCell.replaceAll("\\[blank]", StringUtils.EMPTY);
        }
        if (dataTableCell.contains("[local_date_now_")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            var localDate = getProcessedLocalDate(dataTableCell).format(formatter);
            dataTableCell = dataTableCell.replaceAll("\\[local_date_now_.*]", localDate);
        }
        if (dataTableCell.contains("[local_date_now]")) {
            var localDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MM yyyy"));
            dataTableCell = dataTableCell.replaceAll("\\[local_date_now]", localDate);
        }
        if (dataTableCell.contains("[local_date_time_now]")) {
            var localDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm"));
            dataTableCell = dataTableCell.replaceAll("\\[local_date_time_now]", localDate);
        }
        if (dataTableCell.contains("[random_product_name]")) {
            var productName = faker.commerce().productName();
            dataTableCell = dataTableCell.replaceAll("\\[random_product_name]", productName);
        }
        if (dataTableCell.contains("[random_product_description]")) {
            var productDescription = faker.harryPotter().quote();
            dataTableCell = dataTableCell.replaceAll("\\[random_product_description]", productDescription);
        }
        return dataTableCell;
    }

    /**
     * Process the provided data table by replacing patterns with random values.
     *
     * @param dataTable A map representing the data table with keys and values.
     * @return A new map with patterns replaced by random values.
     */
    public Map<String, String> processDataTable(Map<String, String> dataTable) {
        return dataTable.entrySet().stream()
                .filter(e -> Objects.nonNull(e.getKey()) && Objects.nonNull(e.getValue()))
                .map(key -> Pair.of(key.getKey(), searchForPatternAndReplace(key.getValue())))
                .collect(HashMap::new, (map, pair) -> map.put(pair.getKey(), pair.getValue()), HashMap::putAll);
    }

    LocalDate getProcessedLocalDate(String value) {
        var now = LocalDate.now();
        var regexp = "local_date_now_(plus|minus)_([0-9]+)_(days|months|years)?";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            String operation = matcher.group(1);
            long number = Long.parseLong(matcher.group(2));
            ChronoUnit unit = ChronoUnit.valueOf(matcher.group(3).toUpperCase());
            return operation.equalsIgnoreCase("plus") ? now.plus(number, unit) : now.minus(number, unit);
        } else {
            throw new PatternSyntaxException("Provided expression is invalid, make sure it's according to regexp", regexp, 0);
        }
    }

}
