package it.eng.tim.costi.web.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;

import it.eng.tim.costi.integration.proxy.SDPProxy;
import it.eng.tim.costi.model.configuration.ApplicationConfiguration;
import it.eng.tim.costi.model.exception.BadRequestException;
import it.eng.tim.costi.model.integration.sdp.npat.CommonData;
import it.eng.tim.costi.model.integration.sdp.npat.QueryGroup;
import it.eng.tim.costi.model.integration.sdp.npat.QueryRiepilogoCostiBean;
import it.eng.tim.costi.model.integration.sdp.npat.StatisticheTrafficoTOTResponse;
import it.eng.tim.costi.model.web.ControlloCostiRequest;
import it.eng.tim.costi.model.web.MoreInfo;
import it.eng.tim.costi.model.web.Movement;
import it.eng.tim.costi.model.web.PeriodType;
import it.eng.tim.costi.service.ControlloCostiService;
import it.eng.tim.costi.util.DateRange;
import it.eng.tim.costi.web.ControlloCostiController;


@RunWith(MockitoJUnitRunner.class)
//Tested as in-service integration test
public class ControlloCostiControllerTest {

    @Mock
    SDPProxy sdpProxy;


    @Mock
    ApplicationConfiguration configuration;
    ControlloCostiController controller;


    private ControlloCostiService service;
    
    
    
    @Before
    public void init(){
        service = new ControlloCostiService(sdpProxy);
        controller = new ControlloCostiController(service, configuration);
    }

    @After
    public void cleanup(){
        Mockito.reset(sdpProxy, configuration);
    }


    
    @Test(expected = BadRequestException.class)
    public void getPersonalInfoKoOnInvalidRequest() throws Exception {
        controller.getMovementsAggregati(null, null, null, null, null, null, null, null, null);
    }

    @Test(expected = BadRequestException.class)
    public void getPersonalInfoKoOnInvalidRequest2() throws Exception {
        controller.getMovementsAggregati(null, "", null, null, null, null, null, null, null);
    }
    
    @Test(expected = BadRequestException.class)
    public void getPersonalInfoKoOnInvalidRequest3() throws Exception {
    	
        controller.getMovementsAggregati(null, "", null, null, null, null, null, null, new ControlloCostiRequest());
    }

    @Test(expected = BadRequestException.class)
    public void getPersonalInfoKoOnInvalidRequest4() throws Exception {
        controller.getMovementsAggregati(null, null, null, null, null, null, null, null, new ControlloCostiRequest());
    }

    @Test(expected = BadRequestException.class)
    public void getPersonalInfoKoOnInvalidRequest5() throws Exception {
        controller.getMovementsAggregati(null, "", null, null, null, null, null, null, new ControlloCostiRequest());
    }

    @Test(expected = BadRequestException.class)
    public void getPersonalInfoKoOnInvalidRequest6() throws Exception {
        controller.getMovementsAggregati(null, null, null, null, null, null, null, null, new ControlloCostiRequest());
    }

    @Test(expected = BadRequestException.class)
    public void getPersonalInfoKoOnInvalidRequest7() throws Exception {
        controller.getMovementsAggregati(null, "", null, null, null, null, null, null, new ControlloCostiRequest());
    }

    @Test(expected = BadRequestException.class)
    public void getPersonalInfoKoOnInvalidRequest8() throws Exception {
        controller.getMovementsAggregati(null, null, null, null, null, null, null, null, new ControlloCostiRequest());
    }


    @Test
    public void test10() throws Exception {
    	ControlloCostiRequest req = new ControlloCostiRequest();
    	req.setPeriod(PeriodType.PROF10);
    	
    	StatisticheTrafficoTOTResponse resp = new  StatisticheTrafficoTOTResponse();
    	
    	assertNull(resp.getCommonDataType());
    	assertNull(resp.getStatisticheCostiTOTBean());
    	
    }

    @Test
    public void test11() throws Exception {


    	QueryRiepilogoCostiBean requestBean = buildQueryFullForNPAT("","");
    	
    	assertNotNull(requestBean);
    	assertNotNull(requestBean.getQueryGroup());
    	assertNotNull(requestBean.getQueryGroup().getMtchz());
    	assertNotNull(requestBean.getQueryGroup().getMtcopsc());
    	
    	assertNotNull(requestBean.getQueryGroup().getSms());
    	assertNotNull(requestBean.getQueryGroup().getSms().getSmsentranti());
    	assertNotNull(requestBean.getQueryGroup().getSms().getSmsesteroInviato());
    	assertNotNull(requestBean.getQueryGroup().getSms().getSmsinviatiITZ());
    	
    	assertNotNull(requestBean.getQueryGroup().getSms().getSmsesteroRicevuto());
    	assertNotNull(requestBean.getQueryGroup().getSms().getSmsinviati());		
    	assertNotNull(requestBean.getQueryGroup().getSms().getSmsnazinviatiVsLA());
    	assertNotNull(requestBean.getQueryGroup().getSms().getSmsnazricevutiDaLA());
    	assertNotNull(requestBean.getQueryGroup().getSms().getSmsnotifica());
    	
    	assertNotNull(requestBean.getQueryGroup().getRoaming());
    	assertNotNull(requestBean.getQueryGroup().getRoaming().getRoamingCCRMTC());
    	assertNotNull(requestBean.getQueryGroup().getRoaming().getRoamingCCRMOC());
    	assertNotNull(requestBean.getQueryGroup().getRoaming().getRoamingCCRRCF());
    	assertNotNull(requestBean.getQueryGroup().getRoaming().getRoamingOPSCPPITZ());

    	
    	
    }
    
    @Test
    public void test12() throws Exception {
    	Movement mov = new Movement();
    	assertNotNull(mov);
    	assertNull(mov.getId());
    	assertNull(mov.getLabel());
    	assertNull(mov.getMoreInfo());
    	
    	MoreInfo mi = new MoreInfo();
    	assertNotNull(mi);
    	assertNull(mi.getDetails());
    	assertNull(mi.getId());
    	assertNull(mi.getLabel());
    	assertNull(mi.getValue());
    	
    }

    private HttpHeaders getValidHttpHeaders() {
    	HttpHeaders headers = new HttpHeaders();
    	
    	headers.add("sessionJWT", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsImlzcyI6Imh0dHBzOi8vZHQtcy1hcGlndzAxLnRlbGVjb21pdGFsaWEubG9jYWw6ODQ0MyJ9.ew0KCSJ1c2VyQWNjb3VudCI6ICJwcmltZTFAdGltLml0IiwNCgkiY2ZfcGl2YSI6ICJaSk9SSkE2MkQyMUwyMTlQIiwNCgkiZGNhQ29vY2tpZSI6ICJaamRqWldRNFlXVXRORFV3TVMwME1HTmxMV0psWkdNdFlURXhabVZtT1RWbFpESm1YMTlmUkVOQlZWUklYMEZWVkVoZlEwOVBTMGxGWDE5ZkxuUnBiUzVwZEE9PSIsDQoJImFjY291bnRUeXBlIjogIkFDQ09VTlRfVU5JQ08iDQp9.t0dJFeFFF5v2FHZkI7y2ALqg4iAGav2_XSqFYzIFpOk");
    	
    	return headers;
    }
    
    
    
    private QueryRiepilogoCostiBean buildQueryFullForNPAT(String start, String end) {
    	QueryRiepilogoCostiBean request = new QueryRiepilogoCostiBean();
    	
    	CommonData commonData = new CommonData();
    	
    	commonData.setDataInizio(start );
    	commonData.setDataFine(end );
    	
    	// ???
    	commonData.setOperatore("OP1");
    	commonData.setSubSys("SUBSYS");
    	
    	request.setCommonData(commonData);
    	
    	QueryGroup queryGroup = QueryGroup.buildAllTrafficQueryGroup();
    	
    	request.setQueryGroup(queryGroup);
    	
    	return request;
    	
    }
    
}