package classes;

public class Task {
    protected String taskData;
    protected String taskType;
    protected String taskStatus;
    protected String result;
    protected String taskId;


    public Task(String taskName,String taskData) {
        this.taskData = taskData;
        this.taskId = UniqueStringGenerator.generateUniqueString();
        this.taskType = taskName;
        this.taskStatus = "Pending";
        this.result = "No result yet!";
    }

    public String getTaskID() {
        return taskId;
    }

    public String getTaskName() {
        return taskType;
    }

    public String getTaskStatus() {
        return taskStatus;
    }
    public String getResult() {
        return result;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setTaskResult(String result) {
        this.result = result;
    }
}
