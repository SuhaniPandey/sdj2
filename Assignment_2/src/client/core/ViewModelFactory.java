package client.core;

import client.views.Login.LoginViewModel;
import client.views.Register.RegisterViewModel;

public class ViewModelFactory
{

  private ModelFactory modelFactory;
  private LoginViewModel loginViewModel;
  private RegisterViewModel registerViewModel;

  public ViewModelFactory(ModelFactory modelFactory){
    this.modelFactory=modelFactory;
  }

  public LoginViewModel getLoginViewModel(){
    if (loginViewModel== null){
      loginViewModel= new LoginViewModel(modelFactory);
    }
    return loginViewModel;
}

  public RegisterViewModel getRegisterViewModel(){
    if (registerViewModel== null){
      registerViewModel= new RegisterViewModel(modelFactory);
    }
    return registerViewModel;
  }
}