package com.example.mapping.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "company")
public class Company {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="comp_id")
            private Long id;

		@Column(name="company_name")
        private String companyName;
        
        @Column(name="owner_name")
        private String ownerName;
        
        @Column(name="mobile")
        private String mobileNo;
        
        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "employee_id")
        private Employee employee;

		public Company() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Company(Long id, String companyName, String ownerName, String mobileNo, Employee employee) {
			super();
			this.id = id;
			this.companyName = companyName;
			this.ownerName = ownerName;
			this.mobileNo = mobileNo;
			this.employee = employee;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCompanyName() {
			return companyName;
		}

		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}

		public String getOwnerName() {
			return ownerName;
		}

		public void setOwnerName(String ownerName) {
			this.ownerName = ownerName;
		}

		public String getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}

		public Employee getEmployee() {
			return employee;
		}

		public void setEmployee(Employee employee) {
			this.employee = employee;
		}

		
        
        
}