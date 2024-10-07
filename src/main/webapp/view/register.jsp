<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<h1>Đăng kí tài khoản</h1>
	<div class="content-form-page">
		<div class="row">
			<div class="col-md-7 col-sm-7">
				<form action="/forgetPW_logout/register" method="POST"
					class="form-horizontal" role="form">
					<c:if test="${alert !=null}">
						<h3 class="alert">${alert}</h3>
					</c:if>
					<fieldset>
						<legend>Thông tin cá nhân</legend>
						<div class="form-group">
							<label for="firstname" class="col-lg-4 control-label">Nhập
								ID <span class="require">*</span>
							</label>
							<div class="col-lg-8">
								<input class="form-control" type="number" name="number" placeholder="Nhập id"
									required>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-lg-4 control-label">Nhập
								Tên <span class="require">*</span>
							</label>
							<div class="col-lg-8">
								<input class="form-control" type="text" name="name_r" placeholder="Nhập tên" required>
							</div>
						</div>
						<div class="form-group">
							<label for="Ho va Ten" class="col-lg-4 control-label">Họ và
								Tên <span class="require">*</span>
							</label>
							<div class="col-lg-8">
								<input class="form-control" type="text" name="fullname"
									placeholder="Nhập họ tên đầy đủ" required>
							</div>
						</div>
					</fieldset>
					<fieldset>
						<legend>Mật Khẩu</legend>
						<div class="form-group">
							<label for="password" class="col-lg-4 control-label">Nhập
								Mật Khẩu <span class="require">*</span>
							</label>
							<div class="col-lg-8">
								<input class="form-control" type="password" name="password_r"
									placeholder="Nhập mật khẩu" required>
							</div>
						</div>
					</fieldset>
					<p>
						Bạn đã có tài khoản? <a href="login.jsp">Đăng nhập</a>
					</p>
					<div class="row">
						<div
							class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
							<button type="submit" class="btn btn-primary">Đăng ký</button>
							<button type="button" class="btn btn-default">Thoát</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-4 col-sm-4 pull-right">
				<div class="form-info">
					<h2>
						<em>Important</em> Information
					</h2>
					<p>Lorem ipsum dolor ut sit ame dolore adipiscing elit, sed sit
						nonumy nibh sed euismod ut laoreet dolore magna aliquarm erat sit
						volutpat. Nostrud exerci tation ullamcorper suscipit lobortis nisl
						aliquip commodo quat.</p>

					<p>Duis autem vel eum iriure at dolor vulputate velit esse vel
						molestie at dolore.</p>

					<button type="button" class="btn btn-default">More details</button>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>