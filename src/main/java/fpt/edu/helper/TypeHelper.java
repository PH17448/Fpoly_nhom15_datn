package fpt.edu.helper;

import java.math.BigDecimal;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public class TypeHelper{
	
	public List<Long> convertObjectTypeListLong(List<Long> input) {
		if(input != null ) {
			return input;
		}else {
			List<Long> newData = new ArrayList<Long>(Arrays.asList(-1L));
			return newData;
		}
	}
	
	public String convertObjectTypeString(String input) {
		if(input != null) {
			return input;
		}else {
			String newData = "-1";
			return newData;
		}
	}
	
	public BigDecimal convertObjectTypeBigDecimal(BigDecimal input) {
		if(input != null) {
			return input;
		}else {
			BigDecimal newData = new BigDecimal(-1L);
			return newData;
		}
	}
	
	public Instant convertObjectTypeInstant(Instant input) {
		Instant data = input;
		if(data != null) {
			return data;
		}else {
			data = Instant.EPOCH;
			return data;
		}
	}
	
	public Date convertObjectTypeDate(Date input) {
		Date data = input;
		if(data != null) {
			return data;
		}else {
			Date date = Date.from(Instant.EPOCH);
			data = date;
			return data;
		}
	}
}
