package it.eng.tim.costi.model.integration.sdp.npat;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"smsentranti",
	"smsesteroInviato",
	"smsesteroRicevuto",
	"smsinviati",
	"smsinviatiITZ",
	"smsnazinviatiVsLA",
	"smsnazricevutiDaLA",
	"smsnotifica",
	"smsricevuti",
	"smsroamingInviatiVsLA",
	"smsroamingRicevutiDaLA",
	"smssrtcesteroInviato",
	"smssrtcesteroRicevuto"
})
public class Sms {

	@JsonProperty("smsentranti")
	private String smsentranti;
	@JsonProperty("smsesteroInviato")
	private String smsesteroInviato;
	@JsonProperty("smsesteroRicevuto")
	private String smsesteroRicevuto;
	@JsonProperty("smsinviati")
	private String smsinviati;
	@JsonProperty("smsinviatiITZ")
	private String smsinviatiITZ;
	@JsonProperty("smsnazinviatiVsLA")
	private String smsnazinviatiVsLA;
	@JsonProperty("smsnazricevutiDaLA")
	private String smsnazricevutiDaLA;
	@JsonProperty("smsnotifica")
	private String smsnotifica;
	@JsonProperty("smsricevuti")
	private String smsricevuti;
	@JsonProperty("smsroamingInviatiVsLA")
	private String smsroamingInviatiVsLA;
	@JsonProperty("smsroamingRicevutiDaLA")
	private String smsroamingRicevutiDaLA;
	@JsonProperty("smssrtcesteroInviato")
	private String smssrtcesteroInviato;
	@JsonProperty("smssrtcesteroRicevuto")
	private String smssrtcesteroRicevuto;


	public String getSmsentranti() {
		return smsentranti;
	}


	public void setSmsentranti(String smsentranti) {
		this.smsentranti = smsentranti;
	}


	public String getSmsesteroInviato() {
		return smsesteroInviato;
	}


	public void setSmsesteroInviato(String smsesteroInviato) {
		this.smsesteroInviato = smsesteroInviato;
	}


	public String getSmsesteroRicevuto() {
		return smsesteroRicevuto;
	}


	public void setSmsesteroRicevuto(String smsesteroRicevuto) {
		this.smsesteroRicevuto = smsesteroRicevuto;
	}


	public String getSmsinviati() {
		return smsinviati;
	}


	public void setSmsinviati(String smsinviati) {
		this.smsinviati = smsinviati;
	}


	public String getSmsinviatiITZ() {
		return smsinviatiITZ;
	}


	public void setSmsinviatiITZ(String smsinviatiITZ) {
		this.smsinviatiITZ = smsinviatiITZ;
	}


	public String getSmsnazinviatiVsLA() {
		return smsnazinviatiVsLA;
	}


	public void setSmsnazinviatiVsLA(String smsnazinviatiVsLA) {
		this.smsnazinviatiVsLA = smsnazinviatiVsLA;
	}


	public String getSmsnazricevutiDaLA() {
		return smsnazricevutiDaLA;
	}


	public void setSmsnazricevutiDaLA(String smsnazricevutiDaLA) {
		this.smsnazricevutiDaLA = smsnazricevutiDaLA;
	}


	public String getSmsnotifica() {
		return smsnotifica;
	}


	public void setSmsnotifica(String smsnotifica) {
		this.smsnotifica = smsnotifica;
	}


	public String getSmsricevuti() {
		return smsricevuti;
	}


	public void setSmsricevuti(String smsricevuti) {
		this.smsricevuti = smsricevuti;
	}


	public String getSmsroamingInviatiVsLA() {
		return smsroamingInviatiVsLA;
	}


	public void setSmsroamingInviatiVsLA(String smsroamingInviatiVsLA) {
		this.smsroamingInviatiVsLA = smsroamingInviatiVsLA;
	}


	public String getSmsroamingRicevutiDaLA() {
		return smsroamingRicevutiDaLA;
	}


	public void setSmsroamingRicevutiDaLA(String smsroamingRicevutiDaLA) {
		this.smsroamingRicevutiDaLA = smsroamingRicevutiDaLA;
	}


	public String getSmssrtcesteroInviato() {
		return smssrtcesteroInviato;
	}


	public void setSmssrtcesteroInviato(String smssrtcesteroInviato) {
		this.smssrtcesteroInviato = smssrtcesteroInviato;
	}


	public String getSmssrtcesteroRicevuto() {
		return smssrtcesteroRicevuto;
	}


	public void setSmssrtcesteroRicevuto(String smssrtcesteroRicevuto) {
		this.smssrtcesteroRicevuto = smssrtcesteroRicevuto;
	}


	
	
	public static Sms getSms(boolean sms, boolean contentService) {
		Sms instance = new Sms();
		
		String smsFlag = "N";
		if(sms) {
			smsFlag = "Y";
		}
		
		String contentServiceFlag = "N";
		if(contentService) {
			contentServiceFlag = "Y";
		}
		
		//N
		instance.setSmsricevuti("N");
		instance.setSmsentranti("N");
		instance.setSmsesteroRicevuto("N");
		
		//SMS
		instance.setSmsinviati(smsFlag);
		instance.setSmsesteroInviato(smsFlag);
		instance.setSmssrtcesteroInviato(smsFlag);
		instance.setSmssrtcesteroRicevuto(smsFlag);
		instance.setSmsinviatiITZ(smsFlag);
		instance.setSmsnotifica(smsFlag);
		
		instance.setSmsnazinviatiVsLA(contentServiceFlag);
		instance.setSmsnazricevutiDaLA(contentServiceFlag);
		instance.setSmsroamingInviatiVsLA(contentServiceFlag);
		instance.setSmsroamingRicevutiDaLA(contentServiceFlag);
		
		return instance;
		
		
	}

}