package com.lcwd.todo.todomanager.Helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateHelper {
   public static Date parseDate(LocalDateTime localDateTime) throws ParseException {
//       SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
//       return simpleDateFormat.parse(dateStr);

       Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
       Date date = Date.from(instant);
       return date;
   }
}
