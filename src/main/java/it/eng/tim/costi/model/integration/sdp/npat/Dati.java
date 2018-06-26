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
	"camel",
	"gprs",
	"gprsestero",
	"gprsevento",
	"mmsentranti",
	"mmsentrantiDaLA",
	"mmsinviati",
	"mmsinviatiRoaming",
	"mmsinviatiVsLA",
	"mmsricevutoDaLA",
	"mmsricevutoTIMPrime",
	"rcs",
	"serviziContenutoWAP",
	"wap",
	"wapevento"
})
public class Dati {

	@JsonProperty("camel")
	private String camel;
	@JsonProperty("gprs")
	private String gprs;
	@JsonProperty("gprsestero")
	private String gprsestero;
	@JsonProperty("gprsevento")
	private String gprsevento;
	@JsonProperty("mmsentranti")
	private String mmsentranti;
	@JsonProperty("mmsentrantiDaLA")
	private String mmsentrantiDaLA;
	@JsonProperty("mmsinviati")
	private String mmsinviati;
	@JsonProperty("mmsinviatiRoaming")
	private String mmsinviatiRoaming;
	@JsonProperty("mmsinviatiVsLA")
	private String mmsinviatiVsLA;
	@JsonProperty("mmsricevutoDaLA")
	private String mmsricevutoDaLA;
	@JsonProperty("mmsricevutoTIMPrime")
	private String mmsricevutoTIMPrime;
	@JsonProperty("rcs")
	private String rcs;
	@JsonProperty("serviziContenutoWAP")
	private String serviziContenutoWAP;
	@JsonProperty("wap")
	private String wap;
	@JsonProperty("wapevento")
	private String wapevento;
	

	public String getCamel() {
		return camel;
	}


	public void setCamel(String camel) {
		this.camel = camel;
	}


	public String getGprs() {
		return gprs;
	}


	public void setGprs(String gprs) {
		this.gprs = gprs;
	}


	public String getGprsestero() {
		return gprsestero;
	}


	public void setGprsestero(String gprsestero) {
		this.gprsestero = gprsestero;
	}


	public String getGprsevento() {
		return gprsevento;
	}


	public void setGprsevento(String gprsevento) {
		this.gprsevento = gprsevento;
	}


	public String getMmsentranti() {
		return mmsentranti;
	}


	public void setMmsentranti(String mmsentranti) {
		this.mmsentranti = mmsentranti;
	}


	public String getMmsentrantiDaLA() {
		return mmsentrantiDaLA;
	}


	public void setMmsentrantiDaLA(String mmsentrantiDaLA) {
		this.mmsentrantiDaLA = mmsentrantiDaLA;
	}


	public String getMmsinviati() {
		return mmsinviati;
	}


	public void setMmsinviati(String mmsinviati) {
		this.mmsinviati = mmsinviati;
	}


	public String getMmsinviatiRoaming() {
		return mmsinviatiRoaming;
	}


	public void setMmsinviatiRoaming(String mmsinviatiRoaming) {
		this.mmsinviatiRoaming = mmsinviatiRoaming;
	}


	public String getMmsinviatiVsLA() {
		return mmsinviatiVsLA;
	}


	public void setMmsinviatiVsLA(String mmsinviatiVsLA) {
		this.mmsinviatiVsLA = mmsinviatiVsLA;
	}


	public String getMmsricevutoDaLA() {
		return mmsricevutoDaLA;
	}


	public void setMmsricevutoDaLA(String mmsricevutoDaLA) {
		this.mmsricevutoDaLA = mmsricevutoDaLA;
	}


	public String getMmsricevutoTIMPrime() {
		return mmsricevutoTIMPrime;
	}


	public void setMmsricevutoTIMPrime(String mmsricevutoTIMPrime) {
		this.mmsricevutoTIMPrime = mmsricevutoTIMPrime;
	}


	public String getRcs() {
		return rcs;
	}


	public void setRcs(String rcs) {
		this.rcs = rcs;
	}


	public String getServiziContenutoWAP() {
		return serviziContenutoWAP;
	}


	public void setServiziContenutoWAP(String serviziContenutoWAP) {
		this.serviziContenutoWAP = serviziContenutoWAP;
	}


	public String getWap() {
		return wap;
	}


	public void setWap(String wap) {
		this.wap = wap;
	}


	public String getWapevento() {
		return wapevento;
	}


	public void setWapevento(String wapevento) {
		this.wapevento = wapevento;
	}



	
	
	public static Dati getDati(boolean sms, boolean fonia, boolean dati, boolean contentService) {
		Dati instance = new Dati();
		
		String smsFlag = "N";
		if(sms) {
			smsFlag = "Y";
		}
		
		String contentServiceFlag = "N";
		if(contentService) {
			contentServiceFlag = "Y";
		}

		String datiFlag = "N";
		if(dati) {
			datiFlag = "Y";
		}
		
		String foniaFlag = "N";
		if(fonia) {
			foniaFlag = "Y";
		}
		
		
		//N
		instance.setMmsentranti("N");
		
		instance.setWap(datiFlag);
		instance.setGprs(datiFlag);
		instance.setGprsestero(datiFlag);
		instance.setWapevento(datiFlag);
		instance.setGprsevento(datiFlag);
		instance.setRcs(datiFlag);

		instance.setCamel(foniaFlag);
		
		instance.setMmsinviati(smsFlag);
		instance.setMmsinviatiRoaming(smsFlag);

		instance.setMmsinviatiVsLA(contentServiceFlag);
		instance.setMmsentrantiDaLA(contentServiceFlag);
		instance.setServiziContenutoWAP(contentServiceFlag);
		instance.setMmsricevutoDaLA(contentServiceFlag);
		instance.setMmsricevutoTIMPrime(contentServiceFlag);
		
		
		return instance;
	}
	
}