package com.lib.management.system.libmanagementsysproject25thFeb.models;

public enum TransactionStatus {
	PENDING,
	SUCCESS,
	FAILED
	
}
//it is good practise to when call @enumerated use STRING TO STORE
//no ordinal or index as
//when u add element here index may change of success and u have to further change the program
