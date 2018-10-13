package com.jambo.jambo.controller;

import com.jambo.jambo.entity.OrderEntity;
import com.jambo.jambo.entity.ProductsEntity;
import com.jambo.jambo.interfaces.dao.OrderDao;
import com.jambo.jambo.interfaces.dao.ProductsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
import java.util.List;

@Controller
public class HomeController {


    @Autowired
    ProductsDao productsDao;

    @Autowired
    OrderDao orderDao;

    /**
        * APIS
     * */

    //Displaying homePage
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getHome(){
        ModelAndView mv = new ModelAndView("index");

        List<ProductsEntity> productsEntity = productsDao.fetchAllProducts();
        mv.addObject("products",productsEntity);

        return mv;
    }

    //Fetching All products and Prices from DB
    @RequestMapping(value = "/allproducts", method = RequestMethod.GET)
    public List<ProductsEntity> getProducts(Model mv){
        List<ProductsEntity> productsEntity = productsDao.fetchAllProducts();
        mv.addAttribute("products",productsEntity);

        return productsEntity;
    }

    //Save Product to DB
    @RequestMapping(value = "/save/{product}", method = RequestMethod.GET)
    public String saveProduct(Model mv){
//        productsDao.saveOrUpdate();

        return "";
    }

    //Delete Product to DB
    @RequestMapping(value = "/delete/{product}", method = RequestMethod.GET)
    @ResponseBody
    public String deleteProduct(@PathVariable String product,Model mv){
        productsDao.deleteOneProduct(product);
        return "";
    }

    //Get One Product from DB
    @RequestMapping(value = "/product/{product}", method = RequestMethod.GET)
    @ResponseBody
    public ProductsEntity getOneProduct(@PathVariable String product){

         ProductsEntity productsEntity = productsDao.fetchOneProducts(product);

        return productsEntity;
    }

    //Get Products by using price from DB
    @RequestMapping(value = "/product&/{price}", method = RequestMethod.GET)
    public String getByPrice(@PathVariable double product, Model mv){

        return "";
    }

    //Fetching All orders and Prices from DB
    @RequestMapping(value = "/placeorder", method = RequestMethod.POST)
    public String getOrders(@RequestBody OrderEntity orderEntity){
        String res = "DONE";
        orderDao.saveOrUpdate(orderEntity);
        return res;
    }
}
