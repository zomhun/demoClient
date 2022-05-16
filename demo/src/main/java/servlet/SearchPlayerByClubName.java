package servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import player.entity.Player;

/**
 * Servlet implementation class SearchCustomerByName
 */
@WebServlet("/SearchPlayerByClubName")
public class SearchPlayerByClubName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPlayerByClubName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String clubName = request.getParameter("clubName");
		
		Client client = Client.create();
		if(clubName==null || clubName.length()==0)
			clubName = " ";
		clubName = URLEncoder.encode(clubName,"UTF-8");
		WebResource resource = client.resource("http://localhost:8080/demoService/rest/player-service/getPlayerByClubName/"+clubName);
		String data = resource.get(String.class);
		
		Gson son = new Gson();
		GenericType<List<Player>> listType = new GenericType<List<Player>>() {};
		List<Player> listPlayer = son.fromJson(data, listType.getType());
		
		request.setAttribute("list", listPlayer);
		request.getRequestDispatcher("listPlayer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
