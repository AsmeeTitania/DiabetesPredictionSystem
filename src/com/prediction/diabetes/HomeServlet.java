package com.prediction.diabetes;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prediction.diabetes.nb.NaiveBayesClassifier;

/**
 * Servlet implementation class HomeServlet
 */

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String HOME = "/";
	private static final String FORM = "/form";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request,response);
	}
		

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		try {
			Map<QuestionType, Double> paramaters = new HashMap<QuestionType, Double>();
			paramaters.put(QuestionType.AGE, Double.parseDouble(request.getParameter("age")));
			paramaters.put(QuestionType.NUM_PREGNENCY, Double.parseDouble(request.getParameter("trimep")));
			paramaters.put(QuestionType.GlUCOSE_TOLERANCE, Double.parseDouble(request.getParameter("gtest")));
			paramaters.put(QuestionType.DIASTOLIC_BP, Double.parseDouble(request.getParameter("dtest")));
			paramaters.put(QuestionType.TRICEP_THICKNESS, Double.parseDouble(request.getParameter("tricep")));
			paramaters.put(QuestionType.TWO_HOUR, Double.parseDouble(request.getParameter("serum")));
			paramaters.put(QuestionType.BMI, Double.parseDouble(request.getParameter("bmi")));
			paramaters.put(QuestionType.PEDIGREE, Double.parseDouble(request.getParameter("pedigree")));
			/*ServletContext context = getServletContext();*/
			String dataFile = getServletContext().getRealPath("data/datasets/diabetes.arff");
			String modelFile = getServletContext().getRealPath("data/diabetes.nb.model");
			/*String dataFile = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/data/datasets/diabetes.arff";
			String modelFile = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/data/diabetes.nb.model";*/
			/*String dataFile =  "data/datasets/diabetes.arff";
			String modelFile = "data/diabetes.nb.model";*/
			NaiveBayesClassifier.train(dataFile, modelFile);
			result = NaiveBayesClassifier.medicalBot(modelFile, paramaters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("result", result);
		System.out.println(result);
		RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
		rd.forward(request, response);
	}
		
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String path = request.getServletPath();
	    switch (path) {
	      case HOME:
	    	  RequestDispatcher home = request.getRequestDispatcher("index.jsp");
	  		  home.forward(request, response);
	        break;
	      case FORM:
	    	  RequestDispatcher form = request.getRequestDispatcher("newinterface.jsp");
		  		form.forward(request, response);
	        break;

	       
	    }
	}
	}


