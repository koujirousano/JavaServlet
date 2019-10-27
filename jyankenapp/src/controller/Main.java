package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.JKLogic;
import model.Jyanken;

@WebServlet("/Main")
public class Main extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode=request.getParameter("mode");
		if(mode != null && mode.equals("reset")) {
			HttpSession session=request.getSession();
			session.removeAttribute("jk");
		}
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/main.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String handNo=request.getParameter("handNo");

		HttpSession session=request.getSession();
		Jyanken jk=(Jyanken)session.getAttribute("jk");
		if(jk ==null) {
			jk=new Jyanken();
		}

		JKLogic logic=new JKLogic();
		logic.execute(jk,handNo);

		session.setAttribute("jk", jk);
		doGet(request, response);
	}
}
