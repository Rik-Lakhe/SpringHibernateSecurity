/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.webapp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LAKHE
 */
@Entity
@Table(name = "tbl_customer_accounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerAccounts.findAll", query = "SELECT c FROM CustomerAccounts c"),
    @NamedQuery(name = "CustomerAccounts.findByCustomerAccountId", query = "SELECT c FROM CustomerAccounts c WHERE c.customerAccountId = :customerAccountId"),
    @NamedQuery(name = "CustomerAccounts.findByBalance", query = "SELECT c FROM CustomerAccounts c WHERE c.balance = :balance"),
    @NamedQuery(name = "CustomerAccounts.findByAddedDate", query = "SELECT c FROM CustomerAccounts c WHERE c.addedDate = :addedDate"),
    @NamedQuery(name = "CustomerAccounts.findByModifiedDate", query = "SELECT c FROM CustomerAccounts c WHERE c.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "CustomerAccounts.findByStatus", query = "SELECT c FROM CustomerAccounts c WHERE c.status = :status")})
public class CustomerAccounts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_account_id")
    private Integer customerAccountId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "balance")
    private long balance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "added_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne(optional = false)
    private Customers customerId;
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    @ManyToOne(optional = false)
    private Account accountId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public CustomerAccounts() {
    }

    public CustomerAccounts(Integer customerAccountId) {
        this.customerAccountId = customerAccountId;
    }

    public CustomerAccounts(Integer customerAccountId, long balance, Date addedDate, Date modifiedDate, boolean status) {
        this.customerAccountId = customerAccountId;
        this.balance = balance;
        this.addedDate = addedDate;
        this.modifiedDate = modifiedDate;
        this.status = status;
    }

    public Integer getCustomerAccountId() {
        return customerAccountId;
    }

    public void setCustomerAccountId(Integer customerAccountId) {
        this.customerAccountId = customerAccountId;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Customers getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customers customerId) {
        this.customerId = customerId;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerAccountId != null ? customerAccountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerAccounts)) {
            return false;
        }
        CustomerAccounts other = (CustomerAccounts) object;
        if ((this.customerAccountId == null && other.customerAccountId != null) || (this.customerAccountId != null && !this.customerAccountId.equals(other.customerAccountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.lfa.webapp.entity.CustomerAccounts[ customerAccountId=" + customerAccountId + " ]";
    }
    
}
