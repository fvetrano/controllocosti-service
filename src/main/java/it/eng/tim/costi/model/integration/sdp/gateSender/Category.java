package it.eng.tim.costi.model.integration.sdp.gateSender;

public class Category {

	private String categoryId;
	private String categoryDescription;
	private double totalCost;
	
	
	
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryDescription=" + categoryDescription + ", totalCost="
				+ totalCost + "]";
	}

	
	
	
	
	
}
