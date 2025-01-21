package com.alura.literalura.client;

import com.alura.literalura.entity.book;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GutendexClient {

    private static final String BASE_URL = "https://gutendex.com/books?search=";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public GutendexClient() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    public book fetchBookByTitle(String title) {
        try {
            String url = BASE_URL + title.replace(" ", "+");
            String response = restTemplate.getForObject(url, String.class);
            JsonNode root = objectMapper.readTree(response);

            if (root.has("results") && root.get("results").isArray()) {
                JsonNode firstResult = root.get("results").get(0);
                book book = new book();
                book.setTitle(firstResult.get("title").asText());
                book.setLanguage(firstResult.get("languages").get(0).asText());
                book.setDownloads(firstResult.get("download_count").asInt());
                return book;
            }
        } catch (Exception e) {
            System.err.println("Error al consumir la API de Gutendex: " + e.getMessage());
        }
        return null;
    }
}
