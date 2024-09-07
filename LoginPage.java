/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Keenan
 */
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Main class that contains the entry point of the application.
 */
public class LoginPage {
    /**
     * Main method that creates and shows the login page.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create and show the login page
        Login login = new Login();
        login.createLoginPage();
    }
}

/**
 * Login class that handles the login process and the menu navigation.
 */
class Login implements ActionListener {
    // GUI components for the login page
    private static JLabel usernameLabel;
    private static JLabel passwordLabel;
    private static JTextField userText;
    private static JPasswordField passText;
    private static JFrame frame;
    private static JPanel panel;
    private static JButton btnLogin;
    private static JLabel success;

    // GUI components for the task management
    private static JPanel taskPanel;
    private ArrayList<Task> tasks;
    private static int taskCounter = 0;

    // Arrays to store task data
    private ArrayList<String> developers = new ArrayList<>();
    private ArrayList<String> taskNames = new ArrayList<>();
    private ArrayList<String> taskIDs = new ArrayList<>();
    private ArrayList<String> taskDurations = new ArrayList<>();
    private ArrayList<String> taskStatuses = new ArrayList<>();

    // Constructor initializing the tasks list
    Login() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Creates and displays the login page.
     */
    public void createLoginPage() {
        frame = new JFrame("Login Page");
        panel = new JPanel();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        // Username label and text field
        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(10, 20, 80, 25);
        panel.add(usernameLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        // Password label and password field
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passText = new JPasswordField(20);
        passText.setBounds(100, 50, 165, 25);
        panel.add(passText);

        // Login button
        btnLogin = new JButton("Login");
        btnLogin.setBounds(10, 80, 80, 25);
        btnLogin.addActionListener(this);
        panel.add(btnLogin);

        // Label to display the success or failure message
        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);

        // Make the frame visible
        frame.setVisible(true);
    }

    /**
     * Handles the login button click event.
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userText.getText();
        String password = new String(passText.getPassword());

        // Validate username and password
        if (validateUsername(username) && validatePassword(password)) {
            JOptionPane.showMessageDialog(null, "Login successful");
            success.setText("Login successful");
            showMenu();
        } else {
            JOptionPane.showMessageDialog(null, "Username or password is incorrect. "
                + "Ensure username contains an underscore and is longer than 5 characters. "
                + "Password must be at least 8 characters long, contain a capital letter, "
                + "a number, and a special character.");
            success.setText("Login failed");
        }
    }

    /**
     * Validates the username based on specific criteria.
     * @param username the username to validate
     * @return true if valid, false otherwise
     */
    private boolean validateUsername(String username) {
        return username.length() > 5 && username.contains("_");
    }

    /**
     * Validates the password based on specific criteria.
     * @param password the password to validate
     * @return true if valid, false otherwise
     */
    private boolean validatePassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasUpper = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }
        return hasUpper && hasNumber && hasSpecial;
    }

    /**
     * Displays the main menu after a successful login.
     */
    private void showMenu() {
        frame.getContentPane().removeAll();
        frame.setSize(400, 300);

        taskPanel = new JPanel();
        taskPanel.setLayout(null);
        frame.add(taskPanel);

        // Menu label
        JLabel menuLabel = new JLabel("Welcome to EasyKanban");
        menuLabel.setBounds(10, 10, 200, 25);
        taskPanel.add(menuLabel);

        // Button to add a task
        JButton addTaskButton = new JButton("1. Add Task");
        addTaskButton.setBounds(10, 50, 150, 25);
        addTaskButton.addActionListener((ActionEvent e) -> {
            showAddTaskPanel();
        });
        taskPanel.add(addTaskButton);

        // Button to show report
        JButton showReportButton = new JButton("2. Show Report");
        showReportButton.setBounds(10, 80, 150, 25);
        showReportButton.addActionListener((ActionEvent e) -> {
            showReportPanel();
        });
        taskPanel.add(showReportButton);

        // Button to search for a task
        JButton searchTaskButton = new JButton("3. Search Task");
        searchTaskButton.setBounds(10, 110, 150, 25);
        searchTaskButton.addActionListener((ActionEvent e) -> {
            searchTaskPanel();
        });
        taskPanel.add(searchTaskButton);

        // Button to delete a task
        JButton deleteTaskButton = new JButton("4. Delete Task");
        deleteTaskButton.setBounds(10, 140, 150, 25);
        deleteTaskButton.addActionListener((ActionEvent e) -> {
            deleteTaskPanel();
        });
        taskPanel.add(deleteTaskButton);

        // Button to quit the application
        JButton quitButton = new JButton("5. Quit");
        quitButton.setBounds(10, 170, 150, 25);
        quitButton.addActionListener((ActionEvent e) -> {
            frame.dispose();
        });
        taskPanel.add(quitButton);

        frame.revalidate();
        frame.repaint();
    }

    /**
     * Displays the panel to add a new task.
     */
    private void showAddTaskPanel() {
        taskPanel.removeAll();
        frame.setSize(400, 400);

        // Task name label and text field
        JLabel nameLabel = new JLabel("Task Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        taskPanel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(100, 20, 165, 25);
        taskPanel.add(nameText);

        // Task number label and text field
        JLabel numberLabel = new JLabel("Task Number:");
        numberLabel.setBounds(10, 50, 80, 25);
        taskPanel.add(numberLabel);

        JTextField numberText = new JTextField(20);
        numberText.setBounds(100, 50, 165, 25);
        taskPanel.add(numberText);

        // Description label and text field
        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(10, 80, 80, 25);
        taskPanel.add(descriptionLabel);

        JTextField descriptionText = new JTextField(50);
        descriptionText.setBounds(100, 80, 165, 25);
        taskPanel.add(descriptionText);

        // Developer label and text field
        JLabel developerLabel = new JLabel("Developer:");
        developerLabel.setBounds(10, 110, 80, 25);
        taskPanel.add(developerLabel);

        JTextField developerText = new JTextField(20);
        developerText.setBounds(100, 110, 165, 25);
        taskPanel.add(developerText);

        // Duration label and text field
        JLabel durationLabel = new JLabel("Duration:");
        durationLabel.setBounds(10, 140, 80, 25);
        taskPanel.add(durationLabel);

        JTextField durationText = new JTextField(20);
        durationText.setBounds(100, 140, 165, 25);
        taskPanel.add(durationText);

        // Status label and combo box
        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setBounds(10, 170, 80, 25);
        taskPanel.add(statusLabel);

        String[] statusOptions = {"To Do", "Doing", "Done"};
        JComboBox<String> statusCombo = new JComboBox<>(statusOptions);
        statusCombo.setBounds(100, 170, 165, 25);
        taskPanel.add(statusCombo);

        // Button to add the task
        JButton addButton = new JButton("Add Task");
        addButton.setBounds(10, 200, 150, 25);
        addButton.addActionListener((ActionEvent e) -> {
            String taskName = nameText.getText();
            String taskNumber = numberText.getText();
            String description = descriptionText.getText();
            String developer = developerText.getText();
            String duration = durationText.getText();
            String status = (String) statusCombo.getSelectedItem();

            // Validate input fields
            if (taskName.isEmpty() || taskNumber.isEmpty() || description.isEmpty() || developer.isEmpty() || duration.isEmpty() || status.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields must be filled.");
            } else if (description.length() > 50) {
                JOptionPane.showMessageDialog(null, "Description should not exceed 50 characters.");
            } else {
                Task task = new Task(taskName, taskNumber, description, developer, duration, status);
                tasks.add(task);
                developers.add(developer);
                taskNames.add(taskName);
                taskIDs.add(taskNumber);
                taskDurations.add(duration);
                taskStatuses.add(status);
                taskCounter++;
                JOptionPane.showMessageDialog(null, "Task added successfully.");
                showMenu();
            }
        });
        taskPanel.add(addButton);

        // Button to go back to the main menu
        JButton backButton = new JButton("Back");
        backButton.setBounds(170, 200, 80, 25);
        backButton.addActionListener((ActionEvent e) -> {
            showMenu();
        });
        taskPanel.add(backButton);

        frame.revalidate();
        frame.repaint();
    }

    /**
     * Displays the report panel.
     */
    private void showReportPanel() {
        taskPanel.removeAll();
        frame.setSize(500, 500);

        JTextArea reportArea = new JTextArea();
        reportArea.setBounds(10, 10, 460, 400);
        reportArea.setEditable(false);
        StringBuilder report = new StringBuilder();
        
        for (Task task : tasks) {
            report.append(task.toString()).append("\n");
        }

        reportArea.setText(report.toString());
        taskPanel.add(reportArea);

        // Button to go back to the main menu
        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 420, 80, 25);
        backButton.addActionListener((ActionEvent e) -> {
            showMenu();
        });
        taskPanel.add(backButton);

        frame.revalidate();
        frame.repaint();
    }

    /**
     * Displays the search task panel.
     */
    private void searchTaskPanel() {
        taskPanel.removeAll();
        frame.setSize(400, 400);

        // Search by task name label and text field
        JLabel searchLabel = new JLabel("Search by Task Name:");
        searchLabel.setBounds(10, 20, 150, 25);
        taskPanel.add(searchLabel);

        JTextField searchText = new JTextField(20);
        searchText.setBounds(160, 20, 165, 25);
        taskPanel.add(searchText);

        // Button to search task by name
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(10, 50, 150, 25);
        searchButton.addActionListener((ActionEvent e) -> {
            String taskName = searchText.getText();
            boolean found = false;
            StringBuilder result = new StringBuilder();

            for (Task task : tasks) {
                if (task.getTaskName().equalsIgnoreCase(taskName)) {
                    result.append("Task Name: ").append(task.getTaskName()).append("\n")
                        .append("Developer: ").append(task.getDeveloper()).append("\n")
                        .append("Status: ").append(task.getStatus()).append("\n");
                    found = true;
                    break;
                }
            }

            if (found) {
                JOptionPane.showMessageDialog(null, result.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Task not found.");
            }
        });
        taskPanel.add(searchButton);

        // Search by developer label and text field
        JLabel searchDevLabel = new JLabel("Search by Developer:");
        searchDevLabel.setBounds(10, 90, 150, 25);
        taskPanel.add(searchDevLabel);

        JTextField searchDevText = new JTextField(20);
        searchDevText.setBounds(160, 90, 165, 25);
        taskPanel.add(searchDevText);

        // Button to search tasks by developer
        JButton searchDevButton = new JButton("Search");
        searchDevButton.setBounds(10, 120, 150, 25);
        searchDevButton.addActionListener((ActionEvent e) -> {
            String developer = searchDevText.getText();
            boolean found = false;
            StringBuilder result = new StringBuilder();

            for (Task task : tasks) {
                if (task.getDeveloper().equalsIgnoreCase(developer)) {
                    result.append("Task Name: ").append(task.getTaskName()).append("\n")
                        .append("Status: ").append(task.getStatus()).append("\n\n");
                    found = true;
                }
            }

            if (found) {
                JOptionPane.showMessageDialog(null, result.toString());
            } else {
                JOptionPane.showMessageDialog(null, "No tasks found for developer.");
            }
        });
        taskPanel.add(searchDevButton);

        // Button to go back to the main menu
        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 200, 80, 25);
        backButton.addActionListener((ActionEvent e) -> {
            showMenu();
        });
        taskPanel.add(backButton);

        frame.revalidate();
        frame.repaint();
    }

    /**
     * Displays the delete task panel.
     */
    private void deleteTaskPanel() {
        taskPanel.removeAll();
        frame.setSize(400, 400);

        // Delete by task name label and text field
        JLabel deleteLabel = new JLabel("Delete by Task Name:");
        deleteLabel.setBounds(10, 20, 150, 25);
        taskPanel.add(deleteLabel);

        JTextField deleteText = new JTextField(20);
        deleteText.setBounds(160, 20, 165, 25);
        taskPanel.add(deleteText);

        // Button to delete task by name
        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(10, 50, 150, 25);
        deleteButton.addActionListener((ActionEvent e) -> {
            String taskName = deleteText.getText();
            boolean found = false;

            for (Task task : tasks) {
                if (task.getTaskName().equalsIgnoreCase(taskName)) {
                    tasks.remove(task);
                    developers.remove(task.getDeveloper());
                    taskNames.remove(task.getTaskName());
                    taskIDs.remove(task.getTaskNumber());
                    taskDurations.remove(task.getDuration());
                    taskStatuses.remove(task.getStatus());
                    JOptionPane.showMessageDialog(null, "Task deleted successfully.");
                    found = true;
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(null, "Task not found.");
            } else {
                showMenu();
            }
        });
        taskPanel.add(deleteButton);

        // Button to go back to the main menu
        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 80, 80, 25);
        backButton.addActionListener((ActionEvent e) -> {
            showMenu();
        });
        taskPanel.add(backButton);

        frame.revalidate();
        frame.repaint();
    }
}

/**
 * Task class that represents a task.
 */
class Task {
    private String taskName;
    private String taskNumber;
    private String description;
    private String developer;
    private String duration;
    private String status;

    /**
     * Constructor to initialize a Task object.
     * @param taskName the name of the task
     * @param taskNumber the number of the task
     * @param description the description of the task
     * @param developer the developer assigned to the task
     * @param duration the duration of the task
     * @param status the status of the task
     */
    public Task(String taskName, String taskNumber, String description, String developer, String duration, String status) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.description = description;
        this.developer = developer;
        this.duration = duration;
        this.status = status;
    }

    // Getters for the task attributes
    public String getTaskName() {
        return taskName;
    }

    public String getTaskNumber() {
        return taskNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getDuration() {
        return duration;
    }

    public String getStatus() {
        return status;
    }

    // Overriding toString method to return task details
    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", taskNumber='" + taskNumber + '\'' +
                ", description='" + description + '\'' +
                ", developer='" + developer + '\'' +
                ", duration='" + duration + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
