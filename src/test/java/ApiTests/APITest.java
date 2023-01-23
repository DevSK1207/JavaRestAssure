package ApiTests;

import API.Api;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;


public class APITest {

    Api userAPI = new Api();


    @Test
    public void testGetUsers() {
        Response response = userAPI.getUsers();
        int statusCode = response.getStatusCode();
        try {
            Assert.assertEquals(200, statusCode);
        } catch (AssertionError e) {
            System.out.println("Error: Expected status code 200 but received " + statusCode);
            Assert.fail("Assertion failed");

        }
    }

    @Test
    public void testGetUser() {
        Response response = userAPI.getUser(1);
        int statusCode = response.getStatusCode();
        try {
            Assert.assertEquals(200, statusCode);
        } catch (AssertionError e) {
            System.out.println("Error: Expected status code 200 but received " + statusCode);
            Assert.fail("Assertion failed");

        }
    }

    @Test
    public void testCreateUser() {
        Response response = userAPI.createUser("John", "Developer");
        int statusCode = response.getStatusCode();
        try {
            Assert.assertEquals(201, statusCode);
        } catch (AssertionError e) {
            System.out.println("Error: Expected status code 200 but received " + statusCode);
            Assert.fail("Assertion failed");

        }
    }

    @Test
    public void testUpdateUser() {
        Response response = userAPI.updateUser(2, "Jane", "Tester");
        int statusCode = response.getStatusCode();
        try {
            Assert.assertEquals(200, statusCode);
        } catch (AssertionError e) {
            System.out.println("Error: Expected status code 200 but received " + statusCode);
            Assert.fail("Assertion failed");

        }
    }

    @Test
    public void testDeleteUser() {
        Response response = userAPI.deleteUser(3);
        int statusCode = response.getStatusCode();
        try {
            Assert.assertEquals(204, statusCode);
        } catch (AssertionError e) {
            System.out.println("Error: Expected status code 200 but received " + statusCode);
            Assert.fail("Assertion failed");

        }
    }
}