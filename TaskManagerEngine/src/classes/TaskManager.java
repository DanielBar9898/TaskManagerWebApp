package classes;

import java.util.HashMap;
import java.util.Map;

public class TaskManager {

    protected Map<String, Task> tasks;
    protected int numOfTasks;

    public TaskManager() {
        tasks = new HashMap<String, Task>();
        numOfTasks = 0;
    }

    public void addTask(Task task) {
        tasks.put(task.getTaskID() , task);
        numOfTasks++;
    }

    public Task getTask(String id) {
        return tasks.get(id);
    }

    public boolean removeTask(String id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
            numOfTasks--;
            return true;
        }
        return false;
    }

    public int getNumOfTasks() {
        return numOfTasks;
    }

    synchronized public void proccesTask(String taskId){
        Task currTask = tasks.get(taskId);
        if(currTask != null){
            String type = currTask.taskType;
            switch(type){
                case "factorial" :
                    currTask.setTaskResult("1");
                    break;
            }
        }
    }

}
