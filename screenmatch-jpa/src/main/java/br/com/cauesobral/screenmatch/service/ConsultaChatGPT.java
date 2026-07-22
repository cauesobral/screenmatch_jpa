package br.com.cauesobral.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obterTraducao(String texto) {
        OpenAiService service = new OpenAiService("não vou dar commit com minha chave do chat, também não vou" +
                "colocar essa classe no .gitignore senão o código vai ficar incompleto, ent antes do push vou tirar a" +
                "chave da api da open ai daqui");

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduza para o português o texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();
        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}

