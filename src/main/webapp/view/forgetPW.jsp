<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div class="col-md-9 col-sm-9">
		<h1>QUÊN MẬT KHẨU?</h1>
		<div class="content-form-page">
			<div class="row">
				<div class="col-md-7 col-sm-7">
					<form action="/forgetPW_logout/fogotpassword" method="POST"
						class="form-horizontal form-without-legend" role="form">
						<h2>Quên mật khẩu</h2>
						<c:if test="${alert != null}">
							<h3 class="alert">${alert}</h3>
						</c:if>
						<div class="form-group">
							<label for="username" class="col-lg-4 control-label">Tên
								Tài Khoản</label>
							<div class="col-lg-8">
								<input class="form-control" type="text" id="name" name="name"
									placeholder="Username" required>
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-lg-4 control-label">Mật
								khẩu mới:</label>
							<div class="col-lg-8">
								<input class="form-control" type="password" id="password"
									name="password" placeholder="Password" required>
							</div>
						</div>
						<div class="row">
							<div
								class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-5">
								<button type="submit" class="btn btn-primary">Lấy lại
									mật khẩu</button>
							</div>
						</div>
					</form>
				</div>
				<div class="col-md-4 col-sm-4 pull-right">
					<div class="form-info">
						<h2>
							<em>Important</em> Information
						</h2>
						<p>Enter the e-mail address associated with your account.
							Click submit to have your password e-mailed to you.</p>

						<button type="button" class="btn btn-default">More
							details</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>