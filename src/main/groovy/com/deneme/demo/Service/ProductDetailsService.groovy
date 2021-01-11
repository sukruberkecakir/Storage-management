package com.deneme.demo.Service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.deneme.demo.Entity.Product
import com.deneme.demo.Repository.ProductRepository

@Service
class ProductDetailsService {
	@Autowired
	private ProductRepository productRepo
	
	def listAll(){
		return productRepo.findAll()
	}
	def save(Product product) {
		productRepo.save(product)
	}
	def get(Long id) {
		return productRepo.findById(id).get()
	}
	def delete(Long id) {
		productRepo.deleteById(id)
	}
}
