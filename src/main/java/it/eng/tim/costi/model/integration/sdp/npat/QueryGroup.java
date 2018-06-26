package it.eng.tim.costi.model.integration.sdp.npat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"dati",
	"moc",
	"mtchz",
	"mtcopsc",
	"payForMe",
	"roaming",
	"sms",
	"vas",
	"voip",
	"wlan"
})
public class QueryGroup {

	@JsonProperty("dati")
	private Dati dati;
	@JsonProperty("moc")
	private Moc moc;
	@JsonProperty("mtchz")
	private String mtchz;
	@JsonProperty("mtcopsc")
	private String mtcopsc;
	@JsonProperty("payForMe")
	private String payForMe;
	@JsonProperty("roaming")
	private Roaming roaming;
	@JsonProperty("sms")
	private Sms sms;
	@JsonProperty("vas")
	private String vas;
	@JsonProperty("voip")
	private String voip;
	@JsonProperty("wlan")
	private String wlan;

	public Dati getDati() {
		return dati;
	}

	public void setDati(Dati dati) {
		this.dati = dati;
	}

	public Moc getMoc() {
		return moc;
	}

	public void setMoc(Moc moc) {
		this.moc = moc;
	}

	public String getMtchz() {
		return mtchz;
	}

	public void setMtchz(String mtchz) {
		this.mtchz = mtchz;
	}

	public String getMtcopsc() {
		return mtcopsc;
	}

	public void setMtcopsc(String mtcopsc) {
		this.mtcopsc = mtcopsc;
	}

	public String getPayForMe() {
		return payForMe;
	}

	public void setPayForMe(String payForMe) {
		this.payForMe = payForMe;
	}

	public Roaming getRoaming() {
		return roaming;
	}

	public void setRoaming(Roaming roaming) {
		this.roaming = roaming;
	}

	public Sms getSms() {
		return sms;
	}

	public void setSms(Sms sms) {
		this.sms = sms;
	}

	public String getVas() {
		return vas;
	}

	public void setVas(String vas) {
		this.vas = vas;
	}

	public String getVoip() {
		return voip;
	}

	public void setVoip(String voip) {
		this.voip = voip;
	}

	public String getWlan() {
		return wlan;
	}

	public void setWlan(String wlan) {
		this.wlan = wlan;
	}
	
	public static QueryGroup buildAllTrafficQueryGroup() {
		
		return buildQueryGroup(true,true,true,false);
	}

	
	public static QueryGroup buildQueryGroup(boolean fonia, boolean sms, boolean dati, boolean contentService) {

		QueryGroup instance = new QueryGroup();

		String flagContentService = "N";
		if(contentService) {
			flagContentService = "Y";
		}

		String flagDati = "N";
		if(dati) {
			flagDati = "Y";
		}
		
		String flagFonia = "N";
		if(fonia) {
			flagFonia = "Y";
		}

		//N
		instance.setMtcopsc("N");
		
		//content service
		instance.setVas(flagContentService);
		instance.setVoip(flagContentService);
		
		instance.setPayForMe(flagFonia);
		instance.setMtchz(flagFonia);
		instance.setWlan(flagDati);
		
		instance.setMoc(Moc.getMoc(true));
		instance.setSms(Sms.getSms(sms, contentService));
		instance.setDati(Dati.getDati(sms, fonia, dati, contentService));
		instance.setRoaming(Roaming.getRoaming(fonia));
		
		return instance;
	}

}