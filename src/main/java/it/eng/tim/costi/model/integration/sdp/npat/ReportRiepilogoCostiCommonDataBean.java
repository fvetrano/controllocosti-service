package it.eng.tim.costi.model.integration.sdp.npat;

public class ReportRiepilogoCostiCommonDataBean {

	
	/** I possibili valori sono: -130, -503, -504, -505, -506, -509, -512, -799 */
	private int codErr;
	
	/** -130 Nessuna informazione (dati non presenti in tabella)
		-503 Date non coerenti
		-504 Intervallo di ricerca fuori range (supera gli n mesi)
		-505 Intervallo di estrazione fuori range (supera gli n giorni)
		-506 Nessun filtro impostato (deve essere selezionata almeno una tipologia di traffico)
		-509 Subsys sconosciuto
		-512 Numero presente nella Black List
		-799 Errore Interno
		*/
	private String descrErr;
	
	private String msisdnInterrogato;
	
	private String subSys;

	
	
	public int getCodErr() {
		return codErr;
	}

	public void setCodErr(int codErr) {
		this.codErr = codErr;
	}

	public String getDescrErr() {
		return descrErr;
	}

	public void setDescrErr(String descrErr) {
		this.descrErr = descrErr;
	}

	public String getMsisdnInterrogato() {
		return msisdnInterrogato;
	}

	public void setMsisdnInterrogato(String msisdnInterrogato) {
		this.msisdnInterrogato = msisdnInterrogato;
	}

	public String getSubSys() {
		return subSys;
	}

	public void setSubSys(String subSys) {
		this.subSys = subSys;
	}

	
	
	
}
