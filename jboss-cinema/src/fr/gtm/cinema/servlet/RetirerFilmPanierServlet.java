package fr.gtm.cinema.servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.cinema.dao.FilmDTO;
import fr.gtm.cinema.entities.Panier;
import fr.gtm.cinema.service.FilmService;

/**
 * Servlet implementation class RetirerFilmPanierServlet
 */
@WebServlet("/RetirerFilmPanierServlet")
public class RetirerFilmPanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Inject private Panier panier;
    @Inject private FilmService service;
    public static final Logger tchikita = Logger.getLogger("Cinema");
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Long identifiant = Long.parseLong(id);
		FilmDTO filmdto = new FilmDTO(service.findById(identifiant));
		panier.remove(filmdto);
		String page = "/AfficherPanierServlet";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
