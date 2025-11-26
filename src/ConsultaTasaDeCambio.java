import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaTasaDeCambio {
    public TipoDeCambio consultaApi(String base, String destino){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/2a5caf38d9c4f08111b948b2/pair/"+base+"/"+destino);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .GET()
                .build();
            try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), TipoDeCambio.class);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
