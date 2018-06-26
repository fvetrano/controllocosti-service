package it.eng.tim.costi.model.integration.sdp.npat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"commonData",
	"queryGroup"
})

public class QueryRiepilogoCostiBean {

	@JsonProperty("commonData")
	private CommonData commonData;
	@JsonProperty("queryGroup")
	private QueryGroup queryGroup;
	


	public CommonData getCommonData() {
		return commonData;
	}


	public void setCommonData(CommonData commonData) {
		this.commonData = commonData;
	}


	public QueryGroup getQueryGroup() {
		return queryGroup;
	}


	public void setQueryGroup(QueryGroup queryGroup) {
		this.queryGroup = queryGroup;
	}

	
	


}
