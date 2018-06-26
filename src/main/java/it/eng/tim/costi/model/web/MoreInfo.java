package it.eng.tim.costi.model.web;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder({ "id", "label", "value", "info" })
public class MoreInfo implements Comparable<MoreInfo>{

	
    @ApiModelProperty(notes = "Identificativo del dettaglio" , example = "CAT03V")
    private String id;

    @ApiModelProperty(notes = "Tipologia di dettaglio" , example = "Voce")
    private String label;    
    
    @ApiModelProperty(notes = "Valore del dettaglio. Formato (+/-)##,00 Numerico con due cifre decimali e segno" , example = "+ 75,00")
    private String value;    
    
    @ApiModelProperty(notes = "Informativa associata al dettaglio" , example = "100 min")
    private String details;

    @JsonIgnore
    private int order;
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
    public int compareTo(MoreInfo compare) {
		return this.order - compare.getOrder();
    }

	@Override
	public String toString() {
		return "MoreInfo [id=" + id + ", label=" + label + ", value=" + value + ", details=" + details + ", order="
				+ order + "]";
	}
}
