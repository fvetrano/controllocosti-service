package it.eng.tim.costi.model.web;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "status", "startDate", "endDate", "movements" })
public class AggregatoCostiResponse extends ControlloCostiResponse {

	
    @ApiModelProperty(notes = "Outcome Result" , example = "OK")
    private String status;

    @ApiModelProperty(notes = "Data inizio intervallo della richiesta. Formato dd/MM/YY" , example = "26/01/18")
    private String startDate;
    
    @ApiModelProperty(notes = "Data fine intervallo della richiesta. Formato dd/MM/YY" , example = "26/02/18")
    private String endDate;

    @ApiModelProperty(notes = "Sezioni dell'informativa aggregata", required = true)
    private List<Section> sections;
    
    
    //@ApiModelProperty(notes = "Movimenti associati alla richiesta.", required = true)
    //private List<Movement> movements;

    
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

	
	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	

	@Override
	public String toString() {
		return "AggregatoCostiResponse [status=" + status + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", sections=" + sections + "]";
	}


	
    
        
}
