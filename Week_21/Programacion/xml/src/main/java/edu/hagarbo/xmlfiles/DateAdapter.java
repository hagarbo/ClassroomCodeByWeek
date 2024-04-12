package edu.hagarbo.xmlfiles;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, LocalDate> {

    private static final DateTimeFormatter CUSTOM_FORMAT_STRING = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public LocalDate unmarshal(String date) throws ParseException {
        return LocalDate.parse(date, CUSTOM_FORMAT_STRING);
    }

    @Override
    public String marshal(LocalDate date) throws Exception {

        return date.format(CUSTOM_FORMAT_STRING);
    }

}
