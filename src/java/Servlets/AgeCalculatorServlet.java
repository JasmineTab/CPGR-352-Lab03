package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Double.*;
import static java.lang.Integer.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String message;
        int futAge;
        String currAge = request.getParameter("age_number");
        
        request.setAttribute("currAge", currAge);
        
        if(currAge == "" || currAge == null){
            message  = "You must give your current age";
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            return;
        }
        else if(isNaN(parseInt(currAge))) {
            message  = "You must enter a number";
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            return;
        }
        else{
            futAge = (parseInt(currAge)) + 1;
            
            message = "Your age next birthday will be " + futAge;
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            return;
        }
    }
}
