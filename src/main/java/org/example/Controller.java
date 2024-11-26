package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/home")
    public String getHomePage() {
        return """
            <html>
            <head>
                <title>Petitions Web App</title>
            </head>
            <body>
                <h1>Welcome to the Petitions Web App</h1>
                <p>Here, you can create, view, search, and sign petitions.</p>
                <p>Stay tuned as we build out the functionality!</p>
            </body>
            </html>
            """;
    }
}

