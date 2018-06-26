package it.eng.tim.costi.model.web;

import io.swagger.annotations.ApiModelProperty;

public class DetailsCostiResponse extends ControlloCostiResponse {

	
    @ApiModelProperty(notes = "Outcome Result" , example = "OK")
    private String status;

    @ApiModelProperty(notes = "Data inizio intervallo della richiesta. Formato dd/MM/YYYY" , example = "26/01/2018")
    private String startDate;
    
    @ApiModelProperty(notes = "Data fine intervallo della richiesta. Formato dd/MM/YYYY" , example = "26/02/2018")
    private String endDate;

    
    
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
