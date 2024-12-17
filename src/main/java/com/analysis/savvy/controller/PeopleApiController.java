package com.analysis.savvy.controller;

import com.analysis.savvy.service.PeopleApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@Controller  // Use @Controller for rendering HTML pages and nor RestController
@RequestMapping("/v1")
public class PeopleApiController {

    @Autowired
    private PeopleApiService peopleApiService;

    // Serve the form page (people.html)
    @GetMapping("/get-info")
    public String getPersonInfoPage() {
        return "people"; // Renders people.html
    }

    // API endpoint to fetch information with bearerToken and gpid
    @RestController
    @RequestMapping("/v1")
    public class PeopleApiRestController {
        @Autowired
        private PeopleApiService peopleApiService;

        @GetMapping("/fetch-info")
        public ResponseEntity<String> fetchPersonInfo(
                @RequestParam String bearerToken,
                @RequestParam String gpid
        ) {
            try {
                String response = peopleApiService.callApiWithBearerTokenAndId(bearerToken, gpid);
                return ResponseEntity.ok(response); // Return the API response as plain text
            } catch (Exception e) {
                return ResponseEntity.status(500).body("Error: " + e.getMessage()); // Return error message
            }
        }
    }
}
