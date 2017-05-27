/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.webapp.controller;

import edu.lfa.webapp.dao.CustomerDAO;
import edu.lfa.webapp.dao.UserDAO;
import edu.lfa.webapp.dto.CustomerDTO;
import edu.lfa.webapp.entity.Customers;
import edu.lfa.webapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author LAKHE
 */
@Controller
@RequestMapping(value="/admin/customer")
public class CustomerController {
    
    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private UserDAO userDAO;
    
    @RequestMapping(value="/all",method = RequestMethod.GET)
    public @ResponseBody String index() {
        String data="";
        for(Customers cust : customerDAO.getAll()){
        
            data += "<li>"+cust.getFirstName()+"   "+cust.getLastName()+"</li>";
        
        }
        
        return data;
    } 
    
    
  
    
    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("users",userDAO.getAll());
        return "admin/customer/add";
        
    }
    
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(CustomerDTO cDTO){
        Customers customer= new Customers();
        customer.setFirstName(cDTO.getFirstName());
        customer.setLastName(cDTO.getLastName());
        customer.setContactNo(cDTO.getContactNo());
        customer.setEmail(cDTO.getEmail());
        customer.setUserId(new User(cDTO.getUserId()));
        customer.setStatus(cDTO.isStatus());
        customerDAO.insert(customer);
        return "redirect:/admin/customer/all";
    }
}
