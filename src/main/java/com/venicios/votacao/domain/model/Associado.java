package com.venicios.votacao.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Associado {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @Column(name="cpf" , nullable = false,unique = true)
    private String cpf;

    private boolean votou; // novo atributo

    @OneToMany(mappedBy = "associado")
    private List<Voto> votos;


    public boolean podeVotar(String cpf) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("https://user-info.herokuapp.com/users/" + cpf);

        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            if (response.getStatusLine().getStatusCode() == 404) {
                return false;
            }

            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);

            return result.equals("ABLE_TO_VOTE");
        } catch (IOException e) {
            // tratar exceção
        }
        return false;
    }
}


