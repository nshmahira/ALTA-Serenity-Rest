package Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresAPI {
    public static final String URL = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static  final String JSON_FILE = DIR+ "/src/test/resources/features/postcodes/JSON";
    public static String GET_LIST_USER = URL + "/api/users?page={page}";
    public static String POST_CREATE_USER = URL + "/api/users";
    public static String PUT_UPDATE_USER = URL + "/api/users/{id}";
    public static String DELETE_USER = URL + "/api/users/{id}";
    public static String GET_SINGLE_USER = URL + "/api/users/{id}";
    public static String POST_LOGIN_USER = URL + "/api/login";
    public static String PATCH_UPDATE_USER = URL + "/api/users/{id}";

    @Step("Get list user")
    public void getListUser(String page) {
        SerenityRest.given()
                .pathParam("page", page);
    }

    @Step("Post create user")
    public static void postCreateUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step ("Put update user")
    public void putUpdateUser(File json,int id){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam("id",id);

    }
    @Step("Get single user")
    public void getSingleUser(int id){
        SerenityRest.given()
                .pathParam ("id",id);
    }

    @Step("Post Login success")
    public static void postLoginUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post Unsuccess Login")
    public static void postUnsuccessLoginUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }


    @Step ("Patch update user")
    public void patchUpdateUser(File json,int id){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

}