package com.dev.project;

import com.dev.project.entities.Category;
import com.dev.project.entities.Product;
import com.dev.project.repositories.CategoryRepository;
import com.dev.project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
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
		Category cat1 = new Category(1L, "Eletronicos");
		Category cat2 = new Category(2L, "Livraria");

		Product p1 = new Product(1L,"TV Semp Toshiba", 2200.00, cat1);
		Product p2 = new Product(2L,"Geladeira Esmaltec", 5600.00, cat1);
		Product p3 = new Product(3L,"Programando em Java", 60.00, cat2);
		Product p4 = new Product(4L,"Resma de Papel A4", 32.56, cat2);
		Product p5 = new Product(5L,"Notebook Lenovo", 1200.00, cat1);

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
