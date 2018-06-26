package it.eng.tim.costi.model.web;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "label", "value", "details" })
public class Movement implements Comparable<Movement> {

	
    @ApiModelProperty(notes = "Identificativo della categoria di Costo" , example = "CAT03", required = true)
    private String id;

    @ApiModelProperty(notes = "Tipologia di Costo" , example = "Consumi", required = true)
    private String label;    
    
    @ApiModelProperty(notes = "Valore della Categoria di Costo. Formato (+/-)##,00 Numerico con due cifre decimali e segno" , example = "+ 75,00", required = true)
    private String value;    
    
    @ApiModelProperty(notes = "Dettagli associati alla Categoria di Costo.", required = false)
    private List<MoreInfo> moreInfo;

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

	public List<MoreInfo> getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(List<MoreInfo> moreInfo) {
		this.moreInfo = moreInfo;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
    
	@Override
    public int compareTo(Movement compare) {
		return this.order - compare.getOrder();
    }

	@Override
	public String toString() {
		return "Movement [id=" + id + ", label=" + label + ", value=" + value + ", moreInfo=" + moreInfo + ", order="
				+ order + "]";
	}
}
