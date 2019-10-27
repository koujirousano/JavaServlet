package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Siri;
import model.SiriLogic;


@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Siri siri = new Siri("", "ごりら");
		session.setAttribute("siri", siri);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/main.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String after = request.getParameter("after");
		if (after.length() == 0) {
			request.setAttribute("errorMsg", "言葉を入力してください!");
		} else {
			HttpSession session = request.getSession();
			Siri siri = (Siri) session.getAttribute("siri");
			siri.setBefore(siri.getAfter());
			siri.setAfter(after);
			SiriLogic logic = new SiriLogic();
			logic.execute(siri);
			session.setAttribute("siri", siri);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/main.jsp");
		rd.forward(request, response);
	}

}
