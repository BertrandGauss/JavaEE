<!DOCTYPE html>
<head>
    <meta charset="UTF-8" />
    <title>上传饮食图片</title>
    <link rel="stylesheet" href="../../../../WeAdmin-master/static/css/font.css" />
    <link rel="stylesheet" href="../../../../WeAdmin-master/static/css/weadmin.css" />
</head>
<body>
<h1  class="layui-bg-gray " style="text-align: center ;font-size: 20px;font-family: SimSun;">上传饮食图片</h1>
<form action="fileUpload" method="post" enctype="multipart/form-data" class="layui-form">
    <div class="layui-inline" style="text-align: center">
    <p style="font-size: 14px; text-align: center">选择文件: <input class="layui-btn" type="file" name="fileName" /></p>
    </div>
    <div class="layui-inline" style="text-align: center">
    <p ><input type="submit" class="layui-btn" value="提交"/></p>
    </div>
</form>
<div style="text-align: center">
<#--判断是否上传文件-->
<#if msg??>
<span style="text-align: center;font-size: 12px;">${msg}</span><br>
<#else >
<span style="text-align: center;font-size: 12px;">${msg!("文件未上传")}</span><br>
</#if>
<#--显示图片，一定要在img中的src发请求给controller，否则直接跳转是乱码-->
<#if fileName??>
<img src="/show?fileName=${fileName}" style="width: 200px ;text-align: center"/><br>
<#else>
<img src="/show" style="width: 100px"/><br>
</#if>
<#if data1??>
<span style="font-size: 12px; text-align: center">图片中食品为：${data1} 概率为：${con1}%</span><br>
</#if>
<#if data2??>
<span  style="font-size: 12px; text-align: center">图片中食品为：${data2} 概率为：${con2}%</span><br>
</#if>
<#if data3??>
<span  style="font-size: 12px; text-align: center">图片中食品为：${data3} 概率为：${con3}%</span><br>
</#if>
<#if data4??>
<span  style="font-size: 12px; text-align: center">图片中食品为：${data4} 概率为：${con4}%</span><br>
</#if>
</div>
</body>
</html>