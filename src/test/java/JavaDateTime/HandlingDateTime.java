package JavaDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class HandlingDateTime {

	public static void main(String[] args) {
//		LocalDateTime dt=LocalDateTime.now();
//		System.out.printf("%d",dt.getYear());
//		System.out.println();
//		System.out.println(dt.minusMonths(12));
//		LocalDateTime dt2=LocalDateTime.of(2024, 9, 25, 12, 53);
//		System.out.println(dt2);
		LocalDate birthday=LocalDate.of(1995, 7, 27);
		LocalDate today=LocalDate.now();
		Period p=Period.between(birthday, today);
		System.out.println("Till today your age is "+p.getYears()+"years "+p.getMonths()+"months "+p.getDays()+"days");
		LocalDate deathDay=LocalDate.of(1995+80, 7, 27);
		Period p1=Period.between(birthday, deathDay);
		System.out.println("Age is "+p1.getYears()+"years "+p1.getMonths()+"months "+p1.getDays()+"days");
	}

}
