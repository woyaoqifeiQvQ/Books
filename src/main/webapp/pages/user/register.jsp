<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <%@include file="/pages/common/head.jsp"%>
    <style type="text/css">
	.login_form
	{
		height:420px;
		margin-top: 25px;
	}
</style>
	<script type="text/javascript">
		$(function ()
		{
			$("#sub_btn").click(function ()
			{
				var regExp = /^\w{5,13}$/;
				if(!regExp.test($("#username").val()))
				{
					$("span.errorMsg").text("用户名不合法！");
					return false;
				}

				if(!regExp.test($("#password").val()))
				{
					$("span.errorMsg").text("密码不合法！");
					return false;
				}

				if($("#password").val() != $("#repwd").val())
				{
					$("span.errorMsg").text("确认密码与密码不一致！");
					return false;
				}

				var regExp1 = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/; //邮箱的正则表达式
				if(!regExp1.test($("#email").val()))
				{
					$("span.errorMsg").text("邮箱不合法！");
					return false;
				}

				//看看验证码输入了吗
				if($.trim($("#code").val()) == null || $.trim($("#code").val()) == "")
				{
					$("span.errorMsg").text("验证码输入错误！");
					return false;
				}

				$("span.errorMsg").text("");
			})

            //给验证码绑定单击事件 刷新验证码
            $("#code_img").click(function ()
            {
                this.src = "${basePath}kaptchaServlet.jpg";
            })

			//给用户名绑定失去焦点事件
			$("#username").blur(function ()
			{
				var username = this.value;

				$.getJSON("<%=basePath%>userServlet?username=" + username,"action=ajaxExistsUsername",function (data)
				{
					console.log(data.existsUser)
					if(data.existsUser)
					{
						$(".errorMsg").text("用户名已存在！");
					}
					else
					{
						$(".errorMsg").text("");
					}
				})
			})
		})




	</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg" ><%=request.getAttribute("msg")==null ? "" :request.getAttribute("msg")%></span>
							</div>
							<div class="form">
								<form id="register" action="userServlet" method="post">
									<input type="hidden" name="action" value="register">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username"
										   value="<%=request.getAttribute("username")==null ? "" : request.getAttribute("username")%>"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password"
									      value="<%=request.getAttribute("password")==null ? "" : request.getAttribute("password")%>"/>
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd"
										   value="<%=request.getAttribute("password")==null ? "" : request.getAttribute("password")%>"/>
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email"
										   value="<%=request.getAttribute("email")==null ? "" : request.getAttribute("email")%>"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 100px;" name="codes" id="code"/>
									<img alt="" id="code_img" src="kaptchaServlet.jpg" style="float: right; margin-right: 40px; width: 120px; height: 40px;">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/bottom.jsp"%>
</body>
</html>