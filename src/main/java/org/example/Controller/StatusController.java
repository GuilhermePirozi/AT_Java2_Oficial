package org.example.Controller;

import io.javalin.http.Context;
import java.time.LocalDateTime;
import java.util.Map;

public class StatusController {

    public static void getStatus(Context context) {
            String timestamp = LocalDateTime.now().toString();
            context.json(Map.of(
                    "status", "ok",
                    "timestamp", timestamp
            ));
        }
}


