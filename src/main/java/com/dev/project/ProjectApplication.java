package com.dev.project;

import com.dev.project.entities.Category;
import com.dev.project.entities.Product;
import com.dev.project.repositories.CategoryRepository;
import com.dev.project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {

		SpringApplication.run(ProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null,"Eletronicos");
		Category cat2 = new Category(null, "Livraria");

		Product p1 = new Product(null,"TV Semp Toshiba", 2200.00, cat1);
		Product p2 = new Product(null,"Geladeira Esmaltec", 5600.00, cat1);
		Product p3 = new Product(null,"Programando em Java", 60.00, cat2);
		Product p4 = new Product(null,"Resma de Papel A4", 32.56, cat2);
		Product p5 = new Product(null,"Notebook Lenovo", 1200.00, cat1);

		cat1.getProducts().addAll(Arrays.asList(p1, p2, p5));
		cat2.getProducts().addAll(Arrays.asList(p3, p4));

		categoryRepository.save(cat1);
		categoryRepository.save(cat2);

		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		productRepository.save(p4);
		productRepository.save(p5);

	}
}
