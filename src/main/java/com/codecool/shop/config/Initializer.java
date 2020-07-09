package com.codecool.shop.config;

import com.codecool.shop.dao.*;
import com.codecool.shop.dao.implementation.*;
import com.codecool.shop.dao.sql.ProductCategoryDaoJDBC;
import com.codecool.shop.dao.sql.ProductDaoJDBC;
import com.codecool.shop.dao.sql.SupplierDaoJDBC;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = new ProductDaoJDBC();
        ProductCategoryDao productCategoryDataStore = new ProductCategoryDaoJDBC();
        SupplierDao supplierDataStore = new SupplierDaoJDBC();
        CartDao cartDao = CartDaoMem.getInstance();
//        OrderDao orderDao = OrderDaoMem.getInstance();

        //setting up a new supplier
        Supplier amazon = new Supplier("Amazon", "Digital content and services");
        supplierDataStore.add(amazon);
        Supplier lenovo = new Supplier("Lenovo", "Computers");
        supplierDataStore.add(lenovo);
        Supplier apple = new Supplier("Apple", "Apple");
        supplierDataStore.add(apple);
        Supplier samsung = new Supplier("Samsung", "Samsung");
        supplierDataStore.add(samsung);

        //setting up a new product category
        ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        productCategoryDataStore.add(tablet);
        ProductCategory phone = new ProductCategory("Phone", "Hardware", "A phone");
        productCategoryDataStore.add(phone);
        ProductCategory laptop = new ProductCategory("Laptop", "Hardware", "A laptop");
        productCategoryDataStore.add(laptop);
        System.out.println("DIN INITIALIZER" + productCategoryDataStore.getAll());

        //setting up products and printing it
        productDataStore.add(new Product("Amazon Fire", 49.9f, "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", tablet, amazon));
        productDataStore.add(new Product("Lenovo IdeaPad Miix 700", 479, "USD", "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.", tablet, lenovo));
        productDataStore.add(new Product("Amazon Fire HD 8", 89, "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", tablet, apple));
        productDataStore.add(new Product("Samsung Galaxy S20 Ultra, Dual SIM", 50, "USD", "Galaxy S20 features a sleek modern design, next level capture and share and premium performance.", phone, samsung));
        productDataStore.add(new Product("Apple iPhone 11, 64GB, Black", 150, "USD", "he iPhone 11 is the successor to last year’s iPhone XR model, with a 6.1-inch LCD display.", phone, apple));
        productDataStore.add(new Product("Samsung Galaxy S10+", 350, "USD", "The Samsung Galaxy S10+ delivers flagship performance, it's slick and fast, happy to run intensive games at the top settings and does so without getting warm. ", phone, samsung));
        productDataStore.add(new Product("Lenovo ThinkPad X1 Carbon 7th Gen", 250, "USD", "Business convertible for both homes and offices alike.", laptop, lenovo));
        productDataStore.add(new Product("Lenovo ThinkPad E15", 350, "USD", "A sleek metallic design on top, performance underneath", laptop, lenovo));
        productDataStore.add(new Product("Apple MacBook Pro 16inch Touch Bar", 450, "USD", "The best for the brightest", laptop, apple));


        //setting up the cart
        cartDao.add(new Cart(1));

//        //setting up supplier in db
//        SupplierDao supplierDaoJDBC = new SupplierDaoJDBC();
//        supplierDaoJDBC.add(apple);
//        supplierDaoJDBC.add(samsung);

//        //setting up product in db
//        ProductDao productDaoJDBC = new ProductDaoJDBC();
//        Product product1 = new Product("Apple MacBook Pro 16inch Touch Bar", 450, "USD", "The best for the brightest", laptop, apple);
//        productDaoJDBC.add(product1);
//        productDaoJDBC.add(new Product("Lenovo ThinkPad E15", 350, "USD", "A sleek metallic design on top, performance underneath", laptop, lenovo));
//        productDaoJDBC.add(new Product("Samsung Galaxy S10+", 350, "USD", "The Samsung Galaxy S10+ delivers flagship performance, it's slick and fast, happy to run intensive games at the top settings and does so without getting warm. ", phone, samsung));
//
//
//        //setting up categories in db
//        ProductCategoryDao productCategoryDaoJDBC = new ProductCategoryDaoJDBC();
//        productCategoryDaoJDBC.add(phone);
//        productCategoryDaoJDBC.add(laptop);

    }
}
