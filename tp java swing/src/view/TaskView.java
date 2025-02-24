package view;

import model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class TaskView extends JFrame {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskInput;
    private JButton addTaskButton, removeTaskButton, toggleTaskButton;

    public TaskView() {
        setTitle("Gestion des tâches - To-Do List");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Liste des tâches
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        add(new JScrollPane(taskList), BorderLayout.CENTER);

        // Entrée et boutons
        JPanel inputPanel = new JPanel(new BorderLayout());
        taskInput = new JTextField();
        addTaskButton = new JButton("Ajouter");
        removeTaskButton = new JButton("Supprimer");
        toggleTaskButton = new JButton("Marquer terminé");

        inputPanel.add(taskInput, BorderLayout.CENTER);
        inputPanel.add(addTaskButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(removeTaskButton);
        buttonPanel.add(toggleTaskButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public String getTaskInput() { return taskInput.getText(); }
    public int getSelectedTaskIndex() { return taskList.getSelectedIndex(); }

    public void setAddTaskListener(ActionListener listener) { addTaskButton.addActionListener(listener); }
    public void setRemoveTaskListener(ActionListener listener) { removeTaskButton.addActionListener(listener); }
    public void setToggleTaskListener(ActionListener listener) { toggleTaskButton.addActionListener(listener); }

    public void updateTaskList(List<Task> tasks) {
        taskListModel.clear();
        for (Task task : tasks) {
            taskListModel.addElement(task.toString());
        }
    }
}
