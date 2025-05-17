package org.example.botreminder.scheduler;

import com.google.gson.Gson;
import org.example.botreminder.dto.send.MessageSendDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

@Component
@PropertySource("classpath:bot.properties")
public class CustomBotClient {
    private static final Logger logger = LoggerFactory.getLogger(CustomBotClient.class);
    private static final String SSL_PROTOCOL = "TLS";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String APPLICATION_JSON = "application/json";
    private static final String SEND_MESSAGE_ENDPOINT = "/sendMessage";
    private static final String GET_UPDATES_MESSAGE_ENDPOINT = "/getUpdates";

    private final String botBaseUrl;
    private final String botChatId;
    private final HttpClient client;
    private final Gson gson = new Gson();

    public CustomBotClient(
            @Value("${bot.url}") String botBaseUrl,
            @Value("${bot.chat.id}") String botChatId) {
        this.botBaseUrl = botBaseUrl;
        this.botChatId = botChatId;
        this.client = createHttpClient();
    }

    public void sendMessage(String messageText) {
        var message = new MessageSendDto(botChatId, messageText);
        String jsonMessage = gson.toJson(message);
        logger.info("JsonMessage = {}", jsonMessage);

        var request = HttpRequest.newBuilder()
                .uri(URI.create(botBaseUrl + SEND_MESSAGE_ENDPOINT))
                .header(CONTENT_TYPE_HEADER, APPLICATION_JSON)
                .POST(HttpRequest.BodyPublishers.ofString(jsonMessage))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            logger.info("Telegram API response: {}", response.body());
        } catch (IOException | InterruptedException e) {
            logger.error("Failed to send message to Telegram API", e);
        }
    }

    public String getUpdates() {

        logger.info("Sending request to get updates");

        var request = HttpRequest.newBuilder()
                .uri(URI.create(botBaseUrl + GET_UPDATES_MESSAGE_ENDPOINT))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            logger.info("Telegram API response: {}", response.body());
            return response.body();
        } catch (IOException | InterruptedException e) {
            logger.error("Failed to get messageUpdates from Telegram API", e);
        }
        return null;
    }


    private HttpClient createHttpClient() {
        try {
            SSLContext sslContext = createTrustAllSslContext();
            return HttpClient.newBuilder()
                    .sslContext(sslContext)
                    .build();
        } catch (RuntimeException e) {
            logger.error("Failed to initialize HTTP client", e);
            throw e;
        }
    }

    private SSLContext createTrustAllSslContext() {
        try {
            SSLContext sslContext = SSLContext.getInstance(SSL_PROTOCOL);
            sslContext.init(null, createTrustAllManagers(), new java.security.SecureRandom());
            return sslContext;
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            logger.error("Failed to create SSL context", e);
            throw new RuntimeException("SSL context initialization failed", e);
        }
    }

    private TrustManager[] createTrustAllManagers() {
        return new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }

                    @Override
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        // Trust all clients
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        // Trust all servers
                    }
                }
        };
    }
}