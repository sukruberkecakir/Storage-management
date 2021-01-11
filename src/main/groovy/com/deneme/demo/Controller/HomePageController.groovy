package com.deneme.demo.Controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

import com.deneme.demo.Entity.Product
import com.deneme.demo.Entity.User
import com.deneme.demo.Repository.UserRepository
import com.deneme.demo.Service.ProductDetailsService

@Controller
class HomePageController {
	
	@Autowired
	private UserRepository userRepo
	
	@Autowired
	private ProductDetailsService productRepo
	
	@RequestMapping("/")
	def getHomePage() {
		return "index"
	}
	@GetMapping("/register")
	def showRegistrationForm(Model model) {
		model.addAttribute("user", new User())
		 
		return "registration"
	}
	@PostMapping("/register_succeded")
	def processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder()
		String encodedPassword = passwordEncoder.encode(user.getPassword())
		user.setPassword(encodedPassword)
		
		userRepo.save(user)
		 
		return "register_succeded"
	}
	@GetMapping("/add_product")
	def showNewProductForm(Model model) {
		Product product = new Product()
		model.addAttribute("product", product)
		
		return "new_product"
	}
	
	@PostMapping("/save")
	def saveProduct(@ModelAttribute("product") Product product) {
		productRepo.save(product)		
		return "redirect:/"
	}
	
	@RequestMapping("/edit/{id}")
	def showEditProductForm(@PathVariable(name = "id") Long id) {
		ModelAndView modelandView = new ModelAndView("edit_product")
		
		Product product = productRepo.get(id)
		modelandView.addObject("product", product)
		
		return modelandView
	}
	
	@RequestMapping("/delete/{id}")
	def deleteProduct(@PathVariable(name = "id") Long id) {
		productRepo.delete(id)
		
		return "redirect:/"
	}
	
	
	@GetMapping("/products")
	def listProducts(Model model) {
		List<Product> listProducts = productRepo.listAll()
		model.addAttribute("listProducts", listProducts)
				 
		return "products"
	}
	@GetMapping("/usersList")
	def listUsers(Model model) {
		List<User> listUsers = userRepo.findAll()
		model.addAttribute("listUsers", listUsers)
		 
		return "users_List"
	}
}
