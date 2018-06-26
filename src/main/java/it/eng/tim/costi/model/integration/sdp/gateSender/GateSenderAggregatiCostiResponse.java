package it.eng.tim.costi.model.integration.sdp.gateSender;

import java.util.*;

public class GateSenderAggregatiCostiResponse {

	
	private String esito;
	private ErrorResponse errorResponse;
	
	private List<Category> categoryList;
	private List<EventFt> eventFtList;
	
	
	
	public String getEsito() {
		return esito;
	}
	public void setEsito(String esito) {
		this.esito = esito;
	}
	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}
	public void setErrorResponse(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}
	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	public List<EventFt> getEventFtList() {
		return eventFtList;
	}
	public void setEventFtList(List<EventFt> eventFtList) {
		this.eventFtList = eventFtList;
	}
	
	
	
	
}
