package si.um.feri.banka;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestClientJEEDemo {
	                                         
    static final URI PEOPLE_URI = URI.create("http://localhost:8080/my-rest-sample-project/api/people/");

    HttpClient client = HttpClient.newBuilder().build();
    Jsonb jsonb= JsonbBuilder.create();

    void allPeople() throws Exception {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(PEOPLE_URI).build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    void add(Person o) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(jsonb.toJson(o)))
                .header("Content-Type","application/json")
                .uri(PEOPLE_URI)
                .build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.discarding());
        System.out.println(response.body());
    }

    public static void main(String[] args) throws Exception {
        RestClientJEEDemo client=new RestClientJEEDemo();
        client.add(new Person("martin@krpan.si","Martin","Krpan"));
        client.allPeople();
    }

}
