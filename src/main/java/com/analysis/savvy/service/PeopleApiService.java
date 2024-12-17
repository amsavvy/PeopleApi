package com.analysis.savvy.service;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class PeopleApiService {

    private final WebClient webClient ;

    public  PeopleApiService (WebClient.Builder webClinetBuilder ){

        //https://apim-pfna.mypepsico.com/flna/pgt/pcaf/v1/people/03301215/basic-info
        this.webClient = webClinetBuilder.baseUrl("https://apim-pfna.mypepsico.com/").build();
    }


    public String callApiWithBearerTokenAndId( String bearerToken, String gpid){

        // works
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("flna/pgt/pcaf/v1/people/{gpid}/basic-info").build(gpid))
                .headers( headers ->headers.setBearerAuth(bearerToken))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        //  works
//        return webClient.get()
//                .uri("/flna/pgt/pcaf/v1/people/{gpid}/basic-info", gpid) // Dynamic ID
//                .headers(headers -> headers.setBearerAuth(bearerToken)) // Authorization header
//                .retrieve()
//                .bodyToMono(String.class) // Read response as String
//                .block();

//  works
//        return webClient.get()
//                .uri("/flna/pgt/pcaf/v1/people/{gpid}/basic-info", gpid)
//                .headers(headers -> {
//                    headers.set("Authorization", "Bearer " + bearerToken);  // Use raw string for testing
//                })
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();

        // works
//        return webClient.get()
//                .uri("/flna/pgt/pcaf/v1/people/{gpid}/basic-info", gpid)
//                .headers(headers -> {
//                    headers.setBearerAuth(bearerToken);
//                    System.out.println("Headers: " + headers.toString());  // Log headers for debugging
//                })
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();

//works
//        return webClient.get()
//                .uri("/flna/pgt/pcaf/v1/people/{gpid}/basic-info", gpid)
//                .headers(headers -> {
//                    headers.set("Authorization", "Bearer " + bearerToken);  // Use raw string for testing
//                })
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();


        //works
//        return webClient.get()
//                .uri("/flna/pgt/pcaf/v1/people/{gpid}/basic-info", gpid) // Dynamic ID
//                .header("Authorization", "Bearer " + bearerToken) // Add Authorization header This should work same as .header(HttpHeaders.AUTHORIZATION, "Bearer " + bearerToken)
//                .retrieve()
//                .bodyToMono(String.class) // Convert response to String
//                .block(); // Block to get the result (not reactive)



// works
//        return webClient.get()
//                .uri("/flna/pgt/pcaf/v1/people/{gpid}/basic-info", gpid) // Dynamic ID
//                .header(HttpHeaders.AUTHORIZATION, "Bearer " + bearerToken)
//                .retrieve()
//                .bodyToMono(String.class) // Convert response to String
//                .block(); // Block to get the result (not reactive)

    }




}
