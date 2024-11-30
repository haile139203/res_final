package application;

import common.AppConstant;
import dto.request.AuthRequest;
import dto.response.UserResponse;
import javafx.application.Application;
import javafx.stage.Stage;
import mapper.UserMapper;

public class System extends Application {
    private UI ui;
    private UserSystem user;
    private Repositories repositories;
    private Services services;
    
    public System() {
        ui = new UI();
        repositories = new Repositories();
        services = new Services(repositories);
        bindEvent();
    }

    @Override
    public void start(Stage stage) throws Exception {

    }

    private void bindEvent() {

    }
}
