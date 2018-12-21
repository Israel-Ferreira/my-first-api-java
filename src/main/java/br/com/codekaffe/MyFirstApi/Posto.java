package br.com.codekaffe.MyFirstApi;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Posto {

    @Id
    private String id;


    private String nomeDoPosto;
    private String endereco;

    private String latitude;
    private String longitude;

    public Posto(){}

    public Posto(String nomeDoPosto, String endereco, String latitude, String longitude) {
        this.nomeDoPosto = nomeDoPosto;
        this.endereco = endereco;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }


    public String getNomeDoPosto() {
        return nomeDoPosto;
    }


    public String getEndereco() {
        return endereco;
    }


    public String getLatitude() {
        return latitude;
    }


    public String getLongitude() {
        return longitude;
    }


    public void setNomeDoPosto(String nomeDoPosto) {
        this.nomeDoPosto = nomeDoPosto;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posto posto = (Posto) o;
        return Objects.equals(id, posto.id) &&
                Objects.equals(nomeDoPosto, posto.nomeDoPosto) &&
                Objects.equals(endereco, posto.endereco) &&
                Objects.equals(latitude, posto.latitude) &&
                Objects.equals(longitude, posto.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeDoPosto, endereco, latitude, longitude);
    }


    @Override
    public String toString() {
        return "Posto {" +
                "id='" + id + '\'' +
                ", nomeDoPosto='" + nomeDoPosto + '\'' +
                ", endereco='" + endereco + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }

}
