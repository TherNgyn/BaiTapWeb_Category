<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<body>
    <form action="/forgetPW_logout/login" method="POST">

        <c:if test="${alert != null}">
            <h3 class="alert alertdanger">${alert}</h3>
        </c:if>
        <h1>Đăng nhập</h1>
            <div class="content-form-page">
              <div class="row">
                <div class="col-md-7 col-sm-7">
                  <form class="form-horizontal form-without-legend" role="form">
                    <div class="form-group">
                      <label for="email" class="col-lg-4 control-label">Tên tài khoản <span class="require">*</span></label>
                      <div class="col-lg-8">
                        <input type="text" class="form-control" id="name" name="name">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="password" class="col-lg-4 control-label">Mật khẩu <span class="require">*</span></label>
                      <div class="col-lg-8">
                        <input type="text" class="form-control" id="password" name="password">
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-lg-8 col-md-offset-4 padding-left-0">
                        <a href="forgetPW.jsp">Quên mật khẩu?</a>
                      </div>
                      
                    </div>
                    
                    <div class="row">
                      <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
                        <button type="submit" class="btn btn-primary">Đăng nhập</button>
                      </div>
                    </div>
                    <div class="row">
                    <hr>
                        <div class="login-socio">
                        <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-10 padding-right-30">
									<p class="text-muted">
										Nếu bạn chưa có tài khoản trên hệ thống, thì hãy <br> <a
											href="register.jsp">Đăng ký</a>
									</p>
								</div>
								</div>
								</div>
                    <div class="row">
                      <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-10 padding-right-30">
                        <hr>
                        <div class="login-socio">
                            <p class="text-muted">Hoặc đăng nhập bằng:</p>
                            <ul class="social-icons">
                                <li><a href="#" data-original-title="facebook" class="facebook" title="facebook"></a></li>
                                <li><a href="#" data-original-title="Twitter" class="twitter" title="Twitter"></a></li>
                                <li><a href="#" data-original-title="Google Plus" class="googleplus" title="Google Plus"></a></li>
                                <li><a href="#" data-original-title="Linkedin" class="linkedin" title="LinkedIn"></a></li>
                            </ul>
                        </div>

							</div>
                    </div>
                  </form>
                </div>
                <div class="col-md-4 col-sm-4 pull-right">
                  <div class="form-info">
                    <h2><em>Important</em> Information</h2>
                    <p>Duis autem vel eum iriure at dolor vulputate velit esse vel molestie at dolore.</p>

                    <button type="button" class="btn btn-default">More details</button></div>
                </div>
              </div>
            </div>
          </div>
          
    </form>
    <div class="col-md-9 col-sm-9">
            
</body>
</html>