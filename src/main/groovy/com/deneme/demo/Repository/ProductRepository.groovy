package com.deneme.demo.Repository

import org.springframework.data.jpa.repository.JpaRepository

import com.deneme.demo.Entity.Product

interface ProductRepository extends JpaRepository<Product, Long>{
}
