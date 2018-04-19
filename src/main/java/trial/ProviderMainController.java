package trial;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import trial.model.Provider;
import trial.service.ProviderService;

@Controller
public class ProviderMainController {

	@Autowired
	private ProviderService providerService;

	@GetMapping("/providerhome")
	public String user(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_PROVIDER_HOME");
		return "user";
	}

	@GetMapping("/allproviders")
	public String allProviders(HttpServletRequest request) {
		request.setAttribute("providers", providerService.findAll());
		request.setAttribute("mode", "MODE_PROVIDERS");
		return "user";
	}

	@GetMapping("/providersignup")
	public String newProvider(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_PROVIDER_NEW");
		return "user";
	}

	@PostMapping("/saveprovider")
	public String newProviderSignup(@ModelAttribute Provider provider, BindingResult bindingResult,
			HttpServletRequest request) {
		providerService.save(provider);
		request.setAttribute("providers", providerService.findAll());
		request.setAttribute("mode", "MODE_PROVIDERS");
		return "user";
	}

	@GetMapping("/updateprovider")
	public String updateProvider(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("provider", providerService.findProvider(id));
		request.setAttribute("mode", "MODE_PROVIDER_UPDATE");
		return "user";
	}

	@GetMapping("/deleteprovider")
	public String deleteProvider(@RequestParam int id, HttpServletRequest request) {
		providerService.delete(id);
		request.setAttribute("providers", providerService.findAll());
		request.setAttribute("mode", "MODE_PROVIDERS");
		return "user";
	}

}
