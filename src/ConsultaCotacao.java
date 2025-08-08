import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCotacao {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        System.out.println("\nCOTAÇÃO MOEDAS FIDUCIÁRIAS (em relação ao REAL):");

        String enderecoMoedas = "https://economia.awesomeapi.com.br/json/last/USD-BRL,EUR-BRL,GBP-BRL";
        HttpRequest requestMoedas = HttpRequest.newBuilder().uri(URI.create(enderecoMoedas)).build();
        HttpResponse<String> responseMoedas = client.send(requestMoedas, HttpResponse.BodyHandlers.ofString());

        JsonObject jsonMoedas = JsonParser.parseString(responseMoedas.body()).getAsJsonObject();

        String[] codigosMoedas = {"USDBRL", "EURBRL", "GBPBRL"};
        String[] nomesMoedas = {"Dólar Americano", "Euro", "Libra Esterlina"};

        for (int i = 0; i < codigosMoedas.length; i++) {
            JsonObject info = jsonMoedas.getAsJsonObject(codigosMoedas[i]);
            double valor = info.get("bid").getAsDouble();
            System.out.printf("💵 %-18s R$ %.2f\n", nomesMoedas[i], valor);
        }

        System.out.println("\nCOTAÇÃO DAS 10 PRINCIPAIS CRIPTOMOEDAS (em relação ao REAL):");

        String[] criptosIds = {
                "bitcoin", "ethereum", "tether", "binancecoin", "solana",
                "ripple", "usd-coin", "cardano", "dogecoin", "tron"
        };

        String[] criptosNomes = {
                "Bitcoin", "Ethereum", "Tether", "BNB", "Solana",
                "XRP", "USD Coin", "Cardano", "Dogecoin", "TRON"
        };

        String ids = String.join(",", criptosIds);
        String enderecoCripto = "https://api.coingecko.com/api/v3/simple/price?ids=" + ids + "&vs_currencies=brl";

        HttpRequest requestCripto = HttpRequest.newBuilder().uri(URI.create(enderecoCripto)).build();
        HttpResponse<String> responseCripto = client.send(requestCripto, HttpResponse.BodyHandlers.ofString());

        JsonObject jsonCripto = JsonParser.parseString(responseCripto.body()).getAsJsonObject();

        for (int i = 0; i < criptosIds.length; i++) {
            double valor = jsonCripto.getAsJsonObject(criptosIds[i]).get("brl").getAsDouble();
            System.out.printf("🪙 %-10s R$ %.2f\n", criptosNomes[i], valor);
        }
    }
}
