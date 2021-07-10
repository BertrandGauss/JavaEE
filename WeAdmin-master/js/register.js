CheckRegSuccess1 = false;
CheckRegSuccess2 = false;
CheckRegSuccess3 = false;
CheckRegSuccess4 =false;
SetBtnDisable();

function checkAll() {
    checkPassword();
    checkSurepassword();
    checkUsername();
    checkPhone();
}

function checkUsername(){
    var username = $("#username").val();
    var reg_username = /^\w{6,12}$/;
    var flag = reg_username.test(username);
    if(flag){
        $("#s_username").text("");
        CheckRegSuccess1=True;
    }
    else{
        $("#s_username").removeClass("fa-check");
        $("#s_username").addClass("fa-times");
        $("#s_username").css("color","#EB2929");
        $("#RegErrInfo").text("用户名不符合规范");
        CheckRegSuccess1 = false;
    }
    SetBtnDisable();
}



function SetBtnDisable() {
    if (CheckRegSuccess1 && CheckRegSuccess2 && CheckRegSuccess3) {
        $('#btn_sub').removeAttr("disabled");
        $("#btn_sub").css('color',"#000");
    } else {
        $("#btn_sub").attr('disabled',"true");
        $("#btn_sub").css('color',"#888");
    }
}

function checkPhone(){
    var phone = $("#phone").val();
    var reg_phone = /^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/;
    var flag = reg_phone.test(phone);
    if(flag){
        $("#s_phone").text("");
        CheckRegSuccess4=True;
    }
    else{
        $("#s_phone").removeClass("fa-check");
        $("#s_phone").addClass("fa-times");
        $("#s_phone").css("color","#EB2929");
        $("#RegErrInfo").text("手机号码不合规范");
        CheckRegSuccess4 = false;
    }
    SetBtnDisable();
}

function checkPassword(){
    if($("#password").val().length<6){
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
    SetBtnDisable();
}


function checkSurepassword(){
    var pwd1 = $("#surepassword").val();
    var pwd2 = $("#password").val();
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
    SetBtnDisable();
}

$(document).ready(function(){
    $("#btn_sub").click(function(){
        $.ajax({
            type: "POST",   //提交的方法
            url:"/app/register/",
            //url:"#",
            data:$('#regForm').serialize(),// 序列化表单值
            async: false,
            error: function(request) {  //失败的话
                alert("Connection error");
            },
            success: function() {  //成功
                $("#username1").val($("#username").val());
                $(".regText").val("");
                window.location.href="/app/index/#login";
            }
        });
    });
})
