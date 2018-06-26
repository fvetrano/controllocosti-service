package it.eng.tim.costi.model.integration.sdp.npat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"dataFine",
	"dataInizio",
	"operatore",
	"subSys",
	"tutteLeTipologie"
})
public class CommonData {

	@JsonProperty("dataFine")
	private String dataFine;
	@JsonProperty("dataInizio")
	private String dataInizio;
	@JsonProperty("operatore")
	private String operatore;
	@JsonProperty("subSys")
	private String subSys;
	@JsonProperty("tutteLeTipologie")
	private String tutteLeTipologie;



	public String getDataFine() {
		return dataFine;
	}


	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}


	public String getDataInizio() {
		return dataInizio;
	}


	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}


	public String getOperatore() {
		return operatore;
	}


	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}


	public String getSubSys() {
		return subSys;
	}


	public void setSubSys(String subSys) {
		this.subSys = subSys;
	}


	public String getTutteLeTipologie() {
		return tutteLeTipologie;
	}


	public void setTutteLeTipologie(String tutteLeTipologie) {
		this.tutteLeTipologie = tutteLeTipologie;
	}

	

}