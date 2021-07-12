

$(document).ready(function(){
    $("#btn_sub").click(function(){
        $.ajax({
            type: "POST",   //提交的方法
            url:"http://localhost:8081/user/login",
            dataType:"json",
            contentType: "application/json",
            //url:"#",
            data: JSON.stringify({
                "telephone":$("#telephone").val(),
                "user_password":$("#user_password").val()
            }),
            async: false,
            error: function(request) {  //失败的话
                alert("Connection error");
            },
            success: function(data) {

                if (data.code==0){
                    window.location.href="./index.html";
                }
                else{
                    alert(data.msg)
                }

                //成功
                // $("#username1").val($("#user_name").val());
                // $(".regText").val("");
                // window.location.href="./index.html";
                // alert("Connection error");
            }
        });
    });
})
