package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String resultOut = "---";
        request.setAttribute("result", resultOut);

        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String resultOut;
        int result;
        String first = request.getParameter("first_input");
        String second = request.getParameter("second_input");
        String math = request.getParameter("math");

        request.setAttribute("first", first);
        request.setAttribute("second", second);

        if (first.equals("") || first == null || second.equals("") || second == null) {
            resultOut = "invalid";
            request.setAttribute("result", resultOut);
        } else if (!first.matches(".*[0-9999999].*") || !second.matches(".*[0-9999999].*")) {
            resultOut = "invalid";
            request.setAttribute("result", resultOut);
        } else {
            int firstInt = Integer.parseInt(first);
            int secondInt = Integer.parseInt(second);
            
            
            switch(math){
                case "+":
                    result = firstInt + secondInt;
                    request.setAttribute("result", result);
                    break;
                case "-":
                    result = firstInt - secondInt;
                    request.setAttribute("result", result);
                    break;
                case "*":
                    result = firstInt * secondInt;
                    request.setAttribute("result", result);
                    break;
                case "%":
                    result = firstInt % secondInt;
                    request.setAttribute("result", result);
                    break;
            }
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;
    }
}
