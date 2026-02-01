package com.example.demo.controller;
import com.example.demo.dto.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;




@RestController
public class GreetingController {

    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(),template.formatted(name));
    }

    // 2. @PathVariable: Extracting ID from the URL
    // URL: GET /api/greeting/5
    // Use Case: Fetching a specific object by ID (Like Django: path('greeting/<int:id>'))
    @GetMapping("/greeting/{id}")
    public Greeting getSpecificGreeting(@PathVariable Long id) {
        return new Greeting(id, "Content for ID " + id);
    }

    // 3. @PostMapping + @RequestBody: Receiving JSON Data
    // URL: POST /api/greeting
    // Body: { "id": 99, "content": "Super Greeting" }
    // Use Case: Creating a new entry in a database.
    @PostMapping("/greeting")
    public String createGreeting(@RequestBody Greeting newGreeting) {
        // In a real app, you would save 'newGreeting' to the DB here.
        return "Saved greeting: " + newGreeting.content();
    }

    // 4. @PutMapping: Updating existing data
    // URL: PUT /api/greeting/5
    // Body: { "content": "Updated Content" }
    @PutMapping("/greeting/{id}")
    public Greeting updateGreeting(@PathVariable Long id, @RequestBody Greeting updatedData) {
        // We take the ID from the URL and the Content from the JSON body
        return new Greeting(id, "Updated to: " + updatedData.content());
    }

    // 5. @DeleteMapping: Deleting data
    // URL: DELETE /api/greeting/5
    @DeleteMapping("/greeting/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        return "Deleted greeting with ID: " + id;
    }




}