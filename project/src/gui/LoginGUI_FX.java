
package gui;

import listener.LoginListener;
import services.AuthService;
import dto.request.AuthRequest;
import common.Result;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Map;

public class LoginGUI_FX extends Application {

    public LoginListener loginListener;
    private AuthService authService = new AuthService(new repository.UserRepository());

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login application.App");

        // Set up grid layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Add login form components
        Label userLabel = new Label("Username:");
        TextField userTextField = new TextField();
        Label passLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");

        gridPane.add(userLabel, 0, 0);
        gridPane.add(userTextField, 1, 0);
        gridPane.add(passLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(loginButton, 1, 2);

        loginButton.setOnAction(event -> {
            String username = userTextField.getText();
            String password = passwordField.getText();

            // Create login request
            AuthRequest authRequest = new AuthRequest(username, password);
            Map<Object, Object> response = authService.doLogin(authRequest);

            // Handle response
            if (response.get("RESULT") == Result.OK()) {
                showAlert("Login Successful", "Welcome " + username, Alert.AlertType.INFORMATION);
            } else {
                String errorMessage = (String) response.get("MESSAGE");
                showAlert("Login Failed", errorMessage, Alert.AlertType.ERROR);
            }
        });

        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
