package contrôleur;

import model.Task;
import model.TaskManager;
import view.TaskView;

public class TaskController {
    private TaskManager taskManager;
    private TaskView taskView;

    public TaskController(TaskManager taskManager, TaskView taskView) {
        this.taskManager = taskManager;
        this.taskView = taskView;

 
        taskView.setAddTaskListener(e --> addTask());
        taskView.setRemoveTaskListener(e --> removeTask());
        taskView.setToggleTaskListener(e --> toggleTaskCompletion());
    }

    public void addTask() {
        String description = taskView.getTaskInput();
        if (!description.trim().isEmpty()) {
            taskManager.addTask(new Task(description));
            taskView.updateTaskList(taskManager.getTasks());
        }
    }

    public void removeTask() {
        int index = taskView.getSelectedTaskIndex();
        if (index != -1) {
            taskManager.removeTask(index);
            taskView.updateTaskList(taskManager.getTasks());
        }
    }

    public void toggleTaskCompletion() {
        int index = taskView.getSelectedTaskIndex();
        if (index != -1) {
            taskManager.toggleTaskCompletion(index);
            taskView.updateTaskList(taskManager.getTasks());
        }
    }
}
