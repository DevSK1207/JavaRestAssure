package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Properties;


public class Api {

    private String baseUrl;

    public Api() {
        Properties prop = new Properties();
        try {
            prop.load(getClass().getClassLoader().getResourceAsStream("Url.properties"));
            baseUrl = prop.getProperty("BASE_URL");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getbaseUrl() {
        return baseUrl;
    }


    //private String endpoint = "https://reqres.in/api/users";

    public Response getUsers() {
        System.out.println("Base URL: " + getbaseUrl());
        return RestAssured.given()
                .header("Authorization", "Bearer ")
                .get(getbaseUrl());
    }

    public Response getUser(int userId) {
        System.out.println("Base URL: " + getbaseUrl());
        return RestAssured.given()
                .header("Authorization", "Bearer ")
                .get(getbaseUrl() + "/" + userId);

    }

    public Response createUser(String name, String job) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{\"name\":\"" + name + "\",\"job\":\"" + job + "\"}")
                .post(getbaseUrl());
    }

    public Response updateUser(int userId, String name, String job) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{\"name\":\"" + name + "\",\"job\":\"" + job + "\"}")
                .put(getbaseUrl() + "/" + userId);
    }

    public Response deleteUser(int userId) {
        return RestAssured.given()
                .delete(baseUrl + "/" + userId);
    }
}