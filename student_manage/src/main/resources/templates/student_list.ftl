<html>

<head>
    <title>学生列表</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <style>
        .box{
            height: 80px;
            width: 450px;
            margin: 0 auto;
        }
    </style>
</head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>

    function add(){

        location.href="/student/add";

    }

</script>
<body>
<#if user??>
    <h1 align="center">学生列表</h1>
    <div>当前的商家为：<span style="color: red">${user.username?default("")}</span></div>
    <table class="table table-hover">
        <tr>
            <td colspan="11" align="center">
                <input type="button" value="添加" onclick="add()">
                <input type="button" class="btn btn-warning" value="商品编辑" onclick="fruitAdd()">
                <input type="button" class="btn btn-info" value="批量删除" onclick="fruitAdd()">
            </td>
        </tr>
        <tr>
            <th><input type="checkbox"></th>
            <th>学生姓名</th>
            <th>年龄</th>
            <th>爱好</th>
            <th>班级</th>
            <th>居住省</th>
            <th>>居住市</th>
            <th>>居住区</th>
            <th>权限</th>
        </tr>

        <#list studentList as student>
            <tr>
                <td>${student.sid}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td>${student.hobby}</td>
                <td>${student.className?default("")}</td>
                <td>${student.sheng?default("")}</td>
                <td>${student.shi?default("")}</td>
                <td>${student.qu?default("")}</td>
                <td>
                    <button class="btn btn-warning startTx" >编辑</button>
                    <button class="btn btn-warning startTx" >删除</button>
                </td>
            </tr>

        </#list>

    </table>
<#--<#list fruitList as fruit>

    <tr>
        <td>${fruit.fid}</td>
        <td>${fruit.fruitName}</td>
        <td>${fruit.fruitDesc}</td>
        <td>${fruit.weight}</td>
        <td>${fruit.price}</td>
        <td>${fruit.upTime}</td>
        <td>${fruit.aid}</td>
        <td>${fruit.uid}</td>
        <td>${fruit.txFlag}</td>
    </tr>
</#list>-->
<#else>

    <a href="/student/toLogin">请登录！</a>

</#if>

</body>

</html>
