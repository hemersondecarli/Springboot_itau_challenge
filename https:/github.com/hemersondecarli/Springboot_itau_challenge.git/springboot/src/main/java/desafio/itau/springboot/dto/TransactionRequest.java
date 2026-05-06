package desafio.itau.springboot.dto;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class TransactionRequest {
	
	@NotNull
	@Min(0)
	private double value;
	
	@NotNull
	private OffsetDateTime dateHour;
	
	
	public Double getValue() {
		return value;
	}
	
	public OffsetDateTime getDateHour() {
		return dateHour;
	}

}
