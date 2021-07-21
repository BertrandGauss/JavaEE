<!DOCTYPE html>
<head>
    <meta charset="UTF-8" />
    <title>图片上传Demo</title>
</head>
<body>
<h1 style="text-align: center ;font-size: 20px;">上传饮食图片</h1>
<form action="fileUpload" method="post" enctype="multipart/form-data">
    <p style="font-size: 14px; text-align: center">选择文件: <input type="file" name="fileName" /></p>
    <p ><input type="submit" value="提交"/></p>
</form>
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
</body>
</html>