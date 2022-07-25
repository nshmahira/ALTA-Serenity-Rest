package Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;


public class ReqresStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Get list user with parameter {string}")
    public void getListUserWithParameter(String page) {
        reqresAPI.getListUser(page);
    }

    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USER);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(200);
    }

    @And("Response body should contain first name {string} and last name {string}")
    public void responseBodyShouldContainFirstNameAndLastName(String firstName, String lastName) {
        SerenityRest.then().body(ReqresResponses.FIRST_NAME,equalTo(firstName));
        SerenityRest.then().body(ReqresResponses.LAST_NAME,equalTo(lastName));
    }
    @And("Get list user assert json validation")
    public void getListUserAssertJsonValidation() {
        File jsonFiles = new File( ReqresAPI.JSON_FILE+"/GetListUserJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFiles));

    }

    @Given("Post create new user with valid json file")
    public void postCreateNewUserWithValidJsonFile() {
        File jsonFiles = new File("src/test/resources/features/postcodes/JSON/CreateUser.json");
        ReqresAPI.postCreateUser(jsonFiles);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(201);
    }

    @And("Response body should contain name {string} and job {string}")
    public void responseBodyShouldContainNameAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job))
        ;
    }
    @And("Post list user assert json validation")
    public void postListUserAssertJsonValidation() {
        File jsonFile = new File(ReqresAPI.JSON_FILE+"/PostCreateUserJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Put update user with id {int} and with valid json file")
    public void putUpdateUserWithIdAndWithValidJsonFile(int id) {
        File jsonFiles = new File ( ReqresAPI.DIR+"/src/test/resources/features/postcodes/JSON/UpdateUser.json");
        reqresAPI.putUpdateUser(jsonFiles,id);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No content")
    public void statusCodeShouldBeNoContent(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("Delete user with id {int}")
    public void deleteUserWithIdId(int id) {
        reqresAPI.deleteUser(id);

    }

    @Given("Get single user with id {int}")
    public void getSingleUserWithId(int id) {
        reqresAPI.getSingleUser(id);
        
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @And("Response body should contain email {string}")
    public void responseBodyShouldContainEmail(String email) {
        SerenityRest.then().body(ReqresResponses.EMAIL,equalTo(email));
    }

    @And("Get single user assert json validation")
    public void getSingleUserAssertJsonValidation() {
        File jsonFiles = new File( ReqresAPI.JSON_FILE+"/GetSingleUserJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFiles));
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @Given("Post login user with valid json file")
    public void postLoginUserWithValidJsonFile() {
        File jsonFiles = new File(ReqresAPI.JSON_FILE+"/LoginUser.json");
        ReqresAPI.postLoginUser(jsonFiles);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_USER);
    }

    @And("Post login user assert json validation")
    public void postLoginUserAssertJsonValidation() {
        File jsonFile = new File(ReqresAPI.JSON_FILE +"/PostLoginUserJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Post login unsuccess user with valid json file")
    public void postLoginUnsuccessUserWithValidJsonFile() {
        File jsonFiles = new File(ReqresAPI.JSON_FILE+"/Unsuccess-LoginUser.json");
        ReqresAPI.postUnsuccessLoginUser(jsonFiles);
    }

    @When("Send request post login user unsuccess")
    public void sendRequestPostLoginUserUnsuccess() { SerenityRest.when().post(ReqresAPI.POST_LOGIN_USER);

    }

    @Then("Status code should be {int} error")
    public void statusCodeShouldBeError(int error) {
        SerenityRest.then().statusCode(400);
    }

    @And("Response body should contain error {string}")
    public void responseBodyShouldContainError(String error) {
        SerenityRest.then()
                .body(ReqresResponses.ERROR,equalTo(error));
    }

    @And("Post login unsuccess assert json validation")
    public void postLoginUnsuccessAssertJsonValidation() {
        File jsonFile = new File(ReqresAPI.JSON_FILE +"/Unsuccess-PostLoginUserJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Patch update user with id {int} and with valid json file")
    public void patchUpdateUserWithIdAndWithValidJsonFile(int id) {
        File jsonFiles = new File ( ReqresAPI.DIR+"/src/test/resources/features/postcodes/JSON/PatchUpdateUser.json");
        reqresAPI.patchUpdateUser(jsonFiles,id);
    }

    @When("Send request patch update user")
    public void sendRequestPatchUpdateUser() {
        SerenityRest.when().post(ReqresAPI.PATCH_UPDATE_USER);
    }

    @And("Patch update user assert json validation")
    public void patchUpdateUserAssertJsonValidation() {
        File jsonFile = new File(ReqresAPI.JSON_FILE +"/PostCreateUserJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

}
