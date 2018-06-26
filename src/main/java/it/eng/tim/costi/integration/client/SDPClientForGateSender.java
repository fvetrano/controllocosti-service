package it.eng.tim.costi.integration.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import it.eng.tim.costi.model.integration.sdp.gateSender.GateSenderAggregatiCostiResponse;


@FeignClient(
        name="sdp-gatesender",
        url = "${costi.integration.sdp-gs-base-path}"
)
public interface SDPClientForGateSender {

    @GetMapping("/clienti/{rifCliente}/consistenze/{numLinea}/estrattoConto/aggregatiCosti")
    ResponseEntity<GateSenderAggregatiCostiResponse> getAggregatiCosti(@PathVariable("rifCliente") String rifCliente,
    		@PathVariable("numLinea") String msisdn,
    		@RequestParam(value="codiceOperazione") String codiceOperazione,
    		@RequestParam(value="clientType") String clientType,
    		@RequestParam(value="profonditaRichiesta") String profonditaRichiesta,
    		@RequestHeader HttpHeaders headers);


}
