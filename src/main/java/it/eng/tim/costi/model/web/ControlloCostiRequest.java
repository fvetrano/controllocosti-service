package it.eng.tim.costi.model.web;

import io.swagger.annotations.ApiModelProperty;

public class ControlloCostiRequest {

	@ApiModelProperty(notes = "Intervallo su cui si richiedono i movimenti. PROF10: ultimi 7 giorni - PROF11: ultimi 30 giorni - PROF12: mese precedente " , example = "PROF10")
	private PeriodType period;

	public PeriodType getPeriod() {
		return period;
	}

	public void setPeriod(PeriodType period) {
		this.period = period;
	}

	
	@Override
	public String toString() {
		return "ControlloCostiRequest [period=" + period + "]";
	}
	
	
	
	
}
