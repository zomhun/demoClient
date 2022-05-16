package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import player.entity.Player;


/**
 * Servlet implementation class InitUpdateCustomer
 */
@WebServlet("/InitUpdatePlayer")
public class InitUpdatePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitUpdatePlayer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int playerId = Integer.parseInt(request.getParameter("playerId"));
		
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/demoService/rest/player-service/getPlayerById/"+playerId);
		String data = resource.get(String.class);
		
		Gson son = new Gson();
		Player player = son.fromJson(data, Player.class);
		
		request.setAttribute("p", player);
		request.getRequestDispatcher("updateCustomer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
