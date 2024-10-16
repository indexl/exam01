package exam2.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
	   public static String getDateStr() {
	      
	      LocalDateTime now = LocalDateTime.now();
	      DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	      return now.format(format);
	      
	   }
}