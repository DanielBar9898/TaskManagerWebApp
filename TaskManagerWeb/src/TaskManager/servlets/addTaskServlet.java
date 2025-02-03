package TaskManager.servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import classes.*;
import org.json.JSONObject;

@WebServlet(name = "addTask" , urlPatterns = "/addTask")
public class addTaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        StringBuilder jsonInput = new StringBuilder();
        String inputLine;
        while ((inputLine = reader.readLine()) != null) {
            jsonInput.append(inputLine);
        }
        JSONObject json = new JSONObject(jsonInput.toString());
        String taskType = json.getString("taskType");
        String data = json.getString("text");
        Task currentTask = new Task(taskType,data);
        TaskManager taskManager = (TaskManager) getServletContext().getAttribute("taskManager");

        if (taskManager == null) {
            ServletContext context = getServletContext();
            context.setAttribute("taskManager" , new TaskManager());
        }
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("taskId", currentTask.getTaskID());
        jsonResponse.put("status", "Pending");
        jsonResponse.put("message", "Task added successfully.");

        // Send response
        response.setContentType("application/json");
        response.getWriter().write(jsonResponse.toString());
        taskManager.proccesTask(currentTask.getTaskID());

        response.setContentType("text/plain");
        response.getWriter().write("Success!");

    }

}
