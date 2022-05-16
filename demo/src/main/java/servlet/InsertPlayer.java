package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.InsufficientResourcesException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.ClientResponse;

import player.entity.Player;

/**
 * Servlet implementation class InsertCustomer
 */
@WebServlet("/InsertPlayer")
public class InsertPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPlayer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String playerName = request.getParameter("playerName");
		Boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
		SimpleDateFormat sf = new  SimpleDateFormat("yyyy-MM-dd");
		Date birthday = null;
		try {
			birthday = sf.parse(request.getParameter("birthday"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String address = request.getParameter("address");
		String clubName = request.getParameter("clubName");
		String positionPlay = request.getParameter("positionPlay");
		float transportCost = Float.parseFloat(request.getParameter("transportCost"));
		
		Player p = new Player();
		p.setPlayerName(playerName);
		p.setGender(gender);
		p.setBirthday(birthday);
		p.setAddress(address);
		p.setClubName(clubName);
		p.setPositionPlay(positionPlay);
		p.setTransportCost(transportCost);
		
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/demoService/rest/player-service/insertPlayer");
		Gson son = new Gson();
		String objPlayer = son.toJson(p);
		
		ClientResponse clientResource = resource.type("application/json").post(ClientResponse.class,objPlayer);
		String result = clientResource.getEntity(String.class);
		
		Boolean bl = son.fromJson(result, Boolean.class);
		if(bl) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.setAttribute("error", "Insert failed!");
			request.getRequestDispatcher("insertPlayer.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
