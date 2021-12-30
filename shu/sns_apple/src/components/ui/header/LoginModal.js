import React from 'react';



function LoginModal () 
{
         <div class="modal fade login-modal" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="login-modal-label">
            <div class="modal-dialog" role="document">
               <div class="modal-content login-signup-form">
                  <div class="modal-header">
                     <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&#10005;</span></button>
                     <div class="modal-title" id="login-modal-label">
                        <ul class="nav nav-tabs js-login-form-tabs" role="tablist">
                           <li role="presentation" class="active"><a href="#login-tab" aria-controls="login-tab" role="tab" data-toggle="tab">Log in</a></li>
                           <li role="presentation"><a href="#signup-tab" aria-controls="signup-tab" role="tab" data-toggle="tab">Sign up</a></li>
                        </ul>
                     </div>
                  </div>
                  </div>
                  <div class="modal-body">
                     <div class="tab-content">
                        <input role="tabpanel" class="tab-pane fade in active" id="login-tab"></input>
                           <div class="login-with-social">
                              <p>Log in with social account</p>
                              <ul class="social-list social-list--circle list-center ">
                                 <li><a href="#" class="facebook-theme-bg text-white"><i class="mdicon mdicon-facebook"></i></a>
                                 </li>
                                 <li><a href="#" class="twitter-theme-bg text-white"><i class="mdicon mdicon-twitter"></i></a>
                                 </li>
                                 <li><a href="#" class="googleplus-theme-bg text-white"><i class="mdicon mdicon-google-plus"></i></a>
                                 </li>
                              </ul>
                           </div>
                           <div class="block-divider"><span>or</span></div>
                           <input name="loginform" id="loginform" action="#" method="post"></input>
                              <p class="login-username">
                                 <label for="user_login">Username</label>
                                 <input type="text" name="log" id="user_login" class="input" value="" size="20"></input>
                              </p>
                              <p class="login-password">
                                 <label for="user_pass">Password</label>
                                 <input type="password" name="pwd" id="user_pass" class="input" value="" size="20"></input>
                              </p>
                              <input class="login-remember"></input>
                              <label type="checkbox" name="rememberme"  id="rememberme" value="forever"> Remember Me</label>
                              <p class="login-submit"></p>
                                 <input type="submit" name="wp-submit" id="wp-submit" class="btn btn-block btn-primary" value="Log In"></input>
                                 <input type="hidden" name="redirect_to" value="#"></input>
                              
                              <p class="login-lost-password">
                                 <a href="#" class="link link--darken">Lost your password?</a>
                              </p>
                           
                        
                        <div role="tabpanel" class="tab-pane fade" id="signup-tab">
                           <form name="registerform" id="registerform" action="#" method="post"></form>
                              <p class="register-username">
                                 <label for="user_register">Username</label>
                                 <input type="text" name="log" id="user_register" class="input" value="" size="20"></input>
                              </p>
                              <p class="register-password">
                                 <label for="user_register_pass">Password</label>
                                 <input type="password" name="pwd" id="user_register_pass" class="input" value="" size="20"></input>
                              </p>
                              <p class="register-submit">
                                 <input type="submit" name="wp-submit" id="wp-submit-register" class="btn btn-block btn-primary" value="Sign Up"></input>
                                 <input type="hidden" name="redirect_to" value="#"></input>
                              </p>
                              
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         
 
}

export default LoginModal;