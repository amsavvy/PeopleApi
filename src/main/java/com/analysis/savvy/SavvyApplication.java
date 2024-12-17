package com.analysis.savvy;

import com.analysis.savvy.service.PeopleApiService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Scanner;

@SpringBootApplication
public class SavvyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SavvyApplication.class, args);

		Scanner scanner = new Scanner(System.in);


		PeopleApiService peopleApiService = new PeopleApiService(WebClient.builder());

		while (true) {
			System.out.println("Input Bearer Token or hit 'q' to exit ");
			String bearerToken = scanner.nextLine();
			//String bearerToken = "eyJraWQiOiJUZ29wb3hZamNqRzBDYVpvZEtjSjFma0VhOUhYMUs3MGF5dThETGxNc0ljIiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULlctSTlDWlluLVdzWTdVQjlpRUR5QW1ma3U5MC1WRWE5cVpaSjRldUM4S0UiLCJpc3MiOiJodHRwczovL3NlY3VyZS5wZXBzaWNvLmNvbS9vYXV0aDIvYXVzMWxqeHB2M3o5RzhOR2wwaDgiLCJhdWQiOiJDcmVhdGVkIGZvciBwb3J0YWwiLCJpYXQiOjE3MzQyOTE2MjQsImV4cCI6MTczNDI5NTIyNCwiY2lkIjoiMG9hMW4yMnRqM2VaMXJseXgwaDgiLCJ1aWQiOiIwMHUxaHR4cG54MXg5T0JrVDBoOCIsInNjcCI6WyJwZXBSZWdpc3RlcmVkIiwicHJvZmlsZSIsIm9wZW5pZCIsImVtYWlsIl0sImF1dGhfdGltZSI6MTczNDI4ODA1Mywic3ViIjoiU0hBU0hXQVQuR1VQVEExLkNvbnRyYWN0b3JAcGVwc2ljby5jb20iLCJncGlkIjoiMDkyNTA5MDQiLCJGaXJzdE5hbWUiOiJTSEFTSFdBVCIsImRpc3BsYXluYW1lIjoiU0hBU0hXQVQgR1VQVEEiLCJwZXBSZWdpc3RlcmVkIjoiVFJVRSIsIkxhc3ROYW1lIjoiR1VQVEEiLCJsb2NhbGUiOiJVUyIsImVtYWlsIjoiU0hBU0hXQVQuR1VQVEExLkNvbnRyYWN0b3JAcGVwc2ljby5jb20ifQ.F-h9czciiK_SkFjpiw0HvSTZsyobmhP5cuksW6jOrY956V8zzeSWZsv1z8wUVECOQOSj6UrICEcfyJJ3NRSR3t_IkLfiG9sPVoL7xLvpqQm3fnaD7YaoTL_F4uKSVKFuSkmWQ2IehMCw2okXOApsA2B5KUL5Ne5DNTpvWqTlB5NV1NZsGt_MH_-ZMF6pgSsHYqRhLw2MIu55PDRSohwtG98x8U_T2j-WDLSGHtLW3YJNtDNlGtEGaEQyH5oVDAWawQTEM6NUxpo61DxgjuBxBM75Ix4UyeIbBSQp8u_9Pfbo99Pw05iLqXcMdCE2fdxXDHwPQ39FCXN-DtLWeytgew";
			if (bearerToken.equalsIgnoreCase("Q")) {
				System.out.println("Application has stopped");
				break;
			}


			System.out.println("Input gpid");
			String gpid = scanner.nextLine();
			// String gpid = "03301215"; //

			//	String response = peopleApiService.callApiWithBearerTokenAndId(bearerToken, gpid);
			//System.out.println("Response: " + response);

			try {
				String response = peopleApiService.callApiWithBearerTokenAndId(bearerToken, gpid);
				System.out.println("Response: " + response);
			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			}

		}
			scanner.close();
	}
}

