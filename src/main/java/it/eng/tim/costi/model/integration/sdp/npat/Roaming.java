package it.eng.tim.costi.model.integration.sdp.npat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"roamingCCRMOC",
	"roamingCCRMTC",
	"roamingCCRRCF",
	"roamingOPSCPPITZ",
	"roamingOPSCRCF"
})
public class Roaming {

	@JsonProperty("roamingCCRMOC")
	private String roamingCCRMOC;
	@JsonProperty("roamingCCRMTC")
	private String roamingCCRMTC;
	@JsonProperty("roamingCCRRCF")
	private String roamingCCRRCF;
	@JsonProperty("roamingOPSCPPITZ")
	private String roamingOPSCPPITZ;
	@JsonProperty("roamingOPSCRCF")
	private String roamingOPSCRCF;


	
	public String getRoamingCCRMOC() {
		return roamingCCRMOC;
	}


	public void setRoamingCCRMOC(String roamingCCRMOC) {
		this.roamingCCRMOC = roamingCCRMOC;
	}


	public String getRoamingCCRMTC() {
		return roamingCCRMTC;
	}


	public void setRoamingCCRMTC(String roamingCCRMTC) {
		this.roamingCCRMTC = roamingCCRMTC;
	}


	public String getRoamingCCRRCF() {
		return roamingCCRRCF;
	}


	public void setRoamingCCRRCF(String roamingCCRRCF) {
		this.roamingCCRRCF = roamingCCRRCF;
	}


	public String getRoamingOPSCPPITZ() {
		return roamingOPSCPPITZ;
	}


	public void setRoamingOPSCPPITZ(String roamingOPSCPPITZ) {
		this.roamingOPSCPPITZ = roamingOPSCPPITZ;
	}


	public String getRoamingOPSCRCF() {
		return roamingOPSCRCF;
	}


	public void setRoamingOPSCRCF(String roamingOPSCRCF) {
		this.roamingOPSCRCF = roamingOPSCRCF;
	}


	
	public static Roaming getRoaming(boolean fonia) {
		Roaming instance = new Roaming();
		
		String foniaflag = "N";
		if(fonia) {
			foniaflag = "Y";
		}
		
		instance.setRoamingCCRMOC(foniaflag);
		instance.setRoamingCCRMTC(foniaflag);
		instance.setRoamingCCRRCF(foniaflag);
		instance.setRoamingOPSCPPITZ(foniaflag);
		instance.setRoamingOPSCRCF(foniaflag);
		
		return instance;
	}
}