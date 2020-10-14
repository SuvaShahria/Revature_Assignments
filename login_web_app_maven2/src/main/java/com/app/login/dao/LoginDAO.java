package com.app.login.dao;


import com.app.login.exception.BusinessException;
import com.app.login.model.User;

public interface LoginDAO {

	public boolean isValidUserCredentials(User user) throws BusinessException;
}