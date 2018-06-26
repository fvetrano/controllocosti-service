package it.eng.tim.costi.model.web;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

public class Section implements Comparable<Section> {

	@ApiModelProperty(notes = "Label della sezione", required = true)
	private String label;
	
    @ApiModelProperty(notes = "Movimenti associati alla richiesta.", required = true)
    private List<Movement> movements;
    
    @JsonIgnore
    private int order;

    
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Movement> getMovements() {
		return movements;
	}

	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
    
	@Override
    public int compareTo(Section compare) {
		
		return this.order - compare.getOrder();
		
    }

	
	@Override
	public String toString() {
		return "Section [label=" + label + ", movements=" + movements + ", order=" + order + "]";
	}
    
    
	
}
