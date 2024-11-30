package application;

import dao.Role;
import gui.*;

public class UI {
    public EmployeeManagementGUI employeeManagementGUI;
    public FeedbackManagementGUI feedbackManagementGUI;
    public FoodManagementGUI foodManagementGUI;
    public LoginGUI loginGUI;
    public ManagerManagementGUI managerManagementGUI;
    public OrderManagementGUI orderManagementGUI;
    public RegistrationGUI registrationGUI;
    public StatisticsManagementGUI statisticsManagementGUI;


    public UI() {
        loginGUI = new LoginGUI();
    }

    public void changeToUser(Role role) {
        
    }
}
