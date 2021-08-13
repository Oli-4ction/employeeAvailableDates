package academy.learnprogramming;

import academy.learnprogramming.model.NASAMedia;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WebService {

    public void performRequest() {
        try {
            NASAMedia nasaMedia = getRequest();
            processResponse(nasaMedia);
            postRequest(nasaMedia);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public NASAMedia getRequest() throws IOException, InterruptedException {

        // create a client
        var client = HttpClient.newHttpClient();

        // create a request
        var request = HttpRequest.newBuilder(
                        URI.create("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY"))
                .header("accept", "application/json")
                .build();

        // use the client to send the request
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        // the response:
        var jsonResponse= response.body();
        System.out.println(response.body());//.get().title);

        ObjectMapper objectMapper = new ObjectMapper();
        NASAMedia media = objectMapper.readValue(jsonResponse, NASAMedia.class);

        System.out.println("The title is: " + media.title);

        return media;
    }

    public void processResponse(NASAMedia mediaFile) {

    }

    public void postRequest(NASAMedia mediaFile) throws IOException, InterruptedException {

        // create a client
        var client = HttpClient.newHttpClient();

        // create a request
        var request = HttpRequest.newBuilder(
                        URI.create("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY"))
                .header("accept", "application/json")
                .POST(BodyPublishers.ofString(""))
                .build();

        // use the client to send the request
        HttpResponse<?> response = client.send(request, BodyHandlers.discarding());

        // the response:
        var statusCode= response.statusCode();
        System.out.println("Response code: " + (statusCode == 200));//.get().title);
    }
}
