package it.eng.tim.costi.integration.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import it.eng.tim.costi.model.integration.sdp.npat.QueryRiepilogoCostiBean;
import it.eng.tim.costi.model.integration.sdp.npat.StatisticheTrafficoTOTResponse;


@FeignClient(
        name="sdp-npat",
        url = "${costi.integration.sdp-npat-base-path}"
)
public interface SDPClientForNPAT {

	
    @PostMapping("/clienti/{rifCliente}/consistenze/{numLinea}/statisticheTrafficoTOT")
    ResponseEntity<StatisticheTrafficoTOTResponse> getStatisticheTrafficoTOT(@PathVariable("rifCliente") String rifCliente,
    		@PathVariable("numLinea") String msisdn,
    		@RequestBody QueryRiepilogoCostiBean requestBean,
    		@RequestHeader HttpHeaders headers);


}
