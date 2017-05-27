/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.webapp.controller;

import edu.lfa.webapp.dao.AccountDAO;
import edu.lfa.webapp.dto.AccountDTO;
import edu.lfa.webapp.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author LAKHE
 */
@Controller
@RequestMapping(value = "/admin/account")
public class AccountController {

    @Autowired
    private AccountDAO accountDAO;

    @RequestMapping(value="/all",method = RequestMethod.GET)
    public @ResponseBody String index() {
        String data="";
        for(Account acc : accountDAO.getAll()){
        
            data += "<li>"+acc.getAccountName()+"</li>";
        
        }
        
        return data;
    } 
    
    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String add(){
        return "admin/account/add";
    }
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(AccountDTO accDTO){
        Account account= new Account();
        account.setAccountName(accDTO.getName());
        account.setInterest(accDTO.getInterest());
        account.setMinimumBalance(accDTO.getBalance());
        account.setStatus(accDTO.isStatus());
        
        accountDAO.insert(account);
        return "redirect:/admin/account/all";
    }
}
