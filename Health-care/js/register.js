CheckRegSuccess1 = false;
CheckRegSuccess2 = false;
CheckRegSuccess3 = false;
CheckRegSuccess4 =false;
CheckRegSuccess5 = false;
// SetBtnDisable();

function checkAll() {
    checkPassword();
    checkSurepassword();
    checkUsername();
    checkPhone();

}

function checkEmail(){
    var email = $("#email").val();
    var c_email = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$ /;
    var flag = c_email.test(email)
    console.log(email);
    console.log(c_email);
    console.log(flag);
    if(flag){
        $("#email").text("");
        CheckRegSuccess5 = true;
    }
    else{
        $("#semail").removeClass("fa-check");
        $("#email").addClass("fa-times");
        $("#email").css("color","#EB2929");
        $("#RegErrInfo").text("邮箱不合规范");
        CheckRegSuccess5 = false;
    }
}

function checkUsername(){
    var username = $("#user_name").val();
    var reg_username = /^\w{6,12}$/;
    var flag = reg_username.test(username);
    if(flag){
        $("#s_username").text("");
        CheckRegSuccess1=true;
    }
    else{
        $("#s_username").removeClass("fa-check");
        $("#s_username").addClass("fa-times");
        $("#s_username").css("color","#EB2929");
        $("#RegErrInfo").text("用户名不符合规范");
        CheckRegSuccess1 = false;
    }
}



function SetBtnDisable() {
    if (CheckRegSuccess1 && CheckRegSuccess2 && CheckRegSuccess3&&CheckRegSuccess4 && CheckRegSuccess5) {
        $('#btn_sub').removeAttr("disabled");
        $("#btn_sub").css('color',"#000");
    } else {
        $("#btn_sub").attr('disabled',"true");
        $("#btn_sub").css('color',"#888");
    }
}

function checkPhone(){
    var phone = $("#telephone").val();
    var reg_phone = /^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/;
    var flag = reg_phone.test(phone);
    if(flag){
        $("#s_phone").text("");
        CheckRegSuccess4=true;
    }
    else{
        $("#s_phone").removeClass("fa-check");
        $("#s_phone").addClass("fa-times");
        $("#s_phone").css("color","#EB2929");
        $("#RegErrInfo").text("手机号码不合规范");
        CheckRegSuccess4 = false;
    }
}

function checkPassword(){
    if($("#user_password").val().length<6){
        $("#s_password").removeClass("fa-check");
        $("#s_password").addClass("fa-times");
        $("#s_password").css("color","#EB2929");
        $("#RegErrInfo").text("密码不得少于6位");
        CheckRegSuccess2 = false;
    }
    else{
        $("#s_password").removeClass("fa-times");
        $("#s_password").addClass("fa-check");
        $("#s_password").css("color","#2de66a");
        $("#RegErrInfo").text("");
        CheckRegSuccess2 = true;
    }
}


function checkSurepassword(){
    var pwd1 = $("#surepassword").val();
    var pwd2 = $("#user_password").val();
    if(pwd1 != pwd2){
        $("#s_surepassword").removeClass("fa-check");
        $("#s_surepassword").addClass("fa-times");
        $("#s_surepassword").css("color","#EB2929");
        $("#RegErrInfo").text("密码不一致，请重新输入");
        CheckRegSuccess3 = false;
    }else{
        $("#s_surepassword").removeClass("fa-times");
        $("#s_surepassword").addClass("fa-check");
        $("#s_surepassword").css("color","#2de66a");
        $("#RegErrInfo").text("");
        CheckRegSuccess3 = true;
    }

}

// var info = {};
// info.push($("#user_name").val());
// info.push($("#user_password").val());
// info.push($("#telephone").val());
// info.push($("#gender").val());
// info.push($("#birthday").val());

$(document).ready(function(){
    var gender1 = document.getElementsByName('sex');
    console.log(gender1)
    $("#btn_sub").click(function(){
        $.ajax({
            type: "POST",   //提交的方法
            url:"http://localhost:8081/user/register",
            dataType:"json",
            contentType: "application/json",
            //url:"#",
            data: JSON.stringify({
                "user_name":$("#user_name").val(),
                "telephone":$("#telephone").val(),
                "email":$("#email").val(),
                "user_password":$("#user_password").val(),
                "gender":$("input[name='sex']:checked").val(),
                "birthday":$("#birthday").val(),
                // "gender":gender1.values()
            }),
            async: false,
            error: function(request) {  //失败的话
                alert("Connection error");
            },
            success: function() {  //成功
                // $("#username1").val($("#user_name").val());
                // $(".regText").val("");
                window.location="../WeAdmin-master/login.html";
            }
        });
    });
})
