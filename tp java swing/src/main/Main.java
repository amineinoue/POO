package main;

import contrôleur.TaskController;
import model.TaskManager;
import view.TaskView;
import javax.swing.SwingUtilities;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(null {
            TaskManager taskManager = new TaskManager();
            TaskView taskView = new TaskView();
            TaskController taskController = new TaskController(taskManager, taskView); 
            taskView.updateTaskList(taskManager.getTasks()); 
            taskView.setVisible(true);
        });
    }
}
