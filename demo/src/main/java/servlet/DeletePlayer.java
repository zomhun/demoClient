package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import player.entity.Player;

/**
 * Servlet implementation class DeleteCustomer
 */
@WebServlet("/DeletePlayer")
public class DeletePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeletePlayer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int playerId = Integer.parseInt(request.getParameter("playerId"));

		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/demoService/rest/player-service/deletePlayer/" + playerId);
		 String result = resource.type("application/json").delete(String.class);
		
		Gson son = new Gson();
		Boolean bl = son.fromJson(result, Boolean.class);
		if(bl) {
			request.setAttribute("success", "Delete successfully!");
		}else {
			request.setAttribute("error", "Delete failed!");
		}

		resource = client.resource("http://localhost:8089/demoService/rest/player-service/getListPlayer");
		String data = resource.get(String.class);
		
		
		GenericType<List<Player>> listType = new GenericType<List<Player>>() {};
		List<Player> listPlayer = son.fromJson(data, listType.getType());
		
		request.setAttribute("list", listPlayer);
		request.getRequestDispatcher("listPlayer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
