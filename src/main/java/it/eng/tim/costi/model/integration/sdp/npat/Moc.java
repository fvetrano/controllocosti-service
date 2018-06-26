package it.eng.tim.costi.model.integration.sdp.npat;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"moc916",
	"moctariffatoInt",
	"moctariffatoNaz",
	"voltetariffatoInt",
	"voltetariffatoNaz"
})
public class Moc {

	@JsonProperty("moc916")
	private String moc916;
	@JsonProperty("moctariffatoInt")
	private String moctariffatoInt;
	@JsonProperty("moctariffatoNaz")
	private String moctariffatoNaz;
	@JsonProperty("voltetariffatoInt")
	private String voltetariffatoInt;
	@JsonProperty("voltetariffatoNaz")
	private String voltetariffatoNaz;
	


	public String getMoc916() {
		return moc916;
	}


	public void setMoc916(String moc916) {
		this.moc916 = moc916;
	}


	public String getMoctariffatoInt() {
		return moctariffatoInt;
	}


	public void setMoctariffatoInt(String moctariffatoInt) {
		this.moctariffatoInt = moctariffatoInt;
	}


	public String getMoctariffatoNaz() {
		return moctariffatoNaz;
	}


	public void setMoctariffatoNaz(String moctariffatoNaz) {
		this.moctariffatoNaz = moctariffatoNaz;
	}


	public String getVoltetariffatoInt() {
		return voltetariffatoInt;
	}


	public void setVoltetariffatoInt(String voltetariffatoInt) {
		this.voltetariffatoInt = voltetariffatoInt;
	}


	public String getVoltetariffatoNaz() {
		return voltetariffatoNaz;
	}


	public void setVoltetariffatoNaz(String voltetariffatoNaz) {
		this.voltetariffatoNaz = voltetariffatoNaz;
	}


	
	public static Moc getMoc(boolean fonia) {
		Moc instance = new Moc();
		
		String foniaFlag = "N";
		if(fonia) {
			foniaFlag = "Y";	
		}
		
		instance.setMoctariffatoNaz(foniaFlag);
		instance.setMoctariffatoInt(foniaFlag);
		instance.setMoc916("N");
		instance.setVoltetariffatoInt(foniaFlag);
		instance.setVoltetariffatoNaz(foniaFlag);
		
		
		return instance;
	}
	
	
}