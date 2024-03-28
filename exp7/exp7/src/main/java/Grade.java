

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/grade")
public class Grade extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double s1 = Double.parseDouble(request.getParameter("subject1"));
		double s2 = Double.parseDouble(request.getParameter("subject2"));
		double s3 = Double.parseDouble(request.getParameter("subject3"));
		double s4 = Double.parseDouble(request.getParameter("subject4"));
		double s5 = Double.parseDouble(request.getParameter("subject5"));
		
		double avg = (s1 + s2 + s3 + s4 + s5) / 5.0;
		
		String grade;
		if (avg >= 95) {
			grade = "A";
		} else if (avg < 95 && avg >= 90) {
			grade = "A-";
		} else if (avg < 90 && avg >= 87) {
			grade = "B+";
		} else if (avg < 86 && avg >= 85) {
			grade = "B";
		} else if (avg < 85 && avg >= 80) {
			grade = "B-";
		} else if (avg < 80 && avg >= 77) {
			grade = "C+";
		} else if (avg < 77 && avg >= 75) {
			grade = "C";
		} else if (avg < 75 && avg >= 70) {
			grade = "C-";
		} else if (avg < 70 && avg >= 67) {
			grade = "D+";
		} else if (avg < 67 && avg >= 65) {
			grade = "D";
		} else if (avg < 65 && avg >= 60) {
			grade = "D-";
		} else {
			grade = "A";
		}
		
		PrintWriter out = response.getWriter();
		out.println("Grade is " + grade);
	}

}
