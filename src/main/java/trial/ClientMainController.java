package trial;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import trial.model.Client;
import trial.service.ClientService;

@Controller
public class ClientMainController {

	@Autowired
	private ClientService clientService;

	@GetMapping("/clienthome")
	public String client(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_CLIENT_HOME");
		return "client";
	}

	@GetMapping("/allclients")
	public String allClients(HttpServletRequest request) {
		request.setAttribute("clients", clientService.findAll());
		request.setAttribute("mode", "MODE_CLIENTS");
		return "client";
	}

	@GetMapping("/clientsignup")
	public String newClient(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_CLIENT_NEW");
		return "client";
	}

	@PostMapping("/saveclient")
	public String newClientSignup(@ModelAttribute Client client, BindingResult bindingResult,
			HttpServletRequest request) {
		clientService.save(client);
		request.setAttribute("clients", clientService.findAll());
		request.setAttribute("mode", "MODE_CLIENTS");
		return "client";
	}

	@GetMapping("/updateclient")
	public String updateClient(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("client", clientService.findClient(id));
		request.setAttribute("mode", "MODE_CLIENT_UPDATE");
		return "client";
	}

	@GetMapping("/deleteclient")
	public String deleteClient(@RequestParam int id, HttpServletRequest request) {
		clientService.delete(id);
		request.setAttribute("clients", clientService.findAll());
		request.setAttribute("mode", "MODE_CLIENTS");
		return "client";
	}
	
	@PostMapping("/loginclient")
	
	public String loginForm(@ModelAttribute String email, BindingResult bindingResult, HttpServletRequest request) {
		request.setAttribute("client", clientService.findEmail(email));
		//System.err.println(clientCheck.getEmail());
		return "client";
	}
	
	@GetMapping("/loginclient")
	public String loginClient(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_CLIENT_LOGIN");
		return "client";
	}
}
